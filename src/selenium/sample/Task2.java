package selenium.sample;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.sample.page.AgePage;

import java.util.concurrent.TimeUnit;

public class Task2 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static FeedbackPage fbPO;
    static FeedbackResultPage fbResPO;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        fbPO = PageFactory.initElements(driver, FeedbackPage.class);
        fbResPO = PageFactory.initElements(driver, FeedbackResultPage.class);
        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }



    @Test
    public void initialFeedbackPage() throws Exception {
              Assert.assertEquals("", fbPO.getName());
              Assert.assertFalse("", fbPO.verifyMaleIsSelected());
              Assert.assertFalse("", fbPO.verifyFemaleIsSelected());
              Assert.assertEquals("Choose your option", fbPO.getSelectedDropDown());
              Assert.assertEquals("rgba(33, 150, 243, 1)", fbPO.getSubmitBtnBckgrColor());
              Assert.assertEquals("rgba(255, 255, 255, 1)", fbPO.getSubmitBtnLetterColor());
//         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters
    }

    @Test
    public void emptyFeedbackPage() throws Exception {

//         TODO:
//         click "Send" without entering any data
        fbPO.clickSubmitBtn();
       //         check fields are empty or null
        Assert.assertEquals("Your name:",fbResPO.getFormFields(0));
        Assert.assertEquals("Your age:",fbResPO.getFormFields(1));
        Assert.assertEquals("Your language:",fbResPO.getFormFields(2));
        Assert.assertEquals("Your genre: null",fbResPO.getFormFields(3));
        Assert.assertEquals("Your option of us: null",fbResPO.getFormFields(4));
        Assert.assertEquals("Your comment:",fbResPO.getFormFields(5));
        //         check button colors
        Assert.assertEquals("rgba(76, 175, 80, 1)", fbResPO.getYesBtnBckgrColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", fbResPO.getYesBtnLetterColor());

        Assert.assertEquals("rgba(244, 67, 54, 1)", fbResPO.getNoBtnBckgrColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", fbResPO.getNoBtnLetterColor());
//         (green with white letter and red with white letters)
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
        fbPO.enterName("Vasja");
        fbPO.enterAge("29");
        fbPO.selectCheckBox(2);
        fbPO.selectCheckBox(0);
        fbPO.clickMale();
        fbPO.selectDropDown(2);
        fbPO.addComment("I fell good");
        fbPO.clickSubmitBtn();

//         fill the whole form, click "Send"
        Assert.assertEquals("Your name: Vasja",fbResPO.getFormFields(0));
        Assert.assertEquals("Your age: 29",fbResPO.getFormFields(1));
        Assert.assertEquals("Your language: English,Spanish",fbResPO.getFormFields(2));
        Assert.assertEquals("Your genre: male",fbResPO.getFormFields(3));
        Assert.assertEquals("Your option of us: Ok, i guess",fbResPO.getFormFields(4));
        Assert.assertEquals("Your comment: I fell good",fbResPO.getFormFields(5));
//         check fields are filled correctly
        Assert.assertEquals("rgba(76, 175, 80, 1)", fbResPO.getYesBtnBckgrColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", fbResPO.getYesBtnLetterColor());

        Assert.assertEquals("rgba(244, 67, 54, 1)", fbResPO.getNoBtnBckgrColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", fbResPO.getNoBtnLetterColor());
//         check button colors
//         (green with white letter and red with white letters)
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
        fbPO.enterName("Vasja");
//         click "Send"
        fbPO.clickSubmitBtn();
//         click "Yes"
        fbResPO.clickYesBtn();
//         check message text: "Thank you, NAME, for your feedback!"
        Assert.assertEquals("Thank you, Vasja, for your feedback!", driver.findElement(By.id("message")).getText());
//         color of text is white with green on the background
        Assert.assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.id("message")).getCssValue("color"));
        Assert.assertEquals("rgba(76, 175, 80, 1)", driver.findElement(By.cssSelector("div.w3-panel")).getCssValue("background-color"));
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
        fbPO.clickSubmitBtn();
//         click "Yes"
        fbResPO.clickYesBtn();
//         check message text: "Thank you for your feedback!"
        Assert.assertEquals("Thank you for your feedback!", driver.findElement(By.id("message")).getText());
//         color of text is white with green on the background
        Assert.assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.id("message")).getCssValue("color"));
        Assert.assertEquals("rgba(76, 175, 80, 1)", driver.findElement(By.cssSelector("div.w3-panel")).getCssValue("background-color"));
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
        fbPO.enterName("Marusja");
        fbPO.enterAge("92");
        fbPO.selectCheckBox(0);
        fbPO.selectCheckBox(3);
        fbPO.clickFemale();
        fbPO.selectDropDown(2);
        fbPO.addComment("I fell good");

//         click "Send"
        fbPO.clickSubmitBtn();
//         click "No"
        fbResPO.clickNoBtn();
//         check fields are filled correctly
        Assert.assertEquals("Marusja", fbPO.getName());
        Assert.assertEquals("92", fbPO.getAge());
        Assert.assertEquals("Ok, i guess", fbPO.getSelectedDropDown());
        Assert.assertTrue(fbPO.verifyFemaleIsSelected());
        Assert.assertTrue(fbPO.verifyCheckBoxIsSelected(0));
        Assert.assertTrue(fbPO.verifyCheckBoxIsSelected(3));
        Assert.assertEquals("I fell good", fbPO.getComment());



    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}
