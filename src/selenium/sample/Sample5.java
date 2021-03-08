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

public class Sample5 {

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
    public void clickOnButton(){
        WebElement showButton = driver.findElement(By.id("show_text"));
        showButton.click();
        WebElement textAppear = driver.findElement(By.id("show_me"));
        String text = textAppear.getText();
        Assert.assertEquals("I am here!", text);
        System.out.println("clicked on button");
    }
    @Test
    public void test1(){
        WebElement toSummonAlertBtn = driver.findElement(By.className("w3-red"));
        toSummonAlertBtn.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
//        alert.accept();
         alert.dismiss();

        WebElement clickToEnterBtn = driver.findElement(By.className("w3-khaki"));
        clickToEnterBtn.click();
        Alert alert2 = driver.switchTo().alert();
        alert2 = driver.switchTo().alert();
        alert2.sendKeys("22");
        alert2.accept();
        WebElement confirmationText = driver.findElement(By.id("textForAlerts"));
        clickToEnterBtn.click();
        alert2.dismiss();
        System.out.println(confirmationText.getText());

    }
    @Test
    public void test2(){
        WebElement toSummonAlertBtn = driver.findElement(By.className("w3-khaki"));
        toSummonAlertBtn.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
//        alert.accept();
        alert.dismiss();
    }
    @Test
    public void test1AlertOnOpeningPage() {
        //open test page
        driver.get("https://kristinek.github.io/site/examples/alerted_page");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals("Booooooooo!", message);
        System.out.println(alert.getText());
        alert.accept();

        WebElement checkHeading = driver.findElement(By.id("heading"));
        Assert.assertEquals("This page is alerted", checkHeading.getText());
    }

    @Test
    public void test2AlertOnClickingButton() {
        //open test page
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        WebElement toSummonAlertBtn = driver.findElement(By.className("w3-red"));
        toSummonAlertBtn.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
//        alert.dismiss();
        WebElement checkTxt = driver.findElement(By.id("textForAlerts"));
        String text = checkTxt.getText();
        Assert.assertEquals("", text);
     //   Assert.assertTrue(text.getText.isEmpty); //< another way to check for empty text
    }
    @Test
    public void test3popUpConfirm() {
        //open test page
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        WebElement greenBtn = driver.findElement(By.className("w3-teal"));
        greenBtn.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
//        alert.dismiss();
        WebElement checkTxt = driver.findElement(By.id("textForAlerts"));
        String text = checkTxt.getText();
        Assert.assertEquals("Why on earth have you agreed to it?!", text);
    }

    @Test
    public void test4popUpDeny() {
        //open test page
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        WebElement greenBtn2 = driver.findElement(By.className("w3-teal"));
        greenBtn2.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        WebElement checkTxt = driver.findElement(By.id("textForAlerts"));
        String text = checkTxt.getText();
        Assert.assertEquals("You have dared to deny me!!!", text);
    }
    @Test
    public void test5popUpEnterNum() {
        //open test page
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        WebElement khakiBtn = driver.findElement(By.className("w3-khaki"));
        khakiBtn.click();
        Alert alert = driver.switchTo().alert(); //check alert msg text
        System.out.println(alert.getText());
        String message = alert.getText();
        Assert.assertEquals("Please enter a number", message);

        Alert alert3 = driver.switchTo().alert();
        alert3 = driver.switchTo().alert();
        alert3.sendKeys("22");

        alert3.accept();
        WebElement checkTxt = driver.findElement(By.id("textForAlerts"));
        String text = checkTxt.getText();
        //Assert.assertEquals("Wrong! It is 0.5214690195316252 instead of 22", text); <<can not be applied, each time new number is generated
        System.out.println(checkTxt.getText());
    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500);

        //Close browser
        driver.quit();
    }
}
