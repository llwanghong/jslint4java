package com.googlecode.jslint4java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.ScriptableObject;

/**
 * Construct {@link JSLint} instances.
 *
 * @author hdm
 */
public class JSLintBuilder {
    private static final String JSLINT_FILE = "com/googlecode/jslint4java/fulljslint.js";

    private static final ContextFactory CONTEXT_FACTORY = new ContextFactory();

    private final ScriptableObject scope;

    private final Context ctx;

    public JSLintBuilder() {
        ctx = CONTEXT_FACTORY.enterContext();
        scope = ctx.initStandardObjects();
    }

    /**
     * Initialize the scope from a jslint.js found in the classpath.
     *
     * @param resource
     *            the location of jslint.js on the classpath.
     * @return a configured {@link JSLint}
     * @throws IOException
     *             if there are any problems reading the resource.
     */
    public JSLint fromClasspathResource(String resource) throws IOException {
        // TODO encoding?
        Reader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader()
                .getResourceAsStream(resource)));
        return fromReader(reader, resource);
    }

    /**
     * Initialize the scope with a default jslint.js.
     *
     * @return a configured {@link JSLint}
     * @throws RuntimeException
     *             if we fail to load the default jslint.js.
     */
    public JSLint fromDefault() {
        try {
            return fromClasspathResource(JSLINT_FILE);
        } catch (IOException e) {
            // We wrap and rethrow, as there's nothing a caller can do in this
            // case.
            throw new RuntimeException(e);
        }
    }

    /**
     * Initialize the scope with the jslint.js passed in on the filesystem.
     *
     * @param f
     *            the path to jslint.js
     * @return a configured {@link JSLint}
     * @throws IOException
     *             if the file can't be read.
     */
    public JSLint fromFile(File f) throws IOException {
        Reader reader = new BufferedReader(new FileReader(f));
        return fromReader(reader, f.toString());
    }

    /**
     * Initialize the scope with an arbitrary jslint.
     *
     * @param reader
     *            an input source providing jslint.js.
     * @param name
     *            the name of the resource backed by the reader
     * @return a configured {@link JSLint}
     * @throws IOException
     *             if there are any problems reading from {@code reader} .
     */
    public JSLint fromReader(Reader reader, String name) throws IOException {
        ctx.evaluateReader(scope, reader, name, 1, null);
        return new JSLint(scope);
    }
}
