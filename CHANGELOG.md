<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# semgrep-intellij Changelog

## [Unreleased]

## [0.5.0] - 2024-12-18

- Bumped LSP.js version
- Some internal API updates to authentication. The minimum supported Semgrep
  CLI version is now 1.101.0

## [0.4.0] - 2024-11-27

- Bumped LSP.js version
- Removed use of deprecated API

## [0.3.0] - 2024-06-21

- Bump LSP.js
- Sentry added to improve debugging
- Fix URL parsing issues

## [0.2.5] - 2024-05-07

- Bump LSP.js version

## [0.2.4] - 2024-04-09

- Plugin does not freeze on repeat login

## [0.2.3] - 2024-02-05

- Fix login command, and lsp.js on windows

## [0.2.2] - 2024-01-31

- Fix release process again by @ajbt200128 in https://github.com/semgrep/semgrep-intellij/pull/40
- Fix release process again again by @ajbt200128 in https://github.com/semgrep/semgrep-intellij/pull/41

## [0.2.0] - 2024-01-30

- Fixed issue where saving would not trigger rescan
- Now compatible with 2024+ IntelliJ Platform versions
- Windows support added via LSP.js

## [0.1.4] - 2023-09-18

- Changelog update - `v0.1.3` by @github-actions in https://github.com/returntocorp/semgrep-intellij/pull/13
- Add the rest of settings (oops) and rephrase things by @ajbt200128 in https://github.com/returntocorp/semgrep-intellij/pull/15
- @github-actions made their first contribution in https://github.com/returntocorp/semgrep-intellij/pull/13

## [0.1.3] - 2023-09-05

- Bump org.jetbrains.kotlin.jvm from 1.9.0 to 1.9.10 by @dependabot in https://github.com/returntocorp/semgrep-intellij/pull/2
- Bump org.jetbrains.changelog from 2.1.2 to 2.2.0 by @dependabot in https://github.com/returntocorp/semgrep-intellij/pull/6
- Bump actions/checkout from 3 to 4 by @dependabot in https://github.com/returntocorp/semgrep-intellij/pull/10
- Check if OS is windows and notify it is unsupported by @ajbt200128 in https://github.com/returntocorp/semgrep-intellij/pull/11
- Version Bump by @ajbt200128 in https://github.com/returntocorp/semgrep-intellij/pull/12
- @dependabot made their first contribution in https://github.com/returntocorp/semgrep-intellij/pull/2

[Unreleased]: https://github.com/semgrep/semgrep-intellij/compare/v0.5.0...HEAD
[0.5.0]: https://github.com/semgrep/semgrep-intellij/compare/v0.4.0...v0.5.0
[0.4.0]: https://github.com/semgrep/semgrep-intellij/compare/v0.3.0...v0.4.0
[0.3.0]: https://github.com/semgrep/semgrep-intellij/compare/v0.2.5...v0.3.0
[0.2.5]: https://github.com/semgrep/semgrep-intellij/compare/v0.2.4...v0.2.5
[0.2.4]: https://github.com/semgrep/semgrep-intellij/compare/v0.2.3...v0.2.4
[0.2.3]: https://github.com/semgrep/semgrep-intellij/compare/v0.2.2...v0.2.3
[0.2.2]: https://github.com/semgrep/semgrep-intellij/compare/v0.2.0...v0.2.2
[0.2.0]: https://github.com/semgrep/semgrep-intellij/compare/v0.1.4...v0.2.0
[0.1.4]: https://github.com/semgrep/semgrep-intellij/compare/v0.1.3...v0.1.4
[0.1.3]: https://github.com/semgrep/semgrep-intellij/commits/v0.1.3
