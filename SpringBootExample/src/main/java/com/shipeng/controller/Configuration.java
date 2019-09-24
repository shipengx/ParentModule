package com.shipeng.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@org.springframework.context.annotation.Configuration
@PropertySource("file:///deployments/config/application.properties")
public class Configuration {

    @Value("${greeter.message}")
    public String greetingMessage;

    @Bean(name="message")
    public String getGreetingMessage() {
        return this.greetingMessage;
    }


}
