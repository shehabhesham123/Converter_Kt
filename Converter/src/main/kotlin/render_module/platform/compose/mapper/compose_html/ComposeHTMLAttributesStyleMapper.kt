package render_module.platform.compose.mapper.compose_html

import SpanStyle
import render_module.core.AttributesStyleMapper

class ComposeHTMLAttributesStyleMapper : AttributesStyleMapper<SpanStyle> {
    override fun getSpanStyleFromAttributes(attributes: Map<String, String>): SpanStyle {
        val builder = SpanStyle()
        /*attributes.forEach { (key, value) ->
            when (key) {
                "class" -> {
                    if (value.contains("highlight")) {
                        builder.merge(SpanStyle(background = Color.Yellow))
                    }
                }
                "style" -> {
                    value.split(";").forEach { style ->
                        val (styleKey, styleValue) = style.split(":").map { it.trim() }
                        when (styleKey) {
                            "color" -> builder.merge(SpanStyle(color = parseColor(styleValue)))
                            "font-size" -> builder.merge(SpanStyle(fontSize = parseFontSize(styleValue)))
                        }
                    }
                }
            }
        }*/
        return builder
    }
}