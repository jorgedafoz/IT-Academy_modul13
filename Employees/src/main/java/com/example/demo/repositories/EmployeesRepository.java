package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.EmployeeEntity;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeeEntity, Long>{
	//si hicieramos la query nosotros manualmente sería:
	//@Query(value="select * from tbl_employees e where e.job_role like %:jobRole%", nativeQuery = true)  
	//@Param("job") 
	
		List<EmployeeEntity> findEmployeesByJob(String job);

}
