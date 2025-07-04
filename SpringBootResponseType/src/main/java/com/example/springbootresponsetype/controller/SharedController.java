package com.example.springbootresponsetype.controller;

import com.example.springbootresponsetype.model.Employee;
import com.example.springbootresponsetype.model.Student;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SharedController {

    @GetMapping(value = "/student", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Student> getStudentInformation() {
        Student student = new Student();
        student.setId(1);
        student.setName("Mike");
        student.setAge(22);
        student.setGender("male");
        student.setSubjects(List.of("Math","Science","Social science"));

        return ResponseEntity.ok(student);
    }

    @GetMapping(value = "/student/all")
    public ResponseEntity<List> getAllStudentInformation() {
        Student student = new Student();
        student.setId(1);
        student.setName("Mike");
        student.setAge(22);
        student.setGender("male");

        return ResponseEntity.ok(List.of(student));
    }

    @GetMapping("/employee")
    public ResponseEntity<Employee> getEmployeeInformation() {
        Employee employee = new Employee();
        employee.setEmployeeId(100);
        employee.setEmployeeName("Rajesh");
        employee.setEmployeeEmail("rajesh@gmail.com");
        employee.setEmployeeRole("Manager");
        employee.setEmployeePhone("94-28477-2323");
        employee.setEmployeeAddress("Delhi");
        employee.setEmployeeDepartment(Map.of("HR",0.1f,"Sales",0.25f));

        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employee/all")
    public ResponseEntity<List<Employee>> getAllEmployeeInformation() {
        Employee employee = new Employee();
        employee.setEmployeeId(100);
        employee.setEmployeeName("Rajesh");
        employee.setEmployeeEmail("rajesh@gmail.com");
        employee.setEmployeeRole("Manger");
        employee.setEmployeePhone("94-28477-2323");
        employee.setEmployeeAddress("Delhi");

        return ResponseEntity.ok(List.of(employee));
    }

}

