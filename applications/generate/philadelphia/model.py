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
import configparser
import typing

from . import java


class Dialect(typing.NamedTuple):
    package_name: str
    class_name_prefix: str
    name: str


class Field(typing.NamedTuple):
    tag: str
    name: str


class Value(typing.NamedTuple):
    name: str
    value: str


class Enumeration(typing.NamedTuple):
    primary_field: Field
    secondary_fields: list[Field]
    type_: str
    values: list[Value]


class Message(typing.NamedTuple):
    name: str
    msg_type: str


def read_dialect(filename: str) -> Dialect:
    config = configparser.ConfigParser()
    config.read(filename)
    package_name = config['dialect']['package-name']
    class_name_prefix = config['dialect']['class-name-prefix']
    name = config['dialect']['name']
    return Dialect(package_name, class_name_prefix, name)


def format_enumerations(enumerations: list[Enumeration], dialect: Dialect) -> java.CompilationUnit:
    name = '{}Enumerations'.format(dialect.class_name_prefix)
    javadoc = 'Enumerations for {}.'.format(dialect.name)
    classes = [_format_enumeration(enumeration) for enumeration in enumerations]
    class_ = java.Class(name=name, javadoc=javadoc, classes=classes)
    package = java.Package(name=dialect.package_name)
    return java.CompilationUnit(package, class_)


def _format_enumeration(enumeration: Enumeration) -> java.InnerClass:
    primary_field = enumeration.primary_field
    name = '{}Values'.format(primary_field.name)
    primary_field_javadoc = _format_primary_field_javadoc(enumeration)
    secondary_fields_javadoc = _format_secondary_fields_javadoc(enumeration) or ''
    javadoc = '{}{}'.format(primary_field_javadoc, secondary_fields_javadoc)
    fields = [java.ConstantField(type_=enumeration.type_, name=value.name, value=value.value)
              for value in enumeration.values]
    return java.InnerClass(name=name, javadoc=javadoc, fields=fields)


def _format_primary_field_javadoc(enumeration: Enumeration) -> str:
    field = enumeration.primary_field
    return 'Values for {}({}).'.format(field.name, field.tag)


def _format_secondary_fields_javadoc(enumeration: Enumeration) -> typing.Optional[str]:
    fields = enumeration.secondary_fields
    if not fields:
        return None
    header = '\n\n<p>The following fields also use these values:</p>\n<ul>\n'
    items = ''.join('  <li>{}({})</li>\n'.format(field.name, field.tag) for field in fields)
    footer = '</ul>\n'
    return '{}{}{}'.format(header, items, footer)


def format_msg_types(messages: list[Message], dialect: Dialect) -> java.CompilationUnit:
    name = '{}MsgTypes'.format(dialect.class_name_prefix)
    javadoc = 'Message types for {}.'.format(dialect.name)
    fields = [_format_msg_type(message) for message in messages]
    return _format_constant_fields(name, javadoc, fields, dialect)


def _format_msg_type(message: Message) -> java.ConstantField:
    type_ = 'String' if len(message.msg_type) > 1 else 'char'
    return java.ConstantField(type_=type_, name=message.name, value=message.msg_type)


def format_tags(fields: list[Field], dialect: Dialect) -> java.CompilationUnit:
    name = '{}Tags'.format(dialect.class_name_prefix)
    javadoc = 'Tags for {}.'.format(dialect.name)
    constant_fields = [_format_tag(field) for field in fields]
    return _format_constant_fields(name, javadoc, constant_fields, dialect)


def _format_tag(field: Field) -> java.ConstantField:
    return java.ConstantField(type_='int', name=field.name, value=field.tag)


def _format_constant_fields(name: str, javadoc: str,
        fields: list[java.ConstantField], dialect: Dialect) -> java.CompilationUnit:
    package = java.Package(name=dialect.package_name)
    class_ = java.Class(name=name, javadoc=javadoc, fields=fields)
    return java.CompilationUnit(package, class_)
