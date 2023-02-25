package firstHome;

import java.util.Scanner;

public class task1 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // +Написать программу вычисления n-ого треугольного числа

        int userInput = getNumberByUser("Введите число для получеия треугольного числа: ");
        int result = getTriangularNumber(userInput);
        System.out.println("Результат: " + result);

    }

    public static int getNumberByUser(String text) {
        System.out.print(text);
        int userInput = scanner.nextInt();
        System.out.println(userInput);
        return userInput;

    }

    public static int getTriangularNumber(int num) {
        return (num + 1) * num / 2;
    }

    /**
     * Second solution
     * public static int getTriangularNumber(int num) {
     * int sum = 0;
     * for (int i = 1; i <= num; i++) {
     * sum = sum + i;
     * }
     * return sum;
     * }
     */

}
