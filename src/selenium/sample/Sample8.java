package selenium.sample;

import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sample8{

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
    public void checkBoxOperation(){
        WebElement cBox1 = driver.findElement(By.cssSelector("input#vfb-6-0"));
        WebElement cBox2 = driver.findElement(By.cssSelector("input#vfb-6-1"));
        WebElement cBox3 = driver.findElement(By.cssSelector("input#vfb-6-2"));

        cBox1.click();
        System.out.println(cBox1.isSelected());
        System.out.println("Before is "+cBox2.isSelected());
        cBox2.click();
        System.out.println("After check is "+cBox2.isSelected());
        cBox2.click();
        System.out.println("After uncheck "+cBox2.isSelected());

    }

    @Test
    public void dropDownOperations(){
    WebElement dDown= driver.findElement(By.xpath("//select[@id='vfb-12']"));
    Select obj = new Select((dDown));
    System.out.println(obj.getFirstSelectedOption().getText());

    obj.selectByVisibleText("Option 1");
    System.out.println(obj.getFirstSelectedOption().getText());

    obj.deselectByValue("value2");
    System.out.println(obj.getFirstSelectedOption().getText());

    obj.selectByIndex(3);
    System.out.println(obj.getFirstSelectedOption().getText());

    for(int i=0; i<obj.getOptions().size(); i++){
        System.out.println(obj.getOptions().get(i).getText());
    }

    obj.deselectByVisibleText("Option 1");
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

    @Test
    public void selectCheckBox(){
        List<WebElement> list= driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for(WebElement cBox:list){
            System.out.println(cBox.isSelected());
            cBox.click();
            System.out.println(cBox.isSelected());
            cBox.click();
            System.out.println(cBox.isSelected());
        }
        //WebElement cBox3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
        WebElement cBox3 = list.get(2);

        Assert.assertFalse(cBox3.isSelected());
        cBox3.click();
        Assert.assertTrue(cBox3.isSelected());
    }

    @Test
    public void selectRadioButton(){
        List<WebElement> list= driver.findElements(By.cssSelector(".w3-check[type='radio']"));
        for(WebElement radio:list){
            System.out.println(radio.isSelected());
            radio.click();
            System.out.println(radio.isSelected());
            radio.click();
            System.out.println(radio.isSelected());
        }
        //WebElement cBox3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));
        WebElement radio3 = list.get(2);

        Assert.assertTrue(radio3.isSelected());
        radio3.click();
        Assert.assertTrue(radio3.isSelected());
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

    @Test
    public void selectOptionByText(){
        WebElement dDown= driver.findElement(By.xpath("//select[@id='vfb-12']"));
        Select obj = new Select((dDown));
        System.out.println(obj.getFirstSelectedOption().getText());
        obj.selectByVisibleText("Option 2");
        String opt2 = obj.getFirstSelectedOption().getText();
        System.out.println(opt2);
        Assert.assertEquals("Option 2",opt2);
    }

    @Test
    public void selectOptionByIndex(){
        WebElement dDown= driver.findElement(By.xpath("//select[@id='vfb-12']"));
        Select obj = new Select((dDown));

        obj.selectByIndex(1);
        String opt1 =obj.getFirstSelectedOption().getText();
        System.out.println(opt1);
        Assert.assertEquals("Option 1",opt1);

    }

    @Test
    public void selectOptionByValue(){
        WebElement dDown= driver.findElement(By.xpath("//select[@id='vfb-12']"));
        Select obj = new Select((dDown));
        obj.selectByValue("value3");
        String opt3 =obj.getFirstSelectedOption().getText();
        System.out.println(opt3);
        Assert.assertEquals("Option 3",opt3);
    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

        //Close browser
        driver.quit();
    }
}