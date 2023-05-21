package com.hb04.bi_onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Diary04 {

    @Id
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name ="std_id" )
    private Student04 student;  // 1001  1002

    // !!! Getter- Setter

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

    public Student04 getStudent() {
        return student;
    }

    public void setStudent(Student04 student) {
        this.student = student;
    }

    // !!! toString()

    @Override
    public String toString() {
        return "Diary04{" +
                "id=" + id +
                ", name='" + name + '\'' +
               /* ", student=" + student +*/
                '}';
    }
}
