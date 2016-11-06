#!/usr/bin/env python

import collections
import itertools
import os.path
import re
import string
import sys
import xml.etree.ElementTree

INDENT = '    '

SYMBOLIC_NAME_ALIASES = {
    ('434', '2'): [
        'OrderCancelReplaceRequest',
    ],
}

Enum = collections.namedtuple('Enum', ['tag', 'value', 'symbolic_name', 'sort'])

def read_enums(infile):
    def enum_with_aliases(elem):
        tag = elem.find('Tag').text
        value = elem.find('Value').text
        symbolic_name = elem.find('SymbolicName').text
        sort = int(elem.find('Sort').text) if elem.find('Sort') is not None else None
        enum = Enum(tag, value, symbolic_name, sort)
        return [enum] + [enum._replace(symbolic_name=symbolic_name_alias)
                for symbolic_name_alias in SYMBOLIC_NAME_ALIASES.get((tag, value), [])]
    tree = xml.etree.ElementTree.parse(infile)
    enums = [enum_with_aliases(elem) for elem in tree.findall('Enum')]
    return [enum for aliases in enums for enum in aliases]

Field = collections.namedtuple('Field', ['tag', 'name', 'type'])

def read_fields(infile):
    def field(elem):
        tag = elem.find('Tag').text
        name = elem.find('Name').text
        type = elem.find('Type').text
        return Field(tag, name, type)
    tree = xml.etree.ElementTree.parse(infile)
    return [field(elem) for elem in tree.findall('Field')]

Message = collections.namedtuple('Message', ['msg_type', 'name'])

def read_messages(infile):
    def message(elem):
        msg_type = elem.find('MsgType').text
        name = elem.find('Name').text
        return Message(msg_type, name)
    tree = xml.etree.ElementTree.parse(infile)
    return [message(elem) for elem in tree.findall('Message')]

Version = collections.namedtuple('Version', ['protocol', 'major', 'minor', 'sp'])

def read_version(infile):
    version = xml.etree.ElementTree.parse(infile).getroot().get('version')
    match = re.match(r'(?P<protocol>.+)\.(?P<major>\d+)\.(?P<minor>\d+)(SP(?P<sp>\d+))?', version)
    return Version(match.group('protocol'), match.group('major'), match.group('minor'),
        match.group('sp'))

ENUMERATIONS_TEMPLATE = string.Template('''\
package com.paritytrading.philadelphia.${package_name};

/**
 * Enumerations for ${version_name}.
 */
public class ${class_name} {

${body}

    private ${class_name}() {
    }

}
''')

def format_enumerations(version, enumerations):
    body = '\n\n'.join(format_enumeration(enumeration) for enumeration in enumerations)
    return ENUMERATIONS_TEMPLATE.substitute({
            'package_name': package_name(version),
            'class_name': class_name(version, 'Enumerations'),
            'version_name': version_name(version),
            'body': body,
        })

ENUMERATION_TEMPLATE = string.Template('''\
    /**
     * Values for ${field_name}.
     */
    public static class ${class_name} {

${body}

        private ${class_name}() {
        }

    }\
''')

def format_char(value, value_width):
    return '\'{}\''.format(value)

def format_string(value, value_width):
    return '"{}"'.format(value)

def format_int(value, value_width):
    return '{:>{}}'.format(value, value_width)

FIELD_TYPES = {
    'Char': ('char', format_char),
    'char': ('char', format_char),
    'Int': ('int', format_int),
    'int': ('int', format_int),
    'MultipleCharValue': ('char', format_char),
    'MultipleStringValue': ('String', format_string),
    'MultipleValueString': ('String', format_string),
    'NumInGroup': ('int', format_int),
    'String': ('String', format_string),
}

def format_enumeration(enumeration):
    symbolic_name_width = max(len(enum.symbolic_name) for enum in enumeration.enums)
    value_width = max(len(enum.value) for enum in enumeration.enums)
    type, format_type = FIELD_TYPES[enumeration.field.type]
    if type == 'char' and value_width > 1:
        type, format_type = FIELD_TYPES['String']
    body = '\n'.join('{}{}'.format(2 * INDENT, format_enum(enum, type, symbolic_name_width,
      format_type, value_width)) for enum in enumeration.enums)
    return ENUMERATION_TEMPLATE.substitute({
            'field_name': field_name(enumeration.field),
            'class_name': '{}Values'.format(enumeration.field.name),
            'body': body,
        })

def format_enum(enum, type, symbolic_name_width, format_type, value_width):
    return 'public static final {} {:<{}} = {};'.format(type, enum.symbolic_name,
        symbolic_name_width, format_type(enum.value, value_width))

MSG_TYPES_TEMPLATE = string.Template('''\
package com.paritytrading.philadelphia.${package_name};

/**
 * Message types for ${version_name}.
 */
public class ${class_name} {

${body}

    private ${class_name}() {
    }

}
''')

def format_msg_types(version, messages):
    name_width = max(len(message.name) for message in messages)
    msg_type_width = max(len(message.msg_type) for message in messages)
    body = '\n'.join('{}{}'.format(INDENT, format_msg_type(message, name_width, msg_type_width))
        for message in messages)
    return MSG_TYPES_TEMPLATE.substitute({
            'package_name': package_name(version),
            'class_name': class_name(version, 'MsgTypes'),
            'version_name': version_name(version),
            'body': body,
        })

def format_msg_type(message, name_width, msg_type_width):
    if len(message.msg_type) > 1:
        return 'public static final String {:<{}} = "{}";'.format(message.name,
            name_width, message.msg_type)
    else:
        return 'public static final {} {:<{}} = \'{}\';'.format('char' if msg_type_width == 1
            else 'char  ', message.name, name_width, message.msg_type)

TAGS_TEMPLATE = string.Template('''\
package com.paritytrading.philadelphia.${package_name};

/**
 * Tags for ${version_name}.
 */
public class ${class_name} {

${body}

    private ${class_name}() {
    }

}
''')

def format_tags(version, fields):
    name_width = max(len(field.name) for field in fields)
    tag_width = max(len(field.tag)  for field in fields)
    body = '\n'.join('{}{}'.format(INDENT, format_tag(field, name_width, tag_width))
        for field in fields)
    return TAGS_TEMPLATE.substitute({
            'package_name': package_name(version),
            'class_name': class_name(version, 'Tags'),
            'version_name': version_name(version),
            'body': body,
        })

def format_tag(field, name_width, tag_width):
    return 'public static final int {:<{}} = {:>{}};'.format(field.name,
        name_width, field.tag, tag_width)

def version_name(version):
    base = '{} {}.{}'.format(version.protocol, version.major, version.minor)
    if version.sp:
        return '{} Service Pack {}'.format(base, version.sp)
    else:
        return base

def class_name(version, suffix=''):
    base = ''.join([version.protocol, version.major, version.minor])
    if version.sp:
        return '{}SP{}{}'.format(base, version.sp, suffix)
    else:
        return '{}{}'.format(base, suffix)

def package_name(version):
    return class_name(version).lower()

def field_name(field):
    return '{}({})'.format(field.name, field.tag)

def enums_path(indir):
    return os.path.join(indir, 'Enums.xml')

def fields_path(indir):
    return os.path.join(indir, 'Fields.xml')

def messages_path(indir):
    return os.path.join(indir, 'Messages.xml')

Enumeration = collections.namedtuple('Enumeration', ['field', 'enums'])

def enumerations(indir):
    version = read_version(enums_path(indir))
    enums = sorted(read_enums(enums_path(indir)), key=lambda enum: int(enum.tag))
    fields = {field.tag: field for field in read_fields(fields_path(indir))}
    enumerations = [Enumeration(fields[tag], fix_symbolic_names(sort_by_sort_key(list(enums))))
        for tag, enums
        in itertools.groupby(enums, lambda enum: enum.tag)
        if tag in fields and fields[tag].type != 'Boolean'
        and fields[tag].name != 'MsgType']
    sys.stdout.write(format_enumerations(version, enumerations))

def sort_by_sort_key(enums):
    if all(enum.sort is not None for enum in enums):
        return sorted(enums, key=lambda enum: enum.sort)
    else:
        return enums

def fix_symbolic_names(enums):
    counts = collections.Counter(enum.symbolic_name for enum in enums)
    indexes = collections.Counter()
    def fix_symbolic_name(enum):
        if counts[enum.symbolic_name] > 1:
            indexes[enum.symbolic_name] += 1
            symbolic_name = enum.symbolic_name + str(indexes[enum.symbolic_name])
            return enum._replace(symbolic_name=symbolic_name)
        else:
            return enum
    return [fix_symbolic_name(enum) for enum in enums]

def msg_types(indir):
    version = read_version(messages_path(indir))
    messages = read_messages(messages_path(indir))
    sys.stdout.write(format_msg_types(version, messages))

def tags(indir):
    version = read_version(fields_path(indir))
    fields = read_fields(fields_path(indir))
    sys.stdout.write(format_tags(version, fields))

USAGE = '''\
Usage: {} <command> <input-directory>

Commands:
  enumerations  Generate enumerations
  msg-types     Generate message types
  tags          Generate tags
'''

COMMANDS = {
    'enumerations': enumerations,
    'msg-types': msg_types,
    'tags': tags,
}

if len(sys.argv) != 3:
    sys.exit(USAGE.format(os.path.basename(sys.argv[0])))

command = COMMANDS.get(sys.argv[1])
if not command:
    sys.exit('error: {}: Unknown command'.format(sys.argv[1]))

command(sys.argv[2])
