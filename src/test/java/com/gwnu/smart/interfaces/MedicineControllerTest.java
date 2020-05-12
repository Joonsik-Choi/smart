package com.gwnu.smart.interfaces;

import com.gwnu.smart.application.MedicineService;
import com.gwnu.smart.domain.Medicine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(MedicineController.class)
public class MedicineControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private MedicineService medicineService;
    @Test
    public void list() throws Exception {
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