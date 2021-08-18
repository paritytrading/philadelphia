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
import os.path
import sys
import typing

from . import model
from . import orchestra
from . import quickfix
from . import repository
from . import source


USAGE = '''\
Usage: philadelphia-generate <command> [<configuration-file>] <input-path>

Commands:
  enumerations  Generate enumerations
  msg-types     Generate message types
  tags          Generate tags
'''


def enumerations(config: str, path: str) -> None:
    reader = find_reader(path)
    dialect = read_dialect(config, reader, path)
    fields = reader.read_fields(path)
    print(model.format_enumerations(fields, dialect))


def msg_types(config: str, path: str) -> None:
    reader = find_reader(path)
    dialect = read_dialect(config, reader, path)
    messages = reader.read_messages(path)
    print(model.format_msg_types(messages, dialect))


def tags(config: str, path: str) -> None:
    reader = find_reader(path)
    dialect = read_dialect(config, reader, path)
    fields = reader.read_fields(path)
    print(model.format_tags(fields, dialect))


def read_dialect(config: str, reader: source.Reader, path: str) -> model.Dialect:
    if config:
        return model.read_dialect(config)
    if reader.read_dialect:
        dialect = reader.read_dialect(path)
        if not dialect:
            sys.exit('error: Unable to read dialect')
        return dialect
    sys.exit('error: Missing configuration file')


def find_reader(path: str) -> source.Reader:
    if os.path.isdir(path):
        return repository.READER
    if 'fixr:repository' in read(path):
        return orchestra.READER
    return quickfix.READER


def read(path: str) -> str:
    with open(path, 'r') as infile:
        return infile.read()


COMMANDS = {
    'enumerations': enumerations,
    'msg-types': msg_types,
    'tags': tags,
}


def main():
    if len(sys.argv) != 3 and len(sys.argv) != 4:
        sys.exit(USAGE)

    command = COMMANDS.get(sys.argv[1])
    if not command:
        sys.exit('error: {}: Unknown command'.format(sys.argv[1]))

    if len(sys.argv) == 4:
        config = sys.argv[2]
        path = sys.argv[3]
    else:
        config = None
        path = sys.argv[2]

    command(config, path)


if __name__ == '__main__':
    main()
