package winchester.osmium.logic.classification;

public enum TokenType {
    // TYPES
    SYMBOL("__CS_"),
    NUMBER("__NV_"),

    // CHARACTERS
    SPACE(" "),
    TAB("\t"),
    NEWLINE("\n"),
    SEMICOLON(";"),
    COLON(":"),
    OPEN_PAREN("("),
    CLOSE_PAREN(")"),
    OPEN_BRACE("{"),
    CLOSE_BRACE("}"),
    COMMA(","),
    DOT("."),
    EQUALS("="),
    PLUS("+"),
    MINUS("-"),
    STAR("*"),
    SLASH("/"),

    // KEYWORDS
    FOR("FOR"),
    TO("TO"),
    DOWNTO("DOWNTO"),
    IF("IF"),
    ELSE("ELSE"),
    DO("DO"),
    THEN("THEN"),
    BEGIN("BEGIN"),
    END("END"),
    
    // UNKNOWN (ERROR)
    UNKNOWN("__NN_");

    public final String value;

    TokenType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
