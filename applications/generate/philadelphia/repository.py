#
# Copyright 2015 Philadelphia authors
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
import os
import typing

from . import etree
from . import model


def read_messages(dirname: str) -> list[model.Message]:
    def message(elem: etree.Element) -> model.Message:
        name = _find(elem, 'Name')
        msg_type = _find(elem, 'MsgType')
        return model.Message(name, msg_type)
    filename = _messages_path(dirname)
    tree = etree.parse(filename)
    return [message(elem) for elem in tree.findall('Message')]


def read_fields(dirname: str) -> list[model.Field]:
    fields = _read_fields(dirname)
    return sorted([_make_field(field) for field in fields], key=lambda field: int(field.tag))


def read_enumerations(dirname: str) -> list[model.Enumeration]:
    fields = _read_fields(dirname)
    fields_by_tag = {field.tag: field for field in fields}
    enums = _read_enums(dirname)
    enums_by_tag = {tag: list(enums) for tag, enums in itertools.groupby(enums, lambda enum: enum.tag)}
    tags = set(fields_by_tag.keys()).intersection(enums_by_tag.keys())
    return sorted([_make_enumeration(fields_by_tag[tag], enums_by_tag[tag]) for tag in tags if _has_values(fields_by_tag[tag])],
                  key=lambda enumeration: int(enumeration.primary_field.tag))


class _Enum(typing.NamedTuple):
    tag: str
    value: str
    symbolic_name: str
    sort: typing.Optional[int]


class _Field(typing.NamedTuple):
    tag: str
    name: str
    type_: str


def _make_field(field: _Field) -> model.Field:
    return model.Field(tag=field.tag, name=field.name)


def _make_enumeration(field: _Field, enums: list[_Enum]) -> model.Enumeration:
    values = _make_values(enums)
    type_ = _make_type(field.type_, values)
    return model.Enumeration(primary_field=_make_field(field), secondary_fields=[],
            type_=type_, values=values)


def _make_values(enums: list[_Enum]) -> list[model.Value]:
    def value(enum: _Enum) -> model.Value:
        return model.Value(name=enum.symbolic_name, value=enum.value)
    return [value(enum) for enum in _sorted_enums(enums)]


_TYPES = {
    'Char': 'char',
    'Int': 'int',
    'MultipleCharValue': 'char',
    'MultipleStringValue': 'String',
    'MultipleValueString': 'String',
    'NumInGroup': 'int',
}


def _make_type(field_type: str, values: list[model.Value]) -> str:
    type_ = _TYPES.get(field_type, field_type)
    if type_ == 'char' and values and max(len(value.value) for value in values) > 1:
        return 'String'
    return type_


def _has_values(field: _Field) -> bool:
    return not field.type_ == 'Boolean' and not field.name == 'MsgType'


def _read_fields(dirname: str) -> list[_Field]:
    def field(elem: etree.Element) -> _Field:
        tag = _find(elem, 'Tag')
        name = _find(elem, 'Name')
        type_ = _find(elem, 'Type')
        return _Field(tag, name, type_)
    filename = _fields_path(dirname)
    tree = etree.parse(filename)
    return [field(elem) for elem in tree.findall('Field')]


def _read_enums(dirname: str) -> list[_Enum]:
    def enums(elem: etree.Element) -> list[_Enum]:
        tag = _find(elem, 'Tag')
        value = _read_value(elem, tag)
        symbolic_names = _read_symbolic_names(elem, tag, value)
        sort = _read_sort(elem)
        return [_Enum(tag, value, symbolic_name, sort)
                for symbolic_name in symbolic_names]
    filename = _enums_path(dirname)
    tree = etree.parse(filename)
    return sorted([enum for elem in tree.findall('Enum') for enum in enums(elem)],
                  key=lambda enum: int(enum.tag))


def _sorted_enums(enums: list[_Enum]) -> list[_Enum]:
    if all(enum.sort is not None for enum in enums):
        return sorted(enums, key=lambda enum: enum.sort or 0)
    return enums


_VALUES = {
    ('276', 'f '): 'f',
}


def _read_value(elem: etree.Element, tag: str) -> str:
    value = _find(elem, 'Value')
    return _VALUES.get((tag, value), value)


def _read_sort(root: etree.Element) -> typing.Optional[int]:
    elem = root.find('Sort')
    if elem is None or elem.text is None:
        return None
    return int(elem.text)


_SYMBOLIC_NAMES = {
    ('574', '63'): 'CrossAuction2',
    ('574', '64'): 'CounterOrderSelection2',
    ('574', '65'): 'CallAuction2',
}


_SYMBOLIC_NAME_ALIASES = {
    ('434', '2'): [
        'OrderCancelReplaceRequest',
    ]
}


def _read_symbolic_names(elem: etree.Element, tag: str, value: str) -> list[str]:
    symbolic_name = _find(elem, 'SymbolicName')
    primary = _SYMBOLIC_NAMES.get((tag, value), symbolic_name)
    aliases = _SYMBOLIC_NAME_ALIASES.get((tag, value), [])
    return [primary] + aliases


def _enums_path(dirname: str) -> str:
    return os.path.join(dirname, 'Enums.xml')


def _fields_path(dirname: str) -> str:
    return os.path.join(dirname, 'Fields.xml')


def _messages_path(dirname: str) -> str:
    return os.path.join(dirname, 'Messages.xml')


def _find(root: etree.Element, match: str) -> str:
    elem = root.find(match)
    return elem.text if elem is not None and elem.text else ''
