package render_module.platform.compose.mapper.compose_html

import SpanStyle
import render_module.core.Mapper

class ComposeHTMLMapper(
    composeHTMLTagStyleMapper: ComposeHTMLTagStyleMapper,
    composeHTMLAttributesStyleMapper: ComposeHTMLAttributesStyleMapper
) : Mapper<SpanStyle>(composeHTMLAttributesStyleMapper, composeHTMLTagStyleMapper)