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

public class sample5 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
       /* WebElement toSummonAlertBtn = driver.findElement(By.className("w3-red"));
        toSummonAlertBtn.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        //alert.accept();
        alert.dismiss();*/
        WebElement clickToEnterBtn = driver.findElement(By.className("w3-khaki"));
        clickToEnterBtn.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("22");
        alert2.accept();
        WebElement confirmationText = driver.findElement(By.id("textForAlerts"));
        System.out.println(confirmationText.getText());
    }

    //1.alertOnOpeningPage:
    // open “Alerted page”,
    // catch alert,
    // check the text of alert,
    // accept alert,
    // check heading of the page
    @Test
    public void alertOnOpeningPage(){
        driver.get("https://kristinek.github.io/site/examples/alerted_page");
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Booooooooo!", message);
        alert.dismiss();
        WebElement text = driver.findElement(By.id("heading"));
        Assert.assertEquals("This page is alerted", text.getText());
    }
    //2.alertOnclickingButton:
    // open “Alert and pop-ups”,
    // click on element with className “w3-red”,
    // catch alert,
    // check its text,
    // accept it,
    // check text of element with id “textForAlerts”
    @Test
    public void alertOnClickingButton(){
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        WebElement redBtn = driver.findElement(By.className("w3-red"));
        redBtn.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("I am an alert box!", message);
        alert.dismiss();
        WebElement text = driver.findElement(By.id("textForAlerts"));
        Assert.assertTrue(text.getText().isEmpty());
    }
    // 3.popUpConform:
    // open “Alert and pop-ups”,
    // click on element with className “w3-teal”,
    // catch alert,
    // check its text,
    // accept it,
    // check text of element with id “textForAlerts”
    @Test
    public void popUpConfirm(){
        WebElement greenBtn = driver.findElement(By.className("w3-teal"));
        greenBtn.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Press a button!", message);
        alert.accept();
        WebElement text = driver.findElement(By.id("textForAlerts"));
        Assert.assertEquals("Why on earth have you agreed to it?!", text.getText());
    }
    //4.popUpDeny:
    // open “Alert and pop-ups”,
    // click on element with className “w3-teal”,
    // catch alert,
    // check its text,
    // deny it,
    // check text of element with id “textForAlerts”
    @Test
    public void popUpDeny(){
        WebElement greenBtn = driver.findElement(By.className("w3-teal"));
        greenBtn.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Press a button!", message);
        alert.dismiss();
        WebElement text = driver.findElement(By.id("textForAlerts"));
        Assert.assertEquals("You have dared to deny me!!!", text.getText());
    }
    //5.popUpEnterNumber:
    //open “Alert and pop-ups”,
    // click on element with className “w3-khaki”,
    // catch alert,
    // check its text,
    // send a number as a String via sendKeys and accept alert,
    // check text of element with id “textForAlerts”
    @Test
    public void popUpEnteredNumber(){
        WebElement yellowBtn = driver.findElement(By.className("w3-khaki"));
        yellowBtn.click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Please enter a number", message);
        alert.sendKeys("23");
        alert.accept();
        WebElement text = driver.findElement(By.id("textForAlerts"));
        Assert.assertTrue(text.getText().contains("instead of 23"));
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        //Close browser
        driver.quit();

    }
}
