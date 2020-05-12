package com.gwnu.smart.application;

import com.gwnu.smart.domain.JoinRepository;
import com.gwnu.smart.domain.Medicine;
import com.gwnu.smart.domain.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    private  MedicineRepository medicineRepository;
    @Autowired
    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository=medicineRepository;
    }
    public  List<Medicine> getMedicine() {
         return  medicineRepository.findAll();
    }
}
