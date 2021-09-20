package com.example.Task3.pages;

import com.example.Task3.elements.Container;
import com.example.Task3.elements.TextField;
import org.openqa.selenium.By;

public class HoversPage extends BaseForm {

    private UserForm userOneForm;
    private UserForm userTwoForm;
    private UserForm userThreeForm;

    public HoversPage() {
        super(new TextField(By.xpath("//h3[text() = 'Hovers']"), "Hovers Page unique element"), "Hovers Page");
        userOneForm = new UserForm(new Container(By.xpath("//div[@class='figcaption']//h5[text() = 'name: user1']/../.."), "User Form Container"),
                "User One Form");
        userTwoForm = new UserForm(new Container(By.xpath("//div[@class='figcaption']//h5[text() = 'name: user2']/../.."), "User Form Container"),
                "User Two Form");
        userThreeForm = new UserForm(new Container(By.xpath("//div[@class='figcaption']//h5[text() = 'name: user3']/../.."), "User Form Container"),
                "User Three Form");
    }

    public UserForm getUserOneForm() {
        return userOneForm;
    }

    public UserForm getUserTwoForm() {
        return userTwoForm;
    }

    public UserForm getUserThreeForm() {
        return userThreeForm;
    }

    public UserForm getUserForm(String id) {
        switch (id) {
            case "1":
                return getUserOneForm();
            case "2":
                return getUserTwoForm();
            case "3":
                return getUserThreeForm();

        }
        return null;
    }
}
