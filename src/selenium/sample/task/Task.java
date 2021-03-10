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
        feedbackPO.enterName("Lisa");
        feedbackPO.enterAge("22");
        feedbackPO.clickCheckbox("English");
        feedbackPO.clickCheckbox("Spanish");
        feedbackPO.clickRadioBtn(0);
        feedbackPO.enterComment("Was a nice day");
        feedbackPO.optionSelect(1);
        feedbackPO.clickSubmit();
//         fill the whole form, click "Send"
//         check fields are filled correctly
        Assert.assertEquals("Lisa",feedbackCheckPO.getNameField());
        Assert.assertEquals("22",feedbackCheckPO.getAgeField());
        Assert.assertEquals("male",feedbackCheckPO.getGenderField());
        Assert.assertEquals("English,Spanish",feedbackCheckPO.getLanguageField());
        Assert.assertEquals("Good",feedbackCheckPO.getOptionField());
        Assert.assertEquals("Was a nice day",feedbackCheckPO.getCommentField());
//         check button colors
//         (green with white letter and red with white letters)
        //Yes button
        Assert.assertEquals("rgba(76, 175, 80, 1)",  feedbackCheckPO.getYesBtnCollor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedbackCheckPO.getYesBtnTextCollor());

        //No Button
        Assert.assertEquals("rgba(244, 67, 54, 1)",  feedbackCheckPO.getNoBtnCollor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedbackCheckPO.getNoBtnTextCollor());
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {

//         enter only name
        feedbackPO.enterName("Lisa");
//         click "Send"
        feedbackPO.clickSubmit();
//         click "Yes"
        feedbackCheckPO.clickYes();
//         check message text: "Thank you, NAME, for your feedback!"
        Assert.assertEquals("Thank you, Lisa, for your feedback!",feedbackCheckPO.getFinalMessage());

//         color of text is white with green on the background

        Assert.assertEquals("rgba(76, 175, 80, 1)",  feedbackCheckPO.getFinalTextBgColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedbackCheckPO.getFinalTextColor());
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//

//         click "Send" (without entering anything
        feedbackPO.clickSubmit();
//         click "Yes"
        feedbackCheckPO.clickYes();
//         check message text: "Thank you for your feedback!"
        Assert.assertEquals("Thank you for your feedback!",feedbackCheckPO.getFinalMessage());
//         color of text is white with green on the background
        Assert.assertEquals("rgba(76, 175, 80, 1)",  feedbackCheckPO.getFinalTextBgColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedbackCheckPO.getFinalTextColor());
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//
//         fill the whole form
        feedbackPO.enterName("Lisa");
        feedbackPO.enterAge("22");
        feedbackPO.clickCheckbox("English");
        feedbackPO.clickCheckbox("Spanish");
        feedbackPO.clickRadioBtn(0);
        feedbackPO.enterComment("Was a nice day");
        feedbackPO.optionSelect(1);
//         click "Send"
        feedbackPO.clickSubmit();
//         click "No"
        feedbackCheckPO.clickNo();
//         check fields are filled correctly
        Assert.assertEquals("Lisa",feedbackPO.getName());
        Assert.assertEquals("22",feedbackPO.getAge());
        Assert.assertTrue(feedbackPO.verifyRadioBtn(0));
        Assert.assertTrue(feedbackPO.verifyIsSelected("English"));
        Assert.assertTrue(feedbackPO.verifyIsSelected("Spanish"));
        Assert.assertEquals("Good",feedbackPO.getOptionSelect());
        Assert.assertEquals("Was a nice day",feedbackPO.getCommentText());

    }
}