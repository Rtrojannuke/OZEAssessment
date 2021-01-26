package com.experitest.auto;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class login {
	
	//package <set your test package>;



	    private String reportDirectory = "reports";
	    private String reportFormat = "xml";
	    private String testName = "login";
	    protected AndroidDriver<AndroidElement> driver = null;

	    DesiredCapabilities dc = new DesiredCapabilities();
	    
	    @BeforeMethod
	    public void setUp() throws MalformedURLException {
	        dc.setCapability("reportDirectory", reportDirectory);
	        dc.setCapability("reportFormat", reportFormat);
	        dc.setCapability("testName", testName);
	        dc.setCapability(MobileCapabilityType.UDID, "049852502K002442");
	        driver.setLogLevel(Level.INFO);
	    }

	    @Test
	    public void testlogin() {
	        driver.findElement(By.xpath("//*[@text='OZÉ']")).click();
	        driver.findElement(By.xpath("//*[@text='Already have an account? Login here']")).click();
	        driver.findElement(By.xpath("//*[@id='imageView_arrow']")).click();
	        driver.findElement(By.xpath("//*[@id='editText_search']")).sendKeys("Niger");
	        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nigeria (NG)']")));
	        driver.findElement(By.xpath("//*[@text='Nigeria (NG)']")).click();
	        driver.findElement(By.xpath("//*[@id='phone_number']")).sendKeys("07044952993");
	        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='edit_text_password']")));
	        driver.findElement(By.xpath("//*[@id='edit_text_password']")).sendKeys("Password");
	        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Log In']")));
	        driver.findElement(By.xpath("//*[@text='Log In']")).click();
	        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Today']")));
	        driver.findElement(By.xpath("//*[@text='Today']")).click();
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }

}
