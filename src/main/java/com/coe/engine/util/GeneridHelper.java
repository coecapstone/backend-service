package com.coe.engine.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GeneridHelper {

    public static String loadSql(final String sqlName) {

        final InputStream stream =
                Thread
                        .currentThread()
                        .getContextClassLoader()
                        .getResourceAsStream(sqlName);
        try {
            return IOUtils.toString(stream, Charset.defaultCharset());
        } catch (final IOException e){
            throw new IllegalStateException(e);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }
}
