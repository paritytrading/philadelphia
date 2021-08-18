#
# Copyright 2020 Philadelphia authors
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
import typing

from . import etree
from . import model
from . import source


NS = {
    'fixr': 'http://fixprotocol.io/2020/orchestra/repository',
}


def read_messages(filename: str) -> typing.List[model.Message]:
    def message(elem: etree.Element) -> model.Message:
        name = etree.get(elem, 'name')
        msg_type = etree.get(elem, 'msgType')
        return model.Message(name, msg_type)
    tree = etree.parse(filename)
    return [message(elem) for elem in tree.findall('.//fixr:message', NS)]


def read_fields(filename: str) -> typing.List[model.Field]:
    tree = etree.parse(filename)
    fields = _read_fields(tree)
    code_sets = _read_code_sets(tree)
    return sorted([_field(field, code_sets) for field in fields],
                  key=lambda field: int(field.tag))


READER = source.Reader(None, read_fields, read_messages)


class _Field(typing.NamedTuple):
    id_: str
    name: str
    type_: str


class _Code(typing.NamedTuple):
    name: str
    value: str
    sort: typing.Optional[int]

class _CodeSet(typing.NamedTuple):
    name: str
    id_: str
    type_: str
    codes: typing.List[_Code]


def _field(field: _Field, code_sets: typing.Dict[str, _CodeSet]) -> model.Field:
    tag = field.id_
    name = field.name
    code_set = code_sets.get(tag)
    type_ = _type(field, code_set)
    if code_set and _has_values(code_set):
        values = [_value(tag, code) for code in code_set.codes]
    else:
        values = []
    return model.Field(tag, name, _TYPES.get(type_, type_), values)


def _type(field: _Field, code_set: typing.Optional[_CodeSet]) -> str:
    if not code_set:
        return field.type_
    if code_set.type_ == 'char' and max(len(code.value) for code in code_set.codes) > 1:
        return 'String'
    return code_set.type_


_NO_VALUES = [
    '35',
    '41237',
]


def _has_values(code_set: _CodeSet) -> bool:
    return not code_set.id_ in _NO_VALUES and not code_set.type_ == 'Boolean'


_NAME_REPLACEMENTS = {
    ('1779', '1'): 'Int',
    ('1779', '6'): 'Float',
    ('1779', '12'): 'Char',
}


_VALUE_REPLACEMENTS = {
    ('276', 'f '): 'f',
}


def _value(id_: str, code: _Code) -> model.Value:
    name = _NAME_REPLACEMENTS.get((id_, code.value), code.name)
    value = _VALUE_REPLACEMENTS.get((id_, code.value), code.value)
    return model.Value(name, value)


_TYPES = {
    'MultipleCharValue': 'char',
    'MultipleStringValue': 'String',
    'MultipleValueString': 'String',
    'NumInGroup': 'int',
}


def _read_fields(tree: etree.ElementTree) -> typing.List[_Field]:
    def field(elem: etree.Element) -> _Field:
        id_ = etree.get(elem, 'id')
        name = etree.get(elem, 'name')
        type_ = etree.get(elem, 'type')
        return _Field(id_, name, type_)
    return [field(elem) for elem in tree.findall('.//fixr:field', NS)]


def _read_code_sets(tree: etree.ElementTree) -> typing.Dict[str, _CodeSet]:
    def code(elem: etree.Element) -> _Code:
        name = etree.get(elem, 'name')
        value = etree.get(elem, 'value')
        sort = elem.get('sort')
        return _Code(name, value, int(sort) if sort is not None else None)
    def code_set(elem: etree.Element) -> _CodeSet:
        name = etree.get(elem, 'name')
        id_ = etree.get(elem, 'id')
        type_ = etree.get(elem, 'type')
        codes = [code(elem) for elem in elem.findall('fixr:code', NS)]
        return _CodeSet(name, id_, type_, _sorted_codes(codes))
    code_sets = [code_set(elem) for elem in tree.findall('.//fixr:codeSet', NS)]
    return {code_set.id_: code_set for code_set in code_sets}


def _sorted_codes(codes: typing.List[_Code]) -> typing.List[_Code]:
    if all(code.sort is not None for code in codes):
        return sorted(codes, key=lambda code: code.sort or 0)
    return codes
