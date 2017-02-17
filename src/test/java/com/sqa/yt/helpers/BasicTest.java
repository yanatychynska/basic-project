package com.sqa.yt.helpers;

import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.safari.*;
import org.testng.annotations.*;

public class BasicTest extends Core {

	private String baseUrl;

	public BasicTest(String baseUrl) {
		super();
		this.baseUrl = baseUrl;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	@Override
	public int getInt(String name) {
		return AutoBasics.getInt(name);
	}

	@Override
	public String getProp(String name) {
		return AutoBasics.getProp(name);
	}

	@BeforeMethod(groups = "chrome")
	public void setupChrome() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		setDriver(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(this.baseUrl);
	}

	@BeforeMethod(groups = "firefox")
	public void setupFirefox() {
		WebDriver driver;
		driver = new FirefoxDriver();
		setDriver(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(this.baseUrl);
	}

	@BeforeMethod(enabled = false)
	public void setupIE() {
		WebDriver driver;
		System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		setDriver(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(this.baseUrl);
	}

	@BeforeMethod(enabled = false)
	public void setupSafari() {
		WebDriver driver;
		driver = new SafariDriver();
		setDriver(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(this.baseUrl);
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
}
