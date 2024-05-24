package com.helloWorld.helloWorld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot1() {
        var p = new Parrot();
        p.setName("KoKo");
        return p;
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }


    @Bean(name = "MiMia")
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("MiMi");
        return p;
    }

    @Bean
    @Primary
    Parrot parrot3() {
        var p = new Parrot();
        p.setName("KuMi");
        return p;
    }

}
