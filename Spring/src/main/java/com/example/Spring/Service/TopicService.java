package com.example.Spring.Service;


import com.example.Spring.Model.Datas;
import com.example.Spring.Repository.DatasRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    @Autowired
    private DatasRepo repo;

    public List<Datas> topics = new ArrayList<>(
            Arrays.asList(
            new Datas(101, "naveen", 23),
            new Datas(222, "hari", 22),
            new Datas(31, "tamil", 24))
    );

    public List<Datas> getAll(){
        return topics;
//        return repo.findAll();
    }

    public Datas find(int id){
       return topics.stream().filter(entry -> entry.getId() == id).findFirst().get();
//        return repo.getById(id);
    }

    public List<Datas> AddDatas(Datas datas){
        topics.add(datas);
        return topics;
//        return repo.save(datas);
    }

    public List<Datas> Update(int id,Datas datas) {

        Datas d1 = topics.stream().filter(entry -> entry.getId() == id).findFirst().get();
        d1.setName(datas.getName());
        d1.setAge(datas.getAge());
        return topics;

//        Datas d1 = repo.getById(id);
//        if(d1 != null) {
//            d1.setName(datas.getName());
//            d1.setAge(datas.getAge());
//        }
//
//        return repo.save(d1);
    }
    public void Delete(int id) {
        Datas d2 = topics.stream().filter(entry -> entry.getId() == id).findFirst().get();
        topics.remove(d2);
//        repo.deleteById(id);

    }
}



