package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample8 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();

        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }

    @Test
    public void selectCheckBox() {

        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));

        for (WebElement element : checkboxes) {
            Assert.assertFalse(element.isSelected());
            element.click();
            Assert.assertTrue(element.isSelected());
            element.click();
            Assert.assertFalse(element.isSelected());
        }

        WebElement checkBox3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3']"));
        Assert.assertFalse(checkBox3.isSelected());
        checkBox3.click();
        Assert.assertTrue(checkBox3.isSelected());

    }



    @Test
    public void selectRadioButtons() {

        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));

        for (WebElement radioBtn : radioButtons) {
            Assert.assertFalse(radioBtn.isSelected());
            radioBtn.click();
            Assert.assertTrue(radioBtn.isSelected());
        }

        WebElement radioBtn3 = driver.findElement(By.cssSelector("input[value='Option 3'][id='vfb-7-3']"));

        System.out.println("Before clicking on checkbox3 : " + radioBtn3.isSelected());
        radioBtn3.click();
        System.out.println("After clicking on checkbox1 : " + radioBtn3.isSelected());
        Assert.assertTrue(radioBtn3.isSelected());

    }

    @Test
    public void chooseDateViaCalendar() throws Exception
    {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -10);
        String result = new SimpleDateFormat ("MM/15/yyyy").format(cal.getTime());
        System.out.println("Expected Result is:" +result);

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

    @Test
    public void chooseDateViaTextBox ()
    {
        Calendar cal = Calendar.getInstance();
        String result = new SimpleDateFormat ("MM/dd/yyyy").format(cal.getTime());
        System.out.println("Today is: " +result);

        WebElement calendarTextbox = driver.findElement(By.cssSelector("input#vfb-8"));
        calendarTextbox.clear();

        Assert.assertEquals("",calendarTextbox.getAttribute("value"));
        calendarTextbox.sendKeys("12/15/2014");
        String result1 = calendarTextbox.getAttribute("value");
        System.out.println("Your entered date is: " +result1);

        Assert.assertFalse("Your entered date is: 12/15/2014", Boolean.parseBoolean(result1));

    }

    @Test
    public void selectOptionByText(){

        WebElement dropdown = driver.findElement(By.xpath("//select[@name='vfb-12']"));
        Select obj = new Select(dropdown);
        System.out.println(obj.getFirstSelectedOption().getText());

        obj.selectByVisibleText("Option 2");
        System.out.println(obj.getFirstSelectedOption().getText());
        Assert.assertEquals("Option 2", obj.getFirstSelectedOption().getText());
    }

    @Test
    public void selectOptionByIndex(){

        WebElement dropdown = driver.findElement(By.cssSelector("select[name='vfb-12']"));
        Select obj = new Select(dropdown);
        System.out.println(obj.getFirstSelectedOption().getText());

        obj.selectByIndex(1);
        System.out.println(obj.getFirstSelectedOption().getText());
        Assert.assertEquals("Option 1", obj.getFirstSelectedOption().getText());

    }

    @Test
    public void selectOptionByValue(){

        WebElement dropdown = driver.findElement(By.cssSelector("select[name='vfb-12']"));
        Select obj = new Select(dropdown);
        System.out.println(obj.getFirstSelectedOption().getText());

        obj.selectByValue("value3");
        System.out.println(obj.getFirstSelectedOption().getText());
        Assert.assertEquals("Option 3", obj.getFirstSelectedOption().getText());

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
