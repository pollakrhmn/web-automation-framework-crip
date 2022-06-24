package uitaptests;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitappages.*;

public class PageButtons extends CommonAPI {

    private final Logger LOG = LoggerFactory.getLogger(PageButtons.class);

    @Test //T21 Verify the recording of "Button with Dynamic ID" being clicked
    public void DynamicIDButtonClick() {
        HomePage home = new HomePage(getDriver());
        home.clickDynamicId();
        DynamicIDPage autoPage = new DynamicIDPage(getDriver());
        autoPage.clickDynIDButton();
        Assert.assertTrue(autoPage.checkButtonClickable());
    }

    @Test //T23 Verify "Hiding Button" is clickable
    public void HidingButtonClick() {
        HomePage home = new HomePage(getDriver());
        home.clickScrollBars();
        ScrollbarsPage autoPage = new ScrollbarsPage(getDriver());
        autoPage.clickHidingBtn();
        Assert.assertTrue(autoPage.checkButtonClickable());
    }

    @Test //T24 Verify eight different button web elements are clickable, with "Hide" button being last
    public void ClickableRemovedButton() {
        HomePage home = new HomePage(getDriver());
        home.clickVisibility();
        VisibilityPage autoPage = new VisibilityPage(getDriver());
        autoPage.clickRemovedButton();
        Assert.assertTrue(autoPage.checkRemovedClickable());
    }

    @Test //T25 Verify that clicking on "Hide" element hides all of the other 7 clickable web elements
    public void HideFunction() {
        HomePage home = new HomePage(getDriver());
        home.clickVisibility();
        VisibilityPage autoPage = new VisibilityPage(getDriver());
        Assert.assertTrue(autoPage.otherButtonsVisibility());
        autoPage.clickHideButton();
        Assert.assertTrue(autoPage.checkHideClickable());
        boolean hidingButtons = autoPage.otherButtonsInvisibility();
        Assert.assertTrue(hidingButtons);
    }

    @Test //T26 Verify the text boxes inside Playground scroll-window is clickable
    public void textBoxClickable() {
        HomePage home = new HomePage(getDriver());
        home.clickOverlappedElement();
        OverlappedElementPage autoPage = new OverlappedElementPage(getDriver());
        autoPage.selectId();
        Assert.assertTrue(autoPage.checkIDClickable());
        WebElement nameTextField = getDriver().findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/input[2]"));
        scrollToView(nameTextField);
        autoPage.selectName();
        Assert.assertTrue(autoPage.checkNameClickable());
    }

    @Test //T28 Verify the three colored buttons on webpage are clickable part 1
    public void greenButtonClickable() {
        HomePage home = new HomePage(getDriver());
        home.clickClassAttribute();
        ClassAttributePage autoPage = new ClassAttributePage(getDriver());
        autoPage.clickGreenButton();
        Assert.assertTrue(autoPage.checkGreenClickable());
    }

    @Test //T35 Verify that user is able to click a second time on "Button" button
    public void secondClickonButton() {
        HomePage home = new HomePage(getDriver());
        home.clickHiddenLayers();
        HiddenLayersPage autoPage = new HiddenLayersPage(getDriver());
        autoPage.clickBothButtons();
        Assert.assertTrue(autoPage.checkGreenClickable());
        Assert.assertTrue(autoPage.checkBlueClickable());
    }

    @Test //T36 Verify that user is able to click on a button that reads "Button That Ignores DOM Click Event"
    public void verifyDOMButton() {
        HomePage home = new HomePage(getDriver());
        home.clickClickLink();
        ClickPage autoPage = new ClickPage(getDriver());
        autoPage.clickDOM();
        Assert.assertTrue(autoPage.checkDOMClickable());
        autoPage.clickDOM();
        Assert.assertTrue(autoPage.checkDOMClickable());
        LOG.info("Second click on DOM-related button successful");
    }

    @Test //T41 Verify Start button on Progress Bar Webpage is displayed and clickable
    public void verifyStartButton() {
        HomePage home = new HomePage(getDriver());
        home.clickProgressBar();
        ProgressBarPage autoPage = new ProgressBarPage(getDriver());
        autoPage.clickStart();
        Assert.assertTrue(autoPage.checkStartButton());
        autoPage.clickStart();
        Assert.assertTrue(autoPage.checkStartButton());
        LOG.info("Second click on Start button successful");
    }

    @Test //T42 Verify Stop button on Progress Bar Webpage is displayed and clickable
    public void verifyStopButton() {
        HomePage home = new HomePage(getDriver());
        home.clickProgressBar();
        ProgressBarPage autoPage = new ProgressBarPage(getDriver());
        autoPage.clickStop();
        Assert.assertTrue(autoPage.checkStopButton());
        autoPage.clickStop();
        Assert.assertTrue(autoPage.checkStopButton());
        LOG.info("Second click on Stop button successful");
    }

