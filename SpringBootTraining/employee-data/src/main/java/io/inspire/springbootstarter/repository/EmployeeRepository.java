package io.inspire.springbootstarter.repository;

import org.springframework.data.repository.CrudRepository;

import io.inspire.springbootstarter.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}
