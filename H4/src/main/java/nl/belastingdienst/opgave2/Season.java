package nl.belastingdienst.opgave2;

public enum Season {
    Winter, Spring, Summer, Autumn, Wet, Dry;

    public void checkTemperature(){
        switch (this) {
            case Autumn:
            case Winter:
                System.out.println("cold");
                break;
            case Spring:
            case Summer:
                System.out.println("warm");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
}