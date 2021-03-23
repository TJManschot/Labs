package nl.belastingdienst.opgave2;

public class SeasonApp {
    public static void main(String[] args){
        Season season1 = Season.Winter;
        Season season2 = Season.Spring;
        Season season3 = Season.Summer;
        Season season4 = Season.Autumn;
        Season season5 = Season.Wet;
        Season season6 = Season.Dry;

        season1.checkTemperature();
        season2.checkTemperature();
        season3.checkTemperature();
        season4.checkTemperature();
        season5.checkTemperature();
        season6.checkTemperature();
    }
}
