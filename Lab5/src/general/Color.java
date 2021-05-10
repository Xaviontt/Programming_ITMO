package general;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="color")
@XmlEnum
public enum Color {
    GREEN,
    BLACK,
    BLUE,
    YELLOW,
    ORANGE,
    RED;
}
