package com.example.L2Task1.tests;

import aquality.selenium.browser.AqualityServices;
import com.example.L2Task1.configuration.Configuration;
import com.example.L2Task1.forms.pages.RegistrationPage;
import com.example.L2Task1.forms.pages.WelcomePage;
import com.example.L2Task1.steps.ChooseInterestsStep;
import com.example.L2Task1.steps.LoginStep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserinterfaceWebAppTest extends BaseTest {
    private final LoginStep loginStep = new LoginStep();
    private final ChooseInterestsStep chooseInterestsStep = new ChooseInterestsStep();

    @Test
    public void testRegistration() {
        welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().isDisplayed());

        AqualityServices.getLogger().info("Go to next page");
        welcomePage.clickNextPageLink();
        registrationPage = new RegistrationPage();
        Assert.assertTrue(registrationPage.getLoginForm().state().isDisplayed());

        loginStep.login();
        Assert.assertTrue(registrationPage.getAvatarAndInterestsForm().state().isDisplayed(), "Next card isn't open");

        AqualityServices.getLogger().info("Choose three random interests, upload any image and click \"Next\"");
        chooseInterestsStep.chooseRandomInterests();
        registrationPage.getAvatarAndInterestsForm().uploadAvatar(System.getProperty("user.dir") + Configuration.getDefaultImagePath());
        registrationPage.getAvatarAndInterestsForm().clickNext();
        //Assert.assertTrue(registrationPage.getPersonalDetailsForm().state().waitForDisplayed(), "Next card isn't open");
    }

    @Test
    public void testHideHelpForm() {
        welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().isDisplayed());

        AqualityServices.getLogger().info("Go to next page");
        welcomePage.clickNextPageLink();
        registrationPage = new RegistrationPage();
        Assert.assertTrue(registrationPage.getLoginForm().state().isDisplayed());

        AqualityServices.getLogger().info("Hide Help Form");
        registrationPage.getHelpForm().hideForm();
        Assert.assertTrue(registrationPage.getHelpForm().isHide(), "Help form isn't hide");
    }

    @Test
    public void testAcceptCookies() {
        welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().isDisplayed());

        AqualityServices.getLogger().info("Go to next page");
        welcomePage.clickNextPageLink();
        registrationPage = new RegistrationPage();
        Assert.assertTrue(registrationPage.getLoginForm().state().isDisplayed());

        AqualityServices.getLogger().info("Accept cookies");
        registrationPage.getCookiesForm().acceptCookies();
        Assert.assertFalse(registrationPage.getCookiesForm().state().isDisplayed(), "Cookies isn't accept");
    }

    @Test
    public void testTimer() {
        welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().isDisplayed());

        AqualityServices.getLogger().info("Go to next page");
        welcomePage.clickNextPageLink();
        registrationPage = new RegistrationPage();
        Assert.assertTrue(registrationPage.getLoginForm().state().isDisplayed());

        AqualityServices.getLogger().info("Check that the timer starts counting from zero after opening the page");
        Assert.assertTrue(registrationPage.isTimerStartFromZero(), "Timer isn't start from zero");
    }
}
