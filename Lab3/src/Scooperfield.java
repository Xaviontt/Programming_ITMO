public class Scooperfield extends Human implements ScooperfieldActions {

    public Scooperfield(String name) {
        super(name);
    }

    @Override
    public void touchGroundWithCane() {
        System.out.println(getName() + " is touching the " + Ground.getGroundName() + " with the " + Cane.getCaneName());
    }

    @Override
    public void reach(Location location) {
        System.out.println("He reached the " + location.getLocationName());
    }

    private int fallCounter = 0;

    @Override
    public void climbUp() {
        System.out.println(getName() + " is climbing up");
        while (Math.random() < 0.5) {
            fallDown();
            fallCounter++;
            System.out.println(getName() + " is climbing up");
        }
        reach(Location.SURFACE);
        fallCounter = 0;
    }

    @Override
    public void fallDown() {
        if (fallCounter == 0)
            System.out.println(getName() + " fell and rolled down");
        else
            System.out.println(getName() + " fell and rolled down again");
    }

    @Override
    public void breath() {
        System.out.println(getName() + " is breathing");
    }

    @Override
    public void rest() {
        System.out.println(getName() + " is resting");
    }

    @Override
    public void restAndBreath() {
        System.out.println(getName() + " is resting and breathing");
    }

    @Override
    public void pillOutBush() {
        System.out.println(getName() + " pilled out the " + Bushes.getBushesName());
    }

    @Override
    public void examineTubers() {
        System.out.println(getName() + " is examining " + Tubers.getTubersName());
    }

    @Override
    public void guessThat() {
        System.out.print(getName() + " began to guess that ");
    }

    @Override
    public void beUnsure() {
        System.out.println(getName() + " is unsure");
    }

    @Override
    public void saw() {
        System.out.print(getName() + " saw ");
    }

    @Override
    public void imagineThat() {
        System.out.print(getName() + " imagined that ");
    }


    @Override
    public void notice() {                                  // замечает факт который идёт
        System.out.print(getName() + " noticed that ");     // следующим действием
    }

    @Override
    public void keepWalking() {
        System.out.println(getName() + " keep walking");
    }

}
