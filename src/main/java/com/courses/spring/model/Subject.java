package com.courses.spring.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name =("subject"))
public class Subject {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name=("ID"))
    private int id;

    @Column(name=("SUBJECT_NAME"))
    private String name;

    @OneToMany(mappedBy = "subject")
    private Set<Mark> marks = new HashSet<Mark>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Subject(" + "id=" + id + ", name='" + name + '\'' +  ')';
    }
}
