package parser_module.platform.html.matcher

import parser_module.core.abstraction.TagMatcher
import java.util.regex.Pattern

class HTMLTagMatcher : TagMatcher<HTMLMatcherResult?> {
    private val tagPattern = Pattern.compile("""<(\w+:\w+|\w+)([^>]*)>(.*?)</\1>""", Pattern.DOTALL)
    //private val tagPattern = Pattern.compile("""<(\w+:\w+|\w+)([^>]*)(/>|>(.*?)</\1>)""", Pattern.DOTALL)

    override fun match(code: String): HTMLMatcherResult? {
        val matcher = tagPattern.matcher(code)
        if (!matcher.find()) return null
        val tagName = matcher.group(1).trim()
        val attributes = matcher.group(2).trim()
        val content = matcher.group(3).trim()
        return HTMLMatcherResult(tagName, attributes, content)
    }

    fun nestedTag(html: String, onFind: (content: String) -> Unit) {
        val nestedMatcher = tagPattern.matcher(html)
        while (nestedMatcher.find()) {
            onFind(nestedMatcher.group(0))
        }
    }

    fun replaceChildrenWithSpecialMarker(content: String): String {
        return content.replace(tagPattern.toRegex(), "{{CHILD}}").trim()
    }

}