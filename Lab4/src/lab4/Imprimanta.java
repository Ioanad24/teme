package lab4;


class Imprimanta extends Echipament {
    private int ppm;
    private int dpi;
    private int pCar;
    private ModTiparire modTiparire;

    public Imprimanta(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare, int ppm, int dpi, int pCar, ModTiparire modTiparire) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.ppm = ppm;
        this.dpi = dpi;
        this.pCar = pCar;
        this.modTiparire = modTiparire;
    }

    public void setModTiparire(ModTiparire modTiparire) {
        this.modTiparire = modTiparire;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", PPM: %d, DPI: %d, Pagini/Cartus: %d, Mod: %s", ppm, dpi, pCar, modTiparire);
    }
}