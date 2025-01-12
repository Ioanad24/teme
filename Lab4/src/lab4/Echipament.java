package lab4;

import java.io.Serializable;



abstract class Echipament implements Serializable {
    private String denumire;
    private int nrInv;
    private double pret;
    private String zonaMag;
    private StareEchipament stare;

    public Echipament(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare) {
        this.denumire = denumire;
        this.nrInv = nrInv;
        this.pret = pret;
        this.zonaMag = zonaMag;
        this.stare = stare;
    }

    public StareEchipament getStare() {
        return stare;
    }

    public void setStare(StareEchipament stare) {
        this.stare = stare;
    }

    public int getNrInv() {
        return nrInv;
    }

    @Override
    public String toString() {
        return String.format("%s (Nr. Inv: %d, Pret: %.2f, Zona: %s, Stare: %s)", denumire, nrInv, pret, zonaMag, stare);
    }
}
