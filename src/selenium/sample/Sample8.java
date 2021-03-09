package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

        //open test homepage
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test

    public void checkBoxOperations() {
        WebElement checkbox1 = driver.findElement(By.cssSelector("input#vfb-6-0"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("input#vfb-6-1"));
        WebElement checkbox3 = driver.findElement(By.cssSelector("input#vfb-6-2"));

        checkbox1.click();
        System.out.println(checkbox1.isSelected());
        System.out.println("Before clicking on checkbox 2: " + checkbox2.isSelected());


        checkbox2.click();
        System.out.println("After click on checkbox 2: " + checkbox2.isSelected());

        checkbox2.click();
        System.out.println("After uncheck on checkbox 2: " + checkbox2.isSelected());


    }

    @Test
    public void dropDownOperations() {
        WebElement dropdown = driver.findElement(By.xpath("//select[@name='vfb-12']"));
        Select obj = new Select(dropdown);
        System.out.println(obj.getFirstSelectedOption().getText());

        //select by visible text
        obj.selectByVisibleText("Option 1");
        System.out.println(obj.getFirstSelectedOption().getText());

        //select by value
        obj.selectByValue("value2");
        System.out.println(obj.getFirstSelectedOption().getText());

        obj.selectByIndex(3);
        System.out.println(obj.getFirstSelectedOption().getText());
//        All options on dropdown
        for(int i=0; i<obj.getOptions().size(); i++) {
        System.out.println(obj.getOptions().get(1).getText()); }

//        obj.deselectByValue("Option 1");
//        System.out.println(obj.getFirstSelectedOption().getText());


    }

    @Test
    public void radioButtonOperations() {
        WebElement radio1 = driver.findElement(By.cssSelector("input[value='Option 1'][id='vfb-7-1']"));
        WebElement radio2 = driver.findElement(By.cssSelector("input[value='Option 2'][id='vfb-7-2']"));
        WebElement radio3 = driver.findElement(By.cssSelector("input[value='Option 3'][id='vfb-7-3']"));

        System.out.println("Before clicking on checkbox1 " + radio1.isSelected());
        radio1.click();
        System.out.println("After clicking on checkbox1 " + radio1.isSelected());

        radio2.click();
        System.out.println("After clicking on checkbox2 " + radio2.isSelected());
        System.out.println("After clicking on checkbox2, checkbox1 is " + radio1.isSelected());


    }

    @Test
    public void selectCheckBox() {

        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));


        for(WebElement element : checkboxes) {

            Assert.assertFalse(element.isSelected());
            element.click();
            Assert.assertTrue(element.isSelected());
            element.click();
            Assert.assertFalse(element.isSelected());
        }

        WebElement checkbox3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
        Assert.assertFalse(checkbox3.isSelected());
        checkbox3.click();
        Assert.assertTrue(checkbox3.isSelected());

    }

    @Test
    public void selectRadioButton() {
        List<WebElement> radio = driver.findElements(By.cssSelector(".w3-check[type='radio']"));


        for(WebElement rbtn : radio) {

            Assert.assertFalse(rbtn.isSelected());
            rbtn.click();
            Assert.assertTrue(rbtn.isSelected());

        }

        WebElement radio0 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='radio']"));
        WebElement radio9 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio']"));
        Assert.assertFalse(radio9.isSelected());
        radio9.click();
        Assert.assertFalse(radio0.isSelected());
        Assert.assertTrue(radio9.isSelected());

    }

    @Test
    public void chooseDateViaCalendar() throws Exception {

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
        Assert.assertEquals(result, calendarTextbox.isSelected());


    }


    @Test
    public void selectOptionByText() {

        WebElement chooseByText = driver.findElement(By.cssSelector("select#vfb-12"));
        Select selector = new Select(chooseByText);
        System.out.println(selector.getFirstSelectedOption().getText());
        selector.selectByVisibleText("Option 2");
        System.out.println(selector.getFirstSelectedOption().getText());

    }
    @Test
    public void selectOptionByIndex() {


        Select selector = new Select(driver.findElement(By.cssSelector("select#vfb-12")));
        selector.selectByIndex(1);
        System.out.println(selector.getFirstSelectedOption().getText());


    }

    @Test
    public void selectOptionByValue() {

        WebElement chooseByIndex = driver.findElement(By.cssSelector("select#vfb-12"));
        Select selector = new Select(chooseByIndex);
        selector.selectByValue("value3");
        System.out.println(selector.getFirstSelectedOption().getText());

    }



    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
