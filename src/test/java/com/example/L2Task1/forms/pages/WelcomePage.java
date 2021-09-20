package com.example.L2Task1.forms.pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WelcomePage extends Form {
    private final ILink nextPageLink = getElementFactory().getLink(By.xpath("//a[@class='start__link']"), "next page link");

    public WelcomePage() {
        super(By.xpath("//button[@class='start__button']"), "Welcome page");
    }

    public void clickNextPageLink() {
        nextPageLink.click();
    }
}
