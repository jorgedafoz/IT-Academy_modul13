package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name="TBL_Employees")
public class EmployeeEntity {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="First_name", nullable=false, length=30)
	private String name;
	
	@Column(name="Job_role", nullable=false, length=30)
	private String job;
	
	@Column(name="Salary", nullable=false, length=30)
	private int salary;
	
	//constructor parametrizado
	public EmployeeEntity(Long id, String name, String job, int salary) {
		this.id=id;
		this.name=name;
		this.job=job;
		this.salary=salary;
	}
	
	//constructor por defecto
	public EmployeeEntity() {}
	
	//getters & Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setNombre(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setCategoria(String job) {
		this.job = job;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	};
	
	
	
	
	

}
