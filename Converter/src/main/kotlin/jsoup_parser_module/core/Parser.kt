package jsoup_parser_module.core

interface Parser {
    fun parse(code: String): ParsingResult
}