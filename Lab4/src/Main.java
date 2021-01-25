import Enums.Location;
import Exceptions.DirtyPotatoException;
import Exceptions.IncorrectNumber;
import Interfaces.TubersActions;

public class Main {
    public static void main(String[] args) {

        Scooperfield scooperfield = new Scooperfield("Scooperfield");
        Fog fog = new Fog("Fog");
        LooseGround looseGround = new LooseGround();
        Tubers tubers = new Tubers();
        Potato potato = new Potato();
        RawPotato rawPotato = new RawPotato();
        Blazer blazer = new Blazer();

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
//        scooperfield.cleanPotato();

        try {
            scooperfield.bitePotato();
        } catch (DirtyPotatoException e) {
            e.printStackTrace();
        }

        scooperfield.chewPotato();
        scooperfield.seemsThat();
        rawPotato.nastyFood();
        scooperfield.guessThat();

        TubersActions noOne = new TubersActions() {
            @Override
            public void grows() {
                System.out.println("no one grows useless tubers");
            }
        };
        noOne.grows();

        scooperfield.fillPocket();

        try {
            scooperfield.itemsToPocket(5);
        } catch (IncorrectNumber ex){
            ex.printStackTrace();
        }

        blazer.fullBlazerPocket();
        scooperfield.keepWalking();
    }
}
