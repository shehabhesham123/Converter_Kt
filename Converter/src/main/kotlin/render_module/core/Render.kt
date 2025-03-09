package render_module.core

import parser_module.core.model.Tag

interface Render<out Output> {
    fun render(tag: Tag): Output
}