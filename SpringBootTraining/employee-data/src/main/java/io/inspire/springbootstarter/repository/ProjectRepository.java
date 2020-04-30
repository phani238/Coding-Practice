package io.inspire.springbootstarter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.inspire.springbootstarter.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, String> {
	public List<Project> findByCountryId(String country);
}
