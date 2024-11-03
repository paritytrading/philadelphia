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
from . import etree
from . import model


def read_messages(filename: str) -> list[model.Message]:
    def message(elem: etree.Element) -> model.Message:
        name = etree.get(elem, 'name')
        msgtype = etree.get(elem, 'msgtype')
        return model.Message(name=name, msg_type=msgtype)
    tree = etree.parse(filename)
    return [message(elem) for elem in tree.findall('./messages/message')]


def read_fields(filename: str) -> list[model.Field]:
    tree = etree.parse(filename)
    return sorted([_read_field(elem) for elem in tree.findall('./fields/field')],
                  key=lambda field: int(field.tag))


def read_enumerations(filename: str) -> list[model.Enumeration]:
    def enumeration(elem: etree.Element) -> model.Enumeration:
        field = _read_field(elem)
        values = _read_values(elem)
        type_ = _read_type(elem, values)
        return model.Enumeration(primary_field=field, secondary_fields=[], type_=type_, values=values)
    tree = etree.parse(filename)
    return sorted([enumeration(elem) for elem in tree.findall('./fields/field') if _has_values(elem)],
                  key=lambda enumeration: int(enumeration.primary_field.tag))


_TYPES = {
    'CHAR': 'char',
    'INT': 'int',
    'MULTIPLECHARVALUE': 'char',
    'MULTIPLESTRINGVALUE': 'String',
    'NUMINGROUP': 'int',
    'STRING': 'String',
}


def _read_field(elem: etree.Element) -> model.Field:
    number = etree.get(elem, 'number')
    name = etree.get(elem, 'name')
    return model.Field(tag=number, name=name)


def _read_type(elem: etree.Element, values: list[model.Value]) -> str:
    type_ = _TYPES.get(etree.get(elem, 'type'), 'String')
    if type_ == 'char' and values and max(len(value.value) for value in values) > 1:
        return 'String'
    return type_


def _has_values(elem: etree.Element) -> bool:
    return etree.get(elem, 'name') != 'MsgType' and elem.find('value') is not None


def _read_values(root: etree.Element) -> list[model.Value]:
    def value(elem: etree.Element) -> model.Value:
        enum = etree.get(elem, 'enum')
        description = etree.get(elem, 'description')
        return model.Value(name=description, value=enum)
    return [value(elem) for elem in root.findall('value')]
