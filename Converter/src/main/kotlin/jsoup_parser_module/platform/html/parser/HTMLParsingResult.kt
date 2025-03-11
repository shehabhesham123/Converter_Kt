package jsoup_parser_module.platform.html.parser

import jsoup_parser_module.core.ParsingResult
import jsoup_parser_module.platform.html.tag.HTMLTag

class HTMLParsingResult(val head: HTMLTag, val body: HTMLTag) : ParsingResult() {
}