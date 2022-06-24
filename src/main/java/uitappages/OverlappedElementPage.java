package uitappages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OverlappedElementPage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(OverlappedElementPage.class);
    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(css = "#id")
    private WebElement idTextField;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/input[2]")
    private WebElement nameTextField;

    public OverlappedElementPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickLogo() {
        click(logo);
        LOG.info("Page Logo click successful");
    }

    public void clickHome() {
        click(home);
        LOG.info("Home button click successful");
    }

    public void clickResources() {
        click(resources);
        LOG.info("Resources link click successful");
    }

    public void selectId() {
        click(idTextField);
        LOG.info("ID text field was clicked");
    }

    public boolean checkIDClickable() {
        LOG.info("ID text field is ready to be typed into");
        return checkEnabled(idTextField);
    }

    public void selectName() {
        click(nameTextField);
        LOG.info("Name text field was clicked");
    }

    public boolean checkNameClickable() {
        LOG.info("Name text field is ready to be typed into");
        return checkEnabled(nameTextField);
    }

    public void typeId(String text) {
        type(idTextField, text);
        LOG.info(text + " typed into ID text field successful");
    }

    public void typeName(String text) {
        type(nameTextField, text);
        LOG.info(text + "typed into Name text field successful");
    }

    public String getActualIDText() {
        String actualText = idTextField.getAttribute("value");
        LOG.info("Text from the ID text box is now ready for comparison successfully");
        return actualText;
    }

    public WebElement nameElement(){
        return nameTextField;
    }

    public String getActualNameText(){
        String actualText = nameTextField.getAttribute("value");
        LOG.info("Text from the Name text box is now ready for comparison successfully");
        return actualText;
    }


}

