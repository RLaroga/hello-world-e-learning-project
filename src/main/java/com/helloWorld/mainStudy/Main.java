package com.helloWorld.mainStudy;

import com.helloWorld.mainStudy.bean.Person;
import com.helloWorld.mainStudy.bean.SampleBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
    public static void main(String[] args) {

        //Sample bean using @Bean
        var context = new AnnotationConfigApplicationContext(SampleBean.class);
        Person p = context.getBean(Person.class);
        System.out.println("The person's name is : " + p.getName());
        System.out.println("The person's age is : " + p.getAge());
        System.out.println("The person's work is : " + p.getWork());
    }
}
