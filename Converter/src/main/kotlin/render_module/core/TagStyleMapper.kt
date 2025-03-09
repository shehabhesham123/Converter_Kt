package render_module.core

interface TagStyleMapper<out Style> {
    fun getSpanStyleForTag(tagName: String): Style
}