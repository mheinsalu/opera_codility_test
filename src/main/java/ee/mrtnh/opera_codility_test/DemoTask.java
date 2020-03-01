package ee.mrtnh.opera_codility_test;

import java.util.Arrays;
import java.util.Iterator;

public class DemoTask {

    public static void main(String[] args) {

    }

    /*
    This is a DemoTask task.
    Write a function:
    class Solution { public int solution(int[] A); }
    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
    Given A = [1, 2, 3], the function should return 4.
    Given A = [−1, −3], the function should return 1.
    Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000].
    */

    // TODO: turns out fori-loops are faster than streams (loops have decades of optimization)
    public int solution(int[] A) {
        int counter = 1;
        Iterator<Integer> iterator = Arrays.stream(A).filter(number -> number > 0).distinct().sorted().iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (counter != number) return counter;
            counter++;
        }
        return counter;
    }
}
