package general;

public class Coordinates {
    private float x;
    private Float y; //Поле не может быть null

    public Coordinates(float x, Float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


}
