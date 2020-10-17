package pl.sda.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "classroomSeq")
    @GenericGenerator(name = "classroomSeq", strategy = "increment")
    private int id;

    @Column (name = "class_number")
    private int classNumber;

    @ManyToOne(targetEntity = Department.class)
    private Department department;

    public Classroom() {
    }

    public Classroom(int classNumber, Department department) {

        this.classNumber = classNumber;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return id == classroom.id &&
                classNumber == classroom.classNumber &&
                Objects.equals(department, classroom.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, classNumber, department);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", classNumber=" + classNumber +
                ", department=" + department +
                '}';
    }
}
