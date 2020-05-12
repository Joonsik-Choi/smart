package com.gwnu.smart.application;

import com.gwnu.smart.domain.Medicine;
import com.gwnu.smart.domain.MedicineRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class MedicineServiceTest {

    private  MedicineService medicineService;
    @Mock
    MedicineRepository medicineRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        medicineService=new MedicineService(medicineRepository);
    }
    @Test
    public void getMedicine(){
        List<Medicine> medicines=new ArrayList<>();
        Medicine mockMedicine=Medicine.builder().color("white").company("영풍제약(주)").formula("ref").imageURL("")
                .name("가나릴정").shape("정제형").line("-").sortation("").build();
        medicines.add(mockMedicine);
        given(medicineService.getMedicine()).willReturn(medicines);
        List<Medicine> medicineList=medicineService.getMedicine();
        Medicine medicine=medicineList.get(0);
        assertThat(medicine.getName(), is("가나릴정"));
    }

}