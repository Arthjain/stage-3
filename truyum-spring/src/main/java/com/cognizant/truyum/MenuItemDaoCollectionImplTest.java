package com.cognizant.truyum;

import java.math.BigDecimal;
import java.util.List;
//import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.util.DateUtil;

@SpringBootApplication
public class MenuItemDaoCollectionImplTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoCollectionImplTest.class);
	
	private static MenuItemService menuItemService;

	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		ApplicationContext context = SpringApplication.run(MenuItemDaoCollectionImplTest.class, args);
		menuItemService=context.getBean(MenuItemService.class);
		
		/*Scanner sc = new Scanner(System.in);
		String choice;

		do {
			System.out.println("Menu");
			System.out.println("****************************************");
			System.out.println("1. Admin");
			System.out.println("2. Customer");
			System.out.println("3. Exit");
			System.out.println("****************************************");

			choice = sc.nextLine();
			System.out.println("****************************************");

			switch (choice) {
			case "1": {
				String adminChoice;
				do {
					System.out.println("Admin Menu");
					System.out.println("****************************************");
					System.out.println("1. Get Menu Item List");
					System.out.println("2. Modify Menu Item");
					System.out.println("3. Get Menu Item");
					System.out.println("4. Main Menu");
					System.out.println("****************************************");

					adminChoice = sc.nextLine();
					System.out.println("****************************************");

					switch (adminChoice) {
					case "1": {
						System.out.println("Admin Menu Item List");
						System.out.println("****************************************");
						testGetMenuItemListAdmin();
						break;
					}
					case "2": {
						System.out.println("Item 2 is modified. Enter 3 to display the changes.");
						System.out.println("****************************************");
						testModifyMenuItem();
						break;
					}
					case "3": {
						System.out.println("2nd Menu Item is displayed");
						System.out.println("****************************************");
						testGetMenuItem();
						break;
					}
					case "4": {
						break;
					}
					default: {
						System.out.println("Enter valid choice");
					}
					}
				} while (adminChoice.equals("4"));
				break;
			}
			case "2": {
				System.out.println("Customer Menu Item List");
				System.out.println("****************************************");
				testGetMenuItemListCustomer();
				break;
			}
			case "3": {
				break;
			}
			default: {
				System.out.println("Enter valid choice");
			}
			}
		} while (choice.equals("3"));

		sc.close();*/
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
	}

	public static void testGetMenuItemListAdmin() {
		//MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		LOGGER.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();
		LOGGER.debug("Menu Item List={}", menuItemList);
		LOGGER.info("End");

		/*for (int i = 0; i < menuItemList.size(); i++) {
			System.out.println(menuItemList.get(i));
		}*/
	}

	public static void testGetMenuItemListCustomer() {
		//MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		LOGGER.info("Start");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();
		LOGGER.debug("Menu Item List={}", menuItemList);
		LOGGER.info("End");

		/*for (int i = 0; i < menuItemList.size(); i++) {
			System.out.println(menuItemList.get(i));
		}*/
	}

	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(2, "Hotdog", new BigDecimal(129.00), "yes", 
				DateUtil.convertToDate("23/12/2017"), "Main Course", "no");
		//MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		LOGGER.info("Start");
		menuItemService.modifyMenuItem(menuItem);
		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();
		LOGGER.debug("Menu Item List={}", menuItemList);
		LOGGER.info("End");
	}

	public static void testGetMenuItem() {
		//MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		LOGGER.info("Start");
		MenuItem menuItem=menuItemService.getMenuItem(2);
		//LOGGER.debug("Menu Item={}", menuItem);
		LOGGER.info("End");
	}
}
