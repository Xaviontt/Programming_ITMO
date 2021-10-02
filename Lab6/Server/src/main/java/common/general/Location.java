package common.general;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement(name="location")
@XmlAccessorType(XmlAccessType.FIELD)
public class Location implements Serializable {
    private int x;
    private int y;
    private long z;

    public Location(int x, int y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location() {}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public long getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
