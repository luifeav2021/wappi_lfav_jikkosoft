package com.wappi.certificacion.wappi_lfav_jikkosoft.steps;

import com.wappi.certificacion.wappi_lfav_jikkosoft.dto.DtoWappi;
import com.wappi.certificacion.wappi_lfav_jikkosoft.steps.serenity.EndUserStepsWappi;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import net.thucydides.core.annotations.Steps;

public class DefinitionStepsWappiProfile {
	 @Steps
     private EndUserStepsWappi wappi;
	 private DtoWappi dtoWappi=new DtoWappi();
	
	@Dado("^Luisa inicia sesión en la página de wappi con las credenciales (.*) y (.*)$")
	public void loginToWappiPage(String userName, String password) throws Exception {
		wappi.openBrowser();
		dtoWappi.setUserName(userName);
        dtoWappi.setPassword(password);
        wappi.loginWappi(dtoWappi);
	}
	
	@Y("^Luisa ingresa a la opción (.*) del menú$")
    public void enterTheMenuOption(String menu) {
        wappi.pressMenu(menu);
    }
	
	@Cuando("^ella ingresa los siguientes datos en el formulario (.*) y (.*) y (.*) y (.*) y (.*)$")
    public void enterDataInTheForm(String name, String lastName, String dateBirth,String country, String gender) {
        dtoWappi.setName(name);
        dtoWappi.setLastName(lastName);
        dtoWappi.setDateBirth(dateBirth);
        dtoWappi.setCountry(country);
        dtoWappi.setGender(gender);
        wappi.profileForm(dtoWappi);        
    }
	
    @Entonces("^Luisa puede ver el mensaje (.*)$")
    public void canSeeAMessage(String message) {
        wappi.validateMessageUpdateProfile(message);
    }

    @Entonces("^Luisa observa el mensaje (.*) como error en campo (.*)$")
    public void canSeeAMessageInName(String message, String field) {
	    dtoWappi.setField(field);
	    dtoWappi.setErrorMessage(message);
    }
}
