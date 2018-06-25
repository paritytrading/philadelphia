import os.path
import sys

from . import model
from . import quickfix
from . import repository


USAGE = '''\
Usage: philadelphia-generate <command> [<configuration-file>] <input-path>

Commands:
  enumerations  Generate enumerations
  msg-types     Generate message types
  tags          Generate tags
'''


def enumerations(config, path):
    module = read_module(path)
    dialect = read_dialect(config, module, path)
    fields = module.read_fields(path)
    print(model.format_enumerations(fields, dialect))


def msg_types(config, path):
    module = read_module(path)
    dialect = read_dialect(config, module, path)
    messages = module.read_messages(path)
    print(model.format_msg_types(messages, dialect))


def tags(config, path):
    module = read_module(path)
    dialect = read_dialect(config, module, path)
    fields = module.read_fields(path)
    print(model.format_tags(fields, dialect))


def read_dialect(config, module, path):
    if config:
        return model.read_dialect(config)
    if hasattr(module, 'read_dialect'):
        return module.read_dialect(path)
    sys.exit('error: Missing configuration file')


def read_module(path):
    return repository if os.path.isdir(path) else quickfix


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
