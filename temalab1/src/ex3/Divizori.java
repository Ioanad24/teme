package ex3;

import java.util.Scanner;

public class Divizori {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceți un număr natural: ");
        int n = scanner.nextInt();
        scanner.close();

        if (estePrim(n)) {
            System.out.println("Numărul " + n + " este prim.");
        } else {
            System.out.print("Divizorii numărului " + n + " sunt: ");
            afiseazaDivizorii(n);
        }
    }

    public static boolean estePrim(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void afiseazaDivizorii(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}


