package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FeedBackPage {
    @FindBy(how = How.XPATH, using = "//*[@id='name']")
    private WebElement yourName;

    @FindBy(how = How.XPATH, using = "//*[@id='age']")
    private WebElement yourAge;

    @FindBy(how = How.XPATH, using = "//*[@id='language']")
    private WebElement yourLanguage;

    @FindBy(how = How.XPATH, using = "//*[@id='gender']")
    private WebElement yourGender;

    @FindBy(how = How.XPATH, using = "//*[@id='option']")
    private WebElement yourOptionOfUs;

    @FindBy(how = How.XPATH, using = "//*[@id='comment']")
    private WebElement yourComment;

    @FindBy(how = How.XPATH, using = "//*[@id='fb_thx']/div/div[2]/button[1]")
    private WebElement confirmBtn;

    @FindBy(how = How.XPATH, using = "//*[@id='fb_thx']/div/div[2]/button[2]")
    private WebElement denyBtn;

    public String getName() {
        return yourName.getText();
    }

    public String getAge() {
        return yourAge.getText();
    }

    public String getLanguage() {
        return yourLanguage.getText();
    }

    public String getGender() {
        return yourGender.getText();
    }

    public String getOptionOfUs() {
        return yourOptionOfUs.getText();
    }

    public String getComment() {
        return yourComment.getText();
    }

    public void clickOnConfirmBtn() {
        confirmBtn.click();
    }

    public void clickOnDenyBtn() {
        denyBtn.click();
    }



    public String getConfirmButtonBackGroundColor() {
        return confirmBtn.getCssValue("background-color");
    }

    public String getConfirmButtonTextColor() {
        return confirmBtn.getCssValue("color");
    }

    public String getDenyButtonBackGroundColor() {
        return denyBtn.getCssValue("background-color");
    }

    public String getDenyButtonTextColor() {
        return denyBtn.getCssValue("color");
    }
}