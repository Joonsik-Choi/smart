package com.gwnu.smart.interfaces;

import com.gwnu.smart.application.MedicineService;
import com.gwnu.smart.domain.Medicine;
import com.gwnu.smart.domain.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MedicineController {
    @Autowired
    private MedicineService medicineService;
    @GetMapping("/medicines")
    public List<Medicine> list(){
       /* List<Medicine> medicines=new ArrayList<>();
        Medicine mockMedicine=Medicine.builder().id(1L).color("white").company("영풍제약(주)").formula("ref").imageURL("")
                .name("가나릴정").shape("정제형").line("-").sortation("").build();
        medicines.add(mockMedicine);*/

        return  medicineService.getMedicine();
    }

    @GetMapping("/medicines/find")
    public List<Medicine> findMedicine(@RequestParam String shape, @RequestParam String formula,
                                       @RequestParam String color, @RequestParam String line){
        return  medicineService.getMedicine();
    }
}
