import ru.ifmo.se.pokemon.*;

public class Togetic extends Togepi{
    Togetic(String name, int level){
        super(name, level);
        setType(Type.FAIRY,Type.FLYING);
        setStats(55,40,85,80,105,40);
        setMove(new Swagger(),new ThunderWave(),new SweetKiss());
    }
}

class SweetKiss extends StatusMove {
    SweetKiss(){
        super(Type.FAIRY,0,75);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        Effect.confuse(p);
    }

    @Override
    protected String describe(){
        return "использует Sweet Kiss";
    }

}