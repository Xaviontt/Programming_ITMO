public interface ScooperfieldActions {
    void touchWithCane(String touchedObject);
    void reach(Location location);  //перемещение по локациям
    void climbUp();
    void fallDown();
    void keepWalking();
    void noticeSmth(String noticedObject);
    void notice();
    void restAndBreath();
    void pillOut(String pilledOutObject);
    void examine(String examinedObject);
    void guess(String guessAboutFact);
    void beUnsure();
    void saw(String seenFact);
    void imagine(String imaginedFact);
}
