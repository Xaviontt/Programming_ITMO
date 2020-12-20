public class Main {
    public static void main(String[] args) {
        Scooperfield scooperfield = new Scooperfield("Scooperfield");
        Fog fog = new Fog("Fog");
        scooperfield.touchWithCane("ground");
        scooperfield.keepWalking();
        scooperfield.reach(Location.OPPOSITE_SLOPE);
        scooperfield.climbUp();
        scooperfield.restAndBreath();
        scooperfield.notice();
        fog.becomeClearer();
        scooperfield.keepWalking();
        fog.clearAway();
        scooperfield.notice();
        scooperfield.reach(Location.LOOSE_GROUND);
        LooseGround looseGround = new LooseGround("Loose ground");
        Bushes bushes = new Bushes("high bushes","green");
        looseGround.planted();
        scooperfield.pillOut("green bush");
        scooperfield.examine("bush");
        scooperfield.noticeSmth("yellow tubers");
        scooperfield.guess("it is potato");
        scooperfield.beUnsure();
        scooperfield.saw("only fried or boiled potato");
        scooperfield.imagine("potatoes grows on trees");
    }
}
