package uitappages;

import base.CommonAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProgressBarPage extends CommonAPI {
    private final Logger LOG = LoggerFactory.getLogger(ProgressBarPage.class);

    @FindBy(xpath = "//a[contains(text(),'UITAP')]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(css = "#startButton")
    private WebElement startButton;

    @FindBy(css = "#stopButton")
    private WebElement stopButton;

    @FindBy(css = "#result")
    private WebElement durationText;

    public ProgressBarPage(WebDriver driver) {
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

    public void clickStart() {
        click(startButton);
        LOG.info("Start button click successful");
    }

    public boolean checkStartButton() {
        if (checkDisplayed(startButton)) {
            LOG.info("Start button clickable successful");
        }
        return checkEnabled(startButton);
    }

    public void clickStop() {
        click(stopButton);
        LOG.info("Stop button click successful");
    }

    public boolean checkStopButton() {
        if (checkDisplayed(stopButton)) {
            LOG.info("Stop button clickable successful");
        }
        ;
        return checkEnabled(stopButton);
    }

    public boolean verifyDuration() {
        String durationOfLoad = durationText.getText();
        LOG.info(durationOfLoad + " ---is the text showing length of progress bar load");
        return checkDisplayed(durationText);
    }


}


//    public boolean waitForJQueryFULLProcessing(WebDriver driver, int timeOutInSeconds) {
//        boolean jQcondition = false;
//        try {
//            getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
//            // implicitlyWait()
//            new WebDriverWait(getDriver(), Duration.ofSeconds(40)) {
//            }.until(new ExpectedCondition<Boolean>() {
//
//                @Override
//                public Boolean apply(WebDriver driverObject) {
//                    return (Boolean) ((JavascriptExecutor) driverObject)
//                            .executeScript("return jQuery.active == 0");
//
//                }
//            });
//            jQcondition = (Boolean) ((JavascriptExecutor) driver)
//                    .executeScript("return jQuery.active == 0");
//            System.out.println(jQcondition);
//            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS); // reset
//            // implicitlyWait
//            return jQcondition;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return jQcondition;
//    }


