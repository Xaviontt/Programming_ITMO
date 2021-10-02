package common.general;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="semester")
@XmlEnum
public enum Semester implements Serializable {
    SECOND,
    THIRD,
    FIFTH,
    SIXTH,
    SEVENTH;
}
