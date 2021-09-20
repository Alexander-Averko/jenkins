package com.example.Task3.utils.testsdata;

public class SliderTestData {
    private int minSliderCount;
    private int maxSliderCount;

    public SliderTestData() {
    }

    public int getMinSliderCount() {
        return minSliderCount;
    }

    public int getMaxSliderCount() {
        return maxSliderCount;
    }

    public Object[] getData() {
        return new Object[]{minSliderCount, maxSliderCount};
    }
}
