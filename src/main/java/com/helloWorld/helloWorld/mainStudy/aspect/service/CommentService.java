package com.helloWorld.helloWorld.mainStudy.aspect.service;

import com.helloWorld.helloWorld.mainStudy.aspect.dto.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private final Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment) {
        logger.info("Publishing comment:" + comment.getText());
        return "SUCCESS";
    }
}
