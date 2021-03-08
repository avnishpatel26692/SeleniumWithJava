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

import java.util.concurrent.TimeUnit;

public class FormSample {


    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void errorOnNumberTooSmall() {
        WebElement insertnum = driver.findElement(By.id("numb"));
        insertnum.click();
        insertnum.sendKeys("35");
        WebElement orangebtn = driver.findElement(By.className("w3-orange"));
        orangebtn.click();
        WebElement errormsg = driver.findElement(By.id("ch1_error"));
        String actualText = errormsg.getText();
        Assert.assertEquals("Number is too small", actualText);


        /*}
        @Test
        public void alertOnClickingButton()
        {
            WebElement redBtn = driver.findElement(By.className("w3-red"));
            redBtn.click();
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            Assert.assertEquals("I am an alert box!", message);
            alert.dismiss();
            WebElement text = driver.findElement(By.id("textForAlerts"));
            Assert.assertTrue(text.getText().isEmpty());
        }
        @Test
        public void popUpConfirm()
        {
            WebElement greenBtn = driver.findElement(By.className("w3-teal"));
            greenBtn.click();
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            Assert.assertEquals("Press a button!", message);
            alert.accept();
            WebElement text = driver.findElement(By.id("textForAlerts"));
            Assert.assertEquals("Why on earth have you agreed to it?!", text.getText());
        }@Test
        public void popUpDenied()
        {
            WebElement greenBtn = driver.findElement(By.className("w3-teal"));
            greenBtn.click();
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            Assert.assertEquals("Press a button!", message);
            alert.dismiss();
            WebElement text = driver.findElement(By.id("textForAlerts"));
            Assert.assertEquals("You have dared to deny me!!!", text.getText());
        }
        @Test
        public void popUpEnterNumber()
        {
            WebElement yellowBtn = driver.findElement(By.className("w3-khaki"));
            yellowBtn.click();
            Alert alert = driver.switchTo().alert();
            String message = alert.getText();
            Assert.assertEquals("Please enter a number", message);
            alert.sendKeys("26");
            alert.accept();
            WebElement text = driver.findElement(By.id("textForAlerts"));
            Assert.assertTrue(text.getText().contains("instead of 26"));
        }

*/

        @After
        public void tearDown () throws Exception {
         Thread.sleep(1500);

            //Close browser
            driver.quit();
        }
    }
}