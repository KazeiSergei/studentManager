package com.courses.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * {@code Subject} class is a bean that mapping
 * corresponding DB table entity.
 */

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "SUBJECT_NAME")
    @NotNull
    @Size(min = 2, max = 14)
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
        return "Subject(" + "id=" + id + ", name='" + name + '\'' + ')';
    }
}
