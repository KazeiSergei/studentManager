package com.courses.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "mark")
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @ManyToOne
    private Subject subject;

    @Column(name = "MARK")
    private int mark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", student=" + student.getFirstName() + student.getSecondName() +
                ", subject=" + subject.getName() +
                ", mark=" + mark +
                '}';
    }
}
