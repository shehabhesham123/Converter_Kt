package render_module.core

abstract class Mapper<out Style>(
    val attributesStyleMapper: AttributesStyleMapper<Style>,
    val tagStyleMapper: TagStyleMapper<Style>
)