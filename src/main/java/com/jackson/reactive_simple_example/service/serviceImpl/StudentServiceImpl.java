/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.reactive_simple_example.service.serviceImpl;

import com.jackson.reactive_simple_example.dto.StudentRequestDto;
import com.jackson.reactive_simple_example.model.StudentEntity;
import com.jackson.reactive_simple_example.repository.StudentRepository;
import com.jackson.reactive_simple_example.service.StudentService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * StudentServiceImpl Class.
 * <p>
 * </p>
 *
 * @author
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Flux<StudentEntity> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Mono<StudentEntity> findStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Mono<Void> createStudent(StudentRequestDto studentRequestDto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentName(studentRequestDto.getStudentName());
        studentEntity.setStudentAddress(studentRequestDto.getStudentAddress());
        studentEntity.setStudentAge(studentRequestDto.getStudentAge());
        studentEntity.setStudentPhoneNumber(studentRequestDto.getStudentPhoneNumber());

        return studentRepository.save(studentEntity)
                .doOnNext(saved -> System.out.println("Saved student: " + saved.getStudentName()))
                .then(); // convert Mono<StudentEntity> to Mono<Void>
    }

}
