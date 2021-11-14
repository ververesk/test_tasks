package evaluatingExpressionInString;

import java.util.List;

public class LexemeHelper {
    private int posOfLex;

    public List<Lexeme> lexemes;

    public LexemeHelper(List<Lexeme> lexemes) {
        this.lexemes = lexemes;
    }

    protected Lexeme nextPosOfLex() {
        return lexemes.get(posOfLex++);
    }

    protected void back() {
        posOfLex--;
    }

    protected int getPosOfLex() {
        return posOfLex;
    }
}
