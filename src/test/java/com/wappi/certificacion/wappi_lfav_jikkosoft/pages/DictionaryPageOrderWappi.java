package com.wappi.certificacion.wappi_lfav_jikkosoft.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class DictionaryPageOrderWappi extends PageObject {

    @FindBy(xpath = "//*[@id='coupon-0']/td[1]")
    private WebElementFacade txtCoupon;
    
    public String getCoupon() {    	
    		return txtCoupon.waitUntilVisible().getText();		
    }
    
      
}