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

//    @GetMapping("/getAllStudents")
//    public Flux<ResponseEntity<StudentEntity>> getAllStudent(){
//
//        return studentService.findAllStudent()
//                .map(ResponseEntity::ok);
//    }

    @GetMapping("/getAllStudents")
    public Mono<ResponseEntity<Flux<StudentEntity>>> getAllStudent(){

        Flux<StudentEntity> student = studentService.findAllStudent();
        return Mono.just(ResponseEntity.ok(student));

    }
    
    @GetMapping("/getStudentById")
    public Mono<ResponseEntity<StudentEntity>> getStudentById(@RequestParam("studentId") Long studentId){
        return studentService.findStudentById(studentId)
                .flatMap(student -> Mono.just(ResponseEntity.ok(student)));
    }

    @PostMapping("/createStudent")
    public Mono<ResponseEntity<String>> createStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return studentService.createStudent(studentRequestDto)
                .then(Mono.just(ResponseEntity.status(HttpStatus.CREATED)
                                        .body("Student Created Successfully")));
    }

    @PutMapping("/updateStudent")
    public Mono<ResponseEntity<String>> updateStudent(@RequestParam("studentId") Long studentId , @RequestBody StudentRequestDto studentRequestDto){

        return studentService.updateStudent(studentId, studentRequestDto)
                .then(Mono.just(ResponseEntity.status(HttpStatus.OK)
                                        .body("Student Updated Successfully")));

    }

    //added delete service
    @DeleteMapping("/deleteStudent")
    public Mono<ResponseEntity<String>> deleteStudent(@RequestParam("studentId") Long studentId){

        return studentService.deleteStudent(studentId)
                .then(Mono.just(ResponseEntity.status(HttpStatus.OK)
                                        .body("Student Deleted successfully")));
    }
//
//    @GetMapping("/searchStudentName")
//    public Flux<ResponseEntity<String>> searchStudentByName(@RequestParam("studentName") String studentName) {
//
////        return studentService.searchByStudentName(studentName);
//
//    }


}