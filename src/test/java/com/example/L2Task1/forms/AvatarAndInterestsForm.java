package com.example.L2Task1.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import com.example.L2Task1.utils.FileUploadUtil;
import com.example.L2Task1.utils.FileUtil;
import com.example.L2Task1.utils.RandomUtil;
import org.openqa.selenium.By;

import java.util.List;

public class AvatarAndInterestsForm extends Form {
    private final By checkBoxInterestsLocator = By.xpath("//label[@class='checkbox__label' and @for !='interest_selectall' and @for !='interest_unselectall']");

    private final ICheckBox checkBoxUnselectAll = getElementFactory().getCheckBox(By.xpath("//label[@for='interest_unselectall']"), "CheckBox Unselect All");
    private final IButton uploadButton = getElementFactory().getButton(By.xpath("//a[@class='avatar-and-interests__upload-button']"), "Upload button");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//button[text()='Next']"), "Next card button");

    public AvatarAndInterestsForm() {
        super(By.xpath("//*[@class='avatar-and-interests__form']"), "Avatar and Interests form");
    }

    public void unSelectAll() {
        if (!checkBoxUnselectAll.isChecked())
            checkBoxUnselectAll.check();
    }

    public void selectInterests(int num) {
        List<ICheckBox> interests = getElementFactory().findElements(checkBoxInterestsLocator, ElementType.CHECKBOX);
        num = Math.min(num, interests.size());
        for (int i = 0; i < num; i++) {
            int el = RandomUtil.generateRandomInt(0, interests.size());
            interests.get(el).check();
            interests.remove(el);
        }
    }

    public void clickNext() {
        nextButton.clickAndWait();
    }

    public void uploadAvatar(String filePath) {
        if (!FileUtil.fileExists(filePath)) {
            AqualityServices.getLogger().error("File not found!");
            return;
        }
        uploadButton.clickAndWait();
        FileUploadUtil.uploadFile(filePath);
    }
}
