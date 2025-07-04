package com.example.springbootresponsetype.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private List<String> subjects;
}
