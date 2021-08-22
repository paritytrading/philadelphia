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


_NS = {
    'fixr': 'http://fixprotocol.io/2020/orchestra/repository',
}


def read_messages(filename: str) -> typing.List[model.Message]:
    def message(elem: etree.Element) -> model.Message:
        name = etree.get(elem, 'name')
        msg_type = etree.get(elem, 'msgType')
        return model.Message(name=name, msg_type=msg_type)
    tree = etree.parse(filename)
    return [message(elem) for elem in tree.findall('.//fixr:message', _NS)]


def read_fields(filename: str) -> typing.List[model.Field]:
    tree = etree.parse(filename)
    fields = _read_fields(tree)
    code_sets = _read_code_sets(tree)
    code_sets_by_id = {code_set.id_: code_set for code_set in code_sets}
    return sorted([_make_field(field, code_sets_by_id.get(field.id_)) for field in fields],
                  key=lambda field: int(field.tag))


READER = source.Reader(read_fields, read_messages)


class _Code(typing.NamedTuple):
    name: str
    value: str
    sort: typing.Optional[int]


class _CodeSet(typing.NamedTuple):
    name: str
    id_: str
    type_: str
    codes: typing.List[_Code]


def _read_code_sets(tree: etree.ElementTree) -> typing.List[_CodeSet]:
    def code(elem: etree.Element) -> _Code:
        name = etree.get(elem, 'name')
        value = etree.get(elem, 'value')
        sort = elem.get('sort')
        return _Code(name, value, int(sort) if sort is not None else None)
    def code_set(elem: etree.Element) -> _CodeSet:
        name = etree.get(elem, 'name')
        id_ = etree.get(elem, 'id')
        type_ = etree.get(elem, 'type')
        codes = [code(elem) for elem in elem.findall('fixr:code', _NS)]
        return _CodeSet(name, id_, type_, _sorted_codes(codes))
    return [code_set(elem) for elem in tree.findall('.//fixr:codeSet', _NS)]


class _Field(typing.NamedTuple):
    id_: str
    name: str
    type_: str


def _read_fields(tree: etree.ElementTree) -> typing.List[_Field]:
    def field(elem: etree.Element) -> _Field:
        id_ = etree.get(elem, 'id')
        name = etree.get(elem, 'name')
        type_ = etree.get(elem, 'type')
        return _Field(id_, name, type_)
    return [field(elem) for elem in tree.findall('.//fixr:field', _NS)]


def _make_field(field: _Field, code_set: typing.Optional[_CodeSet]) -> model.Field:
    type_ = _make_type(field, code_set)
    values = _make_values(code_set) if code_set and _has_values(code_set) else []
    return model.Field(tag=field.id_, name=field.name, type_=type_, values=values)


_TYPES = {
    'MultipleCharValue': 'char',
    'MultipleStringValue': 'String',
    'MultipleValueString': 'String',
    'NumInGroup': 'int',
}


def _make_type(field: _Field, code_set: typing.Optional[_CodeSet]) -> str:
    if not code_set:
        return _TYPES.get(field.type_, field.type_)
    type_ = _TYPES.get(code_set.type_, code_set.type_)
    if type_ == 'char' and max(len(code.value) for code in code_set.codes) > 1:
        return 'String'
    else:
        return type_


_NAME_REPLACEMENTS = {
    ('1779', '1'): 'Int',
    ('1779', '6'): 'Float',
    ('1779', '12'): 'Char',
}


_VALUE_REPLACEMENTS = {
    ('276', 'f '): 'f',
}


def _make_values(code_set: _CodeSet) -> typing.List[model.Value]:
    def value(id_: str, code: _Code) -> model.Value:
        name = _NAME_REPLACEMENTS.get((id_, code.value), code.name)
        value = _VALUE_REPLACEMENTS.get((id_, code.value), code.value)
        return model.Value(name=name, value=value)
    return [value(code_set.id_, code) for code in code_set.codes]


_NO_VALUES = [
    '35',
    '41237',
]


def _has_values(code_set: _CodeSet) -> bool:
    return not code_set.id_ in _NO_VALUES and not code_set.type_ == 'Boolean'


def _sorted_codes(codes: typing.List[_Code]) -> typing.List[_Code]:
    if all(code.sort is not None for code in codes):
        return sorted(codes, key=lambda code: code.sort or 0)
    return codes
