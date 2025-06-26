/***************************************************************
 * Author       :	 
 * Created Date :	
 * Version      : 	
 * History  :	
 * *************************************************************/
package com.jackson.reactive_simple_example.repository;

import com.jackson.reactive_simple_example.model.StudentEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
/**
 * StudentRepository Class.
 * <p>
 * </p>
 *
 * @author
 */

@Repository
public interface StudentRepository extends R2dbcRepository<StudentEntity, Long>{
}
