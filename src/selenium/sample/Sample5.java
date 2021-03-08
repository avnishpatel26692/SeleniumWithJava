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

public class Sample5{

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void alerts(){
        WebElement toSummonBtn = driver.findElement(By.className("w3-red"));
        toSummonBtn.click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        WebElement clickToEnterBtn = driver.findElement(By.className("w3-khaki"));
        clickToEnterBtn.click();
        alert = driver.switchTo().alert();
        alert.sendKeys("15");
        alert.accept();

    }

    @Test
    public void alertOnOpening(){


    Alert alert = driver.switchTo().alert();
    System.out.println("alert text:"+alert.getText());

    alert.accept();
    String al = driver.getTitle();
    System.out.println("Title is "+al);
    }

    @Test
    public void alertOnClickingButton(){

        WebElement toSummonBtn = driver.findElement(By.className("w3-red"));
        toSummonBtn.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("=======1======"+alert.getText());

        alert.accept();
        String text=driver.findElement(By.id("textForAlerts")).getText();
        System.out.println("=======2======"+text);
        Assert.assertEquals("",text);
    }

    @Test
    public void popUpConfirm(){

        WebElement toSummonBtn = driver.findElement(By.className("w3-teal"));
        toSummonBtn.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("=======1======"+alert.getText());

        alert.accept();
        String text=driver.findElement(By.id("textForAlerts")).getText();
        System.out.println("=======2======"+text);
        Assert.assertEquals("Why on earth have you agreed to it?!",text);
    }

    @Test
    public void popUpDeny(){

        WebElement toSummonBtn = driver.findElement(By.className("w3-teal"));
        toSummonBtn.click();
        Alert alert = driver.switchTo().alert();
        System.out.println("=======1======"+alert.getText());

        alert.dismiss();
        String text=driver.findElement(By.id("textForAlerts")).getText();
        System.out.println("=======2======"+text);
        Assert.assertEquals("You have dared to deny me!!!",text);
    }
    @Test
    public void popUpEnterNumber(){

        WebElement toSummonBtn = driver.findElement(By.className("w3-khaki"));
        toSummonBtn.click();
        Alert alert = driver.switchTo().alert();
        String aText=alert.getText();
        Assert.assertEquals("Please enter a number",aText);
        String num = "15";
        alert.sendKeys(num);
        alert.accept();
        String text=driver.findElement(By.id("textForAlerts")).getText();
        Assert.assertEquals("Wrong! It is 0.24465674711334606 instead of "+num,text);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}