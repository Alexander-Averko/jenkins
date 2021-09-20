package com.example.Task3.pages;

import com.example.Task3.elements.TextField;
import org.openqa.selenium.By;

public class BasicAuthPage extends BaseForm {

    private static TextField congratsTextField = new TextField(By.xpath("//p['contains(Congratulations! You must have the proper credentials.)']"),
            "Congrats Text Field");

    public BasicAuthPage() {
        super(congratsTextField, "Basic Authorisation Page");
    }

    public boolean congratsTextIsDisplayed() {
        return congratsTextField.isDisplayed();
    }
}
