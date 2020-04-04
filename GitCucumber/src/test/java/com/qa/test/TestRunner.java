package com.qa.test;

import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
	    features="src/test/resources/Features",
	    glue="stepDefinitions",
	    plugin = { "pretty", "html:target/cucumber-html-reports", "ru.yandex.qatools.allure.cucumberjvm.AllureReporter",
	            "json:target/cucumber-html-reports/cucumber.json","com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
	    monochrome=true
	    )


public class TestRunner  {

}
