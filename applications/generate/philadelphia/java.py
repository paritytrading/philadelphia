import collections
import string
import textwrap


COMPILATION_UNIT_COMMENT = '''\
/*
 * This file has been automatically generated using Philadelphia Code
 * Generator. For more information on Philadelphia Code Generator, see:
 *
 *   https://github.com/paritytrading/philadelphia
 */\
'''


class CompilationUnit(object):

    def __init__(self, package, class_):
        self.package = package
        self.class_ = class_

    def __str__(self):
        return '{}\n\n{}\n\n{}'.format(self.package, COMPILATION_UNIT_COMMENT,
                self.class_)


class Package(object):

    def __init__(self, name):
        self.name = name

    def __str__(self):
        return 'package {};'.format(self.name)


class Class(object):

    def __init__(self, name, javadoc, classes=None, fields=None):
        self.name = name
        self.javadoc = javadoc
        self.classes = classes if classes else []
        self.fields = fields if fields else []

    def __str__(self):
        body = self._format_classes() or self._format_fields()
        return _CLASS_TEMPLATE.substitute(
                name=self.name,
                javadoc=self.javadoc,
                body=_indent(body),
            )

    def _format_classes(self):
        return '\n\n'.join(str(class_) for class_ in self.classes)

    def _format_fields(self):
        return _format_constant_fields(self.fields)


_CLASS_TEMPLATE = string.Template('''\
/**
 * ${javadoc}
 */
public class ${name} {

${body}

    private ${name}() {
    }

}\
''')


class InnerClass(object):

    def __init__(self, name, javadoc, fields):
        self.name = name
        self.javadoc = javadoc
        self.fields = fields

    def __str__(self):
        body = _format_constant_fields(self.fields)
        return _INNER_CLASS_TEMPLATE.substitute(
                name=self.name,
                javadoc=self.javadoc,
                body=_indent(body),
            )

    def _format_fields(self):
        return _format_constant_fields(self.fields)


_INNER_CLASS_TEMPLATE = string.Template('''\
/**
 * ${javadoc}
 */
public static class ${name} {

${body}

    private ${name}() {
    }

}\
''')


_TYPE_FORMATTERS = {
    'char': lambda value: '\'{}\''.format(value),
    'int': lambda value: '{}'.format(value),
    'String': lambda value: '"{}"'.format(value),
}


ConstantField = collections.namedtuple('ConstantField', ['type_', 'name', 'value'])


def _format_constant_fields(fields):
    type_width = max(len(field.type_) for field in fields)
    name_width = max(len(field.name) for field in fields)
    return '\n'.join(_format_constant_field(field, type_width, name_width)
            for field in fields)


def _format_constant_field(field, type_width, name_width):
    return 'public static final {:<{}} {:<{}} = {};'.format(
            field.type_, type_width, field.name, name_width,
            _TYPE_FORMATTERS[field.type_](field.value))


def _indent(text):
    return textwrap.indent(text, '    ')
