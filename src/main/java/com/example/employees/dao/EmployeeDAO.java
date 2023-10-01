package com.example.employees.dao;

import com.example.employees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//@RepositoryRestResource(path = "members")
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
}
