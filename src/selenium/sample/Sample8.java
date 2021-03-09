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
        driver.get("https://kristinek.github.io/site/examples/actions");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @Test
    public void checkBoxOperation() throws Exception {
        WebElement checkBox1 = driver.findElement(By.cssSelector("input#vfb-6-0"));
        WebElement checkBox2 = driver.findElement(By.cssSelector("input#vfb-6-1"));
        WebElement checkBox3 = driver.findElement(By.cssSelector("input#vfb-6-2"));

        checkBox1.click();
        System.out.println(checkBox1.isSelected()); // true
        System.out.println("Before clicking on checkbox 2: "+ checkBox2.isSelected()); // false

        checkBox2.click();
        System.out.println("After click on checkbox 2: "+ checkBox2.isSelected()); // true

        checkBox2.click();
        System.out.println("After uncheck checkbox 2: "+ checkBox2.isSelected()); // false
    }

    @Test
    public void dropDownOperation() throws Exception {
        WebElement dropdown = driver.findElement(By.xpath("//select[@name='vbf-12']"));
        Select obj = new Select(dropdown);
        System.out.println(obj.getFirstSelectedOption().getText());

        //select by visible text
        obj.selectByVisibleText("Option 1");
        System.out.println(obj.getFirstSelectedOption().getText());
        //select by value
        obj.selectByValue("value2");
        System.out.println(obj.getFirstSelectedOption().getText()); //gives us whatever option is selected
        //select by index
        obj.selectByIndex(3); // because Choose your option has index 0
        System.out.println(obj.getFirstSelectedOption().getText());
        //to print all the options
        for(int i= 0; i <obj.getOptions().size(); i++){
            System.out.println(obj.getOptions().get(i).getText());
        }
        //Deselect by visible text if only first method runned
        obj.deselectByVisibleText("Option 1");
        System.out.println(obj.getFirstSelectedOption().getText());

    }

    @Test
    public void radioButton(){
        WebElement radioBtn1 = driver.findElement(By.cssSelector("input[value='Option1'][id='vfb-7-1']"));
        WebElement radioBtn2 = driver.findElement(By.cssSelector("input[value='Option2'][id='vfb-7-2']"));
        WebElement radioBtn3 = driver.findElement(By.cssSelector("input[value='Option3'][id='vfb-7-3']"));

        System.out.println("Before clicking on radioBtn1 " + radioBtn1.isSelected());
        radioBtn1.click();
        System.out.println("After clicking on radioBtn1 " + radioBtn1.isSelected());

        radioBtn2.click();
        System.out.println("After clicking on radioBtn2 " + radioBtn2.isSelected()); // true
        System.out.println("After clicking on radioBtn2, radioBtn1 is " + radioBtn1.isSelected()); // false
    }
    //selectCheckBox - create a “for” loop for element with selector “.w3-check[type='checkbox']”,
    // within loop check that checkbox is not selected, then click on it and check that it is selected, then click again
    //Then via getElements check that “option 3” is not selected, then click on it and check then element with css
    //“".w3-check[value='Option 3'][type='checkbox']“” is selected

//    @Test
//    public void firstTaskSelectCheckbox(){
//       List<WebElement> checkboxes = driver.findElement(By.cssSelector(".w3-check[type='checkbox']"));
//        for(WebElement element: checkboxes){
//            Assert.assertFalse(element.isSelected()); // false
//            element.click();
//            Assert.assertTrue(element.isSelected()); // true
//            element.click();
//            Assert.assertFalse(element.isSelected()); // false
//        }
//
//        WebElement checkbox3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
//        Assert.assertFalse(checkbox3.isSelected());// false
//        checkbox3.click();
//        Assert.assertTrue(checkbox3.isSelected());//true
//    }

    //selectRadioButton - create a “for” loop for element with selector “.w3-check[type=radio']”,
    // within loop check that checkbox is not selected, then click on it and check that it is selected, then click again
    //Then via getElements check that “option 3” is not selected, then click on it and check then element
    // with css “".w3-check[value='Option 3'][type=radio']“” is selected

//    @Test
//    public void secondTaskSelectRadioBtn(){
//        List<WebElement> radioButtons = driver.findElement(By.cssSelector(".w3-check[type='radio']"));
//        for(WebElement radioBtn: radioButtons){
//            Assert.assertFalse(radioBtn.isSelected()); // false
//            radioBtn.click();
//            Assert.assertTrue(radioBtn.isSelected()); // true
//        }
//
//        WebElement radioBtn2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio']"));
//        WebElement radioBtn3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio']"));
//        radioBtn2.click();
//        Assert.assertFalse(radioBtn3.isSelected());// false
//        radioBtn3.click();
//        Assert.assertTrue(radioBtn3.isSelected());//true
//        Assert.assertTrue(radioBtn2.isSelected());// false
//    }

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

    //selectOptionByText - check text of selected item of Select (with id “vfb-12”) via “getFirstSelectedOption()”,
    // select by text “Option 2”, check the selected item text is “Option 2”
    @Test
    public void selectOptionByText(){

        WebElement dropdown = driver.findElement(By.cssSelector("#vfb-12"));
        Select obj = new Select(dropdown);
        System.out.println(obj.getFirstSelectedOption().getText());
        //select by visible text
        obj.selectByVisibleText("Option 2");
        System.out.println(obj.getFirstSelectedOption().getText());

    }

    //selectOptionByIndex - check text of selected item of Select (with id “vfb-12”) via “getFirstSelectedOption()”,
    // select by index 1, check the selected item text is “Option 1”

    @Test
    public void selectOptionByIndex(){

        WebElement dropdown = driver.findElement(By.cssSelector("#vfb-12"));
        Select obj = new Select(dropdown);
        System.out.println(obj.getFirstSelectedOption().getText());
        //select by index
        obj.selectByIndex(1);
        System.out.println(obj.getFirstSelectedOption().getText());

    }

    //.selectOptionByValue - check text of selected item of Select (with id “vfb-12”) via “getFirstSelectedOption()”,
    // select by value “value3”, check the selected item text is “Option 3”

    @Test
    public void selectOptionByValue(){

        WebElement dropdown = driver.findElement(By.cssSelector("#vfb-12"));
        Select obj = new Select(dropdown);
        System.out.println(obj.getFirstSelectedOption().getText());
        //select by value
        obj.selectByValue("value3");
        System.out.println(obj.getFirstSelectedOption().getText());

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}
