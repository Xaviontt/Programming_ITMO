import ru.ifmo.se.pokemon.*;

public class Togekiss extends Togetic{
    Togekiss(String name, int level){
        super(name, level);
        setType(Type.FAIRY,Type.FLYING);
        setStats(85,50,95,120,115,80);
        setMove(new Swagger(),new ThunderWave(),new ShadowBall());
    }
}

class ShadowBall extends SpecialMove {
    ShadowBall(){
        super(Type.GHOST,80,100);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.SPECIAL_DEFENSE,-1);
    }

    @Override
    protected String describe(){
        return "использует Shadow Ball";
    }

}