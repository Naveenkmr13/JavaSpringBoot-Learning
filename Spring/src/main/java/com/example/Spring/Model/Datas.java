package com.example.Spring.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity      // telling jpa to take these to the db for columns
public class Datas {
    @Id
    private int id;
    private String name;
    private int age;

    public Datas(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Datas(){ //hibernate => want to create empty constructor and  it set the values later by its own,
        // it can't able ot create obj

    }

}
