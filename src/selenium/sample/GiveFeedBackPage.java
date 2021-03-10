package selenium.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GiveFeedBackPage {

    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameText;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageText;

    //checkbox

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private List<WebElement> checkBoxes;


    @FindBy(how = How.XPATH, using = "//input[@value = 'English']")
    private WebElement engcheckBox;

    @FindBy(how = How.XPATH, using = "//input[@value = 'French']")
    private WebElement frenchcheckBox;

    @FindBy(how = How.XPATH, using = "//input[@value = 'Spanish']")
    private WebElement spanishckeckBox;

    @FindBy(how = How.XPATH, using = "//input[@value = 'Chinese']")
    private WebElement chinesecheckBox;

    //radio

    @FindBy(how = How.XPATH, using = "//input[@class='w3-radio']")
    private List<WebElement> radioBtns;


    @FindBy(how = How.XPATH, using = "//input [@class ='w3-radio'][1]")
    private WebElement maleradioBtn;

    @FindBy(how = How.XPATH, using = "//input [@class ='w3-radio'][2]")
    private WebElement femaleradioBtn;

    @FindBy(how = How.XPATH, using = "//input [@class ='w3-radio'][3]")
    private WebElement dontknowradioBtn;


    @FindBy(how = How.ID, using = "like_us")
    private WebElement likeUsDropDown;


    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentText;


    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement sendBtn;


    public void enterName (String name)
    {
        nameText.sendKeys(name);

    }
    public String getName() {

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

    public void selectCheckBox(int index)
    {
        checkBoxes.get(index).click();
    }

    public boolean verifyCheckBoxIsSelected(int index)
    {
        return checkBoxes.get(index).isSelected();
    }

    public void selectRadioBtn(int index)
    {
        radioBtns.get(index).click();
    }

    public boolean verifyRadioButtonIsSelected(int index)
    {
        return radioBtns.get(index).isSelected();
    }

    public String getSelectedOption(int i)
    {
        Select dropdown  = new Select(likeUsDropDown);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectValueFromDropDown(int index)
    {
        Select dropdown  = new Select(likeUsDropDown);
        dropdown.selectByIndex(index);
    }

    public void enterComment(String comment)
    {
        commentText.sendKeys(comment);
    }

    public String getComment() {
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
