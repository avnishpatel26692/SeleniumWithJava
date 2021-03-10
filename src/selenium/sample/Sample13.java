package selenium.sample;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.sample.page.GiveFeedBackPage;




import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Sample13 {
    static String libWithDriversLocation = System.getProperty("user.dir") + "/lib/";
    WebDriver driver;
    GiveFeedBackPage giveFeedBackPO;

    GiveFeedBackPage getFeedBackPO;
    private Label xpathElement;

    @Before
    public void initBrowser() {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver");
        driver = new ChromeDriver();

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
        Assert.assertEquals("",giveFeedBackPO.getName());
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(0));
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(1));
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(2));
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(3));

        Assert.assertFalse(giveFeedBackPO.verifyRadioButtonIsSelected(0));
        Assert.assertFalse(giveFeedBackPO.verifyRadioButtonIsSelected(1));
        Assert.assertFalse(giveFeedBackPO.verifyRadioButtonIsSelected(2));

        //"Choose your option"
        Assert.assertEquals("Choose your option", giveFeedBackPO.getSelectedOption());

        //check that the button send is blue with white letters
        Assert.assertEquals("rgba(33,150,243,1)",giveFeedBackPO.getSendButtonBackGroundColor());
        Assert.assertEquals("rgba(255,255,255,1)",giveFeedBackPO.getSendButtonTextColor());
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)
        giveFeedBackPO.clickOnSendBtn();
        Assert.assertEquals("",getFeedBackPO.getName());
        Assert.assertEquals("",getFeedBackPO.getAge());
        //checking checkboxes
        Assert.assertEquals("", getFeedBackPO.getLang());
        //checking gender
        Assert.assertEquals("null", getFeedBackPO.getGender());
        //checking dropdown value
        Assert.assertEquals("null",getFeedBackPO.getOption());
        //checking comment
        Assert.assertEquals("",getFeedBackPO.getComment());

        Assert.assertEquals("rgba(76, 175, 80, 1)",getFeedBackPO.getSendButtonBackGroundColor());

        Assert.assertEquals("rgba(0, 0, 0, 1)",getFeedBackPO.getBtnTextColor());
        Assert.assertEquals("rgba(244, 67, 54, 1)",getFeedBackPO.getSendButtonTextColor());
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)
        giveFeedBackPO.enterName("Mara");
        giveFeedBackPO.enterAge("40");
        giveFeedBackPO.selectCheckBox(0);
        giveFeedBackPO.selectCheckBox(3);
        giveFeedBackPO.selectRadioBtn(0);
        giveFeedBackPO.selectValueFromDropDown(3);
        giveFeedBackPO.enterComment("Hello world");
        giveFeedBackPO.clickOnSendBtn();

        Assert.assertEquals("Mara",getFeedBackPO.getName());
        Assert.assertEquals("40",getFeedBackPO.getAge());

        Assert.assertEquals("English&Chinese", getFeedBackPO.getLang());

        Assert.assertEquals("male", getFeedBackPO.getGender());

        Assert.assertEquals("Bad",getFeedBackPO.getOption());

        Assert.assertEquals("Hello world",getFeedBackPO.getComment());


    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
        giveFeedBackPO.enterName("Santa");
//         click "Send"
        giveFeedBackPO.clickOnSendBtn();
//         click "Yes"
        giveFeedBackPO.clickOnYesBtn();
//         check message text: "Thank you, NAME, for your feedback!"
        Assert.assertEquals("Thank you, Santa, for your feedback!",getFeedBackPO.getMessage());

//         color of text is white with green on the background
        Assert.assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.id("message")).getCssValue("color"));
        Assert.assertEquals("rgba(76, 175, 80, 1)", driver.findElement(By.cssSelector("div.w3-panel")).getCssValue("background-color"));

    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
        giveFeedBackPO.clickOnSendBtn();
        getFeedBackPO.clickOnYesBtn();
        giveFeedBackPO.enterName("Inna");
        giveFeedBackPO.enterAge("43");
        giveFeedBackPO.selectCheckBox(0);
        giveFeedBackPO.selectCheckBox(3);
        giveFeedBackPO.selectRadioBtn(0);
        giveFeedBackPO.selectValueFromDropDown(3);
        giveFeedBackPO.enterComment("Hello world");


        Assert.assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.id("message")).getCssValue("color"));
        Assert.assertEquals("rgba(76, 175, 80, 1)", driver.findElement(By.cssSelector("div.w3-panel")).getCssValue("background-color"));
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
        giveFeedBackPO.enterName("Mara");

        giveFeedBackPO.enterAge("40");
        giveFeedBackPO.selectCheckBox(1);
        giveFeedBackPO.selectValueFromDropDown(1);

        giveFeedBackPO.clickOnSendBtn();

        giveFeedBackPO.clickOnNoBtn();
        giveFeedBackPO.selectRadioBtn(0);
        giveFeedBackPO.selectValueFromDropDown(3);
        giveFeedBackPO.enterComment("finish");
        giveFeedBackPO.clickOnSendBtn();
//         check fields are filled correctly
        getFeedBackPO.pressNo();
        //checking name and age
        Assert.assertEquals("John",giveFeedBackPO.getName());
        Assert.assertEquals("23",giveFeedBackPO.getAge());
        //checking checkboxes
        Assert.assertTrue(giveFeedBackPO.verifyCheckBoxIsSelected(0));
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(1));
        Assert.assertFalse(giveFeedBackPO.verifyCheckBoxIsSelected(2));
        Assert.assertTrue(giveFeedBackPO.verifyCheckBoxIsSelected(3));
        //checking gender
        Assert.assertTrue(giveFeedBackPO.verifyRadioButtonIsSelected(0));
        //checking dropdown value
        Assert.assertEquals("Bad",giveFeedBackPO.getSelectedOption());
        //checking comment
        Assert.assertEquals("Hello world",giveFeedBackPO.getComment());

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500);

        //Close browser
        driver.quit();
    }
}
