package jsoup_parser_module.platform.html.parser

import jsoup_parser_module.core.Parser
import jsoup_parser_module.core.ParsingResult
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class HTMLParser(private val bodyParser: BodyParser, private val headParser: HeadParser) : Parser {
    override fun parse(code: String): ParsingResult {
        val doc: Document = Jsoup.parse(code)
        val head = headParser.get(doc.head())
        val body = bodyParser.parse(doc.body()) // Start from body
        return HTMLParsingResult(head, body)
    }
}