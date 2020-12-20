public class Bushes {
     static String bushesName;
     static String bushesColour;

    public Bushes(String bushesName, String bushesColour) {
        this.bushesName = bushesName;
        this.bushesColour = bushesColour;
    }

    public static String getBushesName() {
        return bushesName;
    }

    public static String getBushesColour() {
        return bushesColour;
    }
}
