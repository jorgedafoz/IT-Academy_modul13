package com.example.demo.services;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.RecordNotFoundException;
import com.example.demo.models.EmployeeEntity;
import com.example.demo.repositories.EmployeesRepository;


@Service
public class EmployeesService {
	
	@Autowired
	EmployeesRepository repository;
	
	
	public List<EmployeeEntity> getAllEmployees() {
		
		//check if exists, if doesn't create new list
	
		System.out.print("getAllEmployees");
		List<EmployeeEntity> result = (List<EmployeeEntity>) repository.findAll();
		
		if (result.size() > 0) {
			
			return result;
			
		} else {
			
			return new ArrayList<EmployeeEntity>();
		}
	}
	
	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
		
		System.out.print("getEmployeeById");
		Optional<EmployeeEntity> employee = repository.findById(id);
		
		if (employee.isPresent()) {
			
			return employee.get();
			
		} else {
			
			throw new RecordNotFoundException ("No employee record exists for given id: " + id);
			
		}
	}
	
	public EmployeeEntity createOrUpdateEmployee (EmployeeEntity entity) {
		
		System.out.print("createOrUpdateEmpeloyee");
		
		//create new employee
		if (entity.getId()==null) {
			
			entity = repository.save(entity);
			
			return entity;
			
		//update employees data	
		} else {
			Optional<EmployeeEntity> employee = repository.findById(entity.getId());
			
			if (employee.isPresent()) {
				
				EmployeeEntity newEntity = employee.get();
				newEntity.setNombre(entity.getName());
				newEntity.setCategoria(entity.getJob());
				
				newEntity = repository.save(newEntity);
				
				return newEntity;
				
			//create new employee if not found	
			} else {
				
				entity = repository.save(entity);
				
				return entity;
			}
		} 
	}
	
	public void deleteEmployeeById (Long id) throws RecordNotFoundException {
		
		System.out.print ("deleteEmployeeById");
		Optional<EmployeeEntity> employee = repository.findById(id);
		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException ("No employee records for given id: " + id);
		}
		
	}
	
	//Get employees by Job
		public List<EmployeeEntity> findEmployeesByjob (String job) {
			
			return repository.findEmployeesByJob(job);
		}
	
	
	
	
	

}
