package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    StudentRepo repo;


    @GetMapping("/students")
    public List<Student> getStudents() {
        return repo.findAll();
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        repo.save(student);
        return "Data successfully saved in Database";
    }

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student){
        repo.save(student);
        return "Data successfully saved in Database";
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable int id) {
        repo.deleteById(id);
        return "Data deleted";
    }
}
