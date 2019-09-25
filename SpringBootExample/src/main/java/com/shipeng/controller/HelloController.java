package com.shipeng.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    @Qualifier("message")
    public String message;

    @RequestMapping("/")
    public String index() {

        /*
        String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");
        return prefix.equals("Hi") ? "default string" : prefix;
        */

        LOG.info("hahahahajk.com");

        return message == null ? "failure" : message;

    }


}
