package p0812;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자: ");
        double num1 = sc.nextDouble();

        System.out.print("연산자 (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        System.out.print("두 번째 숫자: ");
        double num2 = sc.nextDouble();

        double result = 0;

        switch(operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("잘못된 연산자입니다.");
        }
        System.out.println("결과: " + result);
    }
}
