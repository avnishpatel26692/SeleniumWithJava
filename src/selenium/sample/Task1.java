package selenium.sample;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;

import java.util.concurrent.TimeUnit;


public class Task1 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @Test
    public void test1ErrorOnNumTooSmall(){
        WebElement textField = driver.findElement(By.id("numb"));
        textField.sendKeys("40");
        WebElement submitBtn = driver.findElement(By.className("w3-orange"));//find Submit button
        submitBtn.click(); //press Submit button
        WebElement checkMsg = driver.findElement(By.id("ch1_error"));
        Assert.assertEquals("Number is too small", checkMsg.getText());
    }
    @Test
    public void test2ErrorOnNumTooBig(){
        WebElement textField = driver.findElement(By.id("numb"));
        textField.sendKeys("140");
        WebElement submitBtn = driver.findElement(By.className("w3-orange"));
        submitBtn.click();
        WebElement checkMsg = driver.findElement(By.id("ch1_error"));
        Assert.assertEquals("Number is too big", checkMsg.getText());
    }
    @Test
    public void test3correctSqRootWORemainder(){
        WebElement textField = driver.findElement(By.id("numb"));
        textField.sendKeys("64");
        WebElement submitBtn = driver.findElement(By.className("w3-orange"));
        submitBtn.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        String message = alert.getText();
        Assert.assertEquals("Square root of 64 is 8.00", message);//check that correct no error is seen
        // and check that square root is calculated correctly
        alert.accept();
    }
    @Test
    public void test4correctSqRootWithRemainder(){
        WebElement textField = driver.findElement(By.id("numb"));
        textField.sendKeys("70");
        WebElement submitBtn = driver.findElement(By.className("w3-orange"));
        submitBtn.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        String message = alert.getText();
        Assert.assertEquals("Square root of 70 is 8.37", message);//check that correct no error is seen
        // and check that square root is calculated correctly
        alert.accept();
    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500);

        //Close browser
        driver.quit();
    }

}
