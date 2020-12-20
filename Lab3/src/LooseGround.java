public class LooseGround {
    private String looseGroundName;

    public LooseGround(String looseGroundName) {
        this.looseGroundName = looseGroundName;
    }

    public String getLooseGroundName() {
        return looseGroundName;
    }

    void planted() {
        System.out.println(getLooseGroundName() + " is planted with " + Bushes.getBushesName());
    }

}
