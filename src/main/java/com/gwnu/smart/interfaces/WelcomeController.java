package com.gwnu.smart.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public String hello(){
        return "hello";
    }
    @GetMapping("/test")
    public List<String> test(){
        List<String> strings=new ArrayList<>();

        return strings;
    }
}
