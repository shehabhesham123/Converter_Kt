package parser_module.core.model

/**
 * An abstract class representing the result of matching a tag.
 *
 * This class serves as the base class for platform-specific tag matching results.
 * It contains common properties such as the tag name, attributes, and content.
 *
 * ### Properties:
 * - `tagName`: The name of the matched tag.
 * - `attributes`: The attributes of the matched tag as a string.
 * - `content`: The content inside the matched tag.
 *
 * ### Usage Example:
 * ```kotlin
 * val result = HTMLMatcherResult("div", "class=\"container\"", "Content")
 * println(result.tagName) // Output: div
 * println(result.attributes) // Output: class="container"
 * println(result.content) // Output: Content
 * ```
 *
 * ### Notes:
 * - Platform-specific implementations should extend this class to add additional
 *   functionality or properties as needed.
 */
abstract class MatcherResult(
    val tagName: String,
    val attributes: String,
    val content: String
)