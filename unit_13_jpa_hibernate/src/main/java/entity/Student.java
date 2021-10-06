package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;


    private List<Grade> grades = new ArrayList<>();

    public Student() {
    }

    public Student(String name, Group group) {
        this.name = name;
        this.group = group;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(targetEntity = Group.class,fetch = FetchType.LAZY)
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
        group.addStudent(this);
    }
    @OneToMany(targetEntity = Grade.class, mappedBy = "student", fetch = FetchType.LAZY)
    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
