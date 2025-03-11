package jsoup_parser_module.platform.html.tag

import jsoup_parser_module.core.Tag

class HTMLTag(
    val tagName: String,
    val attributes: Map<String, String>,
    val children: MutableList<HTMLTag>,
    val content: String
) :Tag() {
    override fun toString(): String {
        val attributesString = attributes.entries.joinToString(" ") { "${it.key}=\"${it.value}\"" }
        // Replace special markers with children
        var combinedContent = content
        children.forEach { child ->
            combinedContent = combinedContent.replaceFirst("{{CHILD}}", child.toString())
        }
        return "<$tagName${if (attributesString.isNotEmpty()) " $attributesString" else ""}>$combinedContent</$tagName>"
    }
}