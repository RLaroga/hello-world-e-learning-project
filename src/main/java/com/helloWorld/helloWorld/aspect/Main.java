package com.helloWorld.helloWorld.aspect;

import com.helloWorld.helloWorld.aspect.config.ProjectConfig;
import com.helloWorld.helloWorld.aspect.dto.Comment;
import com.helloWorld.helloWorld.aspect.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var service = c.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Natasha");

        String result = service.publishComment(comment);
        System.out.println(result);
    }
}
