package io.inspire.springbootstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.inspire.springbootstarter.entity.Country;
import io.inspire.springbootstarter.service.CountryService;
import io.inspire.springbootstarter.service.EmployeeService;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employees/{empId}/countries")
	public List<Country> countries(@PathVariable("empId") String id) {
		return countryService.getAllCountry(id);
	}

	@RequestMapping("/employees/{empId}/countries/{countryId}")
	public Country getCountry(@PathVariable("countryId") String id) {
		return countryService.getCountry(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employees/{empId}/countries")
	public void addCountry(@RequestBody Country country, @PathVariable("empId") String empId) {
		country.setEmployee(employeeService.getEmployee(empId));
		countryService.addCountry(country);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employees/{empId}/countries/{countryId}")
	public void updateCountry(@RequestBody Country country, @PathVariable("empId") String empId,
			@PathVariable("countryId") String id) {
		country.setEmployee(employeeService.getEmployee(empId));
		countryService.updateCountry(country);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{empId}/countries/{countryId}")
	public void deleteCountry(@PathVariable("countryId") String id) {
		countryService.deleteCountry(id);
	}
}
