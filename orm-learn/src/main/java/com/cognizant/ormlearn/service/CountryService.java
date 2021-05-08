package com.cognizant.ormlearn.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundExeption;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional
	public List<Country> getAllCountries(){
		
		return countryRepository.findAll();
	}
	
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundExeption {
		Optional<Country> result=countryRepository.findById(countryCode);
		
		if(!result.isPresent())
			throw new CountryNotFoundExeption("Country does not exist");
		
		Country country=result.get();
		return country;
		
	}
	
	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}
	
	@Transactional
	public void updateCountry(String code, String name) {
		Optional<Country> result=countryRepository.findById(code);
		Country country=result.get();
		country.setName(name);
		countryRepository.save(country);
	}
	
	@Transactional
	public void deleteCountry(String code) {
		countryRepository.deleteById(code);
	}
	
	@Transactional
	public List<Country> findByNameContainingOrderByName(String pattern){
		return countryRepository.findByNameContainingOrderByName(pattern);
	}
	
	@Transactional
	public List<Country> findByNameStartingWith(String pattern){
		return countryRepository.findByNameStartingWith(pattern);
	}

}
