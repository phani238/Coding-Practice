package io.inspire.springbootstarter.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Country {
	@Id
	private String id;
	private String country;
	private String state;
	@ManyToOne
	private Employee employee;

	public Country() {
	}

	public Country(String id, String state, String country, String empId) {
		super();
		this.id = id;
		this.state = state;
		this.country = country;
		this.employee = new Employee(empId, "", "");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
