package com.gwnu.smart.application;

import com.gwnu.smart.domain.JoinRepository;
import com.gwnu.smart.domain.State;
import com.gwnu.smart.domain.UserInfo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class JoinServiceTest {
    private JoinService joinService;
    @Mock
    private JoinRepository joinRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        joinService = new JoinService(joinRepository);
    }

    @Test
    public void userIdCheck() {
        UserInfo userInfo = new UserInfo("wnstlr0615", "wnstlr0615@naver.com", "1234", "JoonSik0", 1);
        given(joinRepository.findById(any())).willReturn(java.util.Optional.of(userInfo));

        State state2 = joinService.userIdCheck("wnstlr0615");
        assertThat(state2.getResponse(), is("Join fail"));
    }

    @Test
    public void getUserInfos() {
        List<UserInfo> userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("0", "wnstlr0615@naver.com", "1234", "JoonSik0", 1));
        userInfos.add(new UserInfo("1", "wnstlr0615@naver.com", "1234", "JoonSik1", 1));
        userInfos.add(new UserInfo("2", "wnstlr0615@naver.com", "1234", "JoonSik2", 1));
        userInfos.add(new UserInfo("3", "wnstlr0615@naver.com", "1234", "JoonSik3", 1));
        userInfos.add(new UserInfo("4", "wnstlr0615@naver.com", "1234", "JoonSik4", 1));
        given(joinRepository.findAll()).willReturn(userInfos);
        UserInfo user = userInfos.get(0);
        assertThat(user.getId(), is("0"));
    }

    @Test
    public void createUser() {
        given(joinRepository.save(any())).will(invocation -> {
            UserInfo userInfo1=invocation.getArgument(0);
            return userInfo1;
        });
        UserInfo userInfo=UserInfo.builder()
                .name("joonsik")
                .email("wnstlr0615@naver.com")
                .password("3621")
                .gender(1)
                .build();
        UserInfo newUser=joinRepository.save(userInfo);
        assertThat(newUser.getName(), is("joonsik"));
    }

    @Test
    public void serachId(){
        State state=State.builder().response("sorry not found your name and address").build();
        UserInfo userInfo=UserInfo.builder().id("wnstlr0615").name("joon").email("wnstlr0615").password("3621").gender(1).build();
        given(joinRepository.findByNameAndEmail(any(), any())).willReturn(java.util.Optional.ofNullable(userInfo));
        UserInfo searchInfo=joinRepository.findByNameAndEmail("", "").orElse(null);
        if(userInfo!=null)state.setResponse("find");

        assertThat(state.getResponse(), is("find"));
    }

    @Test
    public void searchPassword(){
        State state=State.builder().response("sorry not found your name and address").build();
        UserInfo userInfo=UserInfo.builder().id("wnstlr0615").name("joon").email("wnstlr0615").password("3621").gender(1).build();
        given(joinRepository.findByNameAndIdAndEmail(any(), any(), any())).willReturn(java.util.Optional.ofNullable(userInfo));
        UserInfo searchInfo=joinRepository.findByNameAndIdAndEmail("", "","").orElse(null);
        if(userInfo!=null)state.setResponse("find");
        assertThat(state.getResponse(), is("find"));
    }
}