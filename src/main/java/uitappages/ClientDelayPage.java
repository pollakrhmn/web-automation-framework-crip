package uitappages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientDelayPage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(ClientDelayPage.class);

    @FindBy(css = "#ajaxButton")
    private WebElement ajaxButton;

    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(css = "#ajaxButton")
    private WebElement buttonTriggClient;

    @FindBy(css = "body:nth-child(2) section:nth-child(2) div.container div:nth-child(8) > p.bg-success")
    private WebElement triggBtnTxt;

    public ClientDelayPage(WebDriver driver) {
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

    public void clickButtonTriggering() {
        click(buttonTriggClient);
        LOG.info("'Button triggering client side Logic' click successful");
    }

    public boolean checkButtonClickable() {
        if (checkDisplayed(buttonTriggClient)) {
            LOG.info("button clickable successful");
        }
        return checkEnabled(buttonTriggClient);
    }

}
