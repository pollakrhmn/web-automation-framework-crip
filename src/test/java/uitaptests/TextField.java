package uitaptests;

import base.CommonAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import uitappages.HomePage;
import uitappages.OverlappedElementPage;
import uitappages.ShadowDOMPage;
import uitappages.TextInputPage;

public class TextField extends CommonAPI {

    private final Logger LOG = LoggerFactory.getLogger(TextField.class);

    @Test //T27 Verify the text box of "Id" can be typed into
    public void idTextBoxTyping() {
        HomePage home = new HomePage(getDriver());
        home.clickOverlappedElement();
        OverlappedElementPage autoPage = new OverlappedElementPage(getDriver());
        String expectedText = "12345abcd";
        autoPage.typeId(expectedText);
        Assert.assertEquals(expectedText, autoPage.getActualIDText());
        LOG.info("Typing into ID text box successful");
    }

    @Test //T40 Verify button name is changed to the text input from user
    public void buttonTextChange() {
        HomePage home = new HomePage(getDriver());
        home.clickTextInput();
        TextInputPage autoPage = new TextInputPage(getDriver());
        String expectedText = "This is dummy text";
        autoPage.typeInTextBox(expectedText);
        autoPage.clickTextChangeButton();
        Assert.assertEquals(autoPage.getTextFromButton(), expectedText);
        LOG.info("Textbox input and Button-text match successful");
    }

    @Test //T67 Verify the text box of "Name" can be typed into
    public void nameTextBoxTyping() {
        HomePage home = new HomePage(getDriver());
        home.clickOverlappedElement();
        OverlappedElementPage autoPage = new OverlappedElementPage(getDriver());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", autoPage.nameElement());
        String expectedText = "Row";
        autoPage.typeName(expectedText);
        Assert.assertEquals(expectedText, autoPage.getActualNameText());
        LOG.info("Typing into Name textbox successful");
    }


    @Test //T78 Verify text box can be typed into
    public void textBoxTextInput() {
        HomePage home = new HomePage(getDriver());
        home.clickTextInput();
        TextInputPage autoPage = new TextInputPage(getDriver());
        String inputText = "random dummy text";
        autoPage.typeInTextBox(inputText);
        Assert.assertEquals(inputText, autoPage.getTextFromBox());
        LOG.info("The input text and expected text match Successful");
    }

//    @Test //T77 Verify text box can be typed into
//    public void textBoxGUID() {
//        HomePage home = new HomePage(getDriver());
//        home.clickShadowDOM();
//        ShadowDOMPage autoPage = new ShadowDOMPage(getDriver());
//        autoPage.typeInGUIDTextBox("random text");
//    }
    
}



