package selenium.sample.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FeedbackPage {
    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameText;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageText;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private List<WebElement> checkBoxes;

    @FindBy(how = How.XPATH, using = "//input[@value='Male']")
    private WebElement maleRadioBtn;

    @FindBy(how = How.XPATH, using = "//input[@value='Female']")
    private WebElement femaleRadioBtn;

    @FindBy(how = How.XPATH, using = "//input[@type='radio'][3]")
    private WebElement unknownGenderRadioBtn;

    @FindBy(how = How.ID, using = "like_us")
    private WebElement dropdown;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement submitBtn;

    public void enterName(String name) {
        nameText.sendKeys(name);
    }

    public void enterAge(String age) {
        ageText.sendKeys("26");
    }

    public void selectLanguage(int index) {
        checkBoxes.get(index).click();
    }

    public void selectMaleGender() {
        maleRadioBtn.click();
    }

    public void selectFemaleGender() {
        femaleRadioBtn.click();
    }

    public void selectUnknownGender() {
        unknownGenderRadioBtn.click();
    }

    public void submit() {
        submitBtn.click();
    }

    public String checkSubmitBtnBackgroundColor() {
        return submitBtn.getCssValue("background-color");
    }

    public String checkSubmitBtnLetterColor() {
        return submitBtn.getCssValue("color");
    }


    public boolean verifyLanguageSelected(int index){
        return checkBoxes.get(index).isSelected();
    }

    public boolean verifyUnknownGenderSelected(){
        return unknownGenderRadioBtn.isSelected();
    }

    public String getAge() {
        return ageText.getAttribute("value");

    }

    public String getName() {
        return  nameText.getAttribute("value");
    }

    public void selectFromDropDown(int index) {
        Select dropdownLikeUs  = new Select(dropdown);
        dropdownLikeUs.selectByIndex(index);
    }

    public String getTheSelectedOption(){
        Select dropdownLikeUs  = new Select(dropdown);
        return dropdownLikeUs.getFirstSelectedOption().getText();
    }

}
