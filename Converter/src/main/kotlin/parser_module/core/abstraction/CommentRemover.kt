package parser_module.core.abstraction


/**
 * An interface for removing comments from a given string of code.
 *
 * This interface defines a contract for classes that are responsible for removing comments
 * from code, such as HTML, XML, or other markup/text formats. Implementations of this
 * interface should provide logic to identify and remove comments based on the specific
 * syntax of the target language.
 *
 * ### Usage Example:
 * ```kotlin
 * val commentRemover: CommentRemover = HTMLCommentRemover()
 * val codeWithComments = "<!-- This is a comment --><div>Content</div>"
 * val codeWithoutComments = commentRemover.remove(codeWithComments)
 * println(codeWithoutComments) // Output: "<div>Content</div>"
 * ```
 *
 * ### Key Responsibilities:
 * - Identify and remove comments from the input string.
 * - Preserve the non-comment parts of the input string.
 *
 * ### Notes:
 * - Implementations should ensure that the removal process does not alter or damage
 *   the non-comment parts of the input string.
 * - If the input string contains no comments, the output should be identical to the input.
 */
interface CommentRemover {

    /**
     * Removes comments from the given string of code.
     *
     * @param code The input string containing code with comments.
     * @return A string with all comments removed.
     *
     * ### Example:
     * ```kotlin
     * val code = "<!-- Comment --><div>Content</div>"
     * val cleanedCode = commentRemover.remove(code)
     * println(cleanedCode) // Output: "<div>Content</div>"
     * ```
     *
     * ### Edge Cases:
     * - If the input string is empty, the output should also be empty.
     * - If the input string contains no comments, the output should be identical to the input.
     * - If the input string contains malformed comments, the behavior is implementation-specific.
     */
    fun remove(code: String): String
}