package com.jackson.reactive_simple_example.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.stereotype.Service;

public class StudentRequestDto {

    private String studentName;

    private Integer studentAge;

    private String studentPhoneNumber;

    private String studentAddress;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public StudentRequestDto(){}

    public StudentRequestDto(String studentName, Integer studentAge, String studentPhoneNumber, String studentAddress) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentPhoneNumber = studentPhoneNumber;
        this.studentAddress = studentAddress;
    }
}
