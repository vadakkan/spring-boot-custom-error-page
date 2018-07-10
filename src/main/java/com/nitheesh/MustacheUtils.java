package com.nitheesh;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.io.StringWriter;

public class MustacheUtils {

    public static <T> String Builder(T data, String mustacheName) {

        if (StringUtils.isBlank(mustacheName))
            mustacheName = "error";

        MustacheFactory mustacheFactory = new DefaultMustacheFactory("templates");
        Mustache mc = mustacheFactory.compile(mustacheName + ".mustache");
        try (StringWriter stringWriter = new StringWriter()) {
            mc.execute(stringWriter, data);
            return stringWriter.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }


}
