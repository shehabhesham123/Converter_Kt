package parser_module.core.abstraction

import parser_module.core.model.MatcherResult

/**
 * An interface for matching and extracting tags from a string of code.
 *
 * This interface defines a contract for classes that are responsible for identifying
 * and extracting tags from a given string of code. The output type is generic and
 * must extend the [MatcherResult] class, allowing different platforms (e.g., HTML, XML)
 * to define their own tag representations.
 *
 * ### Generic Type Parameter:
 * - `Type`: The type of the matched tag, which must extend [MatcherResult].
 *   For example:
 *   - For HTML, `Type` might be `HTMLMatcherResult`.
 *   - For XML, `Type` might be `XMLMatcherResult`.
 *
 * ### Usage Example:
 * ```kotlin
 * val htmlTagMatcher: TagMatcher<HTMLMatcherResult> = HTMLTagMatcher()
 * val code = "<div class=\"container\">Content</div>"
 * val matchedTag = htmlTagMatcher.match(code)
 * println(matchedTag) // Output: HTMLMatcherResult(tagName=div, attributes=class="container", content=Content)
 * ```
 *
 * ### Key Responsibilities:
 * - Identify and extract tags from the input string.
 * - Return the matched tag in a platform-specific format that extends [MatcherResult].
 * - Handle edge cases, such as nested tags, self-closing tags, or malformed syntax.
 *
 * ### Notes:
 * - Implementations should be robust and handle edge cases gracefully.
 * - The input string may contain multiple tags, nested tags, or special characters.
 */
interface TagMatcher<out Type : MatcherResult?> {

    /**
     * Matches and extracts a tag from the given string of code.
     *
     * @param code The input string containing the code to be matched.
     * @return The matched tag in a platform-specific format that extends [MatcherResult],
     *         or `null` if no match is found.
     *
     * ### Example:
     * ```kotlin
     * val code = "<div class=\"container\">Content</div>"
     * val matchedTag = tagMatcher.match(code)
     * println(matchedTag) // Output: HTMLMatcherResult(tagName=div, attributes=class="container", content=Content)
     * ```
     *
     * ### Edge Cases:
     * - If the input string is empty, the method should return `null`.
     * - If the input string contains no valid tags, the method should return `null`.
     * - If the input string contains malformed tags, the behavior is implementation-specific.
     */
    fun match(code: String): Type
}