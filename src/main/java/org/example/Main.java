package org.example;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    // stuff here

    public static void main(String[] args) throws IOException {
        MutableDataSet options = new MutableDataSet();

        byte[] bytes = Files.readAllBytes(Path.of("input.md"));
        String s = new String(bytes, "UTF-8");

        // stuff here

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        // You can re-use parser and renderer instances
        Node document = parser.parse(s);
        String html = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"

        System.out.println(html);
    }
}