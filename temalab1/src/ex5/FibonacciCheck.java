package ex5;

import java.util.Random;

public class FibonacciCheck {
    public static void main(String[] args) {
        Random random = new Random();
        int numar = random.nextInt(21); // Generează un număr între 0 și 20

        System.out.println("Numărul generat: " + numar);

        if (esteFibonacci(numar)) {
            System.out.println("Numărul " + numar + " aparține șirului lui Fibonacci.");
        } else {
            System.out.println("Numărul " + numar + " nu aparține șirului lui Fibonacci.");
        }
    }

    public static boolean esteFibonacci(int n) {
        if (n == 0 || n == 1) {
            return true;
        }
        int a = 0;
        int b = 1;
        int c = a + b;
        while (c <= n) {
            if (c == n) {
                return true;
            }
            a = b;
            b = c;
            c = a + b;
        }
        return false;
    }
}
