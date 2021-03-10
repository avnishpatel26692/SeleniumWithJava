package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProvideFeedback {

    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameText;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageText;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private List<WebElement> checkBoxes;

    @FindBy(how = How.XPATH, using = "//input[@value='English']")
    private WebElement checkBoxEnglish;

    @FindBy(how = How.XPATH, using = "//input[@value='French']")
    private WebElement checkBoxFrench;

    @FindBy(how = How.XPATH, using = "//input[@value='Spanish']")
    private WebElement checkBoxSpanish;

    @FindBy(how = How.XPATH, using = "//input[@value='Chinese']")
    private WebElement checkBoxChinese;

    @FindBy(how = How.XPATH, using = "//input[@type='radio']")
    private List<WebElement> radioBtns;

    @FindBy(how = How.XPATH, using = "//input[@value='male']")
    private WebElement radioBtnMale;

    @FindBy(how = How.XPATH, using = "//input[@value='female']")
    private List<WebElement> radioBtnFemale;

    @FindBy(how = How.ID, using = "like_us")
    private WebElement dropdownLikeUs;

    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentText;

    @FindBy(how = How.XPATH, using = "//button[text()='Send']")
    private WebElement sendBtn;

    public void enterName(String name)
    {
        nameText.sendKeys(name);
    }

    public String getName()
    {
        return nameText.getAttribute("value");
    }

    public void enterAge(String age)
    {
        ageText.sendKeys(age);
    }

    public String getAge()
    {
        return ageText.getAttribute("value");
    }

    public boolean verifyCheckBoxIsSelected(int index)
    {
        return checkBoxes.get(index).isSelected();
    }

    public void selectCheckBox(int index)
    {
        checkBoxes.get(index).click();
    }

    public boolean verifyRadioButtonIsSelected(int index)
    {
        return radioBtns.get(index).isSelected();
    }

    public void selectRadioBtn(int index)
    {
        radioBtns.get(index).click();
    }

    public String getSelectedOption()
    {
        Select dropdown  = new Select(dropdownLikeUs);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectValueFromDropDown(int index)
    {
        Select dropdown  = new Select(dropdownLikeUs);
        dropdown.selectByIndex(index);
    }

    public void enterComment(String comment)
    {
        commentText.sendKeys(comment);
    }

    public String getComment()
    {
        return commentText.getAttribute("value");
    }

    public void clickOnSendBtn()
    {
        sendBtn.click();
    }

    public String getSendButtonBackGroundColor()
    {
        return sendBtn.getCssValue("background-color");
    }

    public String getSendButtonTextColor()
    {
        return sendBtn.getCssValue("color");
    }

}