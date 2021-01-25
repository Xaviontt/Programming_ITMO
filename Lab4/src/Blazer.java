public class Blazer {
    private static final String blazerName = "blazer";
    private boolean pocketIsFull = false;

    public static String getBlazerName() {
        return blazerName;
    }

    private class BlazerPocket{
        public void pocketFull(){
            pocketIsFull = true;
        }
    }

    public void fullBlazerPocket(){
        BlazerPocket blazerPocket = new BlazerPocket();
        blazerPocket.pocketFull();
        System.out.println("Blazer pocket is full");
    }
}
