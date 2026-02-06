package com.example.demo.Kmr.Require;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employees {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB auto-increment
    private int id;
    private String username;
    private String sex;
    private double salary;
    private String password;

    public Employees(int id, String username, String sex, double salary, String password) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.salary = salary;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employees(){ //Hibernate requires a no-args constructor to instantiate entity objects using reflection.

    }
}
