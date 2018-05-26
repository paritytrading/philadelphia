import sys

from . import model
from . import repository


USAGE = '''\
Usage: philadelphia-generate <command> <input-path>

Commands:
  enumerations  Generate enumerations
  msg-types     Generate message types
  tags          Generate tags
'''


def enumerations(path):
    dialect = repository.read_dialect(path)
    fields = repository.read_fields(path)
    print(model.format_enumerations(fields, dialect))


def msg_types(path):
    dialect = repository.read_dialect(path)
    messages = repository.read_messages(path)
    print(model.format_msg_types(messages, dialect))


def tags(path):
    dialect = repository.read_dialect(path)
    fields = repository.read_fields(path)
    print(model.format_tags(fields, dialect))


COMMANDS = {
    'enumerations': enumerations,
    'msg-types': msg_types,
    'tags': tags,
}


def main():
    if len(sys.argv) != 3:
        sys.exit(USAGE)

    command = COMMANDS.get(sys.argv[1])
    if not command:
        sys.exit('error: {}: Unknown command'.format(sys.argv[1]))

    command(sys.argv[2])


if __name__ == '__main__':
    main()
