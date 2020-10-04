package com.getChipTest.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/resources/functionalTests"},
        glue = {"com.getChipTest/stepDefinitions"},
        format = {"html:target/html"}

)

public class TestRunner {
}
