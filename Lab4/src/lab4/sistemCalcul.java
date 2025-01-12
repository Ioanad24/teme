package lab4;

class sistemCalcul extends Echipament {
    private String tipMon;
    private double vitProc;
    private int cHdd;
    private SistemOperare sistemOperare;

    public sistemCalcul(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare, String tipMon, double vitProc, int cHdd, SistemOperare sistemOperare) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.tipMon = tipMon;
        this.vitProc = vitProc;
        this.cHdd = cHdd;
        this.sistemOperare = sistemOperare;
    }

    public void instaleazaSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Monitor: %s, Proc: %.2f GHz, HDD: %d GB, OS: %s", tipMon, vitProc, cHdd, sistemOperare);
    }
}