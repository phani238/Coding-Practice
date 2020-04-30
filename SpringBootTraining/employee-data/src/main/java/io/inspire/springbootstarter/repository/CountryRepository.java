package io.inspire.springbootstarter.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.inspire.springbootstarter.entity.Country;

public interface CountryRepository extends CrudRepository<Country, String> {
	public List<Country> findByEmployeeId(String country);
}
