# Philadelphia Code Generator

Philadelphia Code Generator is a simple console application for generating
Philadelphia profiles for FIX dialects.

Philadelphia Code Generator requires Python 3.5 or newer.

## Features

Philadelphia Code Generator supports the following input sources:

- [FIX Repository][]
- [QuickFIX][]

  [FIX Repository]: https://www.fixtrading.org/standards/fix-repository/
  [QuickFIX]: http://www.quickfixengine.org/

## Development

Run Philadelphia Code Generator with Python:
```
python -m philadelphia.generate <command> [<configuration-file>] <input-path>
```

Install development dependencies:
```
pip install -r requirements.txt
```

Run Pylint:
```
pylint philadelphia
```

## Installation

Install Philadelphia Code Generator:
```
python setup.py install
```

Run Philadelphia Code Generator:
```
philadelphia-generate <command> [<configuration-file>] <input-path>
```

## License

Released under the Apache License, Version 2.0.
