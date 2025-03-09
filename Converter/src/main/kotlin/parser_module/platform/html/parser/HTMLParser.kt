package parser_module.platform.html.parser

import parser_module.core.abstraction.Parser
import parser_module.platform.html.attributes.HTMLTagAttributesParser
import parser_module.platform.html.comment.HTMLCommentRemover
import parser_module.platform.html.factory.HTMLTagFactory
import parser_module.platform.html.matcher.HTMLTagMatcher
import parser_module.platform.html.tag.HTMLTag

class HTMLParser(
    private val htmlCommentRemover: HTMLCommentRemover,
    private val htmlTagMatcher: HTMLTagMatcher,
    private val htmlTagAttributesParser: HTMLTagAttributesParser,
    private val htmlTagFactory: HTMLTagFactory
) : Parser<List<HTMLTag>> {

    override fun parse(code: String): List<HTMLTag> {
        // to support multiple root elements.
        val roots = mutableListOf<HTMLTag>()
        htmlTagMatcher.nestedTag(code) {
            parseSubElement(it)?.let { HTMLTag ->
                roots.add(HTMLTag)
            }
        }
        return roots
    }

    private fun parseSubElement(html: String): HTMLTag? {
        val cleanedHtml = htmlCommentRemover.remove(html)

        val matcherResult = htmlTagMatcher.match(cleanedHtml)
        if (matcherResult == null) return matcherResult

        val tagName = matcherResult.tagName
        val attributes = htmlTagAttributesParser.parse(matcherResult.attributes)
        val content = matcherResult.content

        return try {
            htmlTagFactory.createTag(tagName, attributes).apply {
                htmlTagMatcher.nestedTag(content) {
                    val nestedTag = parseSubElement(it)
                    if (nestedTag != null) {
                        this@apply.addChild(nestedTag)
                    }
                }
                // Replace nested tags with special markers in the content
                this@apply.content = htmlTagMatcher.replaceChildrenWithSpecialMarker(content)
                return this
            }
        } catch (e: IllegalArgumentException) {
            null
        }
    }
}