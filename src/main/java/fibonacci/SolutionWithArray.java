package fibonacci;

public class SolutionWithArray {

    private SolutionWithArray() {
        //private constructor
    }

    protected static void fibonacciNumbers(int n) {
        int[] array = new int[n];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
