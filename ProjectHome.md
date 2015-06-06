This is a java wrapper around the fabulous tool by Douglas Crockford, [jslint](http://jslint.com/). It provides a simple interface for detecting
potential problems in JavaScript code.

The usage is simple:

```
  % java -jar jslint4java-1.4.jar application.js
  jslint:application.js:11:9:Line breaking error ')'.
  jslint:application.js:11:10:Missing semicolon.
```

There are a multitude of options; try `--help` for more details.

You might also be interested in the ant task.  This lets you run jslint as part of your  builds.  For documentation, see the [jslint4java-ant](http://docs.jslint4java.googlecode.com/git/2.0.1/ant.html) page.  If you find this useful, you may also like the [jsmin ant task](http://code.google.com/p/jsmin-ant-task/) for reducing the size of your JavaScript files.

## News ##

### jslint4java-2.0.5 ###

2013-05-10 More bug fixes

  * Update to JSLint 2013-05-06.
  * Fixes [issue 94](https://code.google.com/p/jslint4java/issues/detail?id=94) (thread safety).
  * Clean up docs to remove references to `undef` option, which no longer exists.
  * Allow reading stdin if "-" is passed as a filename.

### jslint4java-2.0.4 ###

2013-04-10 Just bug fixes

  * Update to JSLint 2013-05-01.
    * This removes the `anon`, `css`, `fragment`, `on` and `undef` options.
    * This adds the `ass` and `closure` options.
    * The warnings option is now a noop.
    * This removes the ability to parse HTML.

### jslint4java-2.0.3 ###

2012-12-04 Just bug fixes

  * Update to JSLint 2012-12-04.
    * This removes the `cap` option.
    * This removes the `widget` option.
    * This adds the `stupid` option (sigh).
    * This adds the `todo` option.
  * [issue 78](https://code.google.com/p/jslint4java/issues/detail?id=78): Unused variables not being reported
  * [issue 81](https://code.google.com/p/jslint4java/issues/detail?id=81): Does not work with jslint.js >= 2012-05-09
  * [issue 85](https://code.google.com/p/jslint4java/issues/detail?id=85): NegativeArraySizeException during error reporting
  * [issue 86](https://code.google.com/p/jslint4java/issues/detail?id=86): HTML in JS code is not escaped properly

### jslint4java-2.0.2 ###

2012-02-06  Just bug fixes

  * [Issue 75](https://code.google.com/p/jslint4java/issues/detail?id=75): Handle BOMs when using the CLI.
  * [issue 74](https://code.google.com/p/jslint4java/issues/detail?id=74): document the technique for construction of JSLint objects.
  * [issue 73](https://code.google.com/p/jslint4java/issues/detail?id=73): better examples for maven configuration.
  * [issue 72](https://code.google.com/p/jslint4java/issues/detail?id=72): Add all formatters to the maven plugin automatically.
  * [issue 67](https://code.google.com/p/jslint4java/issues/detail?id=67): fix maven docs.
  * Update to JSLint 2012-02-03.
    * This removes the `adsafe`, `confusion` and `safe` options.
    * This adds the `anon` option.

### jslint4java-2.0.1 ###

2011-10-18: Making maven work.

  * [issue 62](https://code.google.com/p/jslint4java/issues/detail?id=62): Set default indent correctly.
  * [issue 64](https://code.google.com/p/jslint4java/issues/detail?id=64): Make the maven plugin work with older maven versions.
  * [issue 65](https://code.google.com/p/jslint4java/issues/detail?id=65): Don't blow up when the maven plugin writes a report.
  * Update to JSLint 2011-10-17.


### jslint4java-2.0.0 ###

2011-07-14: now with added maven plugin.

  * [issue 27](https://code.google.com/p/jslint4java/issues/detail?id=27): Add a maven plugin.
  * Update to JSLint 2011-07-11.
    * The nature of the boolean options has been inverted--beware!
      * `bitwise` now enables the use of bitwise operators.
      * `newcap` now means “ignore capitalisation of constructors”
      * `plusplus` now means “incr” and “decr” operators are tolerated.
      * `regexp` now means allow the use of “.” in regexes.
      * `undef` now means you can declare variables out of order.
      * `white` now means acceptance of non-compliant whitespace.
    * New options:
      * `sloppy`, which is the inverse of `strict`.
      * `confusion`, allows inconsistent types.
      * `vars`, to tolerate multiple `var` declarations per function (replaces `onevar`).
      * `eqeq`, to tolerate "==" and "!=".
      * `node`, to predefine node.js globals.
      * `properties`, to require declaration of all properties.
      * `unparam`, to allow unused parameters.
    * Removed options:
      * `onevar`
      * `strict`
  * The goodParts() api has been removed (it's the default now).
  * [issue 57](https://code.google.com/p/jslint4java/issues/detail?id=57): cope with a BOM in files.


### jslint4java-1.4.7 ###

2011-03-08: another minor release.

  * Add OSGI bundle headers.
    * I'm an OSGI novice; please let me know if these are wrong.
  * [issue 52](https://code.google.com/p/jslint4java/issues/detail?id=52): Add checkstyle xml formatter.
  * [issue 53](https://code.google.com/p/jslint4java/issues/detail?id=53): No files passed to the ant task is no longer an error (just an info message).
  * Update to JSLint 2011-03-07.
    * This adds the continue option, whilst removing eqeqeq, immed and laxbreak options.
    * JSLints interpretation of line and column numbers has changed. I've tried to keep up. Please file a bug if errors aren't reported at the expected place.

### Sonar integration ###

Do you want sonar to notify you about JSLint violations?  Have a look at [javascript-plugin-for-sonar](http://docs.codehaus.org/display/SONAR/JavaScript+Plugin).

### Hudson integration ###

The [hudson violations plugin](http://wiki.hudson-ci.org/display/HUDSON/Violations) can display JSLint errors in your project.

### Emacs integration ###

Want to run JSLint inside Emacs?  Have a look at [this gist](https://gist.github.com/769416).

### Gradle plugin ###

Do you use gradle for your builds?  [kellyrob99](http://www.kellyrob99.com/blog/) has produced a [gradle-jslint-plugin](https://github.com/kellyrob99/gradle-jslint-plugin)!

### Mercurial integration ###

Want to run JSLint automatically when using mercurial?  Take a look at [Running JSLint as Mercurial precommit hook](http://katratxo.wordpress.com/2010/12/13/running-jslint-as-hg-precommit-hook/).

### Netbeans integration ###

[Integrating JSLint more tightly into NetBeans](http://blogs.sun.com/ashamash/entry/integrating_jslint_more_tightly_into)

### JUnit in Action ###

jslint4java is mentioned in [JUnit in action](http://my.safaribooksonline.com/book/software-engineering-and-development/software-testing/9781935182023/ajax-testing/ch13lev1sec8)!

### Maven integration ###

Whilst there's a [jslint4java maven plugin](https://github.com/happygiraffe/jslint4java/tree/maven-plugin) in the works, [this stackoverflow post](http://stackoverflow.com/questions/92372/maven-plugins-for-javascript) describes several ways of integrating JSLint with Maven.

### jslint4java-1.4.6 ###

2011-01-02 Another bugfix release.

  * Update to JSLint 2010-12-23.
    * This outlaws a top-level "use strict"—stick it in a function instead.
  * [issue 47](https://code.google.com/p/jslint4java/issues/detail?id=47): Make thread safe.
  * [issue 46](https://code.google.com/p/jslint4java/issues/detail?id=46): Clean API for JSLintBuilder.fromDefault().
  * [issue 48](https://code.google.com/p/jslint4java/issues/detail?id=48): Kill JSLintBuilder.create()

### jslint4java-1.4.4 ###

2010-11-08 A bugfix release.

  * [issue 45](https://code.google.com/p/jslint4java/issues/detail?id=45): Add support for “maxlen” option.  Thanks to pigulla for spotting.
  * Update dependencies:
    * rhino 1.7R2
    * JCommander 1.11

### jslint4java-1.4.3 ###

2010-10-28 jslint4java 1.4.3 is released.  This is a bugfix release, with one minor new feature.

  * [issue 43](https://code.google.com/p/jslint4java/issues/detail?id=43): allow access to reports form the command line.
    * Thanks to rharding and stigkj for their assistance.
  * [issue 44](https://code.google.com/p/jslint4java/issues/detail?id=44): stop IllegalAccessException warning from being emitted.
  * Update to JSLint 2010-10-26.

### jslint4java-1.4.2 ###

2010-09-13 jslint4java 1.4.2 is released.  This is a bugfix release.

  * [issue 42](https://code.google.com/p/jslint4java/issues/detail?id=42): numeric keys throw exception.
  * Update JSLint to 2010-09-09.
  * Update to JCommander 1.7.
    * **[INCOMPATIBILITY](INCOMPATIBILITY.md)** This version is able to work with Java 5, so that is now the minimum version again.

### jslint4java-1.4.1 ###

2010-08-05 jslint4java 1.4.1 is released.  This is a bugfix release.

  * [issue 40](https://code.google.com/p/jslint4java/issues/detail?id=40): StringIndexOutOfBoundsException on XmlResultFormatter.

### jslint4java-1.4 ###

2010-07-27 jslint4java 1.4 is released.  Notable changes include:

  * [issue 35](https://code.google.com/p/jslint4java/issues/detail?id=35): Removed embedded JUnit.
  * [issue 30](https://code.google.com/p/jslint4java/issues/detail?id=30): Add a "report" formatter to the ant task.
    * Also available on the command line with `--report`
  * [issue 37](https://code.google.com/p/jslint4java/issues/detail?id=37): add a `--encoding` flag for specifying the encoding files on the command line.
  * [issue 36](https://code.google.com/p/jslint4java/issues/detail?id=36): add a JUnit XML formatter.
  * [issue 26](https://code.google.com/p/jslint4java/issues/detail?id=26): add support for `.data()` call in JSLINT.
    * This is only available in the Java API right now.
  * [issue 39](https://code.google.com/p/jslint4java/issues/detail?id=39): add failureproperty to the ant task.
  * Use JCommander for flag processing.
    * **(INCOMPATIBILITY)** This means that command line option parsing has changed slightly.  You now have to say `--indent 2` instead of `--indent=2`.
    * **(INCOMPATIBILITY)** The minimum version of Java is now 6.
  * Update to JSLint 2010-07-14.
    * Adds options: es5, windows.
    * Removes options: sidebar.

### jslint4java-1.3.3 ###

2009-12-02. jslint4java 1.3.3 is released.  Noteworthy alterations:

  * Add support for the _predef_ option, to allow specifying a list of predefined global variables.
  * Update to JSLint 2009-11-24.  This brings the _devel_ option.

### jslint4java-1.3.2 ###

2009-11-12. jslint4java 1.3.2 is released.  Changes include:

  * Allow use of an external jslint.js.
  * Update to JSLint 2009-10-04.  This includes a new _maxerrs_ option.
  * Tidy up the [docs](http://jslint4java.googlecode.com/svn/docs/1.3.2/index.html) a little.
  * My thanks to Simon Kenyon Shepard and Ryan Alberts for helping me to fix portability issues in my unit tests.

### jslint4java-1.3.1 ###

2009-07-31. jslint4java 1.3.1 is released.  This release fixes:

  * Improved support for  NetBeans thanks to [Ari Shamash](http://blogs.sun.com/ashamash)!
  * Correct line numbers (previously off by one).
  * The ant task now states the full path to the file being checked.
  * The build failure now includes the total number of errors found.
  * Updated to JSLint 2009-07-25.

### jslint4java-1.3 ###

2009-07-23. jslint4java 1.3 is released.  This release features:

  * An upgrade to jslint 2009-07-08.
  * The indent option is now supported.
  * Add `getEdition()` call.
  * The ant task can now work with any kind of nested resource, not just files.
  * Improved [documentation](http://happygiraffe.github.com/jslint4java/).
  * The build system has been switched to maven.  This means jslint4java is now available as a maven dependency:

```
<dependency>
  <groupId>com.googlecode.jslint4java</groupId>
  <artifactId>jslint4java</artifactId>
  <version>1.3</version>
</dependency>
```

**NB:** The package names have changed from _net.happygiraffe.jslint_ to _com.googlecode.jslint4java_.  The most likely place this will affect you is if you are using the antlib support.

### github move ###

2008-12-23.  Development of the code has moved to github.  Feel free to visit http://github.com/happygiraffe/jslint4java or:

```
$ git clone git://github.com/happygiraffe/jslint4java.git
```

### jslint4java-1.2.1 ###

2008-09-07. jslint4java 1.2.1 was released.

  * Recompiled with Java 5 instead of Java 6.

### jslint4java-1.2 ###

2008-09-07. jslint4java 1.2 was released.

  * Update to latest version of jslint.
  * Rework the ant task to be more flexible.