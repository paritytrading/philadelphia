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
import itertools
import typing

from . import etree
from . import model


_NS = {
    'fixr': 'http://fixprotocol.io/2020/orchestra/repository',
}


def read_messages(filename: str) -> list[model.Message]:
    def message(elem: etree.Element) -> model.Message:
        name = etree.get(elem, 'name')
        msg_type = etree.get(elem, 'msgType')
        return model.Message(name=name, msg_type=msg_type)
    tree = etree.parse(filename)
    return [message(elem) for elem in tree.findall('.//fixr:message', _NS)]


def read_fields(filename: str) -> list[model.Field]:
    tree = etree.parse(filename)
    fields = _read_fields(tree)
    return sorted([_make_field(field) for field in fields],
                  key=lambda field: int(field.tag))


def read_enumerations(filename: str) -> list[model.Enumeration]:
    tree = etree.parse(filename)
    fields = _read_fields(tree)
    fields_by_type = _group_fields_by_type(fields)
    code_sets = _read_code_sets(tree)
    return sorted([_make_enumeration(code_set, fields_by_type[code_set.name]) for code_set in code_sets if _has_values(code_set)],
                  key=lambda enumeration: int(enumeration.primary_field.tag))


class _Code(typing.NamedTuple):
    name: str
    value: str
    sort: typing.Optional[int]


class _CodeSet(typing.NamedTuple):
    name: str
    id_: str
    type_: str
    codes: list[_Code]


def _read_code_sets(tree: etree.ElementTree) -> list[_CodeSet]:
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


def _read_fields(tree: etree.ElementTree) -> list[_Field]:
    def field(elem: etree.Element) -> _Field:
        id_ = etree.get(elem, 'id')
        name = etree.get(elem, 'name')
        type_ = etree.get(elem, 'type')
        return _Field(id_, name, type_)
    return [field(elem) for elem in tree.findall('.//fixr:field', _NS)]


def _make_field(field: _Field) -> model.Field:
    return model.Field(tag=field.id_, name=field.name)


def _make_enumeration(code_set: _CodeSet, fields: list[_Field]) -> model.Enumeration:
    primary_fields = [field for field in fields if code_set.id_ == field.id_]
    primary_field = primary_fields[0]
    secondary_fields = sorted([field for field in fields if code_set.id_ != field.id_],
            key=lambda field: int(field.id_))
    return model.Enumeration(primary_field=_make_field(primary_field),
            secondary_fields=[_make_field(secondary_field) for secondary_field in secondary_fields],
                type_=_make_type(primary_field, code_set), values=_make_values(code_set))


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


def _make_values(code_set: _CodeSet) -> list[model.Value]:
    def value(id_: str, code: _Code) -> model.Value:
        name = _NAME_REPLACEMENTS.get((id_, code.value), code.name)
        return model.Value(name=name, value=code.value)
    return [value(code_set.id_, code) for code in code_set.codes]


def _group_fields_by_type(fields: list[_Field]) -> dict[str, list[_Field]]:
    sorted_by_type = sorted(fields, key=lambda field: field.type_)
    return {type_: list(grouped_by_type) for type_, grouped_by_type in itertools.groupby(sorted_by_type, lambda field: field.type_)}


_NO_VALUES = [
    '35',
    '41237',
]


def _has_values(code_set: _CodeSet) -> bool:
    return not code_set.id_ in _NO_VALUES and not code_set.type_ == 'Boolean'


def _sorted_codes(codes: list[_Code]) -> list[_Code]:
    if all(code.sort is not None for code in codes):
        return sorted(codes, key=lambda code: code.sort or 0)
    return codes
