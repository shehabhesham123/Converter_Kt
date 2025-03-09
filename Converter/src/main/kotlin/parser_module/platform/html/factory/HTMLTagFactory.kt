package parser_module.platform.html.factory

import parser_module.core.abstraction.TagFactory
import parser_module.platform.html.tag.HTMLTag


/**
 * A factory class for creating [HTMLTag] instances.
 *
 * This class implements the [TagFactory] interface and is responsible for creating
 * [HTMLTag] objects. It uses an [HTMLTagCreator] to handle the actual creation of tags,
 * ensuring that the logic is decoupled and reusable.
 *
 * ### Usage Example:
 * ```kotlin
 * val tagCreator = HTMLTagCreator()
 * val tagFactory = HTMLTagFactory(tagCreator)
 * val tag = tagFactory.createTag("div", mapOf("class" to "container"))
 * println(tag) // Output: <div class="container"></div>
 * ```
 *
 * ### Key Responsibilities:
 * - Validate the tag name before creating a tag.
 * - Delegate the creation of [HTMLTag] instances to the [HTMLTagCreator].
 * - Handle invalid inputs by throwing exceptions.
 *
 * ### Notes:
 * - This class performs basic validation on the tag name to ensure it is not null,
 *   not blank, and matches the pattern for valid HTML tag names.
 * - It relies on the [HTMLTagCreator] for the actual creation of tags, making it
 *   easy to extend or modify the creation logic without changing the factory.
 */
class HTMLTagFactory(private val htmlTagCreator: HTMLTagCreator) : TagFactory<HTMLTag?> {

    /**
     * Creates an [HTMLTag] instance with the specified tag name and attributes.
     *
     * @param tagName The name of the tag (e.g., "div", "p").
     * @param attributes A map of attributes for the tag (e.g., `{"class": "container"}`).
     * @return A new [HTMLTag] instance.
     * @throws IllegalArgumentException If the tag name is null, blank, or invalid.
     *
     * ### Example:
     * ```kotlin
     * val tag = tagFactory.createTag("div", mapOf("class" to "container"))
     * println(tag) // Output: <div class="container"></div>
     * ```
     *
     * ### Edge Cases:
     * - If the tag name is null, an [IllegalArgumentException] is thrown.
     * - If the tag name is blank or contains invalid characters, an [IllegalArgumentException] is thrown.
     */
    override fun createTag(tagName: String?, attributes: Map<String, String>): HTMLTag {
        return tagName?.takeIf { it.isNotBlank() && it.matches(Regex("[a-zA-Z][a-zA-Z0-9:-]*")) }?.let {
            htmlTagCreator.createTag(it, attributes)
        } ?: throw IllegalArgumentException("Tag name cannot be null or invalid")
    }
}