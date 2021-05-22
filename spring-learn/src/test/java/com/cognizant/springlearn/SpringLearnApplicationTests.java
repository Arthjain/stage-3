package com.cognizant.springlearn;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.springlearn.controller.CountryController;

@AutoConfigureMockMvc
@SpringBootTest
class SpringLearnApplicationTests {
	
	@Autowired
	private CountryController countryController;
	
	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
		// check if controller is loaded
		assertNotNull(countryController);
	}

	@Test
	public void testGetCountry() throws Exception {
		
		// calling service method
		ResultActions actions = mvc.perform(get("/country"));
		
		// to check if the HTTP Status is 200
		actions.andExpect(status().isOk());
		
		// to check if the code is available in response
		actions.andExpect(jsonPath("$.code").exists());
		
		// to check if the value of code is "IN"
		actions.andExpect(jsonPath("$.code").value("IN"));
		
		// checking name attribute
		actions.andExpect(jsonPath("$.name").exists());
		actions.andExpect(jsonPath("$.name").value("India"));
	}
	
	@Test
	public void testGetCountryException() throws Exception {
		ResultActions actions = mvc.perform(get("/countries/az"));
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Country not found"));
	}
	
	@Test
	public void testUpdateEmployeeException() throws Exception {
		ResultActions actions = mvc.perform(put("/employees"));
		actions.andExpect(status().isBadRequest());
	}
}
