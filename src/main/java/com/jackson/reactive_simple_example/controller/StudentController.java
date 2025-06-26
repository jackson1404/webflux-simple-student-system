/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.reactive_simple_example.controller;

import com.jackson.reactive_simple_example.dto.StudentRequestDto;
import com.jackson.reactive_simple_example.model.StudentEntity;
import com.jackson.reactive_simple_example.service.StudentService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * StudentController Class.
 * <p>
 * </p>
 *
 * @author
 */
@RestController
@RequestMapping("/api/v1/student")
@SuppressWarnings("unused")
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

    @GetMapping("/getStudentById")
    public ResponseEntity<Mono<StudentEntity>> getStudentById(@RequestParam("studentId") Long studentId){

        Mono<StudentEntity> student = studentService.findStudentById(studentId);

        return new ResponseEntity<>(student, HttpStatus.OK);

    }
    @PostMapping("/createStudent")
    public Mono<ResponseEntity<Void>> createStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return studentService.createStudent(studentRequestDto)
                .then(Mono.just(ResponseEntity.status(HttpStatus.CREATED).build()));
    }


}