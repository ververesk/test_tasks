package fibonacci;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * всевозможные варианты пользовательского ввода не стала предусматривать
 * хотя бы по минимуму
 */
public class fibonacci {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = 0;
        try {
            System.out.println("Введите сколько чисел Фибоначчи вы хотите увидеть");
            n = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Вы ввели не число " + e);
            return;
        }
        System.out.println("Введите 1 если вы хотите получить решение с помощью массива, 2 - если через stream");
        int solution = scanner.nextInt();
        if (solution == 1) {
            SolutionWithArray.fibonacciNumbers(n);
        } else if (solution == 2) {
            SolutionWithStream.fibonacciNumbers(n);
        } else {
            System.out.println("Решение не может быть выполнено");
        }
    }
}
