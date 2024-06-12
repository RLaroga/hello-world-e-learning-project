package com.helloWorld.helloWorld.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private Integer courseLevel;

    private Integer quizLevel;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

}
