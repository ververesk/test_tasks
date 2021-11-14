package evaluatingExpressionInString;

public class GrammarOfArithmeticExpression {

    private GrammarOfArithmeticExpression() {
        //private constructor
    }

    protected static int expression(LexemeHelper lexemeHelper) throws Exception {
        Lexeme lexeme = lexemeHelper.nextPosOfLex();
        if (lexeme.type == LexemeType.END_OF_LINE) {
            return 0;
        } else {
            lexemeHelper.back();
            return plusMinus(lexemeHelper);
        }
    }

    protected static int plusMinus(LexemeHelper lexemeHelper) throws Exception {
        int value = multDiv(lexemeHelper);
        while (true) {
            Lexeme lexeme = lexemeHelper.nextPosOfLex();
            switch (lexeme.type) {
                case PLUS:
                    value += multDiv(lexemeHelper);
                    break;
                case MINUS:
                    value -= multDiv(lexemeHelper);
                    break;
                case END_OF_LINE:
                case RIGHT_BRACKET:
                    lexemeHelper.back();
                    return value;
                default:
                    throw new Exception("Неверный символ: " + lexeme.value + " на позиции: " + lexemeHelper.getPosOfLex());
            }
        }
    }

    protected static int multDiv(LexemeHelper lexemeHelper) throws Exception {
        int value = factor(lexemeHelper);
        while (true) {
            Lexeme lexeme = lexemeHelper.nextPosOfLex();
            switch (lexeme.type) {
                case MULTIPLICATION:
                    value *= factor(lexemeHelper);
                    break;
                case DIVISION:
                    value /= factor(lexemeHelper);
                    break;
                case END_OF_LINE:
                case RIGHT_BRACKET:
                case PLUS:
                case MINUS:
                    lexemeHelper.back();
                    return value;
                default:
                    throw new Exception("Неверный символ: " + lexeme.value + " на позиции: " + lexemeHelper.getPosOfLex());
            }
        }
    }

    protected static int factor(LexemeHelper lexemeHelper) throws Exception {
        Lexeme lexeme = lexemeHelper.nextPosOfLex();
        switch (lexeme.type) {
            case NUMBER:
                return Integer.parseInt(lexeme.value);
            case LEFT_BRACKET:
                int value = expression(lexemeHelper);
                lexeme = lexemeHelper.nextPosOfLex();
                if (lexeme.type != LexemeType.RIGHT_BRACKET) {
                    throw new Exception("Неверный символ: " + lexeme.value + " на позиции: " + lexemeHelper.getPosOfLex());
                }
                return value;
            default:
                throw new Exception("Неверный символ: " + lexeme.value + " на позиции: " + lexemeHelper.getPosOfLex());
        }
    }
}