    @Test //T44 Verify button on Non-Breaking Space Webpage is displayed and clickable
    public void verifyMyButton() {
        HomePage home = new HomePage(getDriver());
        home.clickNonBreakingSpace();
        NonBreakingSpacePage autoPage = new NonBreakingSpacePage(getDriver());
        autoPage.clickMyButton();
        autoPage.clickMyButton();
        Assert.assertTrue(autoPage.checkMyButton());
        LOG.info("Second click on 'My Button' button successful");
    }

    @Test //T60 Verify "Button Appearing After Delay" is clickable
    public void buttonAfterDelay() {
        HomePage home = new HomePage(getDriver());
        home.clickLoadDelay();
        LoadDelayPage autoPage = new LoadDelayPage(getDriver());
        autoPage.clickButtonAppearing();
        Assert.assertTrue(autoPage.checkButtonAfterDelay());
    }

    @Test //T61 Verify eight different button web elements are clickable, with "Hide" button being last
    public void clickableZeroWidthButton() {
        HomePage home = new HomePage(getDriver());
        home.clickVisibility();
        VisibilityPage autoPage = new VisibilityPage(getDriver());
        autoPage.clickZeroWidthButton();
        Assert.assertTrue(autoPage.checkZeroWidClickable());
    }

    @Test //T62 Verify eight different button web elements are clickable, with "Hide" button being last
    public void clickableOverlapButton() {
        HomePage home = new HomePage(getDriver());
        home.clickVisibility();
        VisibilityPage autoPage = new VisibilityPage(getDriver());
        autoPage.clickOverlapButton();
        Assert.assertTrue(autoPage.checkOverlapClickable());
    }

    @Test //T63 Verify eight different button web elements are clickable, with "Hide" button being last
    public void clickableTransparentButton() {
        HomePage home = new HomePage(getDriver());
        home.clickVisibility();
        VisibilityPage autoPage = new VisibilityPage(getDriver());
        autoPage.clickTransparentButton();
        Assert.assertTrue(autoPage.checkTransparentClickable());
    }

    @Test //T64 Verify eight different button web elements are clickable, with "Hide" button being last
    public void clickableVisibilHiddenButton() {
        HomePage home = new HomePage(getDriver());
        home.clickVisibility();
        VisibilityPage autoPage = new VisibilityPage(getDriver());
        autoPage.clickVisibilHiddenButton();
        Assert.assertTrue(autoPage.checkVisibilHiddenClickable());
    }

    @Test //T65 Verify eight different button web elements are clickable, with "Hide" button being last
    public void clickableDisplayNoneButton() {
        HomePage home = new HomePage(getDriver());
        home.clickVisibility();
        VisibilityPage autoPage = new VisibilityPage(getDriver());
        autoPage.clickDisplayNonButton();
        Assert.assertTrue(autoPage.checkDisplayNonClickable());
    }

    @Test //T66 Verify eight different button web elements are clickable, with "Hide" button being last
    public void clickableOffScreenButton() {
        HomePage home = new HomePage(getDriver());
        home.clickVisibility();
        VisibilityPage autoPage = new VisibilityPage(getDriver());
        autoPage.clickOffScreenButton();
        Assert.assertTrue(autoPage.checkOffscreenClickable());
    }

    @Test //T68 Verify the three colored buttons on webpage are clickable part 2
    public void yellowButtonClickable() {
        HomePage home = new HomePage(getDriver());
        home.clickClassAttribute();
        ClassAttributePage autoPage = new ClassAttributePage(getDriver());
        autoPage.clickYellowButton();
        LOG.info("Button resulted in no popup Successful");
        Assert.assertTrue(autoPage.checkYellowClickable());
    }

    @Test //T79 Verify button name can be changed multiple times from user input
    public void multipleButtonChanges() {
        HomePage home = new HomePage(getDriver());
        home.clickTextInput();
        TextInputPage autoPage = new TextInputPage(getDriver());
        String expectedText1 = "Text Attempt #1";
        autoPage.typeInTextBox(expectedText1);
        autoPage.clickTextChangeButton();
        String actualText1 = autoPage.getTextFromButton();
        Assert.assertEquals(expectedText1, actualText1);
        LOG.info("First text button input matches as expected Successful");
        String expectedText2 = "Text Attempt #2";
        autoPage.typeInTextBox(expectedText2);
        autoPage.clickTextChangeButton();
        String actualText2 = autoPage.getTextFromButton();
        Assert.assertEquals(expectedText2, actualText2);
        LOG.info("New text button input matches as expected Successful");
    }

    @Test //T80 Verify webpage button is clickable
    public void textInputButton() {
        HomePage home = new HomePage(getDriver());
        home.clickTextInput();
        TextInputPage autoPage = new TextInputPage(getDriver());
        autoPage.clickTextChangeButton();
        Assert.assertTrue(autoPage.checkButtonUsable());
    }

}


