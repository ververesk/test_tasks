package evaluatingExpressionInString;

public class LexemeException extends Exception {
    private char symbol;

    public char getSymbol() {
        return symbol;
    }

    public LexemeException(String message, char symbol) {
        super(message);
        this.symbol = symbol;
    }
}
