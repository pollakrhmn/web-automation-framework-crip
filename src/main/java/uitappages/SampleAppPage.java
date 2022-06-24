package uitappages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleAppPage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(SampleAppPage.class);
    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[2]/div[1]/input[1]")
    private WebElement userNameField;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[3]/div[1]/input[1]")
    private WebElement password;

    @FindBy(css = "#login")
    private WebElement logButton;

    public SampleAppPage(WebDriver driver) {
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

    public void typeUserName(String userName) {
        type(userNameField, userName);
        LOG.info("Username type-in successful");
    }

    public void typePassword(String passWord) {
        type(password, passWord);
        LOG.info("Password type-in successful");
    }

    public void clickLogButton() {
        click(logButton);
        LOG.info("Login button click successful");
    }
}
