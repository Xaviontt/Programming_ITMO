public class Main {
    public static void main(String[] args) {

        Scooperfield scooperfield = new Scooperfield("Scooperfield");
        Fog fog = new Fog("Fog");
        LooseGround looseGround = new LooseGround();
        Tubers tubers = new Tubers();
        Potato potato = new Potato();

        scooperfield.touchGroundWithCane();
        scooperfield.keepWalking();
        scooperfield.reach(Location.OPPOSITE_RAVINE_SLOPE);
        scooperfield.climbUp();
        scooperfield.restAndBreath();
        scooperfield.notice();
        fog.becomeClearer();
        scooperfield.keepWalking();
        fog.clearAway();
        scooperfield.notice();
        scooperfield.reach(Location.LOOSE_GROUND);
        looseGround.isPlantedWithBushes();
        scooperfield.pillOutBush();
        scooperfield.examineTubers();
        scooperfield.notice();
        tubers.clungToRoots();
        scooperfield.guessThat();
        potato.isCommon();
        scooperfield.beUnsure();
        scooperfield.saw();
        potato.isBoiled();
        scooperfield.saw();
        potato.isFried();
        scooperfield.imagineThat();
        potato.growOnTrees();
    }
}
