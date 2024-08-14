package com.helloWorld.helloWorld.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @TableId(type = IdType.AUTO)
    Long id;

    String firstName;

    String lastName;

    String username;

    String password;

    Integer courseLevel;

    Integer quizLevel;

    LocalDateTime createdTime;

    LocalDateTime updatedTime;

}
