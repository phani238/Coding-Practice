package io.inspire.springbootstarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.inspire.springbootstarter.entity.Project;
import io.inspire.springbootstarter.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public List<Project> getAllProjects(String id) {
		List<Project> project = new ArrayList<>();
		projectRepository.findByCountryId(id).forEach(project::add);
		return project;
	}

	public Project getProject(String id) {
		return projectRepository.findOne(id);
	}

	public void addProject(Project project) {
		projectRepository.save(project);
	}

	public void updateProject(Project project) {
		projectRepository.save(project);
	}

	public void deleteProject(String id) {
		projectRepository.delete(id);
	}
}
