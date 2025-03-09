package parser_module.core.abstraction

import parser_module.core.model.Tag

/**
 * An interface for creating tags with a specific name and attributes.
 *
 * This interface defines a contract for factories that create tags of a specific type.
 * It is designed to be generic, allowing different platforms (e.g., HTML, XML) to
 * implement their own tag creation logic while adhering to a common interface.
 *
 * ### Generic Type Parameter:
 * - `Type`: The type of the tag to be created, which must extend the [Tag] class.
 *   For example:
 *   - For HTML, `Type` might be `HTMLTag`.
 *   - For XML, `Type` might be `XMLTag`.
 *
 * ### Usage Example:
 * ```kotlin
 * val htmlTagFactory: TagFactory<HTMLTag> = HTMLTagFactory()
 * val tag = htmlTagFactory.createTag("div", mapOf("class" to "container"))
 * println(tag) // Output: <div class="container"></div>
 * ```
 *
 * ### Key Responsibilities:
 * - Create tags with the specified tag name and attributes.
 * - Handle platform-specific logic for tag creation.
 * - Ensure that the created tags are properly initialized.
 *
 * ### Notes:
 * - Implementations of this interface should handle invalid inputs (e.g., null or blank tag names)
 *   by throwing appropriate exceptions.
 * - The interface is generic to support multiple platforms, making it reusable and extensible.
 */
interface TagFactory<out Type : Tag?> {

    /**
     * Creates a tag with the specified tag name and attributes.
     *
     * @param tagName The name of the tag to create (e.g., "div", "p").
     * @param attributes A map of attributes for the tag (e.g., `{"class": "container"}`).
     * @return A new tag of type [Type], or `null` if the tag cannot be created.
     * @throws IllegalArgumentException If the tag name is invalid or unsupported.
     *
     * ### Example:
     * ```kotlin
     * val tag = tagFactory.createTag("div", mapOf("class" to "container"))
     * println(tag) // Output: <div class="container"></div>
     * ```
     *
     * ### Edge Cases:
     * - If the tag name is null or blank, the method should throw an [IllegalArgumentException].
     * - If the tag name is unsupported or invalid, the method should throw an [IllegalArgumentException].
     * - If the attributes are empty, the tag should still be created with no attributes.
     */
    fun createTag(tagName: String?, attributes: Map<String, String>): Type
}