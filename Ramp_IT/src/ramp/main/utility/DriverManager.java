package ramp.main.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	
	public static void set(WebDriver driver){
		webDriver.set(driver);
	}
	public static WebDriver get(){
		return	webDriver.get();
	}
	public static void close(){
		webDriver.get().close();
	}

	public static void quit(){
		webDriver.get().quit();
	}

	public static WebDriver startBrowser(String browserName){
		String browser = browserName.toLowerCase();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		if(browser.contains("headless")){
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
			driver = new ChromeDriver(options);
		}
		return driver;
	}
}
