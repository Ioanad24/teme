package lab5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Mobilier> mobilierList = objectMapper.readValue(new File("/Users/ioanadragomir/Documents/pj/lsb5/target/classes"), new TypeReference<List<Mobilier>>() {});

            // a) Afișarea pieselor de mobilier
            System.out.println("Piesele de mobilier:");
            for (Mobilier mobilier : mobilierList) {
                System.out.println(mobilier.getNume());
            }

            // b) Afișarea detaliilor pieselor și plăcilor
            System.out.println("\nDetalii mobilier și plăci:");
            for (Mobilier mobilier : mobilierList) {
                System.out.println(mobilier);
            }

            // c) Afișarea caracteristicilor plăcilor pentru un anumit mobilier
            String mobilierCautat = "dulap 1"; // Exemplu
            System.out.println("\nCaracteristicile plăcilor pentru " + mobilierCautat + ":");
            for (Mobilier mobilier : mobilierList) {
                if (mobilier.getNume().equals(mobilierCautat)) {
                    for (Placa placa : mobilier.getPlaci()) {
                        System.out.println(placa);
                    }
                }
            }

            // d) Calculul estimativ al colilor de pal necesare
            double dimensiunePal = 2800 * 2070; // mm^2
            System.out.println("\nEstimare coli de pal necesare pentru fiecare mobilier:");
            for (Mobilier mobilier : mobilierList) {
                double totalArie = 0;
                for (Placa placa : mobilier.getPlaci()) {
                    totalArie += placa.getLungime() * placa.getLatime() * placa.getNrBucati();
                }
                double coliNecesare = Math.ceil(totalArie / dimensiunePal);
                System.out.println(mobilier.getNume() + ": " + coliNecesare + " coli");
            }

        } catch (IOException e) {
            System.err.println("Eroare la citirea fișierului JSON: " + e.getMessage());
        }
    }
}

