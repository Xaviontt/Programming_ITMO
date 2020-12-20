import java.util.Objects;

public abstract class Human implements HumanActions {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object){
        if (this == object)
            return true;
        else
            return false;
    }

    @Override
    public String toString(){
        return "Human's name = " + this.name;
    }

    @Override
    public int hashCode(){
        int code = this.name.length();
        return code;
    }
}
