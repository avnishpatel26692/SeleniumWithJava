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

public class Sample5 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver88.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void alertOnOpeningPage () {
        driver.get("https://kristinek.github.io/site/examples/alerted_page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Alert alertOnOpen = driver.switchTo().alert();
        String getText = alertOnOpen.getText();
        alertOnOpen.dismiss();
        Assert.assertEquals("Booooooooo!",getText);

        WebElement getHeading = driver.findElement(By.id("heading"));
        String heading1 = getHeading.getText();
        Assert.assertEquals("This page is alerted",heading1);
    }

    @Test
    public void alertOnclickingButton () {
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement getElem = driver.findElement(By.className("w3-red"));
        getElem.click();
        Alert alertOnOpen = driver.switchTo().alert();
        String getText = alertOnOpen.getText();
        System.out.println(getText);
        alertOnOpen.accept();
        Assert.assertEquals("I am an alert box!",getText);
    }

    @Test
    public void popUpConfirmation () {
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement getElem = driver.findElement(By.className("w3-teal"));
        getElem.click();
        Alert alertOnOpen = driver.switchTo().alert();
        String getText = alertOnOpen.getText();
        System.out.println(getText);
        alertOnOpen.accept();
        Assert.assertEquals("Press a button!",getText);

        WebElement getElem2 = driver.findElement(By.id("textForAlerts"));
        String textAfter = getElem2.getText();
        Assert.assertEquals("Why on earth have you agreed to it?!",textAfter);
    }

    @Test
    public void popUpDeny () {
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement getElem = driver.findElement(By.className("w3-teal"));
        getElem.click();
        Alert alertOnOpen = driver.switchTo().alert();
        String getText = alertOnOpen.getText();
        System.out.println(getText);
        alertOnOpen.dismiss();

        WebElement getElem2 = driver.findElement(By.id("textForAlerts"));
        String textAfter = getElem2.getText();
        Assert.assertEquals("You have dared to deny me!!!",textAfter);
    }

    @Test
    public void popUpEnterNumber () {
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement getElem = driver.findElement(By.className("w3-khaki"));
        getElem.click();

        Alert alertOnOpen = driver.switchTo().alert();
        alertOnOpen.sendKeys("111");
        alertOnOpen.accept();

        WebElement getElem2 = driver.findElement(By.id("textForAlerts"));
        String textAfter = getElem2.getText();
        Assert.assertTrue(textAfter.contains("111"));


    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }

}
