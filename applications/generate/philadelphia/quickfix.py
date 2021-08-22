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
import typing

from . import etree
from . import model
from . import source


def read_messages(filename: str) -> typing.List[model.Message]:
    def message(elem: etree.Element) -> model.Message:
        name = etree.get(elem, 'name')
        msgtype = etree.get(elem, 'msgtype')
        return model.Message(name=name, msg_type=msgtype)
    tree = etree.parse(filename)
    return [message(elem) for elem in tree.findall('./messages/message')]


def read_fields(filename: str) -> typing.List[model.Field]:
    def field(elem: etree.Element) -> model.Field:
        number = etree.get(elem, 'number')
        name = etree.get(elem, 'name')
        type_ = _read_type(elem)
        values = _read_values(elem) if _has_values(name) else []
        return model.Field(tag=number, name=name, type_=type_, values=values)
    tree = etree.parse(filename)
    return sorted([field(elem) for elem in tree.findall('./fields/field')],
                  key=lambda field: int(field.tag))


READER = source.Reader(read_fields, read_messages)


_TYPES = {
    'CHAR': 'char',
    'INT': 'int',
    'MULTIPLECHARVALUE': 'char',
    'MULTIPLESTRINGVALUE': 'String',
    'NUMINGROUP': 'int',
    'STRING': 'String',
}


def _read_type(elem: etree.Element) -> str:
    type_ = etree.get(elem, 'type')
    return _TYPES.get(type_, 'String')


def _has_values(name: str) -> bool:
    return name != 'MsgType'


def _read_values(root: etree.Element) -> typing.List[model.Value]:
    def value(elem: etree.Element) -> model.Value:
        enum = etree.get(elem, 'enum')
        description = etree.get(elem, 'description')
        return model.Value(name=description, value=enum)
    return [value(elem) for elem in root.findall('value')]
