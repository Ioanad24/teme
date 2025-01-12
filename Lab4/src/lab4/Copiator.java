package lab4;

class Copiator extends Echipament {
    private int pTon;
    private FormatCopiere formatCopiere;

    public Copiator(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare, int pTon, FormatCopiere formatCopiere) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.pTon = pTon;
        this.formatCopiere = formatCopiere;
    }

    public void setFormatCopiere(FormatCopiere formatCopiere) {
        this.formatCopiere = formatCopiere;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Pagini/Toner: %d, Format: %s", pTon, formatCopiere);
    }
}