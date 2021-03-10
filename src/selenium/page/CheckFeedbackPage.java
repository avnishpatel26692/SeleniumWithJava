package selenium.page;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class CheckFeedbackPage {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    ProvideFeedbackPage giveFeedBackPO;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver88.exe");
        driver = new ChromeDriver();
        giveFeedBackPO = PageFactory.initElements(driver, ProvideFeedbackPage.class);

        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters
    @Test
    public void initialFeedbackPage() {
        //Checking Fields are empty
        Assert.assertEquals("",giveFeedBackPO.getName());
        Assert.assertEquals("",giveFeedBackPO.getAge());

        //checking checkboxes are not selected
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(0));
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(1));
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(2));
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(3));

        //checking radioButtons are not selected
        Assert.assertFalse(giveFeedBackPO.verifyRadioButtonIsSelected(0));
        Assert.assertFalse(giveFeedBackPO.verifyRadioButtonIsSelected(1));

        //checking don't know radioButton is selected as gender
        Assert.assertTrue(giveFeedBackPO.verifyRadioButtonIsSelected(2));

        //"Choose your option" in "How do you like us?"
        Assert.assertEquals("Choose your option", giveFeedBackPO.getSelectedOption());

        //check that the button send is blue with white letters
        Assert.assertEquals("rgba(33, 150, 243, 1)", giveFeedBackPO.getSendButtonBackGroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", giveFeedBackPO.getSendButtonTextColor());
    }

    @Test
    public void emptyFeedbackPage()  {
//         TODO:
//         click "Send" without entering any data
        giveFeedBackPO.clickOnSendBtn();
//         check fields are empty or null
        Assert.assertEquals("",giveFeedBackPO.getSentName());
        Assert.assertEquals("",giveFeedBackPO.getSentAge());
        Assert.assertEquals("",giveFeedBackPO.getSentLanguage());
        Assert.assertEquals("null",giveFeedBackPO.getSentGender());
        Assert.assertEquals("null",giveFeedBackPO.getSentOption());
        Assert.assertEquals("",giveFeedBackPO.getSentComment());
//         check button colors
//         (green with white letter and red with white letters)
        Assert.assertEquals("rgba(76, 175, 80, 1)", giveFeedBackPO.getYesButtonColor());
        Assert.assertEquals("rgba(244, 67, 54, 1)", giveFeedBackPO.getNoButtonColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", giveFeedBackPO.getYesButtonTextColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", giveFeedBackPO.getNoButtonTextColor());
    }

    @Test
    public void notEmptyFeedbackPage()  {
//         TODO:
        //fill the whole form, click "Send"
        giveFeedBackPO.enterName("Egils");
        giveFeedBackPO.enterAge("27");
        giveFeedBackPO.selectCheckBox(1);
        giveFeedBackPO.selectRadioBtn(0);
        giveFeedBackPO.selectValueFromDropDown(1);
        giveFeedBackPO.enterComment("Thank you!");
        giveFeedBackPO.clickOnSendBtn();
//         check fields are filled correctly
        Assert.assertEquals("Egils",giveFeedBackPO.getSentName());
        Assert.assertEquals("27",giveFeedBackPO.getSentAge());
        Assert.assertEquals("French",giveFeedBackPO.getSentLanguage());
        Assert.assertEquals("male",giveFeedBackPO.getSentGender());
        Assert.assertEquals("Good",giveFeedBackPO.getSentOption());
        Assert.assertEquals("Thank you!",giveFeedBackPO.getSentComment());
//         check button colors
//         (green with white letter and red with white letters)
        Assert.assertEquals("rgba(76, 175, 80, 1)", giveFeedBackPO.getYesButtonColor());
        Assert.assertEquals("rgba(244, 67, 54, 1)", giveFeedBackPO.getNoButtonColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", giveFeedBackPO.getYesButtonTextColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", giveFeedBackPO.getNoButtonTextColor());
    }

    @Test
    public void yesOnWithNameFeedbackPage()  {
//         TODO:
//         enter only name
        giveFeedBackPO.enterName("Egils");
//         click "Send"
        giveFeedBackPO.clickOnSendBtn();
//         click "Yes"
        giveFeedBackPO.clickYes();
//         check message text: "Thank you, NAME, for your feedback!"
        Assert.assertEquals("Thank you, Egils, for your feedback!",giveFeedBackPO.getSentCommentFinal());
//         color of text is white with green on the background
        Assert.assertEquals("rgba(255, 255, 255, 1)",giveFeedBackPO.getFinalTextColor());
        Assert.assertEquals("rgba(76, 175, 80, 1)",giveFeedBackPO.getFinalColor());
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
            giveFeedBackPO.clickOnSendBtn();
//         click "Yes"
            giveFeedBackPO.clickYes();
//         check message text: "Thank you for your feedback!"
            Assert.assertEquals("Thank you for your feedback!",giveFeedBackPO.getSentCommentFinal());
//         color of text is white with green on the background
            Assert.assertEquals("rgba(255, 255, 255, 1)",giveFeedBackPO.getFinalTextColor());
            Assert.assertEquals("rgba(76, 175, 80, 1)",giveFeedBackPO.getFinalColor());
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
        giveFeedBackPO.enterName("Egils");
        giveFeedBackPO.enterAge("27");
        giveFeedBackPO.selectCheckBox(1);
        giveFeedBackPO.selectRadioBtn(0);
        giveFeedBackPO.selectValueFromDropDown(1);
        giveFeedBackPO.enterComment("Thank you!");
//         click "Send"
        giveFeedBackPO.clickOnSendBtn();
//         click "No"
        giveFeedBackPO.clickNo();
//         check fields are filled correctly
        Assert.assertEquals("Egils",giveFeedBackPO.getName());
        Assert.assertEquals("27",giveFeedBackPO.getAge());
        Assert.assertTrue(giveFeedBackPO.verifyCheckBoxIsSelected(1));
        Assert.assertTrue(giveFeedBackPO.verifyRadioButtonIsSelected(0));
        Assert.assertEquals("Good", giveFeedBackPO.getSelectedOption());
        Assert.assertEquals("", giveFeedBackPO.checkComment());

    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);

        //Close browser
        driver.quit();
    }
}




