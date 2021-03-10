package selenium.sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Sample12 {


    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    static WebDriver driver;
    GiveFeedBackPage giveFeedBackPO;
    FeedBackPage feedBackPagePO;



    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();
        giveFeedBackPO = PageFactory.initElements(driver, GiveFeedBackPage.class);
        feedBackPagePO = PageFactory.initElements(driver, FeedBackPage.class);


        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    //
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters

@Test
    public void initialFeedBackPage()throws Exception{

        //check fields are empty

    Assert.assertEquals("", giveFeedBackPO.getName());
    Assert.assertEquals("", giveFeedBackPO.getAge());

    //check checkboxes are not selected
    Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(0));
    Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(1));
    Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(2));
    Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(3));

    //radiobuttons are not selected

    Assert.assertFalse(giveFeedBackPO.verifyRadioButtonIsSelected(0));
    Assert.assertFalse(giveFeedBackPO.verifyRadioButtonIsSelected(1));

    //don't know radiobutton is selected as "Genre"
    Assert.assertTrue(giveFeedBackPO.verifyRadioButtonIsSelected(2));

    //Choose your option is selected in "How do you like us?"

    Assert.assertEquals("Choose your option", giveFeedBackPO.getSelectedOption(1));

    //Check button is Blue in color with White Text
    Assert.assertEquals("rgba(33, 150, 243, 1)", giveFeedBackPO.getSendButtonBackGroundColor());
    Assert.assertEquals("rgba(255, 255, 255, 1)", giveFeedBackPO.getSendButtonTextColor());



}
    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
        giveFeedBackPO.clickOnSendBtn();
//         check fields are empty or null
        Assert.assertEquals("", feedBackPagePO.getName());
        Assert.assertEquals("", feedBackPagePO.getAge());
        Assert.assertEquals("", feedBackPagePO.getLanguage());
        Assert.assertEquals("null", feedBackPagePO.getGender());
        Assert.assertEquals("null", feedBackPagePO.getOption());
        Assert.assertEquals("", feedBackPagePO.getComment());
//         check button colors
//         (green with white letter and red with white letters)
        Assert.assertEquals("rgba(76, 175, 80, 1)", feedBackPagePO.getYesButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedBackPagePO.getYesButtonTextColor());
        Assert.assertEquals("rgba(244, 67, 54, 1)", feedBackPagePO.getNoButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedBackPagePO.getNoButtonTextColor());
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"

       giveFeedBackPO.enterName("Anda");
       giveFeedBackPO.enterAge("28");
       giveFeedBackPO.selectCheckBox(1);
       giveFeedBackPO.selectRadioBtn(1);
       giveFeedBackPO.selectValueFromDropDown(1);
       giveFeedBackPO.enterComment("Hi there");
       giveFeedBackPO.clickOnSendBtn();
//         check fields are filled correctly

        Assert.assertEquals("Anda", feedBackPagePO.getName());
        Assert.assertEquals("28", feedBackPagePO.getAge());
        Assert.assertEquals("French", feedBackPagePO.getLanguage());
        Assert.assertEquals("female", feedBackPagePO.getGender());
        Assert.assertEquals("Good", feedBackPagePO.getOption());
        Assert.assertEquals("Hi there", feedBackPagePO.getComment());
//         check button colors
//         (green with white letter and red with white letters)
        Assert.assertEquals("rgba(76, 175, 80, 1)", feedBackPagePO.getYesButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedBackPagePO.getYesButtonTextColor());
        Assert.assertEquals("rgba(244, 67, 54, 1)", feedBackPagePO.getNoButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedBackPagePO.getNoButtonTextColor());
    }
    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//
//         enter only name
        giveFeedBackPO.enterName("Anda");
//         click "Send"
        giveFeedBackPO.clickOnSendBtn();
//         click "Yes"
        feedBackPagePO.clickOnYesBtn();
//         check message text: "Thank you, NAME, for your feedback!"
        Assert.assertEquals("Thank you, Anda, for your feedback!", feedBackPagePO.getMessage());
//         color of text is white with green on the background
        Assert.assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.id("message")).getCssValue("color"));
        Assert.assertEquals("rgba(76, 175, 80, 1)", driver.findElement(By.cssSelector("div.w3-panel")).getCssValue("background-color"));


    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//
//         click "Send" (without entering anything
        giveFeedBackPO.clickOnSendBtn();
//         click "Yes"
        feedBackPagePO.clickOnYesBtn();
//         check message text: "Thank you for your feedback!"
        Assert.assertEquals("Thank you for your feedback!", feedBackPagePO.getMessage());
//         color of text is white with green on the background
        Assert.assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.id("message")).getCssValue("color"));
        Assert.assertEquals("rgba(76, 175, 80, 1)", driver.findElement(By.cssSelector("div.w3-panel")).getCssValue("background-color"));

    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
        giveFeedBackPO.enterName("Anda");
        giveFeedBackPO.enterAge("28");
        giveFeedBackPO.selectCheckBox(1);
        giveFeedBackPO.selectRadioBtn(1);
        giveFeedBackPO.selectValueFromDropDown(1);
        giveFeedBackPO.enterComment("Hi there");
//         click "Send"
        giveFeedBackPO.clickOnSendBtn();
//         click "No"
        feedBackPagePO.clickOnNoBtn();
//         check fields are filled correctly

        Assert.assertEquals("Anda", giveFeedBackPO.getName());
        Assert.assertEquals("28", giveFeedBackPO.getAge());
        Assert.assertTrue(giveFeedBackPO.verifyCheckBoxIsSelected(1));
        Assert.assertTrue(giveFeedBackPO.verifyRadioButtonIsSelected(1));
        Assert.assertEquals("Good", giveFeedBackPO.getSelectedOption(1));
        Assert.assertEquals("Hi there", giveFeedBackPO.getComment());



    }


}
