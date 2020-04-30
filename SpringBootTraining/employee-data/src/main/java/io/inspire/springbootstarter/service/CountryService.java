package io.inspire.springbootstarter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.inspire.springbootstarter.entity.Country;
import io.inspire.springbootstarter.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public List<Country> getAllCountry(String id) {
		List<Country> country = new ArrayList<>();
		countryRepository.findByEmployeeId(id).forEach(country::add);
		return country;
	}

	public Country getCountry(String id) {
		return countryRepository.findOne(id);
	}

	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	public void updateCountry(Country country) {
		countryRepository.save(country);
	}

	public void deleteCountry(String id) {
		countryRepository.delete(id);
	}
}
