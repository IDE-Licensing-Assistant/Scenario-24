
package com.mycompany.app;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;

public class MarkdownExample {

    public static void main(String[] args) {
        // Create the parser and renderer
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        // Markdown input
        String markdown = "# Hello Flexmark\n\nThis is **Markdown**.";

        // Parse and render
        Node document = parser.parse(markdown);
        String html = renderer.render(document);

        // Output HTML
        System.out.println(html);
    }
    
}
