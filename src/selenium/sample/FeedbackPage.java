package selenium.sample;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FeedbackPage {
    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameText;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageText;

//    @FindBy(how = How.CSS, using = "input.w3-check.__web-inspector-hide-shortcut__")
//    private WebElement engLang;
//    @FindBy(how = How.XPATH, using = "//input[@value='French']")
//    private WebElement frLang;
//    @FindBy(how = How.XPATH, using = "//input[@value='Spanish']")
//    private WebElement spLang;
//    @FindBy(how = How.XPATH, using = "//input[@value='Chinese']")
//    private WebElement chinLang;

    //list of elements
    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
       private List<WebElement> checkBoxes;

    @FindBy(how = How.XPATH, using = "//input[@value='male']")
    private WebElement maleBtn;
    @FindBy(how = How.XPATH, using = "//input[@value='female']")
    private WebElement femaleBtn;


    @FindBy(how = How.ID, using = "like_us")
    private WebElement dropDowns;

    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentForm;

        @FindBy(how = How.CSS, using = "button.w3-btn-block")
        private WebElement sbmBtn;

    public void enterName(String name){
        nameText.clear();
        nameText.sendKeys(name);
    }
    public String getName(){
        return nameText.getAttribute("value");
    }

    public void enterAge(String age){
        ageText.clear();
        ageText.sendKeys(age);
    }
    public String getAge(){
        return ageText.getAttribute("value");
    }

//    public void checkEng(){
//        engLang.isSelected();
//    }
//    public void checkFrench(){
//        frLang.isSelected();
//    }
//    public void checkSpanish(){
//        spLang.isSelected();
//    }
//    public void checkChinese(){
//        chinLang.isSelected();
//    }

    public void clickMale(){
        maleBtn.click();
    }
    public boolean verifyMaleIsSelected()
    {
        return maleBtn.isSelected();
    }
    public void clickFemale(){
        femaleBtn.click();
    }
    public boolean verifyFemaleIsSelected()
    {
        return femaleBtn.isSelected();
    }
    public void selectDropDown(int index){
        Select dropdown = new Select(dropDowns);
        dropdown.selectByIndex(index);
    }
    public String getSelectedDropDown(){
        Select dropdown1 = new Select(dropDowns);
        return dropdown1.getFirstSelectedOption().getText();
    }

    public void selectCheckBox(int index){
        checkBoxes.get(index).click();
    }
    public boolean verifyCheckBoxIsSelected(int index)
    {
        return checkBoxes.get(index).isSelected();
    }
    public void addComment(String comment)
    {
        commentForm.sendKeys(comment);
    }
    public String getComment(){
        return commentForm.getAttribute("value");
    }


    public void clickSubmitBtn(){
        sbmBtn.click();
    }
    public String getSubmitBtnBckgrColor(){
        return sbmBtn.getCssValue("background-color");
    }
    public String getSubmitBtnLetterColor(){
        return sbmBtn.getCssValue("color");
    }

}
