package com.helloWorld.helloWorld.mainStudy.aspect.service;

import com.helloWorld.helloWorld.mainStudy.aspect.annotation.ToLog;
import com.helloWorld.helloWorld.mainStudy.aspect.dto.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private final Logger logger = Logger.getLogger(CommentService.class.getName());

    @ToLog
    public String publishComment(Comment comment) {
        logger.info("Publishing comment:" + comment.getText());
        return "SUCCESS";
    }

    @ToLog
    public String deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment.getText());
        return "DELETE COMMENT";
    }

    public void editComment(Comment comment) {
        logger.info("Editing comment: " + comment.getText());
    }

}
