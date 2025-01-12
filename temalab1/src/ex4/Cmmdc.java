package ex4;

import java.util.Random;

public class Cmmdc {
    public static void main(String[] args) {
        Random random = new Random();
        int numar1 = random.nextInt(31);
        int numar2 = random.nextInt(31);

        System.out.println("Numărul 1: " + numar1);
        System.out.println("Numărul 2: " + numar2);

        int cmmdc = calculeazaCmmdc(numar1, numar2);
        System.out.println("Cel mai mare divizor comun (cmmdc) este: " + cmmdc);
    }

    public static int calculeazaCmmdc(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

