import jsoup_parser_module.platform.html.creator.HTMLAttributesCreator
import jsoup_parser_module.platform.html.creator.HTMLTagCreator
import jsoup_parser_module.platform.html.parser.*

fun main(args: Array<String>) {

    /* val htmlParser = HTMLParser(
         HTMLCommentRemover(), HTMLTagMatcher(), HTMLTagAttributesParser(), HTMLTagFactory(HTMLTagCreator())
     )

     val roots = htmlParser.parse(tests[1])
     roots.forEach {
         println(it)

     }*/

    val parser = HTMLParser(BodyParser(HTMLTagCreator(HTMLAttributesCreator())), HeadParser())
    val node = parser.parse(tests.last())

    val tag = node as HTMLParsingResult
    println(tag.body)
    /* tag.children.forEach {
        println(it.tagName)
     }*/

















}