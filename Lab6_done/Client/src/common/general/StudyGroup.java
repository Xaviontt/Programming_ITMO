package common.general;

import xml.LocalDateXmlAdapter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.Objects;


@XmlRootElement(name="StudyGroup")
@XmlAccessorType(XmlAccessType.FIELD)
public class StudyGroup implements Comparable<StudyGroup>, Serializable {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    @XmlJavaTypeAdapter(LocalDateXmlAdapter.class)
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private int expelledStudents; //Значение поля должно быть больше 0
    private float averageMark; //Значение поля должно быть больше 0
    private Semester semesterEnum; //Поле может быть null
    private Person groupAdmin; //Поле может быть null

    public StudyGroup(Integer id, String name, Coordinates coordinates, java.time.LocalDate creationDate, Long studentsCount, int expelledStudents, float averageMark, Semester semesterEnum, Person groupAdmin) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.studentsCount = studentsCount;
        this.expelledStudents = expelledStudents;
        this.averageMark = averageMark;
        this.semesterEnum = semesterEnum;
        this.groupAdmin = groupAdmin;
    }

    public StudyGroup() {}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Long getStudentsCount() {
        return studentsCount;
    }

    public int getExpelledStudents() {
        return expelledStudents;
    }

    public float getAverageMark() {
        return averageMark;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    @Override
    public int compareTo(StudyGroup s) {
        return studentsCount.compareTo(s.getStudentsCount());
    }

    @Override
    public String toString() {
        return "StudyGroup{" +
                "id = " + id +
                " name = '" + name + '\'' + "\n" +
                " coordinates = " + coordinates + "\n" +
                " creationDate = " + creationDate + "\n" +
                " studentsCount = " + studentsCount + "\n" +
                " expelledStudents = " + expelledStudents + "\n" +
                " averageMark = " + averageMark + "\n" +
                " semesterEnum = " + semesterEnum + "\n" +
                " groupAdmin = " + groupAdmin +
                '}';
    }
}
