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
import string
import textwrap
import typing


_TYPE_FORMATTERS: dict[str, typing.Callable[[str], str]] = {
    'char': lambda value: '\'' + value + '\'',
    'int': str,
    'String': lambda value: '"' + value + '"',
}


class ConstantField(typing.NamedTuple):
    type_: str
    name: str
    value: str


def _format_constant_fields(fields: list[ConstantField]) -> str:
    type_width = max(len(field.type_) for field in fields)
    name_width = max(len(field.name) for field in fields)
    return '\n'.join(_format_constant_field(field, type_width, name_width)
                     for field in fields)


def _format_constant_field(field: ConstantField, type_width: int,
        name_width: int) -> str:
    return 'public static final {:<{}} {:<{}} = {};'.format(
        field.type_, type_width, field.name, name_width,
        _TYPE_FORMATTERS[field.type_](field.value))


class InnerClass:

    def __init__(self, name: str, javadoc: str,
            fields: list[ConstantField]) -> None:
        self.name = name
        self.javadoc = javadoc
        self.fields = fields

    def __str__(self) -> str:
        body = _format_constant_fields(self.fields)
        return _INNER_CLASS_TEMPLATE.substitute(
            name=self.name,
            javadoc=_format_javadoc(self.javadoc),
            body=_indent(body),
        )

    def _format_fields(self) -> str:
        return _format_constant_fields(self.fields)


_INNER_CLASS_TEMPLATE = string.Template('''\
${javadoc}
public static class ${name} {

${body}

    private ${name}() {
    }

}\
''')


class Class:

    def __init__(self, name: str, javadoc: str,
            classes: typing.Optional[list[InnerClass]] = None,
            fields: typing.Optional[list[ConstantField]] = None) -> None:
        self.name = name
        self.javadoc = javadoc
        self.classes = classes if classes else []
        self.fields = fields if fields else []

    def __str__(self) -> str:
        body = self._format_classes() or self._format_fields()
        return _CLASS_TEMPLATE.substitute(
            name=self.name,
            javadoc=_format_javadoc(self.javadoc),
            body=_indent(body),
        )

    def _format_classes(self) -> str:
        return '\n\n'.join(str(class_) for class_ in self.classes)

    def _format_fields(self) -> str:
        return _format_constant_fields(self.fields)


_CLASS_TEMPLATE = string.Template('''\
${javadoc}
public class ${name} {

${body}

    private ${name}() {
    }

}\
''')


class Package:

    def __init__(self, name: str) -> None:
        self.name = name

    def __str__(self):
        return 'package {};'.format(self.name)


class CompilationUnit:

    def __init__(self, package: Package, class_: Class) -> None:
        self.package = package
        self.class_ = class_

    def __str__(self):
        return '{}\n\n{}\n\n{}'.format(self.package, COMPILATION_UNIT_COMMENT,
                                       self.class_)


COMPILATION_UNIT_COMMENT = '''\
/*
 * This file has been automatically generated using Philadelphia Code
 * Generator. For more information on Philadelphia Code Generator, see:
 *
 *   https://github.com/paritytrading/philadelphia
 */\
'''


_JAVADOC_HEADER = '/**\n'

_JAVADOC_PREFIX = ' *'

_JAVADOC_FOOTER = ' */'


def _format_javadoc(javadoc: str) -> str:
    lines = javadoc.splitlines()
    body = ''.join('{}{}{}\n'.format(_JAVADOC_PREFIX, ' ' if line else '', line) for line in lines)
    return '{}{}{}'.format(_JAVADOC_HEADER, body, _JAVADOC_FOOTER)


def _indent(text: str) -> str:
    return textwrap.indent(text, '    ')
