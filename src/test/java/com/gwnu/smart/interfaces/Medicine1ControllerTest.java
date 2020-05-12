package com.gwnu.smart.interfaces;

import com.gwnu.smart.application.Medicine1Service;
import com.gwnu.smart.domain.Medicine1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(Medicine1Controller.class)
public class Medicine1ControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private Medicine1Service medicine1Service;

    @Test
    public void list() throws Exception {
        List<Medicine1> mockMedicine1s=new ArrayList<>();
        mockMedicine1s.add(Medicine1.builder().itemName("가나릴정").build());
        given(medicine1Service.getList(any(), any(), any(), any())).willReturn(mockMedicine1s);
        List<Medicine1> medicine1List=medicine1Service.getList(any(), any(), any(), any());
        assertThat(medicine1List.get(0).getItemName(), is("가나릴정"));
        mvc.perform(get("/medicine1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"itemName\":\"가나릴정\"")));
    }
    @Test
    public void created() throws Exception {
        mvc.perform(post("/medicine1")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"id\":2,\"ITEM_NAME\":\"가나릴정\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/medicine1/2"))
                .andExpect(content().string("{}"));
        verify(medicine1Service).create(any());
    }
    @Test
    public void addList() throws Exception {
        mvc.perform(post("/medicine1/createList")
        .contentType(MediaType.APPLICATION_JSON)
        .content("[\n" +
                "  {\n" +
                "    \"itemSeq\": 199304470,\n" +
                "    \"itemName\": \"징카민정40mg(은행엽건조엑스)(수출명 : 징카프란정)\",\n" +
                "    \"entpSeq\": 19620008,\n" +
                "    \"entpName\": \"영진약품(주)\",\n" +
                "    \"chart\": \"(수출용) 하트형의 연녹색 제피정(내수용) 연녹색의 원형필름 제피정\",\n" +
                "    \"itemImage\": \"https://nedrug.mfds.go.kr/pbp/cmn/itemImageDownload/1Muwq7fAuBq\",\n" +
                "    \"printFront\": \"\",\n" +
                "    \"printBack\": \"Z40\",\n" +
                "    \"drugShape\": \"원형\",\n" +
                "    \"colorClass1\": \"연두\",\n" +
                "    \"colorClass2\": \"\",\n" +
                "    \"lineFront\": \"\",\n" +
                "    \"lineBack\": \"\",\n" +
                "    \"lengLong\": \"9.7\",\n" +
                "    \"lengShort\": \"9.7\",\n" +
                "    \"thick\": \"3.8\",\n" +
                "    \"imgRegistTs\": \"20191029\",\n" +
                "    \"classNo\": 2190,\n" +
                "    \"className\": \"기타의 순환계용약\",\n" +
                "    \"etcOtcName\": \"일반의약품\",\n" +
                "    \"itemPermitDate\": \"19930715\",\n" +
                "    \"formCodeName\": \"필름코팅정\",\n" +
                "    \"markCodeFrontAnal\": \"\",\n" +
                "    \"markCodeBackAnal\": \"\",\n" +
                "    \"markCodeFrontImg\": \"\",\n" +
                "    \"markCodeBackImg\": \"\",\n" +
                "    \"changeDate\": \"20190916\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"itemSeq\": 197400571,\n" +
                "    \"itemName\": \"아스코푸정(히벤즈산티페피딘)\",\n" +
                "    \"entpSeq\": 19620008,\n" +
                "    \"entpName\": \"영진약품(주)\",\n" +
                "    \"chart\": \"황색의 정제임.\",\n" +
                "    \"itemImage\": \"https://nedrug.mfds.go.kr/pbp/cmn/itemImageDownload/151318001317200082\",\n" +
                "    \"printFront\": \"ASCOUGH   YJP\",\n" +
                "    \"printBack\": \"\",\n" +
                "    \"drugShape\": \"원형\",\n" +
                "    \"colorClass1\": \"노랑\",\n" +
                "    \"colorClass2\": \"\",\n" +
                "    \"lineFront\": \"\",\n" +
                "    \"lineBack\": \"\",\n" +
                "    \"lengLong\": \"7.03\",\n" +
                "    \"lengShort\": \"7.03\",\n" +
                "    \"thick\": \"3.38\",\n" +
                "    \"imgRegistTs\": \"20041222\",\n" +
                "    \"classNo\": 2220,\n" +
                "    \"className\": \"진해거담제\",\n" +
                "    \"etcOtcName\": \"전문의약품\",\n" +
                "    \"itemPermitDate\": \"19741016\",\n" +
                "    \"formCodeName\": \"나정\",\n" +
                "    \"markCodeFrontAnal\": \"\",\n" +
                "    \"markCodeBackAnal\": \"\",\n" +
                "    \"markCodeFrontImg\": \"\",\n" +
                "    \"markCodeBackImg\": \"\",\n" +
                "    \"changeDate\": \"\"\n" +
                "  }]"));
    }
}