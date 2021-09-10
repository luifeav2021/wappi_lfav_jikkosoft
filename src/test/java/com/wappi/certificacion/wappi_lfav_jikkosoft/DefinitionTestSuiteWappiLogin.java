package com.wappi.certificacion.wappi_lfav_jikkosoft;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/wappi/wappiLogin.feature",
        snippets = SnippetType.CAMELCASE,
        tags = "@TCLogin")

public class DefinitionTestSuiteWappiLogin {
}
