package parser_module.platform.html.factory

import parser_module.platform.html.tag.HTMLTag


/**
 * A utility class for creating [HTMLTag] instances.
 *
 * This class is responsible for creating [HTMLTag] objects with the provided
 * tag name and attributes. It encapsulates the logic for tag creation, making it
 * reusable and decoupled from the factory class.
 *
 * ### Usage Example:
 * ```kotlin
 * val tagCreator = HTMLTagCreator()
 * val tag = tagCreator.createTag("div", mapOf("class" to "container"))
 * println(tag) // Output: <div class="container"></div>
 * ```
 *
 * ### Key Responsibilities:
 * - Create [HTMLTag] instances with the provided tag name and attributes.
 * - Ensure that the created tags are properly initialized.
 *
 * ### Notes:
 * - This class is intentionally simple and does not perform validation or special handling.
 * - It is designed to be used by the [HTMLTagFactory] for creating tags.
 */
class HTMLTagCreator {

    /**
     * Creates an [HTMLTag] instance with the specified tag name and attributes.
     *
     * @param tagName The name of the tag (e.g., "div", "p").
     * @param attributes A map of attributes for the tag (e.g., `{"class": "container"}`).
     * @return A new [HTMLTag] instance.
     *
     * ### Example:
     * ```kotlin
     * val tag = tagCreator.createTag("div", mapOf("class" to "container"))
     * println(tag) // Output: <div class="container"></div>
     * ```
     */
    fun createTag(tagName: String, attributes: Map<String, String>): HTMLTag {
        return HTMLTag(tagName, attributes)
    }
}