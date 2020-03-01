package ee.mrtnh.opera_codility_test;

import java.util.Collections;

public class Task1 {

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        String s1 = task1.createRandomOfLength(10);
        String s2 = task1.createRandomOfLength(10000);
        String s3 = task1.createRandomOfLength(100000);

        long start = System.currentTimeMillis();
        task1.solution2(s1);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        start = System.currentTimeMillis();
        task1.solution2(s2);
        end = System.currentTimeMillis();
        System.out.println(end-start);

        start = System.currentTimeMillis();
        task1.solution2(s3);
        end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public String solution(String T) {
        int counterS = 0;
        int counterM = 0;
        int counterL = 0;
        for (int index = 0; index < T.length(); index++) {
            if (T.charAt(index) == 'S') counterS++;
            else if (T.charAt(index) == 'M') counterM++;
            else counterL++;
        }
        // create a string made up of n copies of string s
        return String.join("", Collections.nCopies(counterS, "S")) +
                String.join("", Collections.nCopies(counterM, "M")) +
                String.join("", Collections.nCopies(counterL, "L"));
    }

    public String solution2(String T) {
        StringBuilder sbS = new StringBuilder();
        StringBuilder sbM = new StringBuilder();
        StringBuilder sbL = new StringBuilder();

        for (int index = 0; index < T.length(); index++) {
            if (T.charAt(index) == 'S') sbS.append("S");
            else if (T.charAt(index) == 'M') sbM.append("M");
            else sbL.append("L");
        }
        // create a string made up of n copies of string s
        return sbS.append(sbM.toString()).append(sbL.toString()).toString();
    }

    private String createRandomOfLength(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            double random = Math.random() * 3;
            if (random < 1) sb.append("S");
            else if (random < 2) sb.append("M");
            else sb.append("L");
        }
        // System.out.println("Created String " + sb.toString());
        return sb.toString();
    }
}
