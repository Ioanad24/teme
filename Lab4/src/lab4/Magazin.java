package lab4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



class Magazin {
    List<Echipament> echipamente = new ArrayList<>();

    public void adaugaEchipament(Echipament echipament) {
        echipamente.add(echipament);
    }

    public void afiseazaToate() {
        echipamente.forEach(System.out::println);
    }

    public void afiseazaTip(Class<?> tip) {
        echipamente.stream().filter(tip::isInstance).forEach(System.out::println);
    }

    public void modificaStare(int nrInv, StareEchipament stare) {
        for (Echipament echip : echipamente) {
            if (echip.getNrInv() == nrInv) {
                echip.setStare(stare);
                return;
            }
        }
        System.out.println("Echipament inexistent!");
    }

    public void afiseazaVandute() {
        echipamente.stream().filter(e -> e.getStare() == StareEchipament.VANDUT).forEach(System.out::println);
    }

    public static void salveazaInFisier(String numeFisier, List<Echipament> echipamente) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(numeFisier))) {
            oos.writeObject(echipamente);
        }
    }

    public static List<Echipament> incarcaDinFisier(String numeFisier) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(numeFisier))) {
            return (List<Echipament>) ois.readObject();
        }
    }
}
