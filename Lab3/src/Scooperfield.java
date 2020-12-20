public class Scooperfield extends Human implements ScooperfieldActions {

    public Scooperfield(String name) {
        super(name);
    }

    @Override
    public void touchWithCane(String touchedObject) {
        System.out.println(super.getName() + " is touching the " + touchedObject + " with the cane");
    }

    @Override
    public void reach(Location location) {
        System.out.println("He reached the " + location.getLocationName());
    }

    private int fallCounter = 0;

    @Override
    public void climbUp() {
        System.out.println(super.getName() + " is climbing up");
        while (Math.random() < 0.5) {
            fallDown();
            fallCounter++;
            System.out.println(super.getName() + " is climbing up");
        }
        reach(Location.SURFACE);
        fallCounter = 0;
    }

    @Override
    public void fallDown() {
        if (fallCounter == 0)
            System.out.println(super.getName() + " fell and rolled down");
        else
            System.out.println(super.getName() + " fell and rolled down again");
    }

    @Override
    public void breath() {
        System.out.println(super.getName() + " is breathing");
    }

    @Override
    public void rest() {
        System.out.println(super.getName() + " is resting");
    }

    @Override
    public void restAndBreath() {
        System.out.println(super.getName() + " is resting and breathing");
    }

    @Override
    public void pillOut(String pilledOutObject) {
        System.out.println(super.getName() + " pilled out the " + pilledOutObject);
    }

    @Override
    public void examine(String examinedObject) {
        System.out.println(super.getName() + " is examining the " + examinedObject);
    }

    @Override
    public void guess(String guessAboutFact) {
        System.out.println(super.getName() + " began to guess that " + guessAboutFact);
    }

    @Override
    public void beUnsure() {
        System.out.println(super.getName() + " is unsure");
    }

    @Override
    public void saw(String seenFact) {
        System.out.println(super.getName() + " saw " + seenFact);
    }

    @Override
    public void imagine(String imaginedFact) {
        System.out.println(super.getName() + " imagined that " + imaginedFact);
    }

    @Override
    public void notice() {                                        // замечает факт который идёт
        System.out.print(super.getName() + " noticed that ");     // следующим действием
    }

    @Override
    public void noticeSmth(String noticedObject) {                            // замечает нужный нам факт
        System.out.println(super.getName() + " noticed " + noticedObject);
    }

    @Override
    public void keepWalking() {
        System.out.println(super.getName() + " keep walking");
    }

}
