package io.inspire.springbootstarter.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Project {

	@Id
	private String id;
	private String project;
	private String description;

	@ManyToOne
	private Country country;

	Project() {
	}

	Project(String id, String project, String description, String countryId, String empId) {
		super();
		this.id = id;
		this.project = project;
		this.description = description;
		this.country = new Country(countryId, "", "", "");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
