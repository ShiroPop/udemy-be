package p0812;

import java.util.Scanner;

public class SumEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("N 값 입력: ");
        int N = sc.nextInt();

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) {
                evenSum += i;
            } else {
                oddSum += i;
            }
        }

        System.out.println("Even Sum: " + evenSum);
        System.out.println("Odd Sum: " + oddSum);
    }
}
