package com.example.demo.Kmr.Repository;

import com.example.demo.Kmr.Require.Employees;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Integer> {
    Optional<Employees> findByusername(String username);
    // findBy aprm irukurathu username so jpa antha username vechhi eduthu kuduthurum
    //Optional = value irukalam / illamalum irukalam nu safe-ah handle panna use panra wrapper class.
    //username same ha ilana null nu varum so atha safe ha vechika optional nu podanum
}
