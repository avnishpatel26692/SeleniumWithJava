package page;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
//import selenium.page.GiveFeedback;

import java.util.concurrent.TimeUnit;

public class Sample12 {

    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
    WebDriver driver;
    GiveFeedback giveFeedbackPO;
    FeedBack feedBackPO;


    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver89.exe");
        driver = new ChromeDriver();
        giveFeedbackPO = PageFactory.initElements(driver, GiveFeedback.class);
        feedBackPO = PageFactory.initElements(driver, FeedBack.class);


        //open test homepage
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }
    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters
        Assert.assertEquals("", giveFeedbackPO.getName());
        Assert.assertEquals("", giveFeedbackPO.getAge());

        Assert.assertFalse(giveFeedbackPO.verifyCheckbox(0));
        Assert.assertFalse(giveFeedbackPO.verifyCheckbox(1));
        Assert.assertFalse(giveFeedbackPO.verifyCheckbox(2));
        Assert.assertFalse(giveFeedbackPO.verifyCheckbox(3));

        Assert.assertFalse(giveFeedbackPO.verifyRadioButtonIsSelected(0));
        Assert.assertFalse(giveFeedbackPO.verifyRadioButtonIsSelected(1));

        Assert.assertTrue(giveFeedbackPO.verifyRadioButtonIsSelected(2));

        Assert.assertEquals("Choose your option", giveFeedbackPO.getSelectedOption());

        Assert.assertEquals("rgba(33, 150, 243, 1)", giveFeedbackPO.sendButtonBackgroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", giveFeedbackPO.getSendButtonColor());
    }







    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)

        Assert.assertEquals("", giveFeedbackPO.getName());
        Assert.assertEquals("", giveFeedbackPO.getAge());

        Assert.assertFalse(giveFeedbackPO.verifyCheckbox(0));
        Assert.assertFalse(giveFeedbackPO.verifyCheckbox(1));
        Assert.assertFalse(giveFeedbackPO.verifyCheckbox(2));
        Assert.assertFalse(giveFeedbackPO.verifyCheckbox(3));

        Assert.assertFalse(giveFeedbackPO.verifyRadioButtonIsSelected(0));
        Assert.assertFalse(giveFeedbackPO.verifyRadioButtonIsSelected(1));
        Assert.assertTrue( giveFeedbackPO.verifyRadioButtonIsSelected(2));

        Assert.assertEquals("Choose your option", giveFeedbackPO.getSelectedOption());

        giveFeedbackPO.clickSend();


        Assert.assertEquals("rgba(76, 175, 80, 1)", feedBackPO.sendYesButtonBackgroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedBackPO.getYesButtonColor());

        Assert.assertEquals("rgba(244, 67, 54, 1)", feedBackPO.sendNoButtonBackgroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedBackPO.getNoButtonColor());


    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)

        giveFeedbackPO.enterName( "Name");
        giveFeedbackPO.enterAge( "14");

        giveFeedbackPO.selectCheckBox(0);
        giveFeedbackPO.selectCheckBox(1);
        giveFeedbackPO.selectCheckBox(2);
        giveFeedbackPO.selectCheckBox(3);

        Assert.assertTrue(giveFeedbackPO.verifyCheckbox(0));
        Assert.assertTrue(giveFeedbackPO.verifyCheckbox(1));
        Assert.assertTrue(giveFeedbackPO.verifyCheckbox(2));
        Assert.assertTrue(giveFeedbackPO.verifyCheckbox(3));

        giveFeedbackPO.selectRadio(1);

        Assert.assertFalse(giveFeedbackPO.verifyRadioButtonIsSelected(0));
        Assert.assertTrue(giveFeedbackPO.verifyRadioButtonIsSelected(1));
        Assert.assertFalse( giveFeedbackPO.verifyRadioButtonIsSelected(2));

        giveFeedbackPO.selectValueFromDropDown(4);

        Assert.assertEquals("Why me?", giveFeedbackPO.getSelectedOption());

        giveFeedbackPO.enterComment("Thank You!");

        giveFeedbackPO.clickSend();


        Assert.assertEquals("rgba(76, 175, 80, 1)", feedBackPO.sendYesButtonBackgroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedBackPO.getYesButtonColor());

        Assert.assertEquals("rgba(244, 67, 54, 1)", feedBackPO.sendNoButtonBackgroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedBackPO.getNoButtonColor());





    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background

        giveFeedbackPO.enterName( "Marija");
        giveFeedbackPO.clickSend();
        feedBackPO.yesButtonClick();


        Assert.assertEquals("Thank you, Marija, for your feedback!", feedBackPO.getMessage());

        Assert.assertEquals("rgba(76, 175, 80, 1)", feedBackPO.messageBackgroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedBackPO.messageTextColor());


    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
        giveFeedbackPO.clickSend();
        feedBackPO.yesButtonClick();
        Assert.assertEquals("Thank you for your feedback!", feedBackPO.getMessage());
        Assert.assertEquals("rgba(76, 175, 80, 1)", feedBackPO.messageBackgroundColor());
        Assert.assertEquals("rgba(255, 255, 255, 1)", feedBackPO.messageTextColor());


    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly

        giveFeedbackPO.enterName( "Name");
        giveFeedbackPO.enterAge( "31");

        giveFeedbackPO.selectCheckBox(0);
        giveFeedbackPO.selectCheckBox(1);
        giveFeedbackPO.selectCheckBox(2);
        giveFeedbackPO.selectCheckBox(3);

        Assert.assertTrue(giveFeedbackPO.verifyCheckbox(0));
        Assert.assertTrue(giveFeedbackPO.verifyCheckbox(1));
        Assert.assertTrue(giveFeedbackPO.verifyCheckbox(2));
        Assert.assertTrue(giveFeedbackPO.verifyCheckbox(3));

        giveFeedbackPO.selectRadio(1);

        Assert.assertFalse(giveFeedbackPO.verifyRadioButtonIsSelected(0));
        Assert.assertTrue(giveFeedbackPO.verifyRadioButtonIsSelected(1));
        Assert.assertFalse( giveFeedbackPO.verifyRadioButtonIsSelected(2));

        giveFeedbackPO.selectValueFromDropDown(4);

        Assert.assertEquals("Why me?", giveFeedbackPO.getSelectedOption());

        giveFeedbackPO.enterComment("Thank You!");

        giveFeedbackPO.clickSend();

        feedBackPO.noButtonClick();

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);

        //Close browser
        driver.quit();
    }
}
