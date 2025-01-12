package lab4;

import java.io.*;
import java.util.*;

enum StareEchipament {
    ACHIZITIONAT, EXPUS, VANDUT
}

enum ModTiparire {
    COLOR, ALB_NEGRU
}

enum FormatCopiere {
    A3, A4
}

enum SistemOperare {
    WINDOWS, LINUX
}

public class MainApp {
    public static void main(String[] args) {
        Magazin magazin = new Magazin();
        magazin.adaugaEchipament(new Imprimanta("HP LaserJet", 101, 1200, "A1", StareEchipament.ACHIZITIONAT, 20, 600, 2000, ModTiparire.COLOR));
        magazin.adaugaEchipament(new Copiator("Canon Copier", 202, 3000, "B2", StareEchipament.EXPUS, 10000, FormatCopiere.A4));
        magazin.adaugaEchipament(new sistemCalcul("Dell Optiplex", 303, 4500, "C3", StareEchipament.VANDUT, "LED", 3.4, 1000, SistemOperare.WINDOWS));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Afisare toate echipamentele");
            System.out.println("2. Afisare imprimante");
            System.out.println("3. Afisare copiatoare");
            System.out.println("4. Afisare sisteme de calcul");
            System.out.println("5. Modificare stare echipament");
            System.out.println("6. Setare mod tiparire imprimanta");
            System.out.println("7. Setare format copiere copiator");
            System.out.println("8. Instalare sistem operare sistem calcul");
            System.out.println("9. Afisare echipamente vandute");
            System.out.println("10. Iesire");
            System.out.print("Selectati o optiune: ");

            int optiune = scanner.nextInt();
            scanner.nextLine(); // Consum newline

            switch (optiune) {
                case 1 -> magazin.afiseazaToate();
                case 2 -> magazin.afiseazaTip(Imprimanta.class);
                case 3 -> magazin.afiseazaTip(Copiator.class);
                case 4 -> magazin.afiseazaTip(sistemCalcul.class);
                case 5 -> {
                    System.out.print("Numar inventar: ");
                    int nrInv = scanner.nextInt();
                    System.out.print("Noua stare (ACHIZITIONAT/EXPUS/VANDUT): ");
                    String stare = scanner.next();
                    magazin.modificaStare(nrInv, StareEchipament.valueOf(stare.toUpperCase()));
                }
                case 6 -> {
                    System.out.print("Numar inventar imprimanta: ");
                    int nrInv = scanner.nextInt();
                    System.out.print("Mod tiparire (COLOR/ALB_NEGRU): ");
                    String mod = scanner.next();
                    magazin.echipamente.stream()
                            .filter(e -> e instanceof Imprimanta && e.getNrInv() == nrInv)
                            .map(e -> (Imprimanta) e)
                            .forEach(e -> e.setModTiparire(ModTiparire.valueOf(mod.toUpperCase())));
                }
                case 7 -> {
                    System.out.print("Numar inventar copiator: ");
                    int nrInv = scanner.nextInt();
                    System.out.print("Format copiere (A3/A4): ");
                    String format = scanner.next();
                    magazin.echipamente.stream()
                            .filter(e -> e instanceof Copiator && e.getNrInv() == nrInv)
                            .map(e -> (Copiator) e)
                            .forEach(e -> e.setFormatCopiere(FormatCopiere.valueOf(format.toUpperCase())));
                }
                case 8 -> {
                    System.out.print("Numar inventar sistem calcul: ");
                    int nrInv = scanner.nextInt();
                    System.out.print("Sistem operare (WINDOWS/LINUX): ");
                    String os = scanner.next();
                    magazin.echipamente.stream()
                            .filter(e -> e instanceof sistemCalcul && e.getNrInv() == nrInv)
                            .map(e -> (sistemCalcul) e)
                            .forEach(e -> e.instaleazaSistemOperare(SistemOperare.valueOf(os.toUpperCase())));
                }
                case 9 -> magazin.afiseazaVandute();
                case 10 -> running = false;
                default -> System.out.println("Optiune invalida!");
            }
        }

        scanner.close();
    }
}
