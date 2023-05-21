package com.hb06.uni_onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book06 {

    @Id
    private int id;

    private String name;

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

    //!!! toString()

    @Override
    public String toString() {
        return "Book06{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
