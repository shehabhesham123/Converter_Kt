package parser_module.platform.html.comment

import parser_module.core.abstraction.CommentRemover
import java.util.regex.Pattern

class HTMLCommentRemover : CommentRemover {
    private val commentPattern = Pattern.compile("""<!--.*?-->""", Pattern.DOTALL)

    override fun remove(code: String): String {
        return commentPattern.matcher(code).replaceAll("")
    }
}
