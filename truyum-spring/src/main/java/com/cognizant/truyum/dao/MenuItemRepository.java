package com.cognizant.truyum.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer>{
	
	public List<MenuItem> findByActiveAndDateOfLaunchLessThanEqual(String active, Date dateOfLaunch);

}
