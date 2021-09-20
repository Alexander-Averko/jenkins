package com.example.Task3.tests;

import com.example.Task3.pages.SliderPage;
import com.example.Task3.utils.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SliderTest extends BaseTest{

    @Test(dataProvider = "getSliderTestData", dataProviderClass = DataProviderManger.class)
    public void testSlider0(int minSlideCount, int maxSlideCount) {
        //Navigate to URL
        Browser.openPage(ConfigManager.getBaseUrl() + ConfigManager.getSliderUrl());
        SliderPage sliderPage = new SliderPage();
        assertTrue(sliderPage.atPage(), "This isn't Slider page!");

        //Set random value
        int randomValue = RandomUtil.generateRandomInt(minSlideCount, maxSlideCount);
        sliderPage.setSliderValue(randomValue);
        assertEquals(sliderPage.getSliderCount(), Integer.toString(randomValue), "Slider value is not valid");
    }
}
