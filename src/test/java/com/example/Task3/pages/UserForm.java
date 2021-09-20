package com.example.Task3.pages;

import com.example.Task3.elements.BaseElement;
import com.example.Task3.elements.Button;
import com.example.Task3.elements.TextField;
import org.openqa.selenium.By;

public class UserForm extends BaseForm {

    private Button viewProfileButton;
    private TextField userNameTextField;

    public UserForm(BaseElement uniqueElement, String name) {
        super(uniqueElement, name);
        viewProfileButton = new Button(By.xpath(uniqueElement.getLocatorString() + "//a"), "View Profile button");
        userNameTextField = new TextField(By.xpath(uniqueElement.getLocatorString() + "//h5"),"User Name Text Field");
    }

    public String getUserName() {
        return userNameTextField.getText().substring(userNameTextField.getText().indexOf('u'));
    }

    public String getViewProfileLink() {
        return viewProfileButton.getAttribute("href");
    }

    public void moveCursor() {
        getUniqueElement().moveCursor();
    }

    public void clickViewProfileButton() {
        viewProfileButton.click();
    }

    public boolean viewProfileButtonIsDisplayed() {
        return viewProfileButton.isDisplayed();
    }
}
