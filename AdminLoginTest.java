package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdminLoginTest 
{

	@Parameters({"browser"})
	@Test
	public void checkAdminLogin(String br) throws MalformedURLException
	{
	
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(br);
		
		URL huburl = new URL("http://192.168.1.65:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(huburl, cap);
				
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://orangehrm.qedgetech.com");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.id("btnLogin")).click();		
	}
	
}
