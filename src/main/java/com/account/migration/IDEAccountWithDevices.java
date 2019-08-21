package com.account.migration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * It is UI  Automation of to Create location and simulated devices with Smartthings
 * Account on Production Enviornment
 * @author tanusree.bera
 */


public class IDEAccountWithDevices extends IDEAccountCommonAbs {
	@BeforeTest
	public void initialize() {
		
	}
	
	@Test(priority = 0)
	public void runTests() {
		try {
			Scanner sc = new Scanner(IDEAccountWithDevices.class.getClass().getResourceAsStream("/username.txt"));
			while (sc.hasNextLine()) {
				String user = sc.next();
				System.out.println(String.format("Running for user %s", user));
				launchBrowser();
				logIn(user);
				checkLocation();
				testLocationCreate();
				createNewSimulatedSwitch();
				createNewSimulatedLock();
				createNewSimulatedColorBulb();
				createNewSimulatedContactSensor();
				createSimulatedWaterSensor();
				createSimulatedSmokeAlarm();
				createSimulatedMotionSensor();
				createSimulatedDimmerSwitch();
				createSimulatedMinimote();
				createSimulatedPresenceSensor();
				createSimulatedThermostat();
				close();
				
				System.out.println(String.format("End - user %s", user));
				
				Thread.sleep(500);
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//@Test(priority = 0)
	public void logIn(String user) {

		try {
			System.out.println("Logging into the account");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			WebElement aLogin1 = uoDriver.findElement(By.xpath("//*[@id=\"login-selector\"]/button"));
			aLogin1.click();
			System.out.println("Clicking on Smartthings Account");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			//WebElement aLogin = uoDriver.findElement(By.xpath("/html/body/div/main/div/div[2]/div/div/div[1]/button"));
			//aLogin.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println("Entering User Id and Password");
			//uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			//WebElement username1 = uoDriver.findElement(By.xpath("//*[@id=\"username\"]"));
			//username1.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter User Name
			WebElement username = uoDriver.findElement(By.id("username"));
			username.sendKeys(user);

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			// Enter Password for the test account
			WebElement password = uoDriver.findElement(By.xpath("//*[@id=\"password\"]"));
			password.sendKeys("SmartApp12");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			// click to sign In
			WebElement signButton = uoDriver.findElement(By.cssSelector("#login-user-btn"));
			//WebElement signButton = uoDriver.findElement(By.xpath("//*[@id=\"signInButton\"]"));

			//WebElement searchBtn = uoDriver.findElement(By.id("searchbtn"));

			//WebElement visibleElement = uoDriver.findElement(By.cssSelector("whatever"));
			//WebElement hiddenElement = uoDriver.findElement(By.cssSelector("whatever"));
			//Actions a = new Actions(uoDriver);
			//a.moveTo(visibleElement).pause(1000).click(hiddenElement).build().perform();
			signButton.click();
			
			
			 
			System.out.println("Page title is: " + uoDriver.getTitle());
			System.out.println("Test Case Passed");

		} catch (Exception exp) {
			System.out.println("Test Case Failed");
		}

	}

	//@Test(priority = 1)
	public void checkLocation() {
		try {
			System.out.println("Starting List All location ");
			WebElement uLocation = uoDriver.findElement(By.partialLinkText("Locations"));
			uLocation.click();
			uoDriver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
			
		
			System.out.println("Test Case Passed");

		} catch (Exception exp) {
			System.out.println("Test Case Failed");
		}

	}
	//@Test(priority = 2)
	public void testLocationCreate() {
		try {
			System.out.println("Starting Test New Location Create :");
			String expected =("×\n" + "TestCreateLocation created");
			WebElement cLocation = uoDriver.findElement(By.xpath("//*[@id=\"list-location\"]/a"));
			cLocation.click();
			uoDriver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
			WebElement nwLocationName = uoDriver.findElement(By.xpath("//*[@id=\"name\"]"));
			nwLocationName.sendKeys("TestCreateLocation");
			uoDriver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
			WebElement crNewLocation = uoDriver.findElement(By.id("create"));
			crNewLocation.click();
			
			// Verify that New Location has Created:
			System.out.println("Verifying the New Location has Created:");
			
			WebElement gText = uoDriver.findElement(By.xpath("//*[@id=\"flash-message-container\"]/div/div"));
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String actual = gText.getText();
			
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println("Validating New Mode Has Created -----" + actual);
			
			Assert.assertEquals(actual, expected);
		     uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println("Test Case Passed");
		} catch (Exception exp) {
			System.out.println("Test Case Failed");
		}

	}


	//@Test(priority = 3)
	public void createNewSimulatedSwitch() {

		try {
			System.out.println("Starting Create Device SimulatedSwitch ------------ ");
			String expected = ("×\n" + "SimulatedSwitch created");

			WebElement lDevices = uoDriver
					.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a"));
			lDevices.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Click On Add device
			WebElement aDevices = uoDriver.findElement(By.xpath("//*[@id=\"list-device\"]/a"));
			aDevices.click();
			// Enter Device name
			WebElement nDeviceName = uoDriver.findElement(By.id("name"));
			nDeviceName.sendKeys("SimulatedSwitch");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter NetworkId
			WebElement nDeviceNid = uoDriver.findElement(By.id("deviceNetworkId"));
			nDeviceNid.sendKeys("1234");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select DTH
			Select dSelect = new Select(uoDriver.findElement(By.id("type")));
			dSelect.selectByVisibleText("Simulated Switch");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select HUB
			Select hSelect = new Select(uoDriver.findElement(By.id("location")));
			hSelect.selectByIndex(1);

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Click on Create
			WebElement dCreate = uoDriver.findElement(By.id("create"));
			dCreate.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			// Verify that New Device has Created:
			System.out.println("Verifying the New Device has Created:");

			WebElement gText = uoDriver.findElement(By.xpath("//*[@id=\"flash-message-container\"]/div/div"));
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String actual = gText.getText();

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println(actual);
			System.out.println("Validating New Device Has Created -----" + actual);
			Assert.assertEquals(actual, expected);

		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}

	//@Test(priority = 4)
	public void createNewSimulatedLock() {

		try {
			System.out.println("Starting Create Device SimulatedSwitch ------------ ");
			String expected = ("×\n" + "SimulatedLock created");
			WebElement nDevices2 = uoDriver.findElement(By.xpath("//*[@id=\"show-device\"]/a"));
			nDevices2.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter Device name
			WebElement nDeviceName2 = uoDriver.findElement(By.id("name"));
			nDeviceName2.sendKeys("SimulatedLock");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter NetworkId
			WebElement nDeviceNid2 = uoDriver.findElement(By.id("deviceNetworkId"));
			nDeviceNid2.sendKeys("3645");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select DTH
			Select dSelect = new Select(uoDriver.findElement(By.id("type")));
			dSelect.selectByVisibleText("Simulated Lock");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select Location
			Select hSelect = new Select(uoDriver.findElement(By.id("location")));
			hSelect.selectByIndex(1);

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Click on Create
			WebElement dCreate = uoDriver.findElement(By.id("create"));
			dCreate.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			// Verify that New Device has Created:
			System.out.println("Verifying the New Device has Created:");

			WebElement gText = uoDriver.findElement(By.xpath("//*[@id=\"flash-message-container\"]/div/div"));
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String actual = gText.getText();

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println(actual);
			System.out.println("Validating New Device Has Created -----" + actual);
			Assert.assertEquals(actual, expected);

		} catch (Exception exp) {
			System.out.println(exp);

		}

	}

	//@Test(priority = 5)
	public void createNewSimulatedColorBulb() {

		try {
			System.out.println("Starting Create Device SimulatedColorBulb ------------ ");
			String expected = ("×\n" + "SimulatedColorBulb created");
			WebElement nDevices2 = uoDriver.findElement(By.xpath("//*[@id=\"show-device\"]/a"));
			nDevices2.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter Device name
			WebElement nDeviceName2 = uoDriver.findElement(By.id("name"));
			nDeviceName2.sendKeys("SimulatedColorBulb");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter NetworkId
			WebElement nDeviceNid2 = uoDriver.findElement(By.id("deviceNetworkId"));
			nDeviceNid2.sendKeys("3838");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select DTH
			Select dSelect = new Select(uoDriver.findElement(By.id("type")));
			dSelect.selectByVisibleText("Simulated RGBW Bulb");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select location
			Select hSelect = new Select(uoDriver.findElement(By.id("location")));
			hSelect.selectByIndex(1);

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Click on Create
			WebElement dCreate = uoDriver.findElement(By.id("create"));
			dCreate.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			// Verify that New Device has Created:
			System.out.println("Verifying the New Device has Created:");

			WebElement gText = uoDriver.findElement(By.xpath("//*[@id=\"flash-message-container\"]/div/div"));
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String actual = gText.getText();

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println(actual);
			System.out.println("Validating New Device Has Created -----" + actual);
			Assert.assertEquals(actual, expected);

		} catch (Exception exp) {
			System.out.println(exp);
		}

	}

	//@Test(priority = 6)
	public void createNewSimulatedContactSensor() {

		try {
			System.out.println("Starting Create Device SimulatedContactSensor ------------ ");
			String expected = ("×\n" + "SimulatedContactSensor created");
			WebElement nDevices2 = uoDriver.findElement(By.xpath("//*[@id=\"show-device\"]/a"));
			nDevices2.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter Device name
			WebElement nDeviceName2 = uoDriver.findElement(By.id("name"));
			nDeviceName2.sendKeys("SimulatedContactSensor");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter NetworkId
			WebElement nDeviceNid2 = uoDriver.findElement(By.id("deviceNetworkId"));
			nDeviceNid2.sendKeys("3939");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select DTH
			Select dSelect = new Select(uoDriver.findElement(By.id("type")));
			dSelect.selectByVisibleText("Simulated Contact Sensor");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select location
			Select hSelect = new Select(uoDriver.findElement(By.id("location")));
			hSelect.selectByIndex(1);

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Click on Create
			WebElement dCreate = uoDriver.findElement(By.id("create"));
			dCreate.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			// Verify that New Device has Created:
			System.out.println("Verifying the New Device has Created:");

			WebElement gText = uoDriver.findElement(By.xpath("//*[@id=\"flash-message-container\"]/div/div"));
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String actual = gText.getText();

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println(actual);
			System.out.println("Validating New Device Has Created -----" + actual);
			Assert.assertEquals(actual, expected);

		} catch (Exception exp) {
			System.out.println(exp);
		}

	}

	//@Test(priority = 7)
	public void createNewSimulatedDimmableBulb() {

		try {
			System.out.println("Starting Create Device SimulatedDimmableBulb ------------ ");
			String expected = ("×\n" + "SimulatedDimmableBulb created");
			WebElement nDevices2 = uoDriver.findElement(By.xpath("//*[@id=\"show-device\"]/a"));
			nDevices2.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter Device name
			WebElement nDeviceName2 = uoDriver.findElement(By.id("name"));
			nDeviceName2.sendKeys("SimulatedDimmableBulb");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter NetworkId
			WebElement nDeviceNid2 = uoDriver.findElement(By.id("deviceNetworkId"));
			nDeviceNid2.sendKeys("4949");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select DTH
			Select dSelect = new Select(uoDriver.findElement(By.id("type")));
			dSelect.selectByVisibleText("Simulated Dimmable Bulb");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select location
			Select hSelect = new Select(uoDriver.findElement(By.id("location")));
			hSelect.selectByIndex(1);

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Click on Create
			WebElement dCreate = uoDriver.findElement(By.id("create"));
			dCreate.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			// Verify that New Device has Created:
			System.out.println("Verifying the New Device has Created:");

			WebElement gText = uoDriver.findElement(By.xpath("//*[@id=\"flash-message-container\"]/div/div"));
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String actual = gText.getText();

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println(actual);
			System.out.println("Validating New Device Has Created -----" + actual);
			Assert.assertEquals(actual, expected);

		} catch (Exception exp) {
			System.out.println(exp);
		}

	}

	//@Test(priority = 8)
	public void createSimulatedWaterSensor() {

		try {
			System.out.println("Starting Create Device SimulatedWaterSensor ------------ ");
			String expected = ("×\n" + "SimulatedWaterSensor created");
			WebElement nDevices2 = uoDriver.findElement(By.xpath("//*[@id=\"show-device\"]/a"));
			nDevices2.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter Device name
			WebElement nDeviceName2 = uoDriver.findElement(By.id("name"));
			nDeviceName2.sendKeys("SimulatedWaterSensor");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter NetworkId
			WebElement nDeviceNid2 = uoDriver.findElement(By.id("deviceNetworkId"));
			nDeviceNid2.sendKeys("5959");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select DTH
			Select dSelect = new Select(uoDriver.findElement(By.id("type")));
			dSelect.selectByVisibleText("Simulated Water Sensor");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select location
			Select hSelect = new Select(uoDriver.findElement(By.id("location")));
			hSelect.selectByIndex(1);

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Click on Create
			WebElement dCreate = uoDriver.findElement(By.id("create"));
			dCreate.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			// Verify that New Device has Created:
			System.out.println("Verifying the New Device has Created:");

			WebElement gText = uoDriver.findElement(By.xpath("//*[@id=\"flash-message-container\"]/div/div"));
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String actual = gText.getText();

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println(actual);
			System.out.println("Validating New Device Has Created -----" + actual);
			Assert.assertEquals(actual, expected);

		} catch (Exception exp) {
			System.out.println(exp);
		}

	}

	//@Test(priority = 9)
	public void createSimulatedSmokeAlarm() {

		try {
			System.out.println("Starting Create Device SimulatedSmokeAlarm ------------ ");
			String expected = ("×\n" + "SimulatedSmokeAlarm created");
			WebElement nDevices2 = uoDriver.findElement(By.xpath("//*[@id=\"show-device\"]/a"));
			nDevices2.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter Device name
			WebElement nDeviceName2 = uoDriver.findElement(By.id("name"));
			nDeviceName2.sendKeys("SimulatedSmokeAlarm");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter NetworkId
			WebElement nDeviceNid2 = uoDriver.findElement(By.id("deviceNetworkId"));
			nDeviceNid2.sendKeys("6969");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select DTH
			Select dSelect = new Select(uoDriver.findElement(By.id("type")));
			dSelect.selectByVisibleText("Simulated Smoke Alarm");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select location
			Select hSelect = new Select(uoDriver.findElement(By.id("location")));
			hSelect.selectByIndex(1);

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Click on Create
			WebElement dCreate = uoDriver.findElement(By.id("create"));
			dCreate.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			// Verify that New Device has Created:
			System.out.println("Verifying the New Device has Created:");

			WebElement gText = uoDriver.findElement(By.xpath("//*[@id=\"flash-message-container\"]/div/div"));
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String actual = gText.getText();

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println(actual);
			System.out.println("Validating New Device Has Created -----" + actual);
			Assert.assertEquals(actual, expected);

		} catch (Exception exp) {
			System.out.println(exp);
		}

	}

	//@Test(priority = 10)
	public void createSimulatedMotionSensor() {

		try {
			System.out.println("Starting Create Device SimulatedMotionSensor ------------ ");
			String expected = ("×\n" + "SimulatedMotionSensor created");
			WebElement nDevices2 = uoDriver.findElement(By.xpath("//*[@id=\"show-device\"]/a"));
			nDevices2.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter Device name
			WebElement nDeviceName2 = uoDriver.findElement(By.id("name"));
			nDeviceName2.sendKeys("SimulatedMotionSensor");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter NetworkId
			WebElement nDeviceNid2 = uoDriver.findElement(By.id("deviceNetworkId"));
			nDeviceNid2.sendKeys("7979");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select DTH
			Select dSelect = new Select(uoDriver.findElement(By.id("type")));
			dSelect.selectByVisibleText("Simulated Motion Sensor");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select location
			Select hSelect = new Select(uoDriver.findElement(By.id("location")));
			hSelect.selectByIndex(1);

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Click on Create
			WebElement dCreate = uoDriver.findElement(By.id("create"));
			dCreate.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			// Verify that New Device has Created:
			System.out.println("Verifying the New Device has Created:");

			WebElement gText = uoDriver.findElement(By.xpath("//*[@id=\"flash-message-container\"]/div/div"));
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String actual = gText.getText();

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println(actual);
			System.out.println("Validating New Device Has Created -----" + actual);
			Assert.assertEquals(actual, expected);

		} catch (Exception exp) {
			System.out.println(exp);
		}

	}

	//@Test(priority = 11)
	public void createSimulatedDimmerSwitch() {

		try {
			System.out.println("Starting Create Device SimulatedDimmerSwitch ------------ ");
			String expected = ("×\n" + "SimulatedDimmerSwitch created");
			WebElement nDevices2 = uoDriver.findElement(By.xpath("//*[@id=\"show-device\"]/a"));
			nDevices2.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter Device name
			WebElement nDeviceName2 = uoDriver.findElement(By.id("name"));
			nDeviceName2.sendKeys("SimulatedDimmerSwitch");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter NetworkId
			WebElement nDeviceNid2 = uoDriver.findElement(By.id("deviceNetworkId"));
			nDeviceNid2.sendKeys("8989");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select DTH
			Select dSelect = new Select(uoDriver.findElement(By.id("type")));
			dSelect.selectByVisibleText("Simulated Dimmer Switch");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select location
			Select hSelect = new Select(uoDriver.findElement(By.id("location")));
			hSelect.selectByIndex(1);

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Click on Create
			WebElement dCreate = uoDriver.findElement(By.id("create"));
			dCreate.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			// Verify that New Device has Created:
			System.out.println("Verifying the New Device has Created:");

			WebElement gText = uoDriver.findElement(By.xpath("//*[@id=\"flash-message-container\"]/div/div"));
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String actual = gText.getText();

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println(actual);
			System.out.println("Validating New Device Has Created -----" + actual);
			Assert.assertEquals(actual, expected);

		} catch (Exception exp) {
			System.out.println(exp);
		}

	}

	//@Test(priority = 12)
	public void createSimulatedMinimote() {

		try {
			System.out.println("Starting Create Device SimulatedMinimote ------------ ");
			String expected = ("×\n" + "SimulatedMinimote created");
			WebElement nDevices2 = uoDriver.findElement(By.xpath("//*[@id=\"show-device\"]/a"));
			nDevices2.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter Device name
			WebElement nDeviceName2 = uoDriver.findElement(By.id("name"));
			nDeviceName2.sendKeys("SimulatedMinimote");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter NetworkId
			WebElement nDeviceNid2 = uoDriver.findElement(By.id("deviceNetworkId"));
			nDeviceNid2.sendKeys("9999");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select DTH
			Select dSelect = new Select(uoDriver.findElement(By.id("type")));
			dSelect.selectByVisibleText("Simulated Minimote");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select location
			Select hSelect = new Select(uoDriver.findElement(By.id("location")));
			hSelect.selectByIndex(1);

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Click on Create
			WebElement dCreate = uoDriver.findElement(By.id("create"));
			dCreate.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			// Verify that New Device has Created:
			System.out.println("Verifying the New Device has Created:");

			WebElement gText = uoDriver.findElement(By.xpath("//*[@id=\"flash-message-container\"]/div/div"));
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String actual = gText.getText();

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println(actual);
			System.out.println("Validating New Device Has Created -----" + actual);
			Assert.assertEquals(actual, expected);

		} catch (Exception exp) {
			System.out.println(exp);
		}

	}

	//@Test(priority = 13)
	public void createSimulatedPresenceSensor() {

		try {
			System.out.println("Starting Create Device SimulatedPresenceSensor ------------ ");
			String expected = ("×\n" + "SimulatedPresenceSensor created");
			WebElement nDevices2 = uoDriver.findElement(By.xpath("//*[@id=\"show-device\"]/a"));
			nDevices2.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter Device name
			WebElement nDeviceName2 = uoDriver.findElement(By.id("name"));
			nDeviceName2.sendKeys("SimulatedPresenceSensor");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter NetworkId
			WebElement nDeviceNid2 = uoDriver.findElement(By.id("deviceNetworkId"));
			nDeviceNid2.sendKeys("1919");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select DTH
			Select dSelect = new Select(uoDriver.findElement(By.id("type")));
			dSelect.selectByVisibleText("Simulated Presence Sensor");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select location
			Select hSelect = new Select(uoDriver.findElement(By.id("location")));
			hSelect.selectByIndex(1);

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Click on Create
			WebElement dCreate = uoDriver.findElement(By.id("create"));
			dCreate.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			// Verify that New Device has Created:
			System.out.println("Verifying the New Device has Created:");

			WebElement gText = uoDriver.findElement(By.xpath("//*[@id=\"flash-message-container\"]/div/div"));
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String actual = gText.getText();

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println(actual);
			System.out.println("Validating New Device Has Created -----" + actual);
			Assert.assertEquals(actual, expected);

		} catch (Exception exp) {
			System.out.println(exp);
		}

	}

	//@Test(priority = 14)
	public void createSimulatedThermostat() {

		try {
			System.out.println("Starting Create Device SimulatedThermostat ------------ ");
			String expected = ("×\n" + "SimulatedThermostat created");
			WebElement nDevices2 = uoDriver.findElement(By.xpath("//*[@id=\"show-device\"]/a"));
			nDevices2.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter Device name
			WebElement nDeviceName2 = uoDriver.findElement(By.id("name"));
			nDeviceName2.sendKeys("SimulatedThermostat");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Enter NetworkId
			WebElement nDeviceNid2 = uoDriver.findElement(By.id("deviceNetworkId"));
			nDeviceNid2.sendKeys("2929");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select DTH
			Select dSelect = new Select(uoDriver.findElement(By.id("type")));
			dSelect.selectByVisibleText("Simulated Thermostat");
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Select location
			Select hSelect = new Select(uoDriver.findElement(By.id("location")));
			hSelect.selectByIndex(1);

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			// Click on Create
			WebElement dCreate = uoDriver.findElement(By.id("create"));
			dCreate.click();
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

			// Verify that New Device has Created:
			System.out.println("Verifying the New Device has Created:");

			WebElement gText = uoDriver.findElement(By.xpath("//*[@id=\"flash-message-container\"]/div/div"));
			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			String actual = gText.getText();

			uoDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			System.out.println(actual);
			System.out.println("Validating New Device Has Created -----" + actual);
			Assert.assertEquals(actual, expected);

		} catch (Exception exp) {
			System.out.println(exp);
		}

	}
	//@AfterTest
	public void close() {
		destroy();
	}

}

