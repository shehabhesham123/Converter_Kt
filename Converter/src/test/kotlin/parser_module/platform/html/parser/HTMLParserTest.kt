package parser_module.platform.html.parser

import data_provider.HTMLParserProvider
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource
import parser_module.core.abstraction.Parser
import parser_module.platform.html.attributes.HTMLTagAttributesParser
import parser_module.platform.html.comment.HTMLCommentRemover
import parser_module.platform.html.factory.HTMLTagCreator
import parser_module.platform.html.factory.HTMLTagFactory
import parser_module.platform.html.matcher.HTMLTagMatcher
import parser_module.platform.html.tag.HTMLTag
import kotlin.test.assertEquals

class HTMLParserTest {

    lateinit var parser: Parser<List<HTMLTag>>

    @BeforeEach
    fun setup() {
        parser = HTMLParser(
            HTMLCommentRemover(), HTMLTagMatcher(), HTMLTagAttributesParser(), HTMLTagFactory(
                HTMLTagCreator()
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(HTMLParserProvider::class)
    fun testParser(htmlCode: String, expectedResult: String) {
        val parsed =  parser.parse(htmlCode)[0].toString()
        assertEquals(expectedResult,parsed, "$parsed")
    }


}