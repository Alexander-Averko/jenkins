package com.example.L2Task1.steps;

import aquality.selenium.browser.AqualityServices;
import com.example.L2Task1.forms.pages.RegistrationPage;
import com.example.L2Task1.utils.RandomUtil;

public class LoginStep {
    public void login() {
        RegistrationPage registrationPage = new RegistrationPage();
        AqualityServices.getLogger().info("Enter random valid password, email, accept terms condition and click \"Next\"");
        String password = RandomUtil.generateRandomValidPassword();
        registrationPage.getLoginForm().setPassword(password);
        String email = RandomUtil.generateRandomValidEmail(password);
        registrationPage.getLoginForm().setEmail(email);
        registrationPage.getLoginForm().setDomain(RandomUtil.generateRandomAlphabeticString(5));
        registrationPage.getLoginForm().acceptTermsCondition();
        registrationPage.getLoginForm().clickNext();
    }
}
