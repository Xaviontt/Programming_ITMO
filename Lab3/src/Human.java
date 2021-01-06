public abstract class Human implements HumanActions {
    private final String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object){
        return this == object;
    }

    @Override
    public String toString(){
        return "Human's name = " + this.name;
    }

    @Override
    public int hashCode(){
        return this.name.length();
    }
}
