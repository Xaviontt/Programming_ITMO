import ru.ifmo.se.pokemon.*;

public class Xatu extends Natu{
    Xatu(String name, int level){
        super(name, level);
        setType(Type.PSYCHIC,Type.FLYING);
        setStats(65,75,70,95,70,95);
        setMove(new Leer(),new SteelWind(),new ThunderWave(),new AirSlash());
    }
}

class AirSlash extends SpecialMove {
    AirSlash(){
        super(Type.FLYING,75,95);
    }

    @Override
    protected void applyOppEffects(Pokemon p){
        if (Math.random() <= 0.3)
            Effect.flinch(p);
    }

    @Override
    protected String describe(){
        return "использует Air Slash";
    }

}