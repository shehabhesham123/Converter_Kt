import jsoup_parser_module.Parser
import parser_module.platform.html.attributes.HTMLTagAttributesParser
import parser_module.platform.html.comment.HTMLCommentRemover
import parser_module.platform.html.factory.HTMLTagCreator
import parser_module.platform.html.factory.HTMLTagFactory
import parser_module.platform.html.matcher.HTMLTagMatcher
import parser_module.platform.html.parser.HTMLParser

fun main(args: Array<String>) {

   /* val htmlParser = HTMLParser(
        HTMLCommentRemover(), HTMLTagMatcher(), HTMLTagAttributesParser(), HTMLTagFactory(HTMLTagCreator())
    )

    val roots = htmlParser.parse(tests[1])
    roots.forEach {
        println(it)

    }*/

   Parser().parse("""<!DOCTYPE html>
<html>
<head>
    <title>Complex JSoup Test</title>
</head>
<body>
    <div id="main">
        <header>
            <h1>Website Title</h1>
            <nav>
                <ul>
                    <li><a href="/home">Home</a></li>
                    <li><a href="/about">About</a></li>
                    <li><a href="/contact">Contact</a></li>
                </ul>
            </nav>
        </header>
        <section class="content">
            <article>
                <h2>Article 1</h2>
                <p>This is the first paragraph.</p>
                <p>This is the second paragraph with a <a href="https://example.com">link</a>.</p>
            </article>
            <article>
                <h2>Article 2</h2>
                <p>Another article with an <strong>important</strong> word.</p>
                <blockquote>“This is a quoted text inside a blockquote.”</blockquote>
            </article>
        </section>
        <footer>
            <p>&copy; 2025 My Website</p>
        </footer>
    </div>
</body>
</html>
""")

}