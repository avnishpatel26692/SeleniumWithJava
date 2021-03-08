package selenium.sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sample3 {


        static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        WebDriver driver;

        @Before
        public void initBrowser() {
            System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
            driver = new ChromeDriver();

            //open test homepage
            driver.get("https://kristinek.github.io/site/examples/locators");
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        @Test
        public void assertEqualsExample() throws Exception {
            WebElement heading1 = driver.findElement(By.id("heading_1"));
            String actualValue = heading1.getText();
            String expectedValue = "Heading 1";
            Assert.assertEquals("this should be failed", expectedValue, actualValue);
        }
        @Test //the same test with other variable names
         public void assertEquals(){
        String ev = "Heading 1";
        WebElement h1= driver.findElement(By.id("heading_1"));
        String av = h1.getText();
        Assert.assertEquals(ev,av);
    }

        @Test
        public void assertTrueExample(){
            String expectedValue = "This is a button";
            WebElement btn = driver.findElement(By.name("randomButton1"));
            String actualValue = btn.getAttribute("value");
//            Assert.assertTrue(actualValue.equalsIgnoreCase(expectedValue));
            Assert.assertTrue(actualValue.contains(expectedValue)); //1st string contains the 2nd string
//            System.out.println("Test2");
        }
//
        @Test
        public void assertFalseExample(){
          String expectedValue = "This is a button";
            WebElement btn = driver.findElement(By.name("randomButton1"));
            String actualValue = btn.getAttribute("value");
            Assert.assertFalse(actualValue.contains(expectedValue)); //1st string contains the 2nd string

        }
        @Test
        public void fail(){
            //write any logic or conditions, if not satisfied u can fail the test. this type of tests we try to avoid (used rarely)
            // better use more certain type of fail tests. this one to be used on my own logic, I compare myself.
            Assert.fail("I want to fails this");
        }

        @After
        public void tearDown() throws Exception {
            Thread.sleep(1000);

            //Close browser
            driver.quit();
        }
    }
