package com.helloWorld.mainStudy.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleBean {
    @Bean
    Person person() {
        var p = new Person();
        p.setName("Robert");
        p.setAge(25);
        p.setWork("Java Developer");
        return p;
    }
}
