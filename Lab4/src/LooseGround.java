public class LooseGround {
    private static final String looseGroundName = "Loose ground";

    public String getLooseGroundName() {
        return looseGroundName;
    }

    void isPlantedWithBushes() {
        System.out.println(getLooseGroundName() + " is planted with " + PotatoBushes.getBushesName());
    }

}
