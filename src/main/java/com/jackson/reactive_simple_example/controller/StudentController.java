/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.reactive_simple_example.controller;

import com.jackson.reactive_simple_example.model.StudentEntity;
import com.jackson.reactive_simple_example.service.StudentService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * StudentController Class.
 * <p>
 * </p>
 *
 * @author
 */
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<Flux<StudentEntity>> getAllStudent(){
        System.out.println("reach ");
        Flux<StudentEntity> students = studentService.findAllStudent();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}