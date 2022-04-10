package com.coinMarket.api.test.service;

import com.coinMarket.api.test.constants.ServiceUrlConstants;
import com.coinMarket.api.test.utils.ConfigUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ServiceApi {

    public Response getCallToConvertGTQtoGBP() {
        return given()
                .header("Content-Type", "application/json")
                .header("X-CMC_PRO_API_KEY", "21f4ea0b-de71-407c-99d7-4bdb959ba8a1")
                .queryParam("id", "3541").queryParam("amount", "10000000").queryParam("convert", "GBP")
                .log().all()
                .get(ConfigUtils.getBaseURL().concat(ServiceUrlConstants.CONVERT_URL));
    }

    public Response getCallToConvertGBPtoDOGE(float priceInGBP) {

        return given()
                .header("Content-Type", "application/json")
                .header("X-CMC_PRO_API_KEY", "21f4ea0b-de71-407c-99d7-4bdb959ba8a1")
                .queryParam("id", "2791")
                .queryParam("amount", priceInGBP)
                .queryParam("convert", "Dogecoin")
                .log().all()
                .get(ConfigUtils.getBaseURL().concat(ServiceUrlConstants.CONVERT_URL));
    }
}

