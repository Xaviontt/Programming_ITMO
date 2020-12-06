import ru.ifmo.se.pokemon.*;

public class Natu extends Pokemon {
    Natu(String name, int level){
        super(name, level);
        setType(Type.PSYCHIC,Type.FLYING);
        setStats(40,50,45,70,45,70);
        setMove(new Leer(),new SteelWind(),new ThunderWave());
    }
}

class Leer extends StatusMove{
    Leer(){
        super(Type.NORMAL,0,100);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.DEFENSE,-1);
    }

    @Override
    protected String describe() {
        return "использует Leer";
    }
}

class SteelWind extends PhysicalMove {
    SteelWind(){
        super(Type.STEEL,70,90);
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        if (Math.random() <= 0.1)
            p.setMod(Stat.DEFENSE,+1);
    }

    @Override
    protected String describe(){
        return "использует Steel Wind";
    }

}

class ThunderWave extends StatusMove {
    ThunderWave(){
        super(Type.ELECTRIC,0,90);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        Effect.paralyze(p);
    }

    @Override
    protected String describe(){
        return "использует Thunder Wave";
    }

}