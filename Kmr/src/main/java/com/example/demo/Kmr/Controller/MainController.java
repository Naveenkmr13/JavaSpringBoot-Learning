package com.example.demo.Kmr.Controller;

import com.example.demo.Kmr.Repository.EmployeeRepo;
import com.example.demo.Kmr.Require.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private EmployeeRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/home")
    public String HomePage(){
        return "Welcome to home page";
    }

    @GetMapping("/alldatas")
    public List<Employees> Alldatas(){
        return repo.findAll();
    }

    @PostMapping ("/add")
    public Employees Add(@RequestBody Employees data){
        data.setPassword(passwordEncoder.encode(data.getPassword()));
        return repo.save(data);
    }

    @PutMapping ("/update/{id}")
    public String Update(@PathVariable int id, @RequestBody Employees data){
        if(repo.getById(id) != null) {
            data.setPassword(passwordEncoder.encode(data.getPassword()));
            repo.save(data);
        }
        return "DB updated successfully";
    }

    @DeleteMapping ("/delete/{id}")
    public String Delete(@PathVariable int id){
        repo.deleteById(id);
        return "Data successfullt deleted from DB";
    }

}
