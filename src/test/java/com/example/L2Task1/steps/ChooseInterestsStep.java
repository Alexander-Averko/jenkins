package com.example.L2Task1.steps;

import com.example.L2Task1.forms.pages.RegistrationPage;
import com.example.L2Task1.utils.TestDataProvider;

public class ChooseInterestsStep {
    public void chooseRandomInterests() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.getAvatarAndInterestsForm().unSelectAll();
        registrationPage.getAvatarAndInterestsForm().selectInterests(TestDataProvider.getInterestsCount());
    }
}
