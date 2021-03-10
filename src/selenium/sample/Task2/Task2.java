package selenium.page;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Task2 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    static WebDriver driver;
    static selenium.page.ProvideFeedback feedPO;
    static selenium.page.CheckFeedback checkPO;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        feedPO = PageFactory.initElements(driver, selenium.page.ProvideFeedback.class);
        checkPO = PageFactory.initElements(driver, selenium.page.CheckFeedback.class);
        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @Test
    public void initialFeedbackPage() throws Exception {
        //check that all field are empty and no tick are clicked
        Assert.assertEquals("", feedPO.getName());
        Assert.assertEquals("", feedPO.getAge());

        //checking checkboxes are not selected
        Assert.assertFalse(feedPO.verifyCheckBoxIsSelected(0));
        Assert.assertFalse(feedPO.verifyCheckBoxIsSelected(1));
        Assert.assertFalse(feedPO.verifyCheckBoxIsSelected(2));
        Assert.assertFalse(feedPO.verifyCheckBoxIsSelected(3));

        //checking radioButtons are not selected
        Assert.assertFalse(feedPO.verifyRadioButtonIsSelected(0));
        Assert.assertFalse(feedPO.verifyRadioButtonIsSelected(1));

        //checking don't know radioButton is selected as gender
        Assert.assertTrue(feedPO.verifyRadioButtonIsSelected(2));

        //Choose your option is selected in "How do you like us?"
        Assert.assertEquals("Choose your option", feedPO.getSelectedOption());

        //Check button is Blue in color with White Text
        Assert.assertEquals("rgba(33, 150, 243, 1)", feedPO.getSendButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedPO.getSendButtonTextColor());
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         click "Send" without entering any data
        feedPO.clickOnSendBtn();
//         check fields are empty or null
        Assert.assertEquals("", checkPO.getSpanName());
        Assert.assertEquals("", checkPO.getSpanAge());
        Assert.assertEquals("", checkPO.getSpanLanguage());
        Assert.assertEquals("null", checkPO.getSpanGender());
        Assert.assertEquals("null", checkPO.getSpanOption());
        Assert.assertEquals("", checkPO.getSpanComment());
//         check button colors
//         (green with white letter and red with white letters)
        Assert.assertEquals("rgba(76, 175, 80, 1)", checkPO.getYesButtonBackGroundColor());
        Assert.assertEquals("rgba(244, 67, 54, 1)", checkPO.getNoButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", checkPO.getYesButtonTextColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", checkPO.getNoButtonTextColor());
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         fill the whole form, click "Send"
        feedPO.enterName(new String("Vasya"));
        feedPO.enterAge(new String("33"));
        feedPO.selectCheckBox(0);
        feedPO.selectCheckBox(1);
        feedPO.selectRadioBtn(0);
        feedPO.selectValueFromDropDown(2);
        feedPO.enterComment(new String("You are the best!"));
        feedPO.clickOnSendBtn();
//         check fields are filled correctly
        Assert.assertEquals("Vasya", checkPO.getSpanName());
        Assert.assertEquals("33", checkPO.getSpanAge());
        Assert.assertEquals("English,French", checkPO.getSpanLanguage());
        Assert.assertEquals("male", checkPO.getSpanGender());
        Assert.assertEquals("Ok, i guess", checkPO.getSpanOption());
        Assert.assertEquals("You are the best!", checkPO.getSpanComment());
//         check button colors
//         (green with white letter and red with white letters)
        Assert.assertEquals("rgba(76, 175, 80, 1)", checkPO.getYesButtonBackGroundColor());
        Assert.assertEquals("rgba(244, 67, 54, 1)", checkPO.getNoButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", checkPO.getYesButtonTextColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", checkPO.getNoButtonTextColor());
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         enter only name
        feedPO.enterName(new String("Gloria"));
//         click "Send"
        feedPO.clickOnSendBtn();
//         click "Yes"
        checkPO.clickOnYesBtn();
//         check message text: "Thank you, NAME, for your feedback!"
        Assert.assertEquals("Thank you, Gloria, for your feedback!", checkPO.getMessageText());
//         color of text is white with green on the background
        Assert.assertEquals("rgba(76, 175, 80, 1)", checkPO.getMessageBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", checkPO.getMessageTextColor());
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {

//         click "Send" (without entering anything
        feedPO.clickOnSendBtn();
//         click "Yes"
        checkPO.clickOnYesBtn();
//         check message text: "Thank you for your feedback!"
        Assert.assertEquals("Thank you for your feedback!", checkPO.getMessageText());
//         color of text is white with green on the background
        Assert.assertEquals("rgba(76, 175, 80, 1)", checkPO.getMessageBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", checkPO.getMessageTextColor());
    }

    @Test
    public void noOnFeedbackPage() throws Exception {

//         fill the whole form
        feedPO.enterName(new String("Tanya"));
        feedPO.enterAge(new String("44"));
        feedPO.selectCheckBox(0);
        feedPO.selectCheckBox(2);
        feedPO.selectRadioBtn(1);
        feedPO.selectValueFromDropDown(1);
        feedPO.enterComment(new String("Thank You!"));
//         click "Send"
        feedPO.clickOnSendBtn();
//         click "No"
        checkPO.clickOnNoBtn();
//         check fields are filled correctly
        Assert.assertEquals("Tanya", feedPO.getName());
        Assert.assertEquals("44", feedPO.getAge());
        Assert.assertTrue(feedPO.verifyRadioButtonIsSelected(1));
        Assert.assertTrue(feedPO.verifyCheckBoxIsSelected(0));
        Assert.assertFalse(feedPO.verifyCheckBoxIsSelected(1));
        Assert.assertTrue(feedPO.verifyCheckBoxIsSelected(2));
        Assert.assertFalse(feedPO.verifyCheckBoxIsSelected(3));
        Assert.assertEquals("Good",feedPO.getSelectedOption());
        Assert.assertEquals("Thank You!", feedPO.getComment());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}