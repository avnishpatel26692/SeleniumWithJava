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

    @FindBy(how = How.CSS, using = "#name")
    private WebElement spanName;

    @FindBy(how = How.CSS, using = "#age")
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

    public String getSpanName()
    {
        return  spanName.getAttribute("value");
    }

    public String getSpanAge()
    {
        return  spanAge.getAttribute("value");
    }

    public String getSpanLanguage()
    {
        return  spanLanguage.getAttribute("value");
    }
//    @FindBy(how = How.CSS, using = "#language")
//    private List<WebElement> checkboxes;

    public String getSpanGender()
    {
        return  spanGender.getAttribute("value");
    }

    public String getSpanOption()
    {
        return  spanOption.getAttribute("value");
    }

    public String getSpanComment()
    {
        return  spanComment.getAttribute("value");
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

}