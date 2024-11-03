# Code generation

Philadelphia uses code generation for the FIX protocol versions from FIX 4.0
to FIX Latest.

As Philadelphia already contains the output of the code generation process,
users do not need to deal with code generation at all. Developers only need to
deal with it if either the specifications change or the process itself changes.

Code generation requires Bash and Python 3.9 or newer.

## Generating code from FIX Repository

The following FIX protocol versions use [FIX Repository][] as their source:

  - FIX 4.0
  - FIX 4.1
  - FIX 4.2
  - FIX 4.3
  - FIX 4.4
  - FIX 5.0
  - FIX 5.0 SP1
  - FIX 5.0 SP2

  [FIX Repository]: https://www.fixtrading.org/standards/fix-repository/

All these are legacy versions, and FIX Repository can be considered a legacy
specification. Therefore generating code from it should be only needed when the
code generation process itself changes.

Generate the code as follows:

  1. Download [FIX Repository 2010][].

  2. Extract the archive next to this repository:
      ```
      cd ..
      unzip fix_repository_2010_edition_20200402.zip
      ```

  3. Run the code generation:
      ```
      cd philadelphia
      ./scripts/generate-repository ../fix_repository_2010_edition_20200402
      ```

  [FIX Repository 2010]: https://www.fixtrading.org/packages/fix-repository-2010/

## Generating code from FIX Orchestra

The following FIX protocol versions use [FIX Orchestra][] as their source:

  - FIX Latest
  - FIXT 1.1

  [FIX Orchestra]: https://www.fixtrading.org/standards/fix-orchestra/

These are living standards, so generating code from FIX Orchestra is needed
whenever either the specifications change or the code generation process itself
changes.

Generate the code as follows:

  1. Clone the FIX Orchestra repository next to this repository:
      ```
      cd ..
      git clone https://github.com/FIXTradingCommunity/orchestrations.git
      ```

  2. Run the code generation:
      ```
      cd philadelphia
      ./scripts/generate-orchestra ../orchestrations/FIX\ Standard
      ```
