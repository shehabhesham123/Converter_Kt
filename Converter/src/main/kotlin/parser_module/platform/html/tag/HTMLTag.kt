package parser_module.platform.html.tag

import parser_module.core.model.Tag

class HTMLTag(
    val tagName: String,
    val attributes: Map<String, String> = emptyMap(),
    var content: String = "",
    val children: MutableList<HTMLTag> = mutableListOf()
) : Tag() {

    fun addChild(child: HTMLTag) {
        children.add(child)
    }

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
