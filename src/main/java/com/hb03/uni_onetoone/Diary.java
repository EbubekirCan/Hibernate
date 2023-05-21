package com.hb03.uni_onetoone;

import javax.persistence.*;

@Entity
public class Diary {

    @Id
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name="std_id", unique = true)
    private Student03 student; // student_id

    // !!! Getter-Setter

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    //!!! toString()

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
