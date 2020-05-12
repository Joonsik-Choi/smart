package com.gwnu.smart.interfaces;

import com.gwnu.smart.application.JoinService;
import com.gwnu.smart.domain.State;
import com.gwnu.smart.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class JoinController {
    private List<UserInfo> userInfoList;
    @Autowired
    private JoinService joinService;

    JoinController(){
    }
    @GetMapping("/userInfo")
    public List<UserInfo> getUserInfos(){
        List<UserInfo> userInfos = joinService.getUserInfos();
        return userInfos;
    }

    @GetMapping("/userId")
    public State userIdCheck(@RequestParam String id){
        return joinService.userIdCheck(id);
    }

    @PostMapping("/userRegister")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserInfo resource) throws URISyntaxException {
        UserInfo userInfo=joinService.createUser(UserInfo.builder()
                .name(resource.getName())
                .id(resource.getId())
                .email(resource.getEmail())
                .gender(resource.getGender())
                .password(resource.getPassword()).build());
        URI location = new URI("/userRegister/" + userInfo.getId());
        return ResponseEntity.created(location).body("{}");
    }
    @GetMapping("/findId")
    public State findById(@RequestParam String name, @RequestParam String email){
        State state=joinService.findByNameAndEmail(name, email);
        return state;
    }
    @GetMapping("/findPassword")
    public State findPassword(@RequestParam String name, @RequestParam String id ,@RequestParam String email){
        State state=joinService.searchPassword(name, id, email);
        return state;
    }
}
