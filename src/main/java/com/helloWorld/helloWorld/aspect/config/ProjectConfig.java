package com.helloWorld.helloWorld.aspect.config;

import com.helloWorld.helloWorld.aspect.dto.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.helloWorld.mainStudy.aspect.service")
@EnableAspectJAutoProxy
public class ProjectConfig {

//    @Bean
//    public CommentService commentService() {
//        return new CommentService();
//    }

    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}
