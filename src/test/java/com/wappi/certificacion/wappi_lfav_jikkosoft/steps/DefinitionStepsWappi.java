package com.wappi.certificacion.wappi_lfav_jikkosoft.steps;

import com.wappi.certificacion.wappi_lfav_jikkosoft.dto.DtoWappi;
import com.wappi.certificacion.wappi_lfav_jikkosoft.steps.serenity.EndUserStepsWappi;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

public class DefinitionStepsWappi {

    @Steps
    EndUserStepsWappi wappi;
    DtoWappi dtoWappi=new DtoWappi();

    @Dado("^que Luisa carga la página wappi$")
    public void loadTheMainPage() {
        wappi.openBrowser();
    }

    @Cuando("^Luisa inicia sesión con el usuario (.*) y la contraseña (.*)$")
    public void logIn(String strUuserName, String strPassword) throws InterruptedException {
        dtoWappi.setUserName(strUuserName);
        dtoWappi.setPassword(strPassword);
        wappi.loginWappi(dtoWappi);
    }

    @Entonces("^Luisa puede ver en pantalla título (.*)$")
    public void canSeeOnScreen(String strFirstTitle) {
        dtoWappi.setFirstTitle(strFirstTitle);
        wappi.validateFirstTitle(dtoWappi);
    }

    @Y("^después de cerrar sesión Luisa ve en pantalla el título (.*)$")
    public void afterLoggingOutTheTitleIsDisplayedOnTheScreen(String strSecondTitle) {
        dtoWappi.setSecondTitle(strSecondTitle);
        wappi.validateSecondTitle(dtoWappi);
    }

    @Entonces("^Luisa puede ver en pantalla mensaje de error en contraseña (.*)$")
    public void canSeePasswordErrorMessageOnScreen(String strErrorMessage) {
        dtoWappi.setErrorMessage(strErrorMessage);
        wappi.validateErrorMessagePassword(dtoWappi);
    }

    @Entonces("^Luisa puede ver en pantalla mensaje de error en usuario (.*)$")
    public void canSeeUserErrorMessageOnScreen(String strErrorMessage) {
        dtoWappi.setErrorMessage(strErrorMessage);
        wappi.validateErrorMessageUserName(dtoWappi);
    }
}
