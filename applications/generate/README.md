# Philadelphia Code Generator

Philadelphia Code Generator is a simple console application for generating
Philadelphia profiles for FIX dialects.

Philadelphia Code Generator requires Python 3.10 or newer.

## Features

Philadelphia Code Generator supports the following input sources:

- [FIX Orchestra][]
- [FIX Repository][]
- [QuickFIX][]

  [FIX Orchestra]: https://www.fixtrading.org/standards/fix-orchestra/
  [FIX Repository]: https://www.fixtrading.org/standards/fix-repository/
  [QuickFIX]: https://github.com/quickfix/quickfix

## Development

Install dependencies:
```
uv sync
```

Run Philadelphia Code Generator:
```
uv run philadelphia-generate <command> <configuration-file> <input-path>
```

Run type check:
```
uv run mypy philadelphia
```

## Installation

Build Philadelphia Code Generator:
```
uv build --wheel
```

Install Philadelphia Code Generator:
```
pip install philadelphia-*.whl
```

Run Philadelphia Code Generator:
```
philadelphia-generate <command> <configuration-file> <input-path>
```

## License

Released under the Apache License, Version 2.0.
