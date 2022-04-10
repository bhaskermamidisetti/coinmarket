package com.coinMarket.api.test.service;

import com.coinMarket.api.test.context.ScenarioContext;
import com.coinMarket.api.test.context.TestContext;
import com.coinMarket.api.test.utils.ConfigUtils;

public class AbstractSteps {

    private TestContext testContext;
    private ScenarioContext scenarioContext;

    public void beforeEachScenario() {
        testContext = TestContext.getTestContext();
        scenarioContext = testContext.getScenarioContext();

        if (!ConfigUtils.isLoaded()) {
            ConfigUtils.load();
        }
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}