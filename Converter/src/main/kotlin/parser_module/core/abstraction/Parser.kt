package parser_module.core.abstraction

import parser_module.core.model.Tag


/**
 * An interface for parsing a string of code into a list of tags.
 *
 * This interface defines a contract for classes that are responsible for parsing
 * a string of code (e.g., HTML, XML) into a list of platform-specific tags.
 * The output type is generic and must be a list of [Tag] objects, allowing
 * different platforms to define their own tag representations.
 *
 * ### Generic Type Parameter:
 * - `Type`: The type of the parsed tags, which must be a list of [Tag] objects.
 *   For example:
 *   - For HTML, `Type` might be `List<HTMLTag>`.
 *   - For XML, `Type` might be `List<XMLTag>`.
 *
 * ### Usage Example:
 * ```kotlin
 * val htmlParser: Parser<List<HTMLTag>> = HTMLParser()
 * val code = "<div>Content</div><p>Paragraph</p>"
 * val parsedTags = htmlParser.parse(code)
 * println(parsedTags) // Output: [HTMLTag(tagName=div), HTMLTag(tagName=p)]
 * ```
 *
 * ### Key Responsibilities:
 * - Parse a string of code into a list of platform-specific tags.
 * - Handle edge cases, such as malformed code, nested tags, or special characters.
 * - Ensure the output is consistent with the platform's tag representation.
 *
 * ### Notes:
 * - Implementations should be robust and handle edge cases gracefully.
 * - The input string may contain multiple tags, nested tags, or special characters.
 */
interface Parser<out Type : List<Tag>> {

    /**
     * Parses a string of code into a list of tags.
     *
     * @param code The input string containing the code to be parsed.
     * @return A list of platform-specific tags.
     *
     * ### Example:
     * ```kotlin
     * val code = "<div>Content</div><p>Paragraph</p>"
     * val parsedTags = parser.parse(code)
     * println(parsedTags) // Output: [HTMLTag(tagName=div), HTMLTag(tagName=p)]
     * ```
     *
     * ### Edge Cases:
     * - If the input string is empty, the method should return an empty list.
     * - If the input string contains no valid tags, the method should return an empty list.
     * - If the input string contains malformed tags, the behavior is implementation-specific.
     */
    fun parse(code: String): Type
}