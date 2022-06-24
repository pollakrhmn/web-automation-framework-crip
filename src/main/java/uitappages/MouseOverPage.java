package uitappages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MouseOverPage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(MouseOverPage.class);

    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(xpath = "//a[contains(text(),'Click me')]")
    private WebElement clickMe;

    @FindBy(css = "body:nth-child(2) section:nth-child(2) div.container div:nth-child(8) > p:nth-child(1)")
    private WebElement textCounting;

    public MouseOverPage(WebDriver driver) {
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

    public void clickClickMe() {
        click(clickMe);
        LOG.info("Click on 'Click Me' successful");
    }

    public boolean checkClickable() {
        LOG.info("'Click me' is clickable successful");
        return checkEnabled(clickMe);
    }

    public String readClickMeRecord() {
        String textFromCount = textCounting.getText();
        LOG.info("The text counting the clicks reads: " + textFromCount);
        return textFromCount;
    }

    public void clickContinuously(int expectedClicks) {
        for (int i = 0; i < expectedClicks; i++) {
            clickClickMe();
        }
        LOG.info("'Click me' has been clicked " + expectedClicks + " number of times");
    }

}
