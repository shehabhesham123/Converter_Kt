package render_module.core

interface AttributesStyleMapper<out Style> {
    fun getSpanStyleFromAttributes(attributes: Map<String, String>): Style
}