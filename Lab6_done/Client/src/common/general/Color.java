package common.general;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="color")
@XmlEnum
public enum Color implements Serializable {
    GREEN,
    BLACK,
    BLUE,
    YELLOW,
    ORANGE,
    RED;
}
