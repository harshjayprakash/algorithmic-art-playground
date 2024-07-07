package winchester.osmium.logic.preprocess;

import winchester.osmium.logic.classification.Token;
import winchester.osmium.logic.classification.TokenType;

import java.util.ArrayList;
import java.util.Optional;

public class Lexer {
    private final ArrayList<Token> tokens;
    private final Scanner scanner;

    public Lexer(String inputCode) {
        this.tokens = new ArrayList<>();
        this.scanner = new Scanner(inputCode);
    }

    public void convertToTokens() throws Exception {
        this.scanner.advance();
        Optional<Character> optionalCharacter;
        optionalCharacter = this.scanner.getCharacter();
        StringBuilder stringBuilder = new StringBuilder();

        while (optionalCharacter.isPresent()) {
            String char_ = optionalCharacter.get().toString();
            TokenType type = analyseCharacter(char_);

            if (type == TokenType.UNKNOWN) {
                throw new Exception("Detected Unknown Token Type.");
            }
            else if (type == TokenType.SYMBOL || type == TokenType.NUMBER) {
                stringBuilder.append(char_);
            }
            else if (type == TokenType.SPACE || type == TokenType.NEWLINE || type == TokenType.TAB) {
                this.addTokenFromStringBuilder(stringBuilder);
            }
            else {
                this.addTokenFromStringBuilder(stringBuilder);
                this.tokens.add(new Token(type, char_));
            }

            this.scanner.advance();
            optionalCharacter = this.scanner.getCharacter();
        }

        this.reAnalyseForKeyWords();
    }

    private TokenType analyseCharacter(String individualCharacter) {
        if (individualCharacter.matches("[A-Za-z0-9_]")) {
            return TokenType.SYMBOL;   
        }

        for (TokenType type : TokenType.values()) {
            if (individualCharacter.equals(type.getValue())) {
                return type;
            }
        }

        return TokenType.UNKNOWN;
    }

    private void reAnalyseForKeyWords() {
        for (Token token : this.tokens) {
            if (token.getTokenType() != TokenType.SYMBOL) {
                continue;
            }

            for (TokenType type : TokenType.values()) {
                if (token.getValue().equalsIgnoreCase(type.getValue())) {
                    token.setTokenType(type);
                }
            }
        }
    }

    private void addTokenFromStringBuilder(StringBuilder stringBuilder) {
        if (!stringBuilder.isEmpty()) {
            if (stringBuilder.toString().matches("[0-9+]")) {
                this.tokens.add(new Token(TokenType.NUMBER, stringBuilder.toString()));
            }
            else {
                this.tokens.add(new Token(TokenType.SYMBOL, stringBuilder.toString()));
            }
            stringBuilder.setLength(0);
        }
    }

    public Token[] getTokens() {
        return this.tokens.toArray(new Token[0]);
    }



}
