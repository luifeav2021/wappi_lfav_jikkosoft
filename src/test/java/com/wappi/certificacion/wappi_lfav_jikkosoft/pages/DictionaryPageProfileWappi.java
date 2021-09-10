package com.wappi.certificacion.wappi_lfav_jikkosoft.pages;

import com.wappi.certificacion.wappi_lfav_jikkosoft.helpers.Constant;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.io.File;

public class DictionaryPageProfileWappi extends PageObject {

    @FindBy(xpath = "//input[@id='name']")
    private WebElementFacade txtName;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElementFacade txtLatsName;

    @FindBy(xpath = "//input[@id='bornDate']")
    private WebElementFacade txtDateBirth;

    @FindBy(xpath = "//select[@id='country']")
    private WebElementFacade slcCountry;

    @FindBy(xpath = "//*[contains(text(),'Masculino')]")
    private WebElementFacade slcGenderMale;

    @FindBy(xpath = "//*[contains(text(),'Femenino')]")
    private WebElementFacade slcGenderFemale;

    @FindBy(xpath = "//button[@id='save-profile']")
    private WebElementFacade btnSaveProfile;

    @FindBy(xpath = "//input[@id='image']")
    private WebElementFacade btnFile;

    public void uploadImg() {
        try {
            File file = new File(Constant.ABSOLUTE_PATH_FILE);
            String path = file.getAbsolutePath();
            btnFile.sendKeys(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pressSave() {
        try {
            btnSaveProfile.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectGender(String gender) {
        try {
            switch (gender) {
                case Constant.GENDER_MALE:
                    slcGenderMale.click();
                    break;
                case Constant.GENDER_FEMALE:
                    slcGenderFemale.click();
                    break;
                default:
                    System.out.println("Error!!!!!!!!!!");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectCountry(String country) {
        try {
            slcCountry.selectByVisibleText(country);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterName(String name) {
        try {
            txtName.waitUntilVisible().clear();
            txtName.sendKeys(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterLastName(String LastName) {
        try {
            txtLatsName.waitUntilVisible().clear();
            txtLatsName.sendKeys(LastName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterDateBirth(String dateBirth) {
        try {
            txtDateBirth.waitUntilVisible().clear();
            txtDateBirth.sendKeys(dateBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getMessageProfile() {
        WebElementFacade messageOrder = find(By.xpath("//*[@id='confirmation-modal']/div/p"));
        return messageOrder.getText();
    }

    public String getErrorMessageFieldNameProfile() {
        WebElementFacade messageOrder = find(By.xpath("//*[@id='e-name']"));
        return messageOrder.getText();
    }

    public String getErrorMessageFieldLastNameProfile() {
        WebElementFacade messageOrder = find(By.xpath("//*[@id='e-lastName']"));
        return messageOrder.getText();
    }

    public String getErrorMessageFieldBirthDayProfile() {
        WebElementFacade messageOrder = find(By.xpath("//*[@id='e-bornDate']"));
        return messageOrder.getText();
    }

    public String getErrorMessageFieldCountryProfile() {
        WebElementFacade messageOrder = find(By.xpath("//*[@id='e-country']"));
        return messageOrder.getText();
    }
}