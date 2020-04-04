package com.qa.test;


import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@CucumberOptions(
	    features="src/test/resources/Features",
	    glue="stepDefinitions",
	   plugin= {"pretty","html:target/cucumber-html-reports","json:target/cucumber-html-reports/cucumber.json","ru.yandex.qatools.allure.cucumberjvm.AllureReporter:target/allure-results","com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
	  // plugin= {"pretty", "html:target/cucumber-html-reports", "ru.yandex.qatools.allure.cucumberjvm.AllureReporter:target/allure-results", "json:target/cucumber-html-reports/cucumber.json"},
	    		   
	    monochrome=true
	    )

@Test
public class TestRunner extends AbstractTestNGCucumberTests {

}