package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class GiveFeedBackPage
{
    @FindBy(how= How.ID, using = "fb_name")
    private WebElement nameBox;

    @FindBy(how= How.ID, using = "fb_age")
    private WebElement ageBox;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private List<WebElement> checkBoxes;

    @FindBy(how = How.XPATH, using = "//input[@type='radio']")
    private List<WebElement> radioBtns;

    @FindBy(how = How.ID, using = "like_us")
    private WebElement likeUsDropdown;

    @FindBy(how = How.CSS, using = "textarea.w3-input.w3-border")
    private WebElement commentBox;

    @FindBy(how = How.XPATH, using = "//button[text()='Send']")
    private WebElement sendBtn;





    public void enterName(String name) {
        nameBox.sendKeys(name);
    }

    public String getName(){
        return nameBox.getAttribute("value");
    }

    public void enterAge (String age) {
        ageBox.sendKeys(age);
    }

    public String getAge() {
        return ageBox.getAttribute("value");

    }

    public boolean verifyCheckBoxIsSelected(int index) {
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
        Select dropdown  = new Select(likeUsDropdown);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectValueFromDropDown(int index)
    {
        Select dropdown  = new Select(likeUsDropdown);
        dropdown.selectByIndex(index);
    }

    public void enterComment(String comment)
    {
        commentBox.sendKeys(comment);
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
