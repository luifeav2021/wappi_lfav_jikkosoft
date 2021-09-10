package com.wappi.certificacion.wappi_lfav_jikkosoft.steps.serenity;


import com.wappi.certificacion.wappi_lfav_jikkosoft.dto.DtoWappi;
import com.wappi.certificacion.wappi_lfav_jikkosoft.helpers.Constant;
import com.wappi.certificacion.wappi_lfav_jikkosoft.pages.DictionaryPageHomeWappi;
import com.wappi.certificacion.wappi_lfav_jikkosoft.pages.DictionaryPageLoginWappi;
import com.wappi.certificacion.wappi_lfav_jikkosoft.pages.DictionaryPageOrderWappi;
import com.wappi.certificacion.wappi_lfav_jikkosoft.pages.DictionaryPageProfileWappi;

import net.thucydides.core.annotations.Step;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class EndUserStepsWappi {

    private DictionaryPageLoginWappi loginWappi;
    private DictionaryPageHomeWappi homeWappi;
    private DictionaryPageProfileWappi profileWappi;
    private DictionaryPageOrderWappi orderWappi;
    private DtoWappi dtoWappi = new DtoWappi();
    private WebDriver driver;

    @Step
    public void openBrowser() {
        loginWappi.open();
    }

    @Step
    public void loginWappi(DtoWappi dtoWappi) {
        loginWappi.enterUserName(dtoWappi.getUserName());
        loginWappi.enterPassword(dtoWappi.getPassword());
        loginWappi.pressEnter();
    }

    @Step
    public void pressMenu(String menu) {
        homeWappi.enterMenu(menu);
    }

    @Step
    public void profileForm(DtoWappi dtoWappi) {
        profileWappi.enterName(dtoWappi.getName());
        profileWappi.enterLastName(dtoWappi.getLastName());
        profileWappi.enterDateBirth(dtoWappi.getDateBirth());
        profileWappi.selectCountry(dtoWappi.getCountry());
        profileWappi.selectGender(dtoWappi.getGender());
        profileWappi.uploadImg();
        profileWappi.pressSave();
    }

    @Step
    public void validateFirstTitle(DtoWappi dtoWappi) {
        Assert.assertTrue("Título diferente de " + dtoWappi.getFirstTitle(), dtoWappi.getFirstTitle().equals(homeWappi.getTitleHome()));
    }

    @Step
    public void validateSecondTitle(DtoWappi dtoWappi) {
        homeWappi.enterSignOff();
        Assert.assertTrue("Título diferente de " + dtoWappi.getSecondTitle(), dtoWappi.getSecondTitle().equals(loginWappi.getTitleLogin()));
    }

    @Step
    public void validateMessage(DtoWappi dtoWappi) {
        Assert.assertTrue("Mensaje de error diferente de " + dtoWappi.getErrorMessage(), dtoWappi.getErrorMessage().equals(homeWappi.getTitleHome()));
    }

    @Step
    public void validateErrorMessagePassword(DtoWappi dtoWappi) {
        Assert.assertTrue("Mensaje de error diferente de " + dtoWappi.getErrorMessage(), dtoWappi.getErrorMessage().equals(loginWappi.getErrorMessagePassword()));
    }

    @Step
    public void validateErrorMessageUserName(DtoWappi dtoWappi) {
        Assert.assertTrue("Mensaje de error diferente de " + dtoWappi.getErrorMessage(), dtoWappi.getErrorMessage().equals(loginWappi.getErrorMessageUserName()));
    }

    @Step
    public String getCoupon() {
        homeWappi.enterWelcomeCoupon();
        homeWappi.pressModal();
        pressMenu(Constant.OPTION_MENU_COUPON);
        return homeWappi.getCodeCoupon();
    }

    @Step
    public void requestAnOrderWithout(String article) {
        if (validatePrice()) {
            homeWappi.priceOrder();
        }
        chooseItem(article);
        homeWappi.pressOrderConfirm();
    }

    @Step
    public void validateMessageOrder(DtoWappi dtoWappi) {
        Assert.assertTrue("Mensaje de confirmación distinto de " + dtoWappi.getMessage(), homeWappi.getMessageOrder(dtoWappi.getMessage()).contains(dtoWappi.getMessage()));

    }

    @Step
    public void validateMessageUpdateProfile(String message) {
        Assert.assertTrue("Mensaje de error diferente de " + message, message.equals(profileWappi.getMessageProfile()));
    }

    @Step
    public void validateMessageErrorFieldProfile(DtoWappi dtoWappi) {
        switch (dtoWappi.getField()) {
            case Constant.FIELD_NAME_PROFILE:
                Assert.assertTrue("Mensaje de error diferente de " + dtoWappi.getErrorMessage(), dtoWappi.getErrorMessage().equals(profileWappi.getErrorMessageFieldNameProfile()));
                break;
            case Constant.FIELD_LASTNAME_PROFILE:
                Assert.assertTrue("Mensaje de error diferente de " + dtoWappi.getErrorMessage(), dtoWappi.getErrorMessage().equals(profileWappi.getErrorMessageFieldLastNameProfile()));
                break;
            case Constant.FIELD_BIRTHDAY_PROFILE:
                Assert.assertTrue("Mensaje de error diferente de " + dtoWappi.getErrorMessage(), dtoWappi.getErrorMessage().equals(profileWappi.getErrorMessageFieldBirthDayProfile()));
                break;
            case Constant.FIELD_COUNTRY_PROFILE:
                Assert.assertTrue("Mensaje de error diferente de " + dtoWappi.getErrorMessage(), dtoWappi.getErrorMessage().equals(profileWappi.getErrorMessageFieldCountryProfile()));
                break;
            default:
                System.out.println("Error, campo no identificado. " + dtoWappi.getField());
        }
    }

    @Step
    public boolean validatePrice() {
        if (homeWappi.getTextPrice() != Constant.PRICE_PREMIUM_HAM)
            return true;
        else
            return false;
    }

    @Step
    public void requestAnOrdeWith(String article, DtoWappi dtoWappi1) {

        homeWappi.pressMenuBegin();
        if (homeWappi.getTitleBegin().equals(Constant.TITLE_BEGIN)) {
            if (validatePrice()) {
                homeWappi.priceOrder();
            }
            chooseItem(article);
            homeWappi.enterCoupon(dtoWappi1.getCoupon());
            homeWappi.pressOrderConfirm();
        }else{
            System.out.println("Error, no estas en pagina de inicio. ");
        }
    }

    @Step
    public void validateOrderInTheListMyOrders() {
        homeWappi.closeModalOders();
        homeWappi.openListMyOders();
        Assert.assertTrue("Titulo de menú pedidos es diferente de " + Constant.TITLE_ORDERS, Constant.TITLE_ORDERS.equals(homeWappi.getTitleMyOrders()));
    }

    @Step
    public void requestAnOrderInvalidCoupon(String article, String invalidCoupon) {
        if (validatePrice()) {
            homeWappi.priceOrder();
        }
        chooseItem(article);
        homeWappi.enterCoupon(invalidCoupon);
        homeWappi.pressOrderConfirm();
    }

    @Step
    public void validateMessageErrorCoupon(String message) {
        Assert.assertTrue("Mensaje de error es diferente de " + message, message.equals(homeWappi.getMessageErrorCoupon()));
    }

    @Step
    public void requestAnOrdeMoreThanTwice(String article, DtoWappi dtoWappi1) {
        homeWappi.pressMenuBegin();
        for (int i=0; i<=2; i++) {
            if (validatePrice()) {
                homeWappi.priceOrder();
            }
            chooseItem(article);
            homeWappi.enterCoupon(dtoWappi1.getCoupon());
            homeWappi.pressOrderConfirm();
            if (i!=2){
                homeWappi.closeModalOrderConfirmation();
            }
        }


        //if(homeWappi.getMessageConfirmationOrder().equals(Constant.MESSAGE_CONFIRMATION_PEDIDO)){
    }

    @Step
    public void chooseItem(String article){
        switch (article) {
            case Constant.ARTICLE_SUNFLOWER_OIL:
                homeWappi.requestOrderOil();
                break;
            case Constant.ARTICLE_HALVED_BREAD:
                homeWappi.requestOrderHalvedBread();
                break;
            case Constant.ARTICLE_PREMIUM_HAM:
                homeWappi.requestOrderHam();
                break;
            default:
                System.out.println("Error, articulo no identificado. " + article);
        }
    }
}