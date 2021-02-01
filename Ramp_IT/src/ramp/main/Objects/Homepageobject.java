package ramp.main.Objects;

import org.openqa.selenium.By;

public class Homepageobject {

	
	public static By loginId = By.xpath("//*[@name='username']");
	public static By passWord = By.xpath("//*[@name='password']");
	public static By loginButton = By.xpath("//*[text()='Login']");
	
	
	public static By resourceRequest = By.xpath("//span[text()='Resource Request']");
	public static By addNewResourceRequest = By.xpath("//*[text()='Add Resource Request']");
	
	public static By profileIcon = By.xpath("//img[@alt='user']");
	public static By logoutButton = By.xpath("//a[text()=' Logout']");
}
