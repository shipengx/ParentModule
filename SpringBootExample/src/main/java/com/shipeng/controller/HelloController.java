package com.shipeng.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Autowired
    @Qualifier("message")
    public String message;

    @RequestMapping("/")
    public String index() {

        /*
        String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");
        return prefix.equals("Hi") ? "default string" : prefix;
        */

        return message == null ? "failure" : message;
    }


}
