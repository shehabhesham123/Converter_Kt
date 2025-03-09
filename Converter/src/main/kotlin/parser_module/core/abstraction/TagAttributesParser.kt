package parser_module.core.abstraction

/**
 * An interface for parsing attributes from a tag's attribute string.
 *
 * This interface defines a contract for parsing attributes from a string representation
 * of tag attributes. The output type is generic, allowing different platforms (e.g., HTML, XML)
 * to define their own attribute representations.
 *
 * ### Generic Type Parameter:
 * - `Type`: The type of the parsed attributes. This can vary depending on the platform.
 *   For example:
 *   - For HTML, `Type` might be `Map<String, String>` `(Key, Value)`.
 *   - For XML, `Type` might be a custom data class representing XML attributes.
 *
 * ### Usage Example:
 * ```kotlin
 * val htmlAttributesParser = HTMLTagAttributesParser()
 * val attributesString = "class=\"container\" id=\"main\""
 * val parsedAttributes = htmlAttributesParser.parse(attributesString)
 * println(parsedAttributes) // Output: {class=container, id=main}
 * ```
 *
 * ### Key Responsibilities:
 * - Parse a string of tag attributes into a platform-specific representation.
 * - Handle edge cases, such as malformed attribute strings or special characters.
 * - Ensure the output is consistent with the platform's attribute representation.
 *
 * ### Notes:
 * - Implementations should be robust and handle edge cases gracefully.
 * - The input string may contain attributes in various formats (e.g., single-quoted, double-quoted, or unquoted values).
 */
interface TagAttributesParser<out Type : Any> {

    /**
     * Parses a string of tag attributes into a platform-specific representation.
     *
     * @param code The input string containing the tag's attributes.
     * @return The parsed attributes in a platform-specific format.
     *
     * ### Example:
     * ```kotlin
     * val attributesString = "class=\"container\" id=\"main\""
     * val parsedAttributes = tagAttributesParser.parse(attributesString)
     * println(parsedAttributes) // Output: {class=container, id=main}
     * ```
     *
     * ### Edge Cases:
     * - If the input string is empty, the output should represent an empty set of attributes.
     * - If the input string is malformed, the behavior is implementation-specific.
     * - If the input string contains special characters, they should be handled appropriately.
     */
    fun parse(code: String): Type
}