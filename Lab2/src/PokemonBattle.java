import ru.ifmo.se.pokemon.*;

public class PokemonBattle {
    public static void main(String[] args) {
        Battle battle = new Battle();
        battle.addAlly(new Jirachi("Жирачи",1));
        battle.addAlly(new Natu("Нату",3));
        battle.addAlly(new Xatu("Хату",2));
        battle.addFoe(new Togepi("Тогепи",3));
        battle.addFoe(new Togetic("Тогетик",2));
        battle.addFoe(new Togekiss("Тогекисс",1));
        battle.go();
    }
}
