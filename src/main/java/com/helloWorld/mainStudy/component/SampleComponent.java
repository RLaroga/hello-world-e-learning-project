package com.helloWorld.mainStudy.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SampleComponent {
    private String name = "Robo";
    private Integer age = 25;
    private String work = "FullStack Java Developer";
}
