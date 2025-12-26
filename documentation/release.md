# Release process

Philadelphia releases are published to [Maven Central Repository][] via
[Sonatype OSS Repository Hosting (OSSRH)][Sonatype OSSRH].

Publishing a release requires access to the Parity project on Sonatype OSSRH,
write permission to the Philadelphia repository on GitHub, access to the Parity
project on Mastodon, and Python 3.10 or newer.

  [Maven Central Repository]: https://search.maven.org/
  [Sonatype OSSRH]: https://central.sonatype.org/publish/publish-guide/

## Preparing for an upcoming release

Follow these steps to prepare for an upcoming release:

  - Run a performance test to ensure that there are no regressions since the
    previous release.

  - Update the release manifest in `scripts/archive.txt` if needed.

  - Update the release template in `.github/RELEASE_TEMPLATE.md` if needed.

  - Prepare the release notes in `CHANGELOG.md` for the upcoming release.

  - If there are non-backwards-compatible changes since the previous release,
    prepare upgrade instructions in `UPGRADE-<version>.md` for the upcoming
    release.

## Publishing a release

Follow these steps to publish a release:

  1. Prepare for a release:
      ```
      mvn release:clean release:prepare
      ```

  2. Perform the release:
      ```
      mvn release:perform
      ```

  3. Log into [Sonatype][].

  4. Close the repository on Sonatype OSSRH.

  5. Release the repository on Sonatype OSSRH.

  6. Build the release archive:
      ```
      git checkout <version>
      ./scripts/archive philadelphia-<version>.zip < ./scripts/archive.txt
      ```

  7. [Add the release][GitHub] to GitHub.

  8. Announce the release on [Mastodon][].

  [Sonatype]: https://oss.sonatype.org/
  [GitHub]: https://github.com/paritytrading/philadelphia/releases/new
  [Mastodon]: https://fosstodon.org/@paritytrading
