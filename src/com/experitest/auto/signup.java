package com.experitest.auto;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.TouchAction;
import java.time.Duration;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class signup {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "singup";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();
    
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "049852502K002442");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testsingup() {
        driver.findElement(By.xpath("//*[@text='OZÉ']")).click();
        driver.findElement(By.xpath("//*[@text='Sign Up']")).click();
        driver.findElement(By.xpath("//*[@id='imageView_arrow']")).click();
        driver.findElement(By.xpath("//*[@id='editText_search']")).sendKeys("Nig");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nigeria (NG)']")));
        driver.findElement(By.xpath("//*[@text='Nigeria (NG)']")).click();
        driver.findElement(By.xpath("//*[@id='phone_number']")).sendKeys("09047640607");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='new_user_email']")));
        driver.findElement(By.xpath("//*[@id='new_user_email']")).sendKeys("arimiyahmubarak@gmail.com");
        //new TouchAction(driver).press(300, 658).waitAction(Duration.ofMillis(1383)).moveTo(300, -570).release().perform();
        driver.findElement(By.xpath("//*[@id='new_user_password']")).sendKeys("Password");
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='new_user_password2']")));
        driver.findElement(By.xpath("//*[@id='new_user_password2']")).sendKeys("Password");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        driver.findElement(By.xpath("//*[@text='I accept the Terms & Conditions']")).click();
        driver.findElement(By.xpath("//*[@text='Okay']")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}