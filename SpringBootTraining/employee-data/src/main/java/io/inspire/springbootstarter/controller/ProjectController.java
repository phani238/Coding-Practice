package io.inspire.springbootstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.inspire.springbootstarter.entity.Project;
import io.inspire.springbootstarter.service.CountryService;
import io.inspire.springbootstarter.service.EmployeeService;
import io.inspire.springbootstarter.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employees/{empId}/countries/{countryId}/project")
	public List<Project> projects(@PathVariable("empId") String empId, @PathVariable("countryId") String countryId) {
		return projectService.getAllProjects(countryId);
	}

	@RequestMapping("/employees/{empId}/countries/{countryId}/project/{projectId}")
	public Project getProject(@PathVariable("projectId") String id) {
		return projectService.getProject(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employees/{empId}/countries/{countryId}/project")
	public void addCountry(@RequestBody Project project, @PathVariable("empId") String empId,
			@PathVariable("countryId") String countryId) {
		project.setCountry(countryService.getCountry(countryId));
		project.getCountry().setEmployee(employeeService.getEmployee(empId));
		projectService.addProject(project);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employees/{empId}/countries/{countryId}/project/{projectId}")
	public void updateCountry(@RequestBody Project project, @PathVariable("empId") String empId,
			@PathVariable("countryId") String countryId, @PathVariable("projectId") String id) {
		project.setCountry(countryService.getCountry(countryId));
		project.getCountry().setEmployee(employeeService.getEmployee(empId));
		projectService.updateProject(project);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{empId}/countries/{countryId}/project/{projectId}")
	public void deleteCountry(@PathVariable("projectId") String id) {
		projectService.deleteProject(id);
	}
}
