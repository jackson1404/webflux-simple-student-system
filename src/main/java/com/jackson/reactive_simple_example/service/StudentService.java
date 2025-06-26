/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.reactive_simple_example.service;

import com.jackson.reactive_simple_example.dto.StudentRequestDto;
import com.jackson.reactive_simple_example.model.StudentEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * StudentService Class.
 * <p>
 * </p>
 *
 * @author
 */

public interface StudentService {

    Flux<StudentEntity> findAllStudent();


    Mono<StudentEntity> findStudentById(Long studentId);

    Mono<Void> createStudent(StudentRequestDto studentRequestDto);
}
