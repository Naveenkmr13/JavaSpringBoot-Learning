package com.example.Spring.Repository;

import com.example.Spring.Model.Datas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasRepo extends JpaRepository<Datas, Integer> { // this is not db, this takes data to tb like
    // for ex : current pass throught wired, here this jpa is wire the current is hibernate and fan is db.
}

//interface => No need to write implementation, Spring Boot / Hibernate handle it.
//extends JpaRepository<Student, Integer> =>
//Datas → Entity class (table)
//Integer → Primary key type (id)


