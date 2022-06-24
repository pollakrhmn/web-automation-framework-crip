package uitappages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassAttributePage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(ClassAttributePage.class);

    @FindBy(xpath = "//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-success ')]")
    private WebElement greenButton;

    @FindBy(xpath = "//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-warning ')]")
    private WebElement yellowButton;

    @FindBy(xpath = "//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]")
    private WebElement blueButton;

    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    public ClassAttributePage(WebDriver driver) {
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

    public void clickGreenButton() {
        click(greenButton);
        LOG.info("Green button click successful");
    }

    public boolean checkGreenClickable() {
        if(checkEnabled(greenButton)){
            LOG.info("Green button is clickable/usable successful");
        }
        return checkEnabled(greenButton);
    }

    public void clickYellowButton() {
        click(yellowButton);
        LOG.info("Yellow button click successful");
    }

    public boolean checkYellowClickable() {
        if(checkEnabled(yellowButton)){
            LOG.info("Yellow button is clickable/usable successful");
        }
        return checkEnabled(yellowButton);
    }

    public void clickBlueButton() {
        click(blueButton);
        LOG.info("Blue button click successful");
    }

    public boolean checkBlueClickable() {
        if (checkEnabled(blueButton)) {
            LOG.info("Blue button is clickable/usable successful");
        }
        return checkEnabled(blueButton);
    }


}
