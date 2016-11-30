package com.courses.spring.model;


import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name =("student"))
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name=("ID"))
    private int id;

    @Column(name=("FIRST_NAME"))
    @Pattern(regexp="^[A-Z][a-z]{1,255}$",message = "Name is invalid")
    private String firstName;

    @Column(name=("SECOND_NAME"))
    @Pattern(regexp="^[A-Z][a-z]{1,255}$",message = "SecondName is invalid")
    private String secondName;

    @OneToMany(mappedBy = "student")
    private Set<Mark> marks = new HashSet<Mark>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
