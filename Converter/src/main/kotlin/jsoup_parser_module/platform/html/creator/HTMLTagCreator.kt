package jsoup_parser_module.platform.html.creator

import jsoup_parser_module.platform.html.tag.HTMLTag
import org.jsoup.nodes.Element

class HTMLTagCreator(private val htmlAttributesCreator: HTMLAttributesCreator) {
    fun create(body: Element, children: MutableList<HTMLTag>, content: String): HTMLTag {
        val tagName = body.tagName()
        val attributes = htmlAttributesCreator.create(body.attributes())
        return HTMLTag(tagName, attributes, children, content)
    }
}