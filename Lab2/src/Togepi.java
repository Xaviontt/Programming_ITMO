import ru.ifmo.se.pokemon.*;

public class Togepi extends Pokemon{
    Togepi(String name, int level){
        super(name, level);
        setType(Type.FAIRY);
        setStats(35,20,65,40,65,20);
        setMove(new Swagger(),new ThunderWave());
    }
}

class Swagger extends StatusMove {
    Swagger(){
        super(Type.NORMAL,0,85);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.ATTACK,+2);
        Effect.confuse(p);
    }

    @Override
    protected String describe(){
        return "использует Swagger";
    }

}


