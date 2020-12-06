import ru.ifmo.se.pokemon.*;

public class Jirachi extends Pokemon {
    Jirachi(String name, int level){
        super(name, level);
        setType(Type.STEEL, Type.PSYCHIC);
        setStats(100,100,100,100,100,100);
        setMove(new FlashCannon(),new Confide(),new ZenHeadbutt(),new ChargeBeam());
    }
}

class FlashCannon extends SpecialMove{
    FlashCannon(){
        super(Type.STEEL,80,100);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random() <= 0.1)
            p.setMod(Stat.SPECIAL_DEFENSE,-1);
    }

    @Override
    protected String describe(){
        return "использует Flash Cannon";
    }

}

class Confide extends StatusMove{
    Confide(){
        super(Type.NORMAL,0,0);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.SPECIAL_ATTACK,-1);
    }

    @Override
    protected String describe(){
        return "использует Confide";
    }

}

class ZenHeadbutt extends PhysicalMove{
    ZenHeadbutt(){
        super(Type.PSYCHIC,80,90);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random() <= 0.2)
            Effect.flinch(p);
    }

    @Override
    protected String describe(){
        return "использует Zen Headbutt";
    }
}

class ChargeBeam extends SpecialMove{
    ChargeBeam(){
        super(Type.ELECTRIC,50,90);
    }

    @Override
    protected void applySelfEffects(Pokemon p){
        if (Math.random() <= 0.7)
            p.setMod(Stat.SPECIAL_ATTACK,+1);
    }

    @Override
    protected String describe(){
        return "использует Charge Beam";
    }

}