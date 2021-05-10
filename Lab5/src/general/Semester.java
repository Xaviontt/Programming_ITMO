package general;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="semester")
@XmlEnum
public enum Semester {
    SECOND,
    THIRD,
    FIFTH,
    SIXTH,
    SEVENTH;
}
