package selenium.sample;


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
import java.util.List;

public class ExampleCSS {
    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";

    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        WebDriver driver = new ChromeDriver();

        //open test homepage
//        driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/examples/locators");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void selectCheckBox() {




    }

    @Test
    public void selectRadioButton() {
        List <WebElement> loop = driver.findElements(By.cssSelector(".w3-check[type=radio']"));
        for (WebElement element : loop)
        {
            Assert.assertFalse(element.isSelected());
            element.click();
            Assert.assertTrue(element.isSelected());

        }
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type=radio']"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type=radio']"));
        Assert.assertFalse(option3.isSelected());
        option2.click();
        option3.click();
        Assert.assertFalse((option2.isSelected()));
        Assert.assertTrue(option3.isSelected());


    }

    @Test
    public void chooseDateViaCalendar() throws Exception
    {
        Calendar cal = Calendar.getInstance();  //    get today date
        cal.add(Calendar.MONTH, -10); // Select Month -10 (Current is March,2021 It will select May,2020)
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime());// 05/15/2020
        System.out.println("Expected Result" +result);

        WebElement calendarTextbox = driver.findElement(By.cssSelector("input#vfb-8"));
        Assert.assertEquals("",calendarTextbox.getAttribute("value"));
        calendarTextbox.click();


        for(int i=0; i<10; i++)
        {
            Thread.sleep(500);
            WebElement previousMonthBtn = driver.findElement(By.xpath("//span[text()='Prev']"));
            previousMonthBtn.click();
        }

        driver.findElement(By.xpath("//a[text()='15']")).click();
        System.out.println("Actual value : " + calendarTextbox.getAttribute("value"));
        Assert.assertEquals(result, calendarTextbox.getAttribute("value"));
    }


    }

    @Test
    public void CSS() {

    }

    @Test
    public void CSS2() {

    }
        @After
        public void tearDown () throws Exception {
            Thread.sleep(3000);

            //Close browser
            driver.quit();
        }
    }
