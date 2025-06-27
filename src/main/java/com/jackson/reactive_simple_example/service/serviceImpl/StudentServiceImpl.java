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
        return saveStudent(studentEntity, studentRequestDto)
                .doOnNext(saved -> System.out.println("Created Student: " + studentEntity.getStudentName()))
                .then();
    }

    @Override
    public Mono<Void> updateStudent(Long studentId, StudentRequestDto studentRequestDto) {

        return findStudentById(studentId)
                .flatMap(existingStudent -> saveStudent(existingStudent, studentRequestDto))
                        .doOnNext(updated -> System.out.println("Updated student: " + updated.getStudentName()))
                                .then();
    }

    @Override
    public Mono<Void> deleteStudent(Long studentId) {
        return studentRepository.deleteById(studentId)
                .doOnNext(deleted -> System.out.println("Deleted Student Id: " + studentId))
                .then();
    }

    @Override
    public Flux<StudentEntity> searchByStudentName(String studentName) {
        return studentRepository.findStudentsByName(studentName);
    }

    private Mono<StudentEntity> saveStudent(StudentEntity studentEntity, StudentRequestDto studentRequestDto){
        studentEntity.setStudentName(studentRequestDto.getStudentName());
        studentEntity.setStudentAddress(studentRequestDto.getStudentAddress());
        studentEntity.setStudentAge(studentRequestDto.getStudentAge());
        studentEntity.setStudentPhoneNumber(studentRequestDto.getStudentPhoneNumber());

        return studentRepository.save(studentEntity);
    }

}
