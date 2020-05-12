package com.gwnu.smart.application;

import com.gwnu.smart.domain.JoinRepository;
import com.gwnu.smart.domain.Medicine1;
import com.gwnu.smart.domain.Medicine1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Medicine1Service {
    private Medicine1Repository medicine1Repository;
    @Autowired
    public Medicine1Service(Medicine1Repository medicine1Repository){
        this.medicine1Repository=medicine1Repository;
    }
//    public List<Medicine1> getList() {
//        List<Medicine1> medicine1s=medicine1Repository.findAll();
//        return medicine1s;
//    }
    public Medicine1 create(Medicine1 resource) {
       return medicine1Repository.save(resource);
    }
    public void addList(List<Medicine1> medicine1s) {
        for(Medicine1 medicine1: medicine1s) {
            medicine1Repository.save(medicine1);
        }
        }

    public List<Medicine1> getList(String drugShape, String formula, String colorClass1, String line) {
        return medicine1Repository.findAllByDrugShapeAndColorClass1AndLineFront(drugShape, colorClass1, line);
    }
}
