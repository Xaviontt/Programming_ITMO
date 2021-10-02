package xml;

import common.general.StudyGroup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 * Root object of XML file. Contains collection of StudyGroup objects
 */
@XmlRootElement(name = "StudyGroups")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudyGroups {

    @XmlElement(name="StudyGroup")
    private HashMap<Integer, StudyGroup> studyGroups = new HashMap<Integer,StudyGroup>();

    public StudyGroups() {
    }

    /**
     * @return collection of StudyGroup objects
     */
    public HashMap<Integer, StudyGroup> getStudyGroups() {
        return studyGroups;
    }

    public void setStudyGroups(HashMap<Integer, StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }
}
