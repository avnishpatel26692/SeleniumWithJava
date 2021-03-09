package selenium.sample.day2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Sample4 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();}

    @Test
    public void chooseDateViaCalendar(){
        Calendar cal= Calendar.getInstance();  //    get today date
        cal.add(Calendar.MONTH, -10);
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime());  // go back 10 month

        WebElement dateField = driver.findElement(By.cssSelector("input[class='w3-input w3-border hasDatepicker'][type='text']"));
        Assert.assertTrue(dateField.getAttribute("value").isEmpty());
        dateField.click();
        for (int i = 0; i<10; i++){
            WebElement prev = driver.findElement(By.xpath("//span[contains(text(),'Prev')]"));
            prev.click();

        }

        driver.findElement(By.xpath("//a[text()='15']")).click();



        Assert.assertEquals(result,dateField.getAttribute("value"));

    }

    @Test
    public void chooseDateViaTextBox(){
        WebElement dateField = driver.findElement(By.cssSelector("input[class='w3-input w3-border hasDatepicker'][type='text']"));
        Assert.assertTrue(dateField.getAttribute("value").isEmpty());

        dateField.clear();
        dateField.sendKeys("12/15/2014");
        Assert.assertEquals("12/15/2014",dateField.getAttribute("value"));

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
