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
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {

        Thread.sleep(5000);
        driver.quit();
    }
    //

    @Test
    public void checkBoxOperation(){
        WebElement checkBox1 = driver.findElement(By.cssSelector("input#vfb-6-0"));
        WebElement checkBox2 = driver.findElement(By.cssSelector("input#vfb-6-1"));
        WebElement checkBox3 = driver.findElement(By.cssSelector("input#vfb-6-2"));

        checkBox1.click();
        System.out.println(checkBox1.isSelected());
        System.out.println("Before clicking on checkbox 2: " + checkBox2.isSelected());

        checkBox2.click();
        System.out.println("After click on checkbox 2: " + checkBox2.isSelected());

        checkBox2.click();
        System.out.println("After uncheck checkbox 2: " + checkBox2.isSelected());
    }

    //selectCheckBox - create a “for” loop for element with selector “.w3-check[type='checkbox']”,
    // within loop check that checkbox is not selected, then click on it and check that it is selected, then click again
    //Then via getElements check that “option 3” is not selected, then click on it and
    // check then element with css “".w3-check[value='Option 3'][type='checkbox']“” is selected
    @Test
    public void selectCheckBox() {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        System.out.println("number of Elements: " + checkboxes.size());

        for (WebElement checkbox : checkboxes) {//use any name for elements, here - checkbox
            Assert.assertFalse(checkbox.isSelected());
            checkbox.click();
            Assert.assertTrue(checkbox.isSelected());
            checkbox.click();
        }
        WebElement checkbox3 = driver.findElement(By.cssSelector("input#vfb-6-2"));
        Assert.assertFalse(checkbox3.isSelected());
        checkbox3.click();
        Assert.assertTrue(checkbox3.isSelected());
    }

    //selectRadioButton - create a “for” loop for element with selector “.w3-check[type=radio']”,
    // within loop check that checkbox is not selected, then click on it and check that it is selected, then click again
    //Then via getElements check that “option 3” is not selected, then click on it
    // and check then element with css “".w3-check[value='Option 3'][type=radio']“” is selected
    @Test
    public void selectRadioButton() {
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type= 'radio']"));
        for (WebElement radio : radioButtons) {
            Assert.assertFalse(radio.isSelected());
            radio.click();
            Assert.assertTrue(radio.isSelected());
            radio.click();
        }
        WebElement radioButton2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio']"));
        Assert.assertFalse(radioButton2.isSelected());
        radioButton2.click();
        Assert.assertTrue(radioButton2.isSelected());
    }
    //chooseDateViaCalendar - copy-paste for results:
    //Calendar cal = Calendar.getInstance(); // get today date
    //cal.add(Calendar.MONTH, -10);
    //String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime()); // go back 10 month
    //Find element by id “vfb-8”, check its value, click on it
    //Find element by id “ui-datepicker-div”, create a for loop with clicking on item with className “ui-datepicker-prev”
    //Select date 15 via clicking on item with xpath “//a[text()='15']”, check value of “vfb-8” against results above

    @Test
    public void chooseDateViaCalendar() throws Exception {
        Calendar calendar = Calendar.getInstance();  //    get today date
        calendar.add(Calendar.MONTH, -10); // Select Month -10 (Current is March,2021 It will select May,2020)
        String result = new SimpleDateFormat("MM/15/yyyy").format(calendar.getTime());// 05/15/2020
        System.out.println("Expected Result" + result);

        WebElement calendarTextBox = driver.findElement(By.cssSelector("input#vfb-8"));
        Assert.assertEquals("", calendarTextBox.getAttribute("value"));
        calendarTextBox.click();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            WebElement previousMonthBtn = driver.findElement(By.xpath("//span[text()='Prev']"));//to avoid "stale" exception
            previousMonthBtn.click();
        }

        driver.findElement(By.xpath("//a[text()='15']")).click();
        System.out.println("Actual value : " + calendarTextBox.getAttribute("value"));
        Assert.assertEquals(result, calendarTextBox.getAttribute("value"));
    }
    //chooseDateViaTextBox - find element by id “vfb-8”, check its value, clear the element, send keys as string
    //"12/15/2014“, check value of element against previously sent string.
    @Test
    public void chooseDateViaTextBox(){
        WebElement element = driver.findElement(By.id("vfb-8"));
        System.out.println(element.getAttribute("value"));
        element.clear();
        element.sendKeys("12/15/2014");
        Assert.assertEquals("12/15/2014", element.getAttribute("value"));
    }

    //9.selectOptionByText - check text of selected item of Select (with id “vfb-12”) via “getFirstSelectedOption()”,
    // select by text “Option 2”, check the selected item text is “Option 2”
    @Test
    public void selectOptionByText(){
        Select element = new Select(driver.findElement(By.id("vfb-12")));
        // or WebElement dropdown = driver.findElement(By.id("vfb-12"));
        //Select element = new Select (dropdown);
        System.out.println(element.getFirstSelectedOption().getText());
        element.selectByVisibleText("Option 2");
        Assert.assertEquals("Option 2", element.getFirstSelectedOption().getText());

    }
    //10.selectOptionByIndex - check text of selected item of Select (with id “vfb-12”) via “getFirstSelectedOption()”,
    // select by index 1, check the selected item text is “Option 1”
    @Test
    public void selectOptionByIndex(){
        Select element = new Select(driver.findElement(By.id("vfb-12")));
        System.out.println(element.getFirstSelectedOption().getText());
        element.selectByIndex(1);
        Assert.assertEquals("Option 1", element.getFirstSelectedOption().getText());
    }
    //11.selectOptionByValue - check text of selected item of Select (with id “vfb-12”) via “getFirstSelectedOption()”,
    // select by value “value3”, check the selected item text is “Option 3”
    @Test
    public void selectOptionByValue() {
        Select element = new Select(driver.findElement(By.id("vfb-12")));
        System.out.println(element.getFirstSelectedOption().getText());
        element.selectByValue("value3");
        Assert.assertEquals("Option 3", element.getFirstSelectedOption().getText());
    }
}
