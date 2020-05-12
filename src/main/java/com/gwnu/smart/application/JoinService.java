package com.gwnu.smart.application;

import com.gwnu.smart.domain.JoinRepository;
import com.gwnu.smart.domain.State;
import com.gwnu.smart.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinService {
    private JoinRepository joinRepository;
    @Autowired
    public JoinService(JoinRepository joinRepository) {
        this.joinRepository = joinRepository;
    }

    public State userIdCheck(String id) {
         UserInfo userInfo = joinRepository.findById(id).orElse(null);
        if(userInfo==null)return State.builder().response("Join ok").build();
        else return State.builder().response("Join fail").build();

    }

    public List<UserInfo> getUserInfos() {
        List<UserInfo> userInfos= (List<UserInfo>) joinRepository.findAll();
        return userInfos;
    }

    public UserInfo createUser(UserInfo userInfo) {
        return joinRepository.save(userInfo);
    }

    public State findByNameAndEmail(String name, String email) {
        UserInfo userInfo=joinRepository.findByNameAndEmail(name, email).orElse(null);
        if(userInfo==null)
            return State.builder().response("sorry not found your name and address").build();
        else
            return State.builder().response("your id is "+ userInfo.getId()).build();
    }


    public State searchPassword(String name, String id, String email) {
        UserInfo userInfo=joinRepository.findByNameAndIdAndEmail(name, id, email).orElse(null);
        if(userInfo==null)return State.builder().response("not found userInfo").build();
        else  return State.builder().response("your password is "+userInfo.getPassword()).build();
    }
}
