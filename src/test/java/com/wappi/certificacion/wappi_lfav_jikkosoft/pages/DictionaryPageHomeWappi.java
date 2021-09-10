package com.wappi.certificacion.wappi_lfav_jikkosoft.pages;

import org.openqa.selenium.By;

import com.wappi.certificacion.wappi_lfav_jikkosoft.helpers.Constant;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class DictionaryPageHomeWappi extends PageObject {

    @FindBy(xpath = "/html/body/app-root/app-home/div/div/h1")
    private WebElementFacade lblTitle;

    @FindBy(xpath = "/html/body/app-root/app-home/app-nav-bar/nav/ul[2]/li[2]/a")
    private WebElementFacade btnSignOff;

    @FindBy(xpath = "/html/body/app-root/app-home/app-nav-bar/nav/ul[1]/li[4]/a")
    private WebElementFacade lnkProfile;

    @FindBy(xpath = "/html/body/app-root/app-coupons/app-nav-bar/nav/ul[1]/li[2]/a")
    private WebElementFacade lnkCoupon;

    @FindBy(xpath = "/html/body/app-root/app-home/app-nav-bar/nav/ul[1]/li[1]/a")
    private WebElementFacade lnkBegin;

    @FindBy(xpath = "//button[@id='welcome-coupon']")
    private WebElementFacade btnWelcomeCoupon;

    @FindBy(xpath = "//*[@id='coupon-modal']/div/span[1]")
    private WebElementFacade divModal;

    @FindBy(xpath = "//*[@id='offer-0']/td[7]/button")
    private WebElementFacade btnRequestBread;

    @FindBy(xpath = "//*[@id='coupon']")
    private WebElementFacade txtCoupon;

    @FindBy(xpath = "//button[@id='order-confirm']")
    private WebElementFacade btnOrderConfirm;

    @FindBy(xpath = "//*[@id='offer-0']/td[3]")
    private WebElementFacade txtPrice;

    @FindBy(xpath = "//*[@id='offer-1']/td[7]/button")
    private WebElementFacade btnRequestHam;

    @FindBy(xpath = "//*[@id='offer-2']/td[7]/button")
    private WebElementFacade btnRequestOil;

    @FindBy(xpath = "//*[@id='price-order']")
    private WebElementFacade btnPriceOrder;

    @FindBy(xpath = "//*[@id='coupon-0']/td[1]")
    private WebElementFacade txtCouponCode;

    @FindBy(xpath = "/html/body/app-root/app-coupons/app-nav-bar/nav/ul[1]/li[1]/a")
    private WebElementFacade txtInicioMenu;

    @FindBy(xpath = "/html/body/app-root/app-home/div/div/h1")
    private WebElementFacade txtTituloInicio;

    @FindBy(xpath = "//*[@id='confirmation-modal']/div/span")
    private WebElementFacade btnCloseModalOrders;

    @FindBy(xpath = "/html/body/app-root/app-home/app-nav-bar/nav/ul[1]/li[3]/a")
    private WebElementFacade menuListMyOrders;

    @FindBy(xpath = "//*[@id='e-coupon']")
    private WebElementFacade txtMessageErrorCoupon;

    @FindBy(xpath = "//*[@id='confirmation-modal']/div/span")
    private WebElementFacade btnCloseModalOrderConfirmation;

    public void closeModalOrderConfirmation() {
        btnCloseModalOrderConfirmation.waitUntilVisible().click();
    }

    public String getMessageErrorCoupon() {
        WebElementFacade messageOrder = find(By.xpath("//*[@id='e-coupon']"));
        return messageOrder.getText();
    }

    public void openListMyOders() {
        menuListMyOrders.waitUntilVisible().click();
    }

    public void closeModalOders() {
        btnCloseModalOrders.waitUntilVisible().click();
    }

    public String getTitleBegin() {
        return txtTituloInicio.getText();
    }

    public void pressMenuBegin() {
        txtInicioMenu.waitUntilVisible().click();
    }

    public void pressOrderConfirm() {
        btnOrderConfirm.waitUntilVisible().click();
    }

    public void enterCoupon(String coupon) {
        txtCoupon.waitUntilVisible().click();
        txtCoupon.sendKeys(coupon);
    }

    public void requestOrderHalvedBread() {
        btnRequestBread.waitUntilVisible().click();
    }

    public void requestOrderHam() {
        btnRequestHam.waitUntilVisible().click();
    }

    public void requestOrderOil() {
        btnRequestOil.waitUntilVisible().click();
    }

    public void priceOrder() {
        btnPriceOrder.waitUntilVisible().click();
    }

    public void pressModal() {
        divModal.waitUntilVisible().click();
    }

    public void enterWelcomeCoupon() {
        btnWelcomeCoupon.waitUntilVisible().click();
    }

    public String getTitleHome() {
        return lblTitle.getText();
    }

    public void enterSignOff() {
        btnSignOff.click();
    }

    public void enterMenu(String menu) {
        try {
            switch (menu) {
                case Constant.OPTION_MENU_PROFILE:
                    lnkProfile.waitUntilVisible().click();
                    break;
                case Constant.OPTION_MENU_COUPON:
                    lnkCoupon.waitUntilVisible().click();
                    break;
                default:
                    lnkBegin.waitUntilVisible().click();
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getMessageOrder(String message) {
        WebElementFacade messageOrder = find(By.xpath("//p[@class='confirmation-modal-info' and contains(text(),'" + message + "')]"));
        return messageOrder.getText();
    }

    public String getTitleMyOrders() {
        WebElementFacade messageOrder = find(By.xpath("/html/body/app-root/app-orders/div/div/h1"));
        return messageOrder.getText();
    }



    public String getTextPrice() {
        return txtPrice.getText();
    }

    public String getCodeCoupon() {
        return txtCouponCode.getText();
    }

    public String getMessageConfirmationOrder() {
        WebElementFacade messageOrder = find(By.xpath("//*[@id='confirmation-modal']/div/p"));
        return messageOrder.getText();
    }

}