import Interfaces.RawFoodActions;

public class RawPotato implements RawFoodActions {
    @Override
    public void tastelessFood() {
        System.out.println(Potato.getPotatoName() + " is tasteless");
    }

    @Override
    public void nastyFood() {
        System.out.println(Potato.getPotatoName() + " is nasty");
    }
}
