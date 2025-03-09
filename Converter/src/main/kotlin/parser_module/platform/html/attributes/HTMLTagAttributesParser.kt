package parser_module.platform.html.attributes

import parser_module.core.abstraction.TagAttributesParser
import java.util.regex.Pattern

class HTMLTagAttributesParser : TagAttributesParser<Map<String, String>> {
    //private val attrPattern = Pattern.compile("""(\w+)=(?:'([^']*)'|"([^"]*)"|([^>\s]+))""")
    val attrPattern = Pattern.compile("""(\w+)=("([^"]*)"|'([^']*)'|([^ >]+))""")

    override fun parse(code: String): Map<String, String> {
        val attrs = mutableMapOf<String, String>()
        val matcher = attrPattern.matcher(code)
        while (matcher.find()) {
            /*val key = matcher.group(1)
            val value = matcher.group(2) ?: matcher.group(3) ?: matcher.group(4)*/
            val key = matcher.group(1)
            val value = matcher.group(3) ?: matcher.group(4) ?: matcher.group(5)
            if (value != null) {
                attrs[key] = value
            }
        }
        return attrs
    }
}