/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.reactive_simple_example.service.serviceImpl;

import com.jackson.reactive_simple_example.model.StudentEntity;
import com.jackson.reactive_simple_example.repository.StudentRepository;
import com.jackson.reactive_simple_example.service.StudentService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

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
}
