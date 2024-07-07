package winchester.osmium.logic.preprocess;

import java.util.Optional;

public class Scanner {
    private final char[] inputCode;
    private int position;

    public Scanner(String inputCode) {
        this.inputCode = inputCode.toCharArray();
        position = -1;
    }
    
    public void advance() {
        position = position + 1;
    }

    public Optional<Character> getCharacter() {
        if (position >= inputCode.length || position < 0) {
            return Optional.empty();
        }
        return Optional.of(inputCode[position]);
    }

}
