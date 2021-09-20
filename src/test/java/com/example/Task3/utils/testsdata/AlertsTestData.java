package com.example.Task3.utils.testsdata;

public class AlertsTestData {

    private String jsAlertText;
    private String jsAlertResultText;
    private String jsConfirmText;
    private String jsConfirmResultText;
    private String jsPromptText;
    private String jsPromptResultText;
    private int lengthRandomText;

    public AlertsTestData() {
    }

    public String getJsAlertText() {
        return jsAlertText;
    }

    public String getJsAlertResultText() {
        return jsAlertResultText;
    }

    public String getJsConfirmText() {
        return jsConfirmText;
    }

    public String getJsConfirmResultText() {
        return jsConfirmResultText;
    }

    public String getJsPromptText() {
        return jsPromptText;
    }

    public String getJsPromptResultText() {
        return jsPromptResultText;
    }

    public int getLengthRandomText() {
        return lengthRandomText;
    }

    public Object[] getData() {
        return new Object[]{
                jsAlertText,
                jsAlertResultText,
                jsConfirmText,
                jsConfirmResultText,
                jsPromptText,
                jsPromptResultText,
                lengthRandomText
        };
    }


}
