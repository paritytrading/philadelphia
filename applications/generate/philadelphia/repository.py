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
from . import source


def read_messages(dirname):
    def message(elem: etree.Element) -> model.Message:
        name = _text(elem.find('Name'))
        msg_type = _text(elem.find('MsgType'))
        return model.Message(name, msg_type)
    filename = _messages_path(dirname)
    tree = etree.parse(filename)
    return [message(elem) for elem in tree.findall('Message')]


def read_fields(dirname):
    tag_fields = _read_tag_fields(dirname)
    tag_values = _read_tag_values(dirname)
    def field_with_values(tag, field):
        name = field.name
        values = _values(tag, field, tag_values)
        type_ = _type(field.type_, values)
        return model.Field(tag, name, type_, values)
    fields = [field_with_values(tag, field) for tag, field in tag_fields.items()]
    return sorted(fields, key=lambda field: int(field.tag))


READER = source.Reader(read_fields, read_messages)


_TYPES = {
    'Char': 'char',
    'Int': 'int',
    'MultipleCharValue': 'char',
    'MultipleStringValue': 'String',
    'MultipleValueString': 'String',
    'NumInGroup': 'int',
}


def _type(field_type: str, values: typing.List[model.Value]) -> str:
    type_ = _TYPES.get(field_type, field_type)
    if type_ == 'char' and values and max(len(value.value) for value in values) > 1:
        return 'String'
    return type_


class _Field(typing.NamedTuple):
    name: str
    type_: str


def _values(tag: str, field: _Field,
        tag_values: typing.Dict[str, typing.List[model.Value]]) -> typing.List[model.Value]:
    if field.type_ == 'Boolean' or field.name == 'MsgType':
        return []
    return tag_values.get(tag, [])


def _read_tag_fields(dirname: str) -> typing.Dict[str, _Field]:
    def tag(elem: etree.Element) -> str:
        return _text(elem.find('Tag'))
    def field(elem: etree.Element) -> _Field:
        name = _text(elem.find('Name'))
        type_ = _text(elem.find('Type'))
        return _Field(name, type_)
    filename = _fields_path(dirname)
    tree = etree.parse(filename)
    return {tag(elem): field(elem) for elem in tree.findall('Field')}


class _Enum(typing.NamedTuple):
    tag: str
    value: str
    symbolic_name: str
    sort: typing.Optional[int]


def _read_tag_values(dirname: str) -> typing.Dict[str, typing.List[model.Value]]:
    def value(enum: _Enum) -> model.Value:
        return model.Value(name=enum.symbolic_name, value=enum.value)
    def values(enums: typing.List[_Enum]):
        return [value(enum) for enum in _sort_enums(enums)]
    enums = _read_enums(dirname)
    return {tag: values(list(enums)) for tag, enums in
            itertools.groupby(enums, lambda enum: enum.tag)}


def _read_enums(dirname: str) -> typing.List[_Enum]:
    def enums(elem: etree.Element) -> typing.List[_Enum]:
        tag = _text(elem.find('Tag'))
        value = _value(elem, tag)
        symbolic_names = _symbolic_names(elem, tag, value)
        sort = _sort(elem)
        return [_Enum(tag, value, symbolic_name, sort)
                for symbolic_name in symbolic_names]
    filename = _enums_path(dirname)
    tree = etree.parse(filename)
    return sorted([enum for elem in tree.findall('Enum') for enum in enums(elem)],
                  key=lambda enum: int(enum.tag))


def _sort_enums(enums: typing.List[_Enum]) -> typing.List[_Enum]:
    if all(enum.sort is not None for enum in enums):
        return sorted(enums, key=lambda enum: enum.sort or 0)
    return enums


_VALUES = {
    ('276', 'f '): 'f',
}


def _value(elem: etree.Element, tag: str) -> str:
    value = _text(elem.find('Value'))
    return _VALUES.get((tag, value), value)


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


def _symbolic_names(elem: etree.Element, tag: str, value: str) -> typing.List[str]:
    symbolic_name = _text(elem.find('SymbolicName'))
    primary = _SYMBOLIC_NAMES.get((tag, value), symbolic_name)
    aliases = _SYMBOLIC_NAME_ALIASES.get((tag, value), [])
    return [primary] + aliases


def _sort(root: etree.Element) -> typing.Optional[int]:
    elem = root.find('Sort')
    if elem is None or elem.text is None:
        return None
    return int(elem.text)


def _enums_path(dirname: str) -> str:
    return os.path.join(dirname, 'Enums.xml')


def _fields_path(dirname: str) -> str:
    return os.path.join(dirname, 'Fields.xml')


def _messages_path(dirname: str) -> str:
    return os.path.join(dirname, 'Messages.xml')


def _text(elem: typing.Optional[etree.Element]) -> str:
    if elem is None:
        raise RuntimeError('Missing element')
    return elem.text or ''
