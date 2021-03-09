package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
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

        //1.errorOnNumberTooSmall
        //TODO: enter number which is too small, check that correct error is seen

        @Test
        public void errorOnNumberTooSmall(){
            WebElement field = driver.findElement(By.id("numb"));
            field.sendKeys("40");
            WebElement button = driver.findElement(By.className("w3-orange"));
            button.click();
            WebElement message = driver.findElement(By.id("ch1-error"));
            String actualValue = message.getText();
            Assert.assertEquals("Number is too small",actualValue);
        }

    //2.errorOnNumberTooBig
    //TODO: enter number which is too big, check that correct error is seen

    @Test
    public void errorOnNumberTooBig(){
        WebElement field = driver.findElement(By.id("numb"));
        field.sendKeys("125");
        WebElement button = driver.findElement(By.className("w3-orange"));
        button.click();
        WebElement message = driver.findElement(By.id("ch1-error"));
        String actualValue = message.getText();
        Assert.assertEquals("Number is too big",actualValue);
    }

    //3.correctSquareRootWithoutRemainder
    //TODO: enter a number between 50 and 100 digit in the input (square root of
    // which doesn't have a remainder, e.g. 2 is square root of 4), then and press
    // submit and check that correct no error is seen and check that square root is calculated correctly
    @Test
    public void correctSquareRootWithoutRemainder(){
        WebElement field = driver.findElement(By.id("numb"));
        double sixtyFour = 64;
        field.sendKeys("64");
        WebElement button = driver.findElement(By.className("w3-orange"));
        button.click();
        Alert alert = driver.switchTo().alert();
        String message =alert.getText();
        Assert.assertEquals("Square root of 64 is 8.00",message);
        alert.dismiss();
        System.out.println(Math.sqrt(sixtyFour) + " is in the message" + message);
    }

    //4.correctSquareRootWithRemainder
    //TODO: enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder,
    // e.g. 1.732.. is square root of 3) and press submit, then check that correct no error is seen and check
    // that square root is calculated correctly

    @Test
    public void correctSquareRootWithRemainder(){
        WebElement field = driver.findElement(By.id("numb"));
        double sixtyFive = 65;
        field.sendKeys("65");
        WebElement button = driver.findElement(By.className("w3-orange"));
        button.click();
        Alert alert = driver.switchTo().alert();
        String message =alert.getText();
        Assert.assertEquals("Square root of 65 is 8.06",message);
        alert.dismiss();
        System.out.println(Math.sqrt(sixtyFive) + " is in the message" + message);

    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
