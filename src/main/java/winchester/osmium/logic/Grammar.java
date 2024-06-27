package winchester.osmium.logic;

import java.util.ArrayList;

public class Grammar {

    public static final ArrayList<TokenType> variableDeclaration = new ArrayList<>() {{
        add(TokenType.SYMBOL); add(TokenType.COLON); add(TokenType.NUMBER); add(TokenType.SEMI_COLON);
    }};

    public static final ArrayList<TokenType> variableAssignment = new ArrayList<>() {{
       add(TokenType.SYMBOL); add(TokenType.COLON); add(TokenType.EQUALS); add(TokenType.NUMBER);
       add(TokenType.SEMI_COLON);
    }};

    public static final ArrayList<TokenType> constantDeclaration = new ArrayList<>() {{
        add(TokenType.SYMBOL); add(TokenType.EQUALS); add(TokenType.NUMBER); add(TokenType.SEMI_COLON);
    }};

    public static final ArrayList<TokenType> moveFunctionCall = new ArrayList<>() {{
        add(TokenType.SYMBOL); add(TokenType.OPEN_PAREN); add(TokenType.SYMBOL); add(TokenType.COMMA);
        add(TokenType.NUMBER); add(TokenType.CLOSE_PAREN); add(TokenType.SEMI_COLON);
    }};

    public static final ArrayList<TokenType> positionFunctionCall = new ArrayList<>() {{
        add(TokenType.SYMBOL); add(TokenType.OPEN_PAREN); add(TokenType.NUMBER); add(TokenType.COMMA);
        add(TokenType.NUMBER); add(TokenType.CLOSE_PAREN); add(TokenType.SEMI_COLON);
    }};

}
