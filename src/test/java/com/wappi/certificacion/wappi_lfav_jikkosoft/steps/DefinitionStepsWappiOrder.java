package com.wappi.certificacion.wappi_lfav_jikkosoft.steps;

import com.wappi.certificacion.wappi_lfav_jikkosoft.dto.DtoWappi;
import com.wappi.certificacion.wappi_lfav_jikkosoft.helpers.Constant;
import com.wappi.certificacion.wappi_lfav_jikkosoft.steps.serenity.EndUserStepsWappi;
import cucumber.api.java.en.Then;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

public class DefinitionStepsWappiOrder {
	 @Steps
     private EndUserStepsWappi wappi;
	 private DtoWappi dtoWappi=new DtoWappi();

    @Cuando("^Luisa confirma un pedido de (.*) (.*) el cupón$")
    public void confirmAnOrder(String article, String without) {
        switch (without){
            case Constant.WITHOUT:
                wappi.requestAnOrderWithout(article);
                break;
            case Constant.WITH:
                wappi.requestAnOrdeWith(article,dtoWappi);
                break;
        }
    }
    
    @Then("^ella puede ver un mensaje en modal que dice (.*)$")
    public void canViewAMessageInModal(String message) {
        dtoWappi.setMessage(message);
        wappi.validateMessageOrder(dtoWappi);
    }

    @Y("^Luisa obtiene el código del cupón$")
    public void getTheCouponCode() {
        dtoWappi.setCoupon(wappi.getCoupon());
    }

    @Y("^Luisa observa su pedido en el listado mis pedidos$")
    public void seeYourOrderInTheListMyOrders() {
    }

    @Cuando("^Luisa elije pedir (.*) ingresando cupón (.*) inválido$")
    public void orderWithInvalidCoupon(String article, String invalidCoupon) {
        wappi.requestAnOrderInvalidCoupon(article,invalidCoupon);
    }

    @Entonces("^Luisa ve en pantalla mensaje de error (.*)$")
    public void seeErrorMessageOnScreen(String message) {
        wappi.validateMessageErrorCoupon(message);
    }

    @Cuando("^Luisa confirma más de dos veces un pedido de (.*) con el cupón$")
    public void confirmAndOrderMoreThanTwice(String article) {
        wappi.requestAnOrdeMoreThanTwice(article,dtoWappi);
    }
}
