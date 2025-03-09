package render_module.platform.compose

import AnnotatedString
import parser_module.core.model.Tag
import render_module.core.Render
import render_module.platform.compose.mapper.ComposeMapperFactory

class ComposeRender(
    private val composeMapperFactory: ComposeMapperFactory
) : Render<AnnotatedString> {
    override fun render(tag: Tag): AnnotatedString {
        val composeMapper = composeMapperFactory.createMapper(tag)

        return AnnotatedString()
    }
}