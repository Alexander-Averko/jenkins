package com.example.L2Task1.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CookiesForm extends Form {
    private final IButton acceptCookiesButton = getElementFactory().getButton(By.xpath("//button[text()='Not really, no']"), "Accept cookies button");

    public CookiesForm() {
        super(By.xpath("//*[@class='cookies']"), "Cookies form");
    }

    public void acceptCookies() {
        acceptCookiesButton.click();
    }
}
