package evaluatingExpressionInString;

import java.util.List;
import java.util.Scanner;

/**
 * участвуют операторы -, /, *, +
 * и только целые числа
 */
public class Runner {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение");
        String expression = scanner.nextLine();
        try {
            List<Lexeme> lexemes = Analyser.analyzer(expression);
            LexemeHelper lexemeHelper = new LexemeHelper(lexemes);
            System.out.println(GrammarOfArithmeticExpression.expression(lexemeHelper));
        } catch (LexemeException ex) {
            System.out.println(ex.getMessage() + " " + ex.getSymbol());
        }
    }
}

