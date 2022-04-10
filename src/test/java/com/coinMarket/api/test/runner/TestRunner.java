package com.coinMarket.api.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        glue = {"com.coinMarket.api.test.stepDefinitions"},
        features = {"src/test/resources/features"},
        tags = {"@coinMarketApiTest"},
        format = {"pretty", "html:target/report"}
)
public class TestRunner {
}