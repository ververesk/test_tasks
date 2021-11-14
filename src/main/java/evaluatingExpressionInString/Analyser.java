package evaluatingExpressionInString;

import java.util.ArrayList;
import java.util.List;

public class Analyser {

    private Analyser() {
        //private constructor
    }

    protected static List<Lexeme> analyzer(String expression) throws LexemeException {
        List<Lexeme> lexemes = new ArrayList<>();
        int posOfLex = 0;
        while (posOfLex < expression.length()) {
            char symbol = expression.charAt(posOfLex);
            switch (symbol) {
                case '(':
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, symbol));
                    posOfLex++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, symbol));
                    posOfLex++;
                    continue;
                case '+':
                    lexemes.add(new Lexeme(LexemeType.PLUS, symbol));
                    posOfLex++;
                    continue;
                case '-':
                    lexemes.add(new Lexeme(LexemeType.MINUS, symbol));
                    posOfLex++;
                    continue;
                case '*':
                    lexemes.add(new Lexeme(LexemeType.MULTIPLICATION, symbol));
                    posOfLex++;
                    continue;
                case '/':
                    lexemes.add(new Lexeme(LexemeType.DIVISION, symbol));
                    posOfLex++;
                    continue;
                default:
                    if (symbol <= '9' && symbol >= '0') {
                        StringBuilder stringBuilder = new StringBuilder();
                        do {
                            stringBuilder.append(symbol);
                            posOfLex++;
                            if (posOfLex >= expression.length()) {
                                break;
                            }
                            symbol = expression.charAt(posOfLex);
                        } while (symbol <= '9' && symbol >= '0');
                        lexemes.add(new Lexeme(LexemeType.NUMBER, stringBuilder.toString()));
                    } else {
                        if (symbol != ' ') {
                            throw new LexemeException("Символ, который не поддаётся анализу: ", symbol);
                        }
                        posOfLex++;
                    }
            }
        }
        lexemes.add(new Lexeme(LexemeType.END_OF_LINE, ""));
        return lexemes;
    }
}
