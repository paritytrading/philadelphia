#
# Copyright 2021 Philadelphia authors
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
import xml.etree.ElementTree


ElementTree = xml.etree.ElementTree.ElementTree

Element = xml.etree.ElementTree.Element


def parse(filename: str) -> ElementTree:
    return xml.etree.ElementTree.parse(filename)


def get(elem: Element, key: str) -> str:
    value = elem.get(key)
    if not value:
        raise KeyError('Attribute not found: {}'.format(key))
    return value
