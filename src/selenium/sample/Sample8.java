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
//TOPIC: verification of Styles

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
    public void checkBox(){
    WebElement checkBox1 = driver.findElement(By.cssSelector("input#vfb-6-0"));
            WebElement checkBox2 = driver.findElement(By.cssSelector("input#vfb-6-1"));
            WebElement checkBox3 = driver.findElement(By.cssSelector("input#vfb-6-2"));
            List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
            for(WebElement element : checkBoxes)
            {
                                Assert.assertFalse((element.isSelected()));
                element.click();
                Assert.assertTrue((element.isSelected()));
            }

            WebElement cb = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
            cb.click(); // unclick checkbox 3
            Assert.assertFalse((cb.isSelected()));
            cb.click();
            Assert.assertTrue((cb.isSelected()));

//            checkBox.isSelected();
//            System.out.println("Status before clicking " +checkBox.isSelected()); //false expected
//            checkBox.click();
//            System.out.println(checkBox.isSelected()); //true expected

//            checkBox1.click();
//            System.out.println(checkBox1.isSelected());
//            System.out.println(checkBox2.isSelected());
    }

    @Test
    public void dropDownOperations(){
        WebElement dropDown = driver.findElement(By.xpath("//select[@name='vfb-12']"));
        Select obj = new Select(dropDown);
        System.out.println(obj.getFirstSelectedOption().getText());
// select by visible text
        obj.selectByVisibleText("Option 1");
        System.out.println(obj.getFirstSelectedOption().getText());
// select by value
        obj.selectByValue("value2");
        System.out.println(obj.getFirstSelectedOption().getText());
// select by index
        obj.selectByIndex(3);
        System.out.println(obj.getFirstSelectedOption().getText());
//        //deselect by visible text value
//        obj.deselectByVisibleText("Option1 ");


        //deselect all options:

        //to print all the options values:
                for(int i=0; i<obj.getOptions().size(); i++)
        {
            System.out.println(obj.getOptions().get(i).getText());
        }
    }
@Test
    public void radio (){
        WebElement radioBtn1 = driver.findElement(By.cssSelector("input[value='Option 1'][id='vfb-7-1']"));
    WebElement radioBtn2 = driver.findElement(By.cssSelector("input[value='Option 1'][id='vfb-7-2']"));
    WebElement radioBtn3 = driver.findElement(By.cssSelector("input[value='Option 1'][id='vfb-7-3']"));

    System.out.println("before clicking on checkbox1: "+radioBtn1.isSelected()); //expect false
    radioBtn1.click();
    System.out.println("After clicking on checkbox1: "+radioBtn1.isSelected()); //expect true

    radioBtn2.click();
    System.out.println("After clicking on checkbox2: "+radioBtn1.isSelected());//expect false
    System.out.println("After clicking on checkbox2, checkbox 1 is : "+radioBtn1.isSelected()); //expect true
}
    @Test
    public void selectRadioButton (){
       List<WebElement> rdbuttons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
        for (WebElement btns : rdbuttons){
            Assert.assertFalse(btns.isSelected());
            btns.click();
            Assert.assertTrue(btns.isSelected());
        }
        WebElement radioBtn1 = driver.findElement(By.cssSelector("input[value='Option 1'][id='vfb-7-1']"));
        WebElement radioBtn2 = driver.findElement(By.cssSelector("[id='vfb-7-2']"));
        Assert.assertFalse(radioBtn2.isSelected());
        radioBtn2.click();
        Assert.assertFalse(radioBtn1.isSelected());
        Assert.assertTrue(radioBtn2.isSelected());
    }
    @Test
    public void chooseDateViaCalendar() throws Exception{
        Calendar cal = Calendar.getInstance(); // get today date
        cal.add(Calendar.MONTH, -10); //will select month current-10 months (current = march, will select May 2020)
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime()); // go back 10 month 05/15/2020
        System.out.println("expected  value is : " +result);

        WebElement dateBox = driver.findElement(By.cssSelector("[id='vfb-8']"));
        Assert.assertEquals("", dateBox.getAttribute("value"));
        dateBox.click();

        for(int i=0; i<10; i++){
            Thread.sleep(800);
            WebElement prevMonthBtn = driver.findElement(By.xpath("//span[text()='Prev']"));
            prevMonthBtn.click();
        }
       driver.findElement(By.xpath("//a[text()='15']")).click();
        System.out.println("Actual value is : " +dateBox.getAttribute("value"));
        Assert.assertEquals(result, dateBox.getAttribute("value"));
    }
    @Test
    public void chooseDateViaTextBox(){
        WebElement dBox = driver.findElement(By.cssSelector("[id='vfb-8']"));
        Assert.assertEquals("", dBox.getAttribute("value"));
        dBox.clear();
        dBox.sendKeys("12/15/2014");
        Assert.assertEquals("12/15/2014", dBox.getAttribute("value"));
    }
    @Test
    public void selectOptionByText(){
        WebElement selectBox = driver.findElement(By.cssSelector("[id='vfb-12']"));
        System.out.println(selectBox.getText());
        Select obj = new Select(selectBox);
        System.out.println("first selection: " +obj.getFirstSelectedOption().getText());

        obj.selectByVisibleText("Option 2");
        Assert.assertEquals("Option 2", obj.getFirstSelectedOption().getText());
    }
    @Test
    public void selectOptionByIndex(){
        WebElement selectBox = driver.findElement(By.cssSelector("[id='vfb-12']"));
       // System.out.println(selectBox.getText());

        Select obj = new Select(selectBox);
        System.out.println("first selection: " +obj.getFirstSelectedOption().getText());

        obj.selectByIndex(1);
        Assert.assertEquals("Option 1", obj.getFirstSelectedOption().getText());
    }
    @Test
    public void selectOptionByValue(){
        WebElement selectBox = driver.findElement(By.cssSelector("[id='vfb-12']"));
      //  System.out.println(selectBox.getText());

        Select obj = new Select(selectBox);
       System.out.println("first selection: " +obj.getFirstSelectedOption().getText());

        obj.selectByValue("value3");
        System.out.println("value3 is for: " +obj.getFirstSelectedOption().getText());
        Assert.assertEquals("Option 3", obj.getFirstSelectedOption().getText());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500);

        //Close browser
        driver.quit();
    }
}
