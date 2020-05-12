package com.gwnu.smart.application;

import com.gwnu.smart.domain.Medicine1;
import com.gwnu.smart.domain.Medicine1Repository;
import com.gwnu.smart.domain.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class Medicine1ServiceTest {
    private Medicine1Service medicine1Service;
    @Mock
    private Medicine1Repository medicine1Repository;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        medicine1Service=new Medicine1Service(medicine1Repository);
    }
    @Test
    public void getList(){
        List<Medicine1> mockMedicine1s=new ArrayList<>();
        mockMedicine1s.add(Medicine1.builder().itemName("가나릴정").build());
        given(medicine1Service.getList(any(), any(), any(), any())).willReturn(mockMedicine1s);
        List<Medicine1> medicine1List=medicine1Service.getList(any(), any(), any(), any());
        assertThat(medicine1List.get(0).getItemName(), is("가나릴정"));
    }
    @Test
    public void created(){
        given(medicine1Repository.save(any())).will(invocation -> {
            Medicine1 medicine1=invocation.getArgument(0);
            return medicine1;
        });
        Medicine1 medicine1=Medicine1.builder().itemName("가나릴정").build();
        Medicine1 newMedicine11=medicine1Service.create(medicine1);
        assertThat(newMedicine11.getItemName(), is("가나릴정"));
    }
}