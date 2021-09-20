package com.example.Task3.elements;

import com.example.Task3.utils.BrowserFactory;
import com.example.Task3.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Slider extends BaseElement{

    public Slider(By locator, String name) {
        super(locator, name);
    }
    public float getSliderStep() {
        return Float.parseFloat(getAttribute("step"));
    }
    public void setSliderValue(int value) {
        Actions builder = new Actions(BrowserFactory.getDriver());
        Action clickRightArrow = builder.sendKeys(Keys.ARROW_RIGHT).build();
        Action clickLeftArrow = builder.sendKeys(Keys.ARROW_LEFT).build();
        click();
        Logger.info(getName(), "set value: " + value);
        for (int i = 0; i < (5); i++) {
            clickLeftArrow.perform();
        }
        for (int i = 0; i < (value / getSliderStep()); i++) {
            clickRightArrow.perform();
        }

    }
}
