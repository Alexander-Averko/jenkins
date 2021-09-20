package com.example.Task3.pages;

import com.example.Task3.elements.BaseElement;
import com.example.Task3.utils.Logger;
import com.example.Task3.utils.Waits;

public abstract class BaseForm {


    private BaseElement uniqueElement;
    private String name;

    public BaseForm(BaseElement uniqueElement, String name) {
        this.uniqueElement = uniqueElement;
        this.name = name;
    }

    public BaseElement getUniqueElement() {
        return uniqueElement;
    }

    public boolean atPage() {
        if(!uniqueElement.isDisplayed()) Logger.info(name, "didn't open!");
        return uniqueElement.isDisplayed();
    }

    public void waitForPresent() {
        Waits.waitForPresentPage(uniqueElement.getLocator());
    }

}
