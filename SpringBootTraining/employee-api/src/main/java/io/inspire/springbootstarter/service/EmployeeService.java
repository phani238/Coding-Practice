package io.inspire.springbootstarter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import io.inspire.springbootstarter.employee.Employee;

@Service
public class EmployeeService {

	private List<Employee> employees = new ArrayList<Employee>(
			Arrays.asList(new Employee("1", "Steve", "Rogers"), new Employee("2", "Tony", "Stark"),
					new Employee("3", "Bruce", "Banner"), new Employee("4", "Thor", "Odinson")));

	public List<Employee> getAllEmployee() {
		return employees;
	}

	public Employee getEmployee(String id) {
		return employees.stream().filter(e -> e.getId().equals(id)).findFirst().get();
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public void updateEmployee(Employee employee, String id) {
		for (Employee e : employees) {
			if (e.getId().equals(id)) {
				e.setFirstName(employee.getFirstName());
				e.setLastName(employee.getLastName());
				e.setId(employee.getId());
				return;
			}
		}
	}

	public void deleteEmployee(String id) {
		employees.removeIf(e -> e.getId().equals(id));
	}
}
