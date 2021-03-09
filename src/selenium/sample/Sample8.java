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

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/locators_different");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
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

    @Test
    public void dropDownOperations(){
        WebElement dropdown = driver.findElement(By.xpath("//select[@name='vfb-12']"));
        Select obj = new Select(dropdown);
        System.out.println(obj.getFirstSelectedOption().getText());

        //Select By visible Text
        obj.selectByVisibleText("Option 1");
        System.out.println(obj.getFirstSelectedOption().getText());
        Assert.assertEquals("Option 1", obj.getFirstSelectedOption().getText());

        //Select By Value
        obj.selectByValue("value2");
        System.out.println(obj.getFirstSelectedOption().getText());
        Assert.assertEquals("Option 2", obj.getFirstSelectedOption().getText());

        //Select By Index
        obj.selectByIndex(3);
        System.out.println(obj.getFirstSelectedOption().getText());
        Assert.assertEquals("Option 3", obj.getFirstSelectedOption().getText());

        //To Print All values of Dropdown
        for(int i = 0; i<obj.getOptions().size(); i++)
        {
            System.out.println(obj.getOptions().get(i).getText());
        }

        //Deselect by visible Text
        /*obj.deselectByVisibleText("Option 1");
        System.out.println(obj.getFirstSelectedOption().getText());*/
    }

    @Test
    public void radioButtonOperations()
    {
        WebElement radioBtn1 = driver.findElement(By.cssSelector("input[value='Option 1'][id='vfb-7-1']"));
        WebElement radioBtn2 = driver.findElement(By.cssSelector("input[value='Option 2'][id='vfb-7-2']"));
        WebElement radioBtn3 = driver.findElement(By.cssSelector("input[value='Option 3'][id='vfb-7-3']"));

        System.out.println("Before clicking on checkbox1 : " + radioBtn1.isSelected());
        radioBtn1.click();
        System.out.println("After clicking on checkbox1 : " + radioBtn1.isSelected());

        radioBtn2.click();
        System.out.println("After clicking on checkbox2 : " + radioBtn2.isSelected());
        System.out.println("After clicking on checkbox 2, checkbox1 is : " + radioBtn1.isSelected());

    }
    //4.selectCheckBox - create a “for” loop for element with selector “.w3-check[type='checkbox']”, within loop check that checkbox is not selected, then click on it and check that it is selected, then click again
    //Then via getElements check that “option 3” is not selected, then click on it and check then element with css “".w3-check[value='Option 3'][type='checkbox']“” is selected

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

    //5.selectRadioButton - create a “for” loop for element with selector “.w3-check[type=‘radio']”, within loop check that checkbox is not selected, then click on it and check that it is selected, then click again
    //Then via getElements check that “option 2” is not selected, then click on it and check then element with css “".w3-check[value='Option 2'][type=‘radio']“” is selected
    @Test
    public void selectRadioButton() {
        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
        for(WebElement radioBtn : radioButtons) {

            Assert.assertFalse(radioBtn.isSelected());
            radioBtn.click();
            Assert.assertTrue(radioBtn.isSelected());

        }

        WebElement radioBtn1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='radio']"));
        WebElement radioBtn2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio']"));
        Assert.assertFalse(radioBtn1.isSelected());
        radioBtn1.click();
        radioBtn2.click();
        Assert.assertFalse(radioBtn1.isSelected());
        Assert.assertTrue(radioBtn2.isSelected());

    }
    @Test
    public void chooseDateViaCalendar() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -10);
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime());
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
    //8.chooseDateViaTextBox;
    // find element by id “vfb-8”,
    // check its value,
    // clear the element,
    // send keys as string "12/15/2014“,
    // check value of element against previously sent string.
    @Test
    public void chooseDateViaTextBox(){
        WebElement element = driver.findElement(By.id("vfb-8"));
        System.out.println(element.getAttribute("value"));
        element.clear();
        element.sendKeys("12/15/2014");
        Assert.assertEquals("12/15/2014", element.getAttribute("value"));
    }
    //9.selectOptionByText:
    // check text of selected item of Select (with id “vfb-12”) via “getFirstSelectedOption()”,
    // select by text “Option 2”, check the selected item text is “Option 2”
    @Test
    public void selectOptionByText(){
        WebElement dDownI = driver.findElement(By.xpath("//select[@id='vfb-12']"));
        Select obj = new Select((dDownI));
        System.out.println(obj.getFirstSelectedOption().getText());
        obj.selectByVisibleText("Option 2");
        String option2 = obj.getFirstSelectedOption().getText();
        System.out.println(option2);
        Assert.assertEquals("Option 2",option2);
    }
    //10.selectOptionByIndex:
    // check text of selected item of Select (with id “vfb-12”) via “getFirstSelectedOption()”,
    // select by index 1,
    // check the selected item text is “Option 1”
    @Test
    public void selectOptionByIndex(){
        WebElement dDownI = driver.findElement(By.xpath("//select[@id='vfb-12']"));
        Select obj = new Select((dDownI));

        obj.selectByIndex(1);
        String option1 =obj.getFirstSelectedOption().getText();
        System.out.println(option1);
        Assert.assertEquals("Option 1",option1);

    }
    //11.selectOptionByValue:
    // check text of selected item of Select (with id “vfb-12”) via “getFirstSelectedOption()”,
    // select by value “value3”,
    // check the selected item text is “Option 3”
    @Test
    public void selectOptionByValue(){
        WebElement dDownI = driver.findElement(By.xpath("//select[@id='vfb-12']"));
        Select obj = new Select((dDownI));
        obj.selectByValue("value3");
        String option3 =obj.getFirstSelectedOption().getText();
        System.out.println(option3);
        Assert.assertEquals("Option 3",option3);
    }


    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        //Close browser
        driver.quit();
    }
}
