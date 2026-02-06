package com.example.Spring.Controller;

import com.example.Spring.Model.Datas;
import com.example.Spring.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private TopicService service;

    @RequestMapping("/datas")
    public List<Datas> getAll() {
        return service.getAll();
    }

    @GetMapping("/datas/{id}")
    public Datas find(@PathVariable int id) {
        return service.find(id);
    }

    @PostMapping("/adddatas")
    public List<Datas> AddDatas(@RequestBody Datas datas) {
        return service.AddDatas(datas);
    }

    @PutMapping("/update/{id}")
    public List<Datas> Update(@PathVariable int id,@RequestBody Datas datas){
        return service.Update(id,datas);
    }

    @DeleteMapping("/delete/{id}")
    public String Delete(@PathVariable int id){
        service.Delete(id);
        return "Id "+id+" succefully deleted check using get !..";
    }
}
