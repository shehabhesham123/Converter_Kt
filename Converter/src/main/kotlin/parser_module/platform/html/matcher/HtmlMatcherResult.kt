package parser_module.platform.html.matcher

import parser_module.core.model.MatcherResult

class HTMLMatcherResult(tagName: String, attributes: String, content: String) :
    MatcherResult(tagName, attributes, content)
