package com.cognizant.truyum.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemRepository;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Service
public class MenuItemService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemService.class);
	@Autowired
	MenuItemRepository menuItemRepository;
	//private MenuItemDao menuItemDao;

	/*public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}*/
	
	@Transactional
	public List<MenuItem> getMenuItemListAdmin(){
		//return menuItemDao.getMenuItemListAdmin();
		return menuItemRepository.findAll();
	}
	
	@Transactional
	public List<MenuItem> getMenuItemListCustomer(){
		//return menuItemDao.getMenuItemListCustomer();
		String active="yes";
		Date dateOfLaunch=DateUtil.convertToDate("29/04/2021");
		return menuItemRepository.findByActiveAndDateOfLaunchLessThanEqual(active, dateOfLaunch);
	}
	
	@Transactional
	public void modifyMenuItem(MenuItem menuItem) {
		//menuItemDao.modifyMenuItem(menuItem);
		menuItemRepository.save(menuItem);
	}
	
	@Transactional
	public MenuItem getMenuItem(int menuItemId) {
		//return menuItemDao.getMenuItem(menuItemId);
		MenuItem menuItem=menuItemRepository.getOne(menuItemId);
		LOGGER.debug("Menu Item={}", menuItem);
		return menuItem;
	}

}
