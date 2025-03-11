/*
package jsoup_parser_module

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.nodes.TextNode
*/
/**//*


class Parser {

    fun parse(html: String) {
        val doc: Document = Jsoup.parse(html)
        val head = doc.head()
        val root: Element = doc.body() // Start from body
        traverseTree(root, 0)
    }

*/
/*    fun traverseTree2(element: Element, depth: Int) {
        for (i in 0..<depth) print("  ") // Indentation
        var attr = ""
        element.attributes().forEach { attr += "${it.key} = ${it.value}, " }
        println(
            "<${element.tagName()}  ${attr}>  ${element.text()}<${element.tagName()}>"
        )

        for (child in element.children()) {
            child.append("{Child}")
            traverseTree2(child, depth + 1)
        }
    }*//*


    fun traverseTree(element: Element, depth: Int) {

        // Get all child nodes (including text nodes)
        val childNodes = element.childNodes()
        val parentText = StringBuilder() // Reconstruct the parent's text with markers
        val children = mutableListOf<String>()

        for (node in childNodes) {
            if (node is Element) {
                children.add(node.tagName())
                // If the node is an element, replace its text with {Child}
                parentText.append("{{Child}}")
                // Recursively traverse the child element
                traverseTree(node, depth + 1)
            } else if (node is TextNode) {
                // If the node is a text node, append its text to the parent's text
                parentText.append(node.text())
            }
        }
        println(element.tagName())
        children.forEach {
            print("$it ")
        }
        println()
        // Print the modified parent text with {Child} markers
        println("${"  ".repeat(depth)}Modified Text: $parentText")
    }
}
*/
