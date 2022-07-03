package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	
	public static WebDriver launch() {
		String browser = System.getProperty("browser");
		if(browser.equals("firefox")) {
			return new FirefoxDriver();
		} else if(browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--incognito");
			return new ChromeDriver(options);
		} else if(browser.equals("msie")) {
			return new InternetExplorerDriver();
		} else {
			throw new RuntimeException("Unrecognized system property 'browser': " + browser);
		}
	}
}
