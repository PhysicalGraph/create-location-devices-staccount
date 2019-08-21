package com.account.migration;
import org.openqa.selenium.WebDriver;

/*
 * It is UI  Automation of to Create location and simulated devices with Smartthings
 * Account on Production Enviornment
 * @author tanusree.bera
 */
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class IDEAccountCommonAbs {
	
	  //protected String uoBaseURL ="https://consigliere-regionald.smartthingsgdev.com/login";
	  protected String uoBaseURL ="https://account.smartthings.com/login";
		WebDriver uoDriver = null;

		protected void launchBrowser() {
			System.out.println("...... " + System.getProperty("driverPath"));
			if (System.getProperty("driverPath") == null)
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/chromedriver");

			if (uoDriver == null) {
				uoDriver = new ChromeDriver();
				uoDriver.get(uoBaseURL);

			}
		}

		protected void destroy() {
			System.out.println("Closing browser");
			if (uoDriver != null) {
				uoDriver.close();
				uoDriver = null;
			}

		}

	

}
