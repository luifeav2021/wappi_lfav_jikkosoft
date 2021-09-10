package com.wappi.certificacion.wappi_lfav_jikkosoft.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://automation-wappi.vercel.app/login")
public class DictionaryPageLoginWappi extends PageObject {

    @FindBy(xpath = "//input[@id='username']")
    private WebElementFacade txtUserName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElementFacade txtPassword;

    @FindBy(xpath = "//button[@id='button-login']")
    private WebElementFacade btnLogin;

    @FindBy(xpath = "//*[@id='e-username']")
    private WebElementFacade lblEUserName;

    @FindBy(xpath = "//*[@id='e-password']")
    private WebElementFacade lblEPassword;

    @FindBy(xpath = "/html/body/app-root/app-login/div/div/h1")
    private WebElementFacade lblTitleLogin;


    public String getTitleLogin(){
        return lblTitleLogin.getText();
    }

    public void enterUserName(String userName) {
        txtUserName.waitUntilVisible().click();
        txtUserName.sendKeys(userName);

    }

    public void enterPassword(String password) {
        txtPassword.waitUntilVisible().click();
        txtPassword.type(password);
    }

    public void pressEnter(){
        btnLogin.click();
    }

    public String getErrorMessageUserName(){
        return lblEUserName.getText();
    }

    public String getErrorMessagePassword(){
        return lblEPassword.getText();
    }
}