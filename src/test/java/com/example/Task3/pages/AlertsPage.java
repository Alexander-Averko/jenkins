package com.example.Task3.pages;

import com.example.Task3.elements.Button;
import com.example.Task3.elements.TextField;
import org.openqa.selenium.By;

public class AlertsPage extends BaseForm {

    private static Button alertButton = new Button(By.xpath("//button[@onclick='jsAlert()']"), "JS Alert Button");
    private Button confirmButton;
    private Button promptButton;
    private TextField resultTextField;

    public AlertsPage() {
        super(alertButton, "JS Alerts Page");
        confirmButton = new Button(By.xpath("//button[@onclick='jsConfirm()']"), "JS Confirm Button");
        promptButton = new Button(By.xpath("//button[@onclick='jsPrompt()']"), "JS Prompt Button");
        resultTextField = new TextField(By.xpath("//p[@id='result']"), "Result Text Field");
    }

    public void clickAlertButton() {
        alertButton.click();
    }
    public void clickConfirmButton() {
        confirmButton.click();
    }
    public void clickPromptButton() {
        promptButton.click();
    }
    public String getResultText () {
        return resultTextField.getText();
    }


}
