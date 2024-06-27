package winchester.osmium.logic;

import java.util.ArrayList;

public class Tokeniser {

    public Tokeniser() { }

    public Token[] convertToTokensList(String code) {
        ArrayList<Token> tokens = new ArrayList<>();
        String[] lines = this.splitIntoLines(code);

        for (String line : lines) {
            tokens.addAll(this.analyseLine(line.toCharArray()));
        }

        return tokens.toArray(new Token[0]);
    }

    private String[] splitIntoLines(String code) {
        return code.split("\\r?\\n");
    }

    private ArrayList<Token> analyseLine(char[] line) {
        ArrayList<Token> tokens = new ArrayList<>();
        StringBuilder symbolBuilder = new StringBuilder();

        for (char c : line) {
            String character = String.valueOf(c);
            TokenType type = analyseCharacter(character);

            if (type == TokenType.UNKNOWN || type == TokenType.SYMBOL || type == TokenType.NUMBER) {
                symbolBuilder.append(character);
                continue;
            }

            if (type != TokenType.SPACE) {
                if (!symbolBuilder.isEmpty()) {
                    if (symbolBuilder.toString().matches("[0-9]+")) {
                        tokens.add(new Token(TokenType.NUMBER, symbolBuilder.toString()));
                    }
                    else {
                        tokens.add(new Token(TokenType.SYMBOL, symbolBuilder.toString()));
                    }
                    symbolBuilder.setLength(0);
                }
                tokens.add(new Token(type, character));
            }
        }

        return tokens;
    }

    private TokenType analyseCharacter(String individualCharacter) {
        if (individualCharacter.matches("[A-Za-z0-9_]")) {
            return TokenType.SYMBOL;
        }

        return switch (individualCharacter) {
            case " " -> TokenType.SPACE;
            case ";" -> TokenType.SEMI_COLON;
            case ":" -> TokenType.COLON;
            case "(" -> TokenType.OPEN_PAREN;
            case ")" -> TokenType.CLOSE_PAREN;
            case "," -> TokenType.COMMA;
            case "." -> TokenType.DOT;
            case "=" -> TokenType.EQUALS;
            case "+" -> TokenType.PLUS;
            case "-" -> TokenType.MINUS;
            case "*" -> TokenType.ASTERISK;
            case "/" -> TokenType.FORWARD_SLASH;
            default -> TokenType.UNKNOWN;
        };
    }

}
