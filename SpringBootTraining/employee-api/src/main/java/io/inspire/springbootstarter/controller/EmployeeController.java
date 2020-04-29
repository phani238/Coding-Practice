package io.inspire.springbootstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.inspire.springbootstarter.employee.Employee;
import io.inspire.springbootstarter.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employees")
	public List<Employee> employee() {
		return employeeService.getAllEmployee();
	}

	@RequestMapping("/employees/{empId}")
	public Employee getEmployee(@PathVariable("empId") String id) {
		return employeeService.getEmployee(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employees")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employees/{empId}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable("empId") String id) {
		employeeService.updateEmployee(employee, id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{empId}")
	public void deleteEmployee(@PathVariable("empId") String id) {
		employeeService.deleteEmployee(id);
	}
}
