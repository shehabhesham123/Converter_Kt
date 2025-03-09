package render_module.platform.compose.mapper

import SpanStyle
import parser_module.core.model.Tag
import parser_module.platform.html.tag.HTMLTag
import parser_module.platform.xml.XMLTag
import render_module.core.Mapper
import render_module.core.MapperFactory
import render_module.platform.compose.mapper.compose_html.ComposeHTMLAttributesStyleMapper
import render_module.platform.compose.mapper.compose_html.ComposeHTMLMapper
import render_module.platform.compose.mapper.compose_html.ComposeHTMLTagStyleMapper

class ComposeMapperFactory(
    private val composeHTMLAttributesStyleMapper: ComposeHTMLAttributesStyleMapper,
    private val composeHTMLTagStyleMapper: ComposeHTMLTagStyleMapper
) : MapperFactory<SpanStyle> {
    override fun createMapper(tag: Tag): Mapper<SpanStyle>? {
        return when (tag) {
            is HTMLTag -> {
                ComposeHTMLMapper(
                    composeHTMLTagStyleMapper,
                    composeHTMLAttributesStyleMapper
                )
            }

            is XMLTag -> {
                return null
            }

            else -> {
                return null
            }
        }
    }
}