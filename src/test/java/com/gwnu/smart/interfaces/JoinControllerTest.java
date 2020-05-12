package com.gwnu.smart.interfaces;

import com.gwnu.smart.application.JoinService;
import com.gwnu.smart.domain.State;
import com.gwnu.smart.domain.UserInfo;
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

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(JoinController.class)
public class JoinControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private JoinService joinService;

    @Test
    public void userIdCheck() throws Exception {
        State state= State.builder().response("Join Fail").build();
        given(joinService.userIdCheck(any())).willReturn(state);
        mvc.perform(get("/userId?id=1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"response\":\"Join Fail\"}")));
    }

    @Test
    public void getuserInfos() throws Exception {
        List<UserInfo> userInfos=new ArrayList<>();
        userInfos.add(new UserInfo("0", "wnstlr0615@naver.com", "1234", "JoonSik0", 1));
        given(joinService.getUserInfos()).willReturn(userInfos);
        mvc.perform(get("/userInfo"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":\"0\"")));
    }
    @Test
    public void createUserWithValidation() throws Exception {
        given(joinService.createUser(any())).will(invocation -> {
            UserInfo userInfo=invocation.getArgument(0);
            return UserInfo.builder()
                    .name(userInfo.getName())
                    .id(userInfo.getId())
                    .email(userInfo.getEmail())
                    .gender(userInfo.getGender())
                    .password(userInfo.getPassword()).build();
        });
        mvc.perform(post("/userRegister")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"wnstlr0615\",\"name\":\"joonsik\",\"email\":\"wnstlr0615@naver.com\",\"gender\":1,\"password\":\"3621\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/userRegister/wnstlr0615"))
                .andExpect(content().string("{}"));

    }
    @Test
    public void createUserWithInvalidation() throws Exception {
        given(joinService.createUser(any())).will(invocation -> {
            UserInfo userInfo=invocation.getArgument(0);
            return UserInfo.builder()
                    .name(userInfo.getName())
                    .id(userInfo.getId())
                    .email(userInfo.getEmail())
                    .gender(userInfo.getGender())
                    .password(userInfo.getPassword()).build();
        });
        mvc.perform(post("/userRegister")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"\",\"name\":\"\",\"email\":\"\",\"gender\":\"\",\"password\":\"\"}"))
                .andExpect(status().isBadRequest());

    }
    @Test
    public void searchId() throws Exception {
        given(joinService.findByNameAndEmail(any(), any())).willReturn(State.builder().response("sorry not found your name and address").build());

        State state= joinService.findByNameAndEmail("joon", "wnstlr0615");
        mvc.perform(get("/findId?name=joon&email=wnstlr0615"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"response\":\"sorry not found your name and address\"")));

    }

    @Test
    public void searchPassword() throws Exception {
        given(joinService.searchPassword(any(), any(), any())).willReturn(State.builder().response("find").build());
        State state= joinService.searchPassword("joon", "wnstlr0615", "wnstlr0615@naver.com");
        mvc.perform(get("/findPassword?name=joon&id=wnstlr0615&email=wnstlr0615@naver.com"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"response\":\"find\"")));
    }
}
