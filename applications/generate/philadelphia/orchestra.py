#
# Copyright 2020 Philadelphia authors
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
import xml.etree.ElementTree
import collections

from . import model


NS = {
    'fixr': 'http://fixprotocol.io/2020/orchestra/repository',
}


def read_messages(filename):
    def message(elem):
        name = elem.get('name')
        msg_type = elem.get('msgType')
        return model.Message(name, msg_type)
    tree = xml.etree.ElementTree.parse(filename)
    return [message(elem) for elem in tree.findall('.//fixr:message', NS)]


def read_fields(filename):
    tree = xml.etree.ElementTree.parse(filename)
    fields = _read_fields(tree)
    code_sets = _read_code_sets(tree)
    return sorted([_field(field, code_sets) for field in fields],
                  key=lambda field: int(field.tag))


def _field(field, code_sets):
    tag = field.id_
    name = field.name
    code_set = code_sets.get(tag)
    type_ = _type(field, code_set)
    has_values = code_set and _has_values(code_set)
    values = [_value(tag, code) for code in code_set.codes] if has_values else []
    return model.Field(tag, name, _TYPES.get(type_, type_), values)


def _type(field, code_set):
    if not code_set:
        return field.type_
    if code_set.type_ == 'char' and max(len(code.value) for code in code_set.codes) > 1:
        return 'String'
    return code_set.type_


_NO_VALUES = [
    '35',
    '41237',
]


def _has_values(code_set):
    return not code_set.id_ in _NO_VALUES and not code_set.type_ == 'Boolean'


_NAME_REPLACEMENTS = {
    ('1779', '1'): 'Int',
    ('1779', '6'): 'Float',
    ('1779', '12'): 'Char',
}


_VALUE_REPLACEMENTS = {
    ('276', 'f '): 'f',
}


def _value(id_, code):
    name = _NAME_REPLACEMENTS.get((id_, code.value), code.name)
    value = _VALUE_REPLACEMENTS.get((id_, code.value), code.value)
    return model.Value(name, value)


_TYPES = {
    'MultipleCharValue': 'char',
    'MultipleStringValue': 'String',
    'MultipleValueString': 'String',
    'NumInGroup': 'int',
}


_Field = collections.namedtuple('_Field', ['id_', 'name', 'type_'])


def _read_fields(tree):
    def field(elem):
        id_ = elem.get('id')
        name = elem.get('name')
        type_ = elem.get('type')
        return _Field(id_, name, type_)
    return [field(elem) for elem in tree.findall('.//fixr:field', NS)]


_Code = collections.namedtuple('_Code', ['name', 'value', 'sort'])

_CodeSet = collections.namedtuple('_CodeSet', ['name', 'id_', 'type_', 'codes'])


def _read_code_sets(tree):
    def code(elem):
        name = elem.get('name')
        value = elem.get('value')
        sort = elem.get('sort')
        return _Code(name, value, int(sort) if sort is not None else None)
    def code_set(elem):
        name = elem.get('name')
        id_ = elem.get('id')
        type_ = elem.get('type')
        codes = [code(elem) for elem in elem.findall('fixr:code', NS)]
        return _CodeSet(name, id_, type_, _sorted_codes(codes))
    code_sets = [code_set(elem) for elem in tree.findall('.//fixr:codeSet', NS)]
    return {code_set.id_: code_set for code_set in code_sets}


def _sorted_codes(codes):
    if all(code.sort is not None for code in codes):
        return sorted(codes, key=lambda code: code.sort)
    return codes
