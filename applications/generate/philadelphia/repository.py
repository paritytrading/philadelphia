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
import collections
import itertools
import os
import re
import xml.etree.ElementTree

from . import model


def read_dialect(dirname):
    version = _read_version(dirname)
    class_name_prefix = _class_name_prefix(version)
    package_name = _package_name(class_name_prefix)
    name = _name(version)
    return model.Dialect(package_name, class_name_prefix, name)


def _class_name_prefix(version):
    return ''.join([version.protocol, version.major, version.minor, version.sp])


def _package_name(class_name_prefix):
    return 'com.paritytrading.philadelphia.{}'.format(class_name_prefix.lower())


def _name(version):
    name = '{} {}.{}'.format(version.protocol, version.major, version.minor)
    if version.sp:
        return '{} {}'.format(name, version.sp)
    return name


_Version = collections.namedtuple('_Version', ['protocol', 'major', 'minor', 'sp'])


def _read_version(dirname):
    filename = _messages_path(dirname)
    tree = xml.etree.ElementTree.parse(filename)
    value = tree.getroot().get('version')
    match = re.match(r'(?P<protocol>.+)\.(?P<major>\d+)\.(?P<minor>\d+)((?P<sp>SP\d+))?', value)
    return _Version(protocol=match.group('protocol'), major=match.group('major'),
            minor=match.group('minor'), sp=match.group('sp') or '')


def read_messages(dirname):
    def message(elem):
        name = elem.find('Name').text
        msg_type = elem.find('MsgType').text
        return model.Message(name, msg_type)
    filename = _messages_path(dirname)
    tree = xml.etree.ElementTree.parse(filename)
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


_TYPES = {
    'Char': 'char',
    'char': 'char',
    'Int': 'int',
    'int': 'int',
    'MultipleCharValue': 'char',
    'MultipleStringValue': 'String',
    'MultipleValueString': 'String',
    'NumInGroup': 'int',
    'String': 'String',
}


def _type(field_type, values):
    type_ = _TYPES.get(field_type)
    if type_ == 'char' and values and max(len(value.value) for value in values) > 1:
        return 'String'
    return type_


def _values(tag, field, tag_values):
    if field.type_ == 'Boolean' or field.name == 'MsgType':
        return []
    return tag_values.get(tag, [])


_Field = collections.namedtuple('_Field', ['name', 'type_'])


def _read_tag_fields(dirname):
    def tag(elem):
        return elem.find('Tag').text
    def field(elem):
        name = elem.find('Name').text
        type_ = elem.find('Type').text
        return _Field(name, type_)
    filename = _fields_path(dirname)
    tree = xml.etree.ElementTree.parse(filename)
    return {tag(elem): field(elem) for elem in tree.findall('Field')}


def _read_tag_values(dirname):
    def value(enum):
        return model.Value(name=enum.symbolic_name, value=enum.value)
    def values(enums):
        return [value(enum) for enum in _sort_enums(enums)]
    enums = _read_enums(dirname)
    return {tag: values(list(enums)) for tag, enums in
            itertools.groupby(enums, lambda enum: enum.tag)}


_Enum = collections.namedtuple('_Enum', ['tag', 'value', 'symbolic_name', 'sort'])


def _read_enums(dirname):
    def enums(elem):
        tag = elem.find('Tag').text
        value = _value(elem, tag)
        symbolic_names = _symbolic_names(elem, tag, value)
        sort = _sort(elem)
        return [_Enum(tag, value, symbolic_name, sort)
                for symbolic_name in symbolic_names]
    filename = _enums_path(dirname)
    tree = xml.etree.ElementTree.parse(filename)
    return sorted([enum for elem in tree.findall('Enum') for enum in enums(elem)],
            key=lambda enum: int(enum.tag))


def _sort_enums(enums):
    if all(enum.sort is not None for enum in enums):
        return sorted(enums, key=lambda enum: enum.sort)
    return enums


_VALUES = {
    ('276', 'f '): 'f',
}


def _value(elem, tag):
    value = elem.find('Value').text
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


def _symbolic_names(elem, tag, value):
    symbolic_name = elem.find('SymbolicName').text
    primary = _SYMBOLIC_NAMES.get((tag, value), symbolic_name)
    aliases = _SYMBOLIC_NAME_ALIASES.get((tag, value), [])
    return [primary] + aliases


def _sort(elem):
    value = elem.find('Sort')
    return int(value.text) if value is not None else None


def _enums_path(dirname):
    return os.path.join(dirname, 'Enums.xml')


def _fields_path(dirname):
    return os.path.join(dirname, 'Fields.xml')


def _messages_path(dirname):
    return os.path.join(dirname, 'Messages.xml')
