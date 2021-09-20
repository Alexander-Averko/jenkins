package com.example.L2Task1.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {
    private final IButton sendToBottomButton = getElementFactory().getButton(By.xpath("//button[contains(@class, 'help-form__send-to-bottom-button')]"),
            "Send to bottom button");

    public HelpForm() {
        super(By.xpath("//*[@class='help-form']"), "Help Form");
    }

    public void hideForm() {
        sendToBottomButton.clickAndWait();
    }

    public boolean isHide() {
        return getElementFactory().getLabel(By.xpath("//h2[@class='help-form__title']"), "").state().waitForNotDisplayed();
    }
}
