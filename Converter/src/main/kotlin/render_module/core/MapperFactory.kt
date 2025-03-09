package render_module.core

import parser_module.core.model.Tag

interface MapperFactory<out Style> {
    fun createMapper(tag: Tag): Mapper<Style>?
}