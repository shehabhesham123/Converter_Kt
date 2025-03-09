package parser_module.platform.html.tag

enum class HTMLTagType {
    DIV, P, A, B, U, IMG, SPAN, H1, H2, H3, H4, H5, H6,
    UL, OL, LI, STRONG, EM, BR, HR, BLOCKQUOTE, CODE, PRE,
    TABLE, TR, TD, TH, FORM, INPUT, BUTTON, LABEL, TEXTAREA,
    SELECT, OPTION, HEADER, FOOTER, NAV, SECTION, ARTICLE,
    ASIDE, MAIN, VIDEO, AUDIO, SOURCE, IFRAME, CANVAS, HTML,
    SCRIPT, STYLE, LINK, META, TITLE, HEAD, BODY, UNKNOWN;

    override fun toString(): String {
        return name.lowercase()
    }

    companion object {
        fun fromString(tag: String): HTMLTagType? {
            return try {
                valueOf(tag.uppercase())
            } catch (e: IllegalArgumentException) {
                null // Return null if the string doesn't match any enum value
            }
        }
    }
}