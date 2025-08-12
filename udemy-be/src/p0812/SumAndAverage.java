package p0812;

public class SumAndAverage {
    public static int sum (int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    public static double average(int... numbers) {
        if (numbers.length == 0) return 0;
        return (double) sum(numbers) / numbers.length;
    }

    public static void main(String[] args) {
        int total = sum(1, 2, 3, 4, 5);
        double avg = average(1, 2, 3, 4, 5);

        System.out.println("Total Sum: " + total);
        System.out.println("Average Sum: " + avg);
    }
}
