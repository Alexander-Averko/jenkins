package com.example.Task3.pages;

import com.example.Task3.elements.Container;
import com.example.Task3.elements.Slider;
import com.example.Task3.elements.TextField;
import com.example.Task3.utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SliderPage extends BaseForm {

    private Slider slider;
    private TextField sliderCount;

    public SliderPage() {
        super(new Container(By.xpath("//div[@class='sliderContainer']"), "Slider Container"), "Slider Page");
        slider = new Slider(By.xpath("//div[@class='sliderContainer']//input"), "Slider");
        sliderCount = new TextField(By.xpath("//div[@class='sliderContainer']//span[@id='range']"), "Slider count Text Field");
    }

    public String getSliderCount() {
        return sliderCount.getText();
    }


    public void clickSlider() {
        slider.click();
    }

    public void setSliderValue(int value) {
        slider.setSliderValue(value);

    }
}
