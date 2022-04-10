package com.coinMarket.api.test.stepDefinitions;

import com.coinMarket.api.test.service.AbstractSteps;
import com.coinMarket.api.test.service.ServiceApi;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

import static com.coinMarket.api.test.constants.ServiceUrlConstants.GBP_PRICE;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestApiSteps extends AbstractSteps {
    private ServiceApi serviceApi;
    public TestApiSteps() {
        serviceApi = new ServiceApi();
    }

    @Before
    public void beforeEachScenario() {
        super.beforeEachScenario();
    }

    @Given("^Convert Guatemalan Quetzal to British pounds$")
    public void convertGuatemalanQuetzalToBritishPounds() {
        Response response = serviceApi.getCallToConvertGTQtoGBP();
        Float price = response.jsonPath().get("data.quote.GBP.price");
        getScenarioContext().set(GBP_PRICE, price);
        response
                .then()
                .statusCode(200)
                .log().all()
                .body("data.id", equalTo(response.jsonPath().get("data.id")));

    }

    @Then("^convert the amount received in GBP to doge coin$")
    public void convertTheAmountReceivedInGBPToDogeCoin() {
        Float price = (Float) getScenarioContext().get(GBP_PRICE);
        Response response = serviceApi.getCallToConvertGBPtoDOGE(price);
        response
                .then()
                .statusCode(200)
                .log().all()
                .body("data.id", equalTo(response.jsonPath().get("data.id")))
                .body("quote.DOGECOIN",equalTo(response.jsonPath().get("quote.DOGECOIN")));
    }
}


