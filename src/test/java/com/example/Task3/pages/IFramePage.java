package com.example.Task3.pages;

import com.example.Task3.elements.Button;
import com.example.Task3.elements.Container;
import com.example.Task3.elements.TextField;
import com.example.Task3.utils.Browser;
import com.example.Task3.utils.BrowserFactory;
import com.example.Task3.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class IFramePage extends BaseForm {
    private Button alignLeftButton;
    private Button formatButton;
    private Button fontSizeButton;
    private Button fontEightPtButton;
    private TextField inputText;
    private TextField formattedText;
    private Button fileButton;
    private Button newDocumentButton;
    private Container textEmptyTrigger;

    public IFramePage() {
        super(new TextField(By.xpath("//iframe"), "Uniq element"), "IFrame Page");
        alignLeftButton = new Button(By.xpath("//button[@aria-label='Align left']"), "Align Left Button");
        inputText = new TextField(By.xpath("//*[@id=\"tinymce\"]/*"), "Input Text Field");
        formatButton = new Button(By.xpath("//div[@role='menubar']/button[4]"), "Format DropDown Button");
        fontSizeButton = new Button(By.xpath("//div[@title='Font sizes']"), "Font Size Drop Down Button");
        fontEightPtButton = new Button(By.xpath("//div[@title='8pt']"), "Font Eight Pt Button");
        formattedText = new TextField(By.xpath("//*[@id=\"tinymce\"]//span"), "Formatted text");
        fileButton = new Button(By.xpath("//div[@role='menubar']/button[1]"), "File Button");
        newDocumentButton = new Button(By.xpath("//div[@title='New document']"), "New document Button");
        textEmptyTrigger = new Container(By.xpath("//br[@data-mce-bogus]"), "Text empty trigger");
    }

    public boolean isInputTextEmpty() {
        Browser.switchToFrame("mce_0_ifr");
        boolean returnValue  = textEmptyTrigger.isDisplayed();
        Browser.switchToDefaultContent();
        return returnValue;
    }

    public void createNewDocument() {
        fileButton.click();
        newDocumentButton.click();
    }

    public void alignTextLeft() {
        alignLeftButton.click();
    }

    public boolean isTextAlignLeft() {
        Browser.switchToFrame("mce_0_ifr");
        boolean returnValue  = inputText.getCssValue("text-align").equals("left");
        Browser.switchToDefaultContent();
        return returnValue;
    }

    public String getInputText() {
        Browser.switchToFrame("mce_0_ifr");
        String returnValue = inputText.getText();
        Browser.switchToDefaultContent();
        return returnValue;
    }

    public String getFormattedText() {
        Browser.switchToFrame("mce_0_ifr");
        String returnValue =  formattedText.getText();
        Browser.switchToDefaultContent();
        return returnValue;
    }

    public boolean isFormattedTextDisplayed() {
        Browser.switchToFrame("mce_0_ifr");
        boolean returnValue =  formattedText.isDisplayed();
        Browser.switchToDefaultContent();
        return returnValue;
    }

    public String getFormattedTextSize() {
        Browser.switchToFrame("mce_0_ifr");
        String returnValue =  formattedText.getAttribute("style");
        returnValue = returnValue.substring(returnValue.indexOf(' ') + 1, returnValue.lastIndexOf(';'));
        Browser.switchToDefaultContent();
        return returnValue;
    }

    public void changeHalfTextSize() {
        Browser.switchToFrame("mce_0_ifr");
        int value = inputText.getText().length()/2;
        Actions builder = new Actions(BrowserFactory.getDriver());
        Action clickRightArrow = builder.sendKeys(Keys.ARROW_RIGHT).build();
        Action pressShift = builder.keyDown(Keys.SHIFT).build();
        Action releaseShift = builder.keyUp(Keys.SHIFT).build();
        pressShift.perform();
        for (int i = 0; i < (value); i++) {
            clickRightArrow.perform();
        }
        releaseShift.perform();
        Browser.switchToDefaultContent();
        formatButton.click();
        fontSizeButton.click();
        fontEightPtButton.click();
    }
}
