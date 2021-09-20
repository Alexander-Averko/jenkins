package com.example.Task3.tests;

import com.example.Task3.pages.IFramePage;
import com.example.Task3.utils.Browser;
import com.example.Task3.utils.ConfigManager;
import com.example.Task3.utils.Logger;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IFrameTest extends BaseTest {

    @Test
    public void testIFrame() {
        //Navigate to URL (host+path)
        Browser.openPage(ConfigManager.getBaseUrl() + ConfigManager.getIFrameUrl());
        IFramePage iframePage = new IFramePage();
        assertTrue(iframePage.atPage());

        //Align text left
        iframePage.alignTextLeft();
        assertTrue(iframePage.isTextAlignLeft(), "Text doesn't align left");

        //For the first half of text symbols change font size
        iframePage.changeHalfTextSize();
        assertEquals(iframePage.getInputText().substring(0,iframePage.getInputText().length()/2), iframePage.getFormattedText());
        assertEquals(iframePage.getFormattedTextSize(), "8pt", "Text size doesn't correct");

        //Click File -> New document
        iframePage.createNewDocument();
        assertTrue(iframePage.isInputTextEmpty(), "Text field doesn't empty");
        assertFalse(iframePage.isFormattedTextDisplayed() && iframePage.isTextAlignLeft(), "Document formatting doesn't default");
    }
}
