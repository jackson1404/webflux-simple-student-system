/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.reactive_simple_example.repository;

import com.jackson.reactive_simple_example.model.StudentEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

/**
 * StudentRepository Class.
 * <p>
 * </p>
 *
 * @author
 */

@Repository
public interface StudentRepository extends R2dbcRepository<StudentEntity, Long>{

    @Query("SELECT * FROM StudentEntity s WHERE s.studentName = studentName")
    Flux<StudentEntity> findStudentsByName(String studentName);


}
