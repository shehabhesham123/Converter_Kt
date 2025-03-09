package parser_module.platform.html.parser

/*

class JsoupParser : Parser<List<HTMLTag>> {

    override fun parse(code: String): List<HTMLTag> {
        val document: Document = Jsoup.parse(code)
        val rootElements = document.body().children() // Get all top-level elements
        return rootElements.map { element ->
            parseElement(element)
        }
    }

    private fun parseElement(element: Element): HTMLTag {
        // Create an HTMLTag from the Jsoup element
        val tagName = element.tagName()
        val attributes = element.attributes().associate { it.key to it.value }
        val content = element.ownText()

        // Create the HTMLTag
        val htmlTag = HTMLTag(
            tagName = HTMLTagType.fromString(tagName) ?: HTMLTagType.UNKNOWN,
            attributes = attributes,
            content = content
        )

        // Recursively parse child elements
        element.children().forEach { childElement ->
            htmlTag.addChild(parseElement(childElement))
        }

        return htmlTag
    }
}*/
