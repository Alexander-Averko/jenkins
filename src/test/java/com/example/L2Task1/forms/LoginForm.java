package com.example.L2Task1.forms;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import com.example.L2Task1.utils.RandomUtil;
import org.openqa.selenium.By;

import java.util.List;

public class LoginForm extends Form {
    private final ITextBox txbPassword = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "Password text box");
    private final ITextBox txbEmail = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Your email']"), "Email text box");
    private final ITextBox txbDomain = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Domain']"), "Domain text box");
    private final IButton dropDownListButton = getElementFactory().getButton(By.xpath("//*[@class='dropdown__field']"), "Dropdown list button");
    private final List<IButton> domainButtons = getElementFactory().findElements(By.xpath("//*[@class='dropdown__list-item']"),
            ElementType.BUTTON, ElementsCount.ANY, ElementState.EXISTS_IN_ANY_STATE);
    private final ICheckBox conditionCheckBox = getElementFactory().getCheckBox(By.xpath("//label[@class='checkbox__label']"), "Accept terms condition checkbox");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//a[text()='Next']"), "Next card button");

    public LoginForm() {
        super(By.xpath("//*[@class='login-form__container']//form"), "Login form");
    }

    public void setPassword(String text) {
        txbPassword.clearAndType(text);
    }

    public void setEmail(String text) {
        txbEmail.clearAndType(text);
    }

    public void setDomain(String text) {
        txbDomain.clearAndType(text);
        dropDownListButton.click();
        domainButtons.get(0).state().waitForDisplayed();
        domainButtons.get(RandomUtil.generateRandomInt(0, domainButtons.size() - 1)).click();
    }

    public void acceptTermsCondition() {
        if (!conditionCheckBox.isChecked()) {
            conditionCheckBox.check();
        }
    }

    public void clickNext() {
        nextButton.clickAndWait();
    }
}
