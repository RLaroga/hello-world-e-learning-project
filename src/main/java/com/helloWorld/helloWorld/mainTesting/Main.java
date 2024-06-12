package com.helloWorld.helloWorld.mainTesting;

import com.helloWorld.helloWorld.config.Parrot;
import com.helloWorld.helloWorld.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String [] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean("parrot1", Parrot.class);
        System.out.println("Parrot 1 name is : " + p.getName());

        String hello = context.getBean(String.class);
        System.out.println("String value: " + hello);

        Integer ten = context.getBean(Integer.class);
        System.out.println("Integer value: " + ten);

//        //Call specific beans
//        Parrot parrot = context.getBean("parrot2", Parrot.class);
//        System.out.println("Parrot 2 name is : " + parrot.getName());

        //I don't call specific beans so the Spring will choose a beans that has @Primary as its default choice
        Parrot parrotPrimary = context.getBean(Parrot.class);
        System.out.println("Parrot Spring Primary choice : " + parrotPrimary.getName());

        Parrot parrotMiMia = context.getBean("MiMia", Parrot.class);
        System.out.println("Parrot Spring with name in @Bean : " + parrotMiMia.getName());
    }
}
