package com.example.Task3.alerts;

import com.example.Task3.utils.Logger;
import com.example.Task3.utils.Waits;

public class Alert {
    private org.openqa.selenium.Alert alert;
    private String name;

    public Alert(String name) {
        this.name = name;
    }


    private org.openqa.selenium.Alert getAlert() {
        return alert;
    }

    public void accept() {
        Logger.info(name, "accept");
        getAlert().accept();
    }

    public void dismiss() {
        Logger.info(name, "dismiss");
        getAlert().dismiss();
    }

    public void sendKeys(String text) {
        Logger.info(name, "send keys: " + text);
        getAlert().sendKeys(text);
    }

    public String getText() {
        return alert.getText();
    }

    public void waitForPresent() {
        alert = Waits.waitForPresentAlert();
    }
}
