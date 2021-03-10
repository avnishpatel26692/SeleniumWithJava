package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GiveFeedback {


    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameText;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageText;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(how = How.XPATH, using = "//input[@class='w3-radio']")
    private List<WebElement> radio;

    @FindBy(how = How.ID, using = "like_us")
    private WebElement likeUs;

    @FindBy(how = How.NAME, using = "comment")
    private WebElement commentText;

    @FindBy(how = How.XPATH, using = "//button[text()='Send']")
    private WebElement send;

    @FindBy(how = How.XPATH, using = "//input[@value='English']")
    private WebElement english;

    @FindBy(how = How.XPATH, using = "//input[@value='French']")
    private WebElement french;

    @FindBy(how = How.XPATH, using = "//input[@value='Spanish']")
    private WebElement spanish;

    @FindBy(how = How.XPATH, using = "//input[@value='Chinese']")
    private WebElement chinese;

    @FindBy(how = How.XPATH, using = "//input[@value='male']")
    private WebElement male;

    @FindBy(how = How.XPATH, using = "//input[@value='male']")
    private WebElement female;

    @FindBy(how = How.XPATH, using = "//input[@class='w3-radio'][3]")
    private WebElement disabled;



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
        return nameText.getAttribute("value");
    }


    public boolean verifyCheckbox(int index) {
        return checkboxes.get(index).isSelected();
    }

    public void selectCheckBox(int index) {
        checkboxes.get(index).click();
    }

    public boolean verifyRadioButtonIsSelected(int index) {
        return radio.get(index).isSelected();

    }

    public void selectRadio(int index) {
        radio.get(index).click();
    }


    public String getSelectedOption() {
        Select dropdown = new Select(likeUs);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectValueFromDropDown(int index)
    {
        Select dropdown  = new Select(likeUs);
        dropdown.selectByIndex(index);
    }

    public void enterComment(String comment) {
        commentText.sendKeys(comment);
    }

    public void clickSend(){
        send.click();
    }

    public String sendButtonBackgroundColor() {
        return send.getCssValue("background-color");
    }

    public String getSendButtonColor() {
        return send.getCssValue("color");
    }







}
