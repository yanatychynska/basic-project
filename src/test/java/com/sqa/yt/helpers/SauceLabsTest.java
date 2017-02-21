package com.sqa.yt.helpers;

import java.net.*;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.testng.annotations.*;

public abstract class SauceLabsTest extends BasicTest {

	private String accessKey;

	private Browser browser;

	private String platform;

	private String username;

	private String version;

	public SauceLabsTest(String baseUrl) {
		super(baseUrl);
	}

	public Object[][] config() {
		return new Object[][] { new Object[] { Browser.IE, "11", "Windows 8.1" },
				new Object[] { Browser.CHROME, "41", "Windows XP" },
				new Object[] { Browser.SAFARI, "7", "OS X 10.9" },
				new Object[] { Browser.FIREFOX, "35", "Windows 7" } };
	}

	public Object[][] cred() {
		return new Object[][] { new Object[] { "yanatychynska",
				"442ca72a-a4cf-43e9-890e-0d23982699a4" } };
	}

	@DataProvider
	public Object[][] dataProvider() {
		return DataHelper.joinData(cred(), config(), dp());
	}

	abstract public Object[][] dp();

	public String getAccessKey() {
		return this.accessKey;
	}

	public Browser getBrowser() {
		return this.browser;
	}

	public String getPlatform() {
		return this.platform;
	}

	public String getUsername() {
		return this.username;
	}

	public String getVersion() {
		return this.version;
	}

	public void preTest(String username, String accessKey, Browser browser,
			String version, String platform)
			throws BrowserNotSupportedBySauceLabsException {
		this.username = username;
		this.accessKey = accessKey;
		this.browser = browser;
		this.platform = platform;
		this.version = version;
		setDriver(setupSpecDriver());
		getDriver().get(getBaseUrl());
	}

	@Override
	@BeforeMethod(groups = "chrome")
	public void setupChrome() {
	}

	@Override
	@BeforeMethod(groups = "firefox")
	public void setupFirefox() {
	}

	@Override
	@BeforeMethod(groups = "safari")
	public void setupSafari() {
	}

	/**
	 * @return
	 * @throws BrowserNotSupportedBySauceLabsException
	 */
	private WebDriver setupSpecDriver() throws BrowserNotSupportedBySauceLabsException {
		DesiredCapabilities cap;
		switch (getBrowser()) {
		case IE:
			cap = DesiredCapabilities.internetExplorer();
			break;
		case FIREFOX:
			cap = DesiredCapabilities.firefox();
			break;
		case CHROME:
			cap = DesiredCapabilities.chrome();
			break;
		case SAFARI:
			cap = DesiredCapabilities.safari();
			break;
		default:
			throw new BrowserNotSupportedBySauceLabsException();
		}
		cap.setCapability("platform", this.platform);
		cap.setCapability("version", this.version);
		cap.setCapability("passed", true);
		String testName = getClass().getSimpleName() + " within "
				+ getBrowser().toString().toLowerCase() + " on " + getPlatform();
		cap.setCapability("name", testName);
		URL url = null;
		try {
			url = new URL("http://" + this.username + ":" + this.accessKey
					+ "@ondemand.saucelabs.com:80/wd/hub");
		} catch (MalformedURLException e) {
			System.out.println("Can not connect to Sauce Labs URL[http://" + this.username
					+ ":" + this.accessKey + "@ondemand.saucelabs.com:80/wd/hub]");
		}
		return new RemoteWebDriver(url, cap);
	}
}
