public class Tubers {
    private static final String tubersName = "tubers";
    private static final String tubersColour = "yellow";

    public static String getTubersName() {
        return tubersName;
    }

    public static String getTubersColour() {
        return tubersColour;
    }

    public void clungToRoots(){
        System.out.println(getTubersColour() + " " + getTubersName() + " clung to " + PotatoBushes.PotatoRoots.getPotatoRootsName());
    }
}
