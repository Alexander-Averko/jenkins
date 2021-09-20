package com.example.Task3.elements;

import com.example.Task3.utils.BrowserFactory;
import com.example.Task3.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public abstract class BaseElement {
    private By locator;


    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public boolean isDisplayed() {
        if (findElements().isEmpty()) Logger.info(name, "is not displayed");
        return !findElements().isEmpty();
    }

    public void click() {
        Logger.info(name, "click");
        findElement().click();
    }

    public String getAttribute(String attribute) {
        return findElement().getAttribute(attribute);
    }

    public String getCssValue(String value) {
        return findElement().getCssValue(value);
    }

    public String getText() {
        return findElement().getText();
    }

    public By getLocator() {
        return locator;
    }

    public String getLocatorString() {
        return locator.toString().substring(locator.toString().indexOf('/'));
    }

    public String getName() {
        return name;
    }

    public void moveCursor() {
        Actions builder = new Actions(BrowserFactory.getDriver());
        builder.moveToElement(findElement());
        Action moveCursor = builder.build();
        moveCursor.perform();
    }

    protected WebElement findElement() {
        try {
            return BrowserFactory.getDriver().findElement(locator);
        } catch (NoSuchElementException e) {
            Logger.error(name, "no such element");
        }
        return BrowserFactory.getDriver().findElement(locator);
    }

    protected List<WebElement> findElements() {
        return BrowserFactory.getDriver().findElements(locator);
    }
}
