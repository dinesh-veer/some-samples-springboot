package com.example.springbootresponsetype.model;

import lombok.Data;

import java.util.Map;

@Data
public class Employee {

    private Integer employeeId;
    private String employeeName;
    private String employeeAddress;
    private String employeePhone;
    private String employeeEmail;
    private String employeeRole;
    private Map<String, Float> employeeDepartment;
}
