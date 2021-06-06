package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GiveFeedbackPage {
    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameText;

    @FindBy(how = How.XPATH, using = "//input[@id='fb_age']")
    private WebElement ageText;

    //Checkbox
    @FindBy(how = How.XPATH, using = "//input[@name='language']")
    private List<WebElement> languageBox;

    //RadioButton
    @FindBy(how = How.XPATH, using ="//input[@name='gender']")
    private List<WebElement> radioButtons;

    //Dropdown
    @FindBy(how = How.XPATH, using ="//*[@id='like_us']")
    private WebElement option;

    //Comment
    @FindBy(how = How.XPATH, using = "//*[@id='fb_form']/form/div[6]/textarea")
    private WebElement commentText;

    //Button
    @FindBy(how = How.XPATH, using = "//button[contains(@class,'w3-section')] ")
    private WebElement submitBtn;

    public void enterName(String name) {
        nameText.sendKeys(name);
    }

    public String getName() {
        return nameText.getAttribute("value");
    }

    public void enterAge(String age) {
        ageText.sendKeys(age);
    }

    public String getAge() {
        return ageText.getAttribute("value");
    }

    public boolean verifyCheckBoxIsSelected(int index) {
        return languageBox.get(index).isSelected();
    }

    public void selectCheckBox(int index) {
        languageBox.get(index).click();
    }

    public boolean verifyRadioButtonIsSelected(int index) {
        return radioButtons.get(index).isSelected();
    }

    public void selectRadioBtn(int index) {
        radioButtons.get(index).click();
    }

    public String getSelectedOption() {
        Select dropdown  = new Select(option);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectValueFromDropDown(int index) {
        Select dropdown  = new Select(option);
        dropdown.selectByIndex(index);
    }

    public void enterComment(String comment) {
        commentText.sendKeys(comment);
    }

    public String getComment() {
        return commentText.getAttribute("value");
    }

    public void clickOnSendBtn() {
        submitBtn.click();
    }

    public String getSendButtonBackGroundColor() {
        return submitBtn.getCssValue("background-color");
    }

    public String getSendButtonTextColor() {
        return submitBtn.getCssValue("color");
    }
}
