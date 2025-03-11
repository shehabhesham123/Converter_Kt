package jsoup_parser_module.platform.html.parser

import jsoup_parser_module.platform.html.tag.HTMLTag
import org.jsoup.nodes.Element

class HeadParser {
    fun get(head:Element): HTMLTag {
        return HTMLTag("", mapOf(), mutableListOf(),"")
    }
}