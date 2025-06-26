/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.reactive_simple_example.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * StudentEntity Class.
 * <p>
 * </p>
 *
 * @author
 */

@Table(name = "tbl_student")
public class StudentEntity {

    @Id
    @Generated
    @Column("student_id")
    private Long studentId;

    @Column("student_name")
    private String studentName;

    @Column("student_age")
    private Integer studentAge;

    @Column("student_phone_number")
    private String studentPhoneNumber;

    @Column("student_address")
    private String studentAddress;

    public StudentEntity(){
    }

    public StudentEntity(Long studentId, String studentName, Integer studentAge, String studentPhoneNumber, String studentAddress) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentPhoneNumber = studentPhoneNumber;
        this.studentAddress = studentAddress;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

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
}
