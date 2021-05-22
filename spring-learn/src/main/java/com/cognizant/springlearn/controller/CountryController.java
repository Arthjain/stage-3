package com.cognizant.springlearn.controller;

import java.util.List;
import javax.validation.Valid;

/*
import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

//@RequestMapping("/countries")
@RestController
public class CountryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	private CountryService countryService;
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@RequestMapping(value="/country", method=RequestMethod.GET)
	public Country getCountryIndia() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country",Country.class);
		
		LOGGER.debug("Country : {}", country);
		LOGGER.info("END");
		return country;
	}
	
	//@GetMapping
	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = (List<Country>) context.getBean("countryList");
		
		LOGGER.debug("Countries : {}", countries);
		LOGGER.info("END");
		return countries;
	}
	
	//@GetMapping("/{code}")
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("START");
		Country country = countryService.getCountry(code);
		
		LOGGER.debug("Country using Country code : {}", country);
		LOGGER.info("END");
		return country;
	}
	
	//@PostMapping
	@PostMapping("/countries")
	public Country addCountry(@RequestBody @Valid Country country) { 
		// reading country data as a bean
		// @Valid annotation intimates spring framework to validate the country bean based on the validation annotations added in the Country class
		LOGGER.info("START");
		LOGGER.info(country.toString());
		
		/*
		// Validations
		
		// Create validator factory
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		// Validation is done against annotations defined in country bean
		Set<ConstraintViolation<Country>> violations = validator.validate(country);
		List<String> errors =  new ArrayList<String>();
		
		// Accumulate all errors in ArrayList of type String
		for(ConstraintViolation<Country> violation : violations) {
			errors.add(violation.getMessage());
		}
		
		//Throw exception so that user of this web service receives appropriate error message
		if(violations.size() > 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
		}
		
		*/

		LOGGER.info("END");
		return country;		
	}
}
