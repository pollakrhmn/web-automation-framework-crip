package uitappages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VisibilityPage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(VisibilityPage.class);

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;
    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    private WebElement removedHidden;
    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;
    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(css = "#hideButton")
    private WebElement hideButton;

    @FindBy(css = "div.container table:nth-child(7) tbody:nth-child(1) tr:nth-child(1) > td:nth-child(2)")
    private WebElement removedButton;

    @FindBy(css = "div.container table:nth-child(7) tbody:nth-child(1) tr:nth-child(1) > td:nth-child(3)")
    private WebElement zeroWidthButton;

    @FindBy(css = "div.container table:nth-child(7) tbody:nth-child(1) tr:nth-child(1) > td:nth-child(4)")
    private WebElement overlappedButton;

    @FindBy(css = "#transparentButton")
    private WebElement opacity0Btn;

    @FindBy(css = "div.container table:nth-child(7) tbody:nth-child(1) tr:nth-child(2) > td:nth-child(2)")
    private WebElement visibilHiddenBtn;

    @FindBy(css = "div.container table:nth-child(7) tbody:nth-child(1) tr:nth-child(2) > td:nth-child(3)")
    private WebElement displayNonBtn;

    @FindBy(css = "div.container table:nth-child(7) tbody:nth-child(1) tr:nth-child(2) > td:nth-child(4)")
    private WebElement offScreenButton;

    private boolean flag;

    public VisibilityPage(WebDriver driver) {
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

    public void clickHideButton() {
        click(hideButton);
        LOG.info("Hide button click successful");
    }

    public boolean checkHideClickable() {
        LOG.info("Button clickable successful");
        return checkEnabled(hideButton);
    }

    public boolean otherButtonsVisibility() {
        if (checkDisplayed(removedButton) &&
                checkDisplayed(zeroWidthButton) &&
                checkDisplayed(overlappedButton) &&
                checkDisplayed(opacity0Btn) &&
                checkDisplayed(visibilHiddenBtn) &&
                checkDisplayed(displayNonBtn) &&
                checkDisplayed(offScreenButton) &&
                checkDisplayed(hideButton)
        ) {
            flag = true;
        }
        LOG.info("All buttons visibility successful");
        return flag;
    }

    public boolean otherButtonsInvisibility() {
        if (checkNotDisplayed(removedButton) &&
                checkNotDisplayed(zeroWidthButton) &&
                checkNotDisplayed(overlappedButton) &&
                checkNotDisplayed(opacity0Btn) &&
                checkNotDisplayed(visibilHiddenBtn) &&
                checkNotDisplayed(displayNonBtn) &&
                checkNotDisplayed(offScreenButton) &&
                checkDisplayed(hideButton)
        ) {
            flag = true;
        }
        LOG.info("All other buttons invisibility successful");
        return flag;
    }

    public void clickRemovedButton() {
        click(removedButton);
        LOG.info("'Removed' button click successful");
    }

    public boolean checkRemovedClickable() {
        LOG.info("Button clickable successful");
        return checkEnabled(removedButton);
    }

    public void clickZeroWidthButton() {
        click(zeroWidthButton);
        LOG.info("'Zero Width' button click successful");
    }

    public boolean checkZeroWidClickable() {
        LOG.info("Button clickable successful");
        return checkEnabled(zeroWidthButton);
    }

    public void clickTransparentButton() {
        click(opacity0Btn);
        LOG.info("'Opacity Zero' button click successful");
    }

    public boolean checkTransparentClickable() {
        LOG.info("Button clickable successful");
        return checkEnabled(opacity0Btn);
    }

    public void clickVisibilHiddenButton() {
        click(visibilHiddenBtn);
        LOG.info("'Visibility Hidden' button click successful");
    }

    public boolean checkVisibilHiddenClickable() {
        LOG.info("Button clickable successful");
        return checkEnabled(visibilHiddenBtn);
    }

    public void clickDisplayNonButton() {
        click(displayNonBtn);
        LOG.info("'Display None' button click successful");
    }

    public boolean checkDisplayNonClickable() {
        LOG.info("Button clickable successful");
        return checkEnabled(displayNonBtn);
    }

    public void clickOffScreenButton() {
        click(offScreenButton);
        LOG.info("'Offscreen' button click successful");
    }

    public boolean checkOffscreenClickable() {
        LOG.info("Button clickable successful");
        return checkEnabled(offScreenButton);
    }

    public void clickOverlapButton() {
        click(overlappedButton);
        LOG.info("'Overlapped' button click successful");
    }

    public boolean checkOverlapClickable() {
        if (checkEnabled(overlappedButton)) {
            LOG.info("Button clickable successful");
        }
        return checkEnabled(overlappedButton);
    }

}
