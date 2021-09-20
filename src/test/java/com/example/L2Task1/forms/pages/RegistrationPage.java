package com.example.L2Task1.forms.pages;

import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import com.example.L2Task1.forms.*;
import org.openqa.selenium.By;

public class RegistrationPage extends Form {
    private final LoginForm loginForm = new LoginForm();
    private final AvatarAndInterestsForm avatarAndInterestsForm = new AvatarAndInterestsForm();
    private final PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm();
    private final HelpForm helpForm = new HelpForm();
    private final CookiesForm cookiesForm = new CookiesForm();

    private final ITextBox timerTextBox = getElementFactory().getTextBox(By.xpath("//*[@class='view__content']//*[contains(@class,'timer')]"), "Timer text box");

    public RegistrationPage() {
        super(By.xpath("//*[@class='login-form']"), "Register Page");
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public AvatarAndInterestsForm getAvatarAndInterestsForm() {
        return avatarAndInterestsForm;
    }

    public PersonalDetailsForm getPersonalDetailsForm() {
        return personalDetailsForm;
    }

    public HelpForm getHelpForm() {
        return helpForm;
    }

    public CookiesForm getCookiesForm() {
        return cookiesForm;
    }

    public boolean isTimerStartFromZero() {
        return timerTextBox.getText().equals("00:00:00");
    }
}
