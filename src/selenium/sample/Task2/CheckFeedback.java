package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckFeedback {

    @FindBy(how = How.ID, using = "name")
    private WebElement spanName;

    @FindBy(how = How.ID, using = "age")
    private WebElement spanAge;

    @FindBy(how = How.CSS, using = "#language")
    private WebElement spanLanguage;

    @FindBy(how = How.CSS, using = "#gender")
    private WebElement spanGender;

    @FindBy(how = How.CSS, using = "#option")
    private WebElement spanOption;

    @FindBy(how = How.CSS, using = "#comment")
    private WebElement spanComment;

    @FindBy(how = How.XPATH, using = "//button[text()='Yes']")
    private WebElement yesBtn;

    @FindBy(how = How.XPATH, using = "//button[text()='No']")
    private WebElement noBtn;

    @FindBy(how = How.CSS, using = ".w3-green")
    private WebElement message;

    public String getSpanName()
    {
        return  spanName.getText();
    }

    public String getSpanAge()
    {
        return  spanAge.getText();
    }

    public String getSpanLanguage()
    {
        return  spanLanguage.getText();
    }

    public String getSpanGender()
    {
        return  spanGender.getText();
    }

    public String getSpanOption()
    {
        return  spanOption.getText();
    }

    public String getSpanComment()
    {
        return  spanComment.getText();
    }

    public void clickOnYesBtn()
    {
        yesBtn.click();
    }

    public void clickOnNoBtn()
    {
        noBtn.click();
    }

    public String getYesButtonBackGroundColor()
    {
        return yesBtn.getCssValue("background-color");
    }

    public String getYesButtonTextColor()
    {
        return yesBtn.getCssValue("color");
    }

    public String getNoButtonBackGroundColor()
    {
        return noBtn.getCssValue("background-color");
    }

    public String getNoButtonTextColor()
    {
        return noBtn.getCssValue("color");
    }

    public String getMessageText()
    {
        return  message.getText();
    }

    public String getMessageBackGroundColor()
    {
        return message.getCssValue("background-color");
    }

    public String getMessageTextColor()
    {
        return message.getCssValue("color");
    }

}