import collections
import configparser

from . import java


Dialect = collections.namedtuple('Dialect', ['package_name', 'class_name_prefix', 'name'])


Field = collections.namedtuple('Field', ['tag', 'name', 'type_', 'values'])


Value = collections.namedtuple('Value', ['name', 'value'])


Message = collections.namedtuple('Message', ['name', 'msg_type'])


def read_dialect(filename):
    config = configparser.ConfigParser()
    config.read(filename)
    package_name = config['dialect']['package-name']
    class_name_prefix = config['dialect']['class-name-prefix']
    name = config['dialect']['name']
    return Dialect(package_name, class_name_prefix, name)


def format_enumerations(fields, dialect):
    name = '{}Enumerations'.format(dialect.class_name_prefix)
    javadoc = 'Enumerations for {}.'.format(dialect.name)
    classes = [_format_enumeration(field) for field in fields if field.values]
    class_ = java.Class(name=name, javadoc=javadoc, classes=classes)
    package = java.Package(name=dialect.package_name)
    return java.CompilationUnit(package, class_)


def _format_enumeration(field):
    name = '{}Values'.format(field.name)
    javadoc = 'Values for {}({}).'.format(field.name, field.tag)
    fields = [java.ConstantField(type_=field.type_, name=value.name, value=value.value)
            for value in field.values]
    return java.InnerClass(name=name, javadoc=javadoc, fields=fields)


def format_msg_types(messages, dialect):
    name = '{}MsgTypes'.format(dialect.class_name_prefix)
    javadoc = 'Message types for {}.'.format(dialect.name)
    fields = [_format_msg_type(message) for message in messages]
    return _format_constant_fields(name, javadoc, fields, dialect)


def _format_msg_type(message):
    type_ = 'String' if len(message.msg_type) > 1 else 'char'
    return java.ConstantField(type_=type_, name=message.name, value=message.msg_type)


def format_tags(fields, dialect):
    name = '{}Tags'.format(dialect.class_name_prefix)
    javadoc = 'Tags for {}.'.format(dialect.name)
    fields = [_format_tag(field) for field in fields]
    return _format_constant_fields(name, javadoc, fields, dialect)


def _format_tag(field):
    return java.ConstantField(type_='int', name=field.name, value=field.tag)


def _format_constant_fields(name, javadoc, fields, dialect):
    package = java.Package(name=dialect.package_name)
    class_ = java.Class(name=name, javadoc=javadoc, fields=fields)
    return java.CompilationUnit(package, class_)
