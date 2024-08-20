package com.helloWorld.helloWorld.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class ResponseUserDTO {
    @Schema(title = "Login Token")
    String token;

    @Schema(title = "User ID")
    Integer id;

    @Schema(title = "User First Name")
    String firstName;

    @Schema(title = "User Last Name")
    String lastName;

    @Schema(title = "User Course Level")
    Integer courseLevel;

    @Schema(title = "User quiz Level")
    Integer quizLevel;

    @Schema(title = "User created time")
    LocalDateTime createdTime;

    @Schema(title = "User updated time")
    LocalDateTime updatedTime;
}
