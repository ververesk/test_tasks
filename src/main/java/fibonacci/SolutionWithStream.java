package fibonacci;

import java.util.stream.Stream;

public class SolutionWithStream {

    private SolutionWithStream() {
        //private constructor
    }
    protected static void fibonacciNumbers(int n) {
        Stream.iterate(new int[]{0,1},array ->new int[]{array[1],array[0]+array[1]})
                .limit(n)
                .map(x -> x[0])
                .forEach(System.out::println);
    }
}
