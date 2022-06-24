package uitappages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AjaxPage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(AjaxPage.class);

    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(css = "#ajaxButton")
    private WebElement ajaxButton;

    @FindBy(css = "body:nth-child(2) section:nth-child(2) div.container div:nth-child(8) > p.bg-success")
    private WebElement ajaxText;


    public AjaxPage(WebDriver driver) {
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

    public void clickAjaxButton() {
        click(ajaxButton);
        LOG.info("'Button triggering AJAX Request' click successful");
    }

    public boolean checkAjaxText() {
        LOG.info("Text display successful");
        return checkDisplayed(ajaxText);
    }

}
