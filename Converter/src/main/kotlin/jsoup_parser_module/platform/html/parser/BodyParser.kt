package jsoup_parser_module.platform.html.parser

import jsoup_parser_module.platform.html.creator.HTMLTagCreator
import jsoup_parser_module.platform.html.tag.HTMLTag
import org.jsoup.nodes.Element
import org.jsoup.nodes.TextNode

class BodyParser(private val htmlTagCreator: HTMLTagCreator) {

    fun parse(body: Element): HTMLTag {
        val childNodes = body.childNodes()
        val content = StringBuilder()
        val children = mutableListOf<HTMLTag>()

        for (node in childNodes) {
            if (node is Element) {
                content.append("{{CHILD}}")
                children.add(parse(node))
            } else if (node is TextNode) {
                content.append(node.text())
            }
        }
        return htmlTagCreator.create(body, children, content.toString())
    }


}