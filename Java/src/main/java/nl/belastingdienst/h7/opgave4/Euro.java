package nl.belastingdienst.h7.opgave4;

public class Euro {
    private int waarde;

    public Euro(int bedrag) { this.waarde = bedrag; }

    public int getWaarde() {
        return waarde;
    }
    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

    public void add(Euro bedrag) {
        this.waarde += bedrag.getWaarde();
    }
    public void subtract(Euro bedrag) {
        this.waarde -= bedrag.getWaarde();
    }
    public void multiply(int multiplier) {
        this.waarde *= multiplier;
    }
    public void multiply(double multiplier) {
        this.waarde = (int) (this.waarde * multiplier);
    }

    public boolean isLargerThan(Euro bedrag) {
        return this.waarde > bedrag.getWaarde();
    }
    public boolean isSmallerThan(Euro bedrag) {
        return this.waarde < bedrag.getWaarde();
    }

    public String toString() {
        if (waarde % 100 >= 10) {
            return "€" + waarde / 100 + "," + waarde % 100;
        } else {
            return "€" + waarde / 100 + ",0" + waarde % 100;
        }
    }
}
