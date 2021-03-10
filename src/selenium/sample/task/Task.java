package selenium.sample.task;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.sample.page.AgePage;
import selenium.sample.page.AgeSubmitPage;
import selenium.sample.task.page.FeedbackCheckPage;
import selenium.sample.task.page.FeedbackMainPage;

import java.util.concurrent.TimeUnit;

public class Task {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    static FeedbackMainPage feedbackPO;
    static FeedbackCheckPage feedbackCheckPO ;


    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        feedbackPO = PageFactory.initElements(driver,FeedbackMainPage.class);
        feedbackCheckPO = PageFactory.initElements(driver,FeedbackCheckPage.class);

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }

    @Test
    public void initialFeedbackPage() throws Exception {



//         check that all field are empty and no tick are clicked
        Assert.assertTrue(feedbackPO.getName().isEmpty());
        Assert.assertTrue(feedbackPO.getAge().isEmpty());

        Assert.assertFalse(feedbackPO.verifyIsSelected("English"));
        Assert.assertFalse(feedbackPO.verifyIsSelected("Spanish"));
        Assert.assertFalse(feedbackPO.verifyIsSelected("French"));
        Assert.assertFalse(feedbackPO.verifyIsSelected("Chinese"));


//         "Don't know" is selected in "Genre"
       Assert.assertTrue(feedbackPO.verifyRadioBtn(2));
//         "Choose your option" in "How do you like us?"
        feedbackPO.optionSelect(0);
        Assert.assertEquals("Choose your option",feedbackPO.getOptionSelect());
//         check that the button send is blue with white letters

        Assert.assertEquals("rgba(33, 150, 243, 1)",  feedbackPO.getSendBtnBgColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedbackPO.getSendBtnTextColor());
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
        feedbackPO.clickSubmit();
//         check fields are empty or null
        Assert.assertEquals("",feedbackCheckPO.getNameField());
        Assert.assertEquals("",feedbackCheckPO.getAgeField());
        Assert.assertEquals("null",feedbackCheckPO.getGenderField());
        Assert.assertEquals("",feedbackCheckPO.getLanguageField());
        Assert.assertEquals("null",feedbackCheckPO.getOptionField());
        Assert.assertEquals("",feedbackCheckPO.getCommentField());

//         check button colors
        //Yes button
        Assert.assertEquals("rgba(76, 175, 80, 1)",  feedbackCheckPO.getYesBtnCollor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedbackCheckPO.getYesBtnTextCollor());

        //No Button
        Assert.assertEquals("rgba(244, 67, 54, 1)",  feedbackCheckPO.getNoBtnCollor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedbackCheckPO.getNoBtnTextCollor());
//         (green with white letter and red with white letters)
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly
    }
}