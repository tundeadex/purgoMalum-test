package com.purgomalum.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;



import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import static com.purgomalum.constant.Constants.*;


public class ProfanityServiceTest_StepDef {
    private static Response response;

    @Given("^a call is made to profanity service with text \"([^\"]*)\"$")
    public void a_call_is_made_to_profanity_service_with_text(String arg1) throws Throwable {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = CONTAINS_PROFANITY;
        RequestSpecification request = RestAssured.given();
        request.param(TEXT, arg1);
        response = request.get();

    }

    @Then("^response code is \"([^\"]*)\"$")
    public void response_code_is(String arg1) throws Throwable {
        Assert.assertEquals(Integer.parseInt(arg1), response.statusCode());

    }

    @Given("^a call is made to profanity service with text \"([^\"]*)\" and a new profanity word \"([^\"]*)\"$")
    public void a_call_is_made_to_profanity_service_with_text_and_a_new_profanity_word(String arg1, String arg2) throws Throwable {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = CONTAINS_PROFANITY;
        RequestSpecification request = RestAssured.given();
        request.param(TEXT, arg1);
        request.param(ADD, arg2);
        response = request.get();
    }

    @Then("^the response body is \"([^\"]*)\"$")
    public void the_response_body_is(String arg1) throws Throwable {
        System.out.println(response.body().asString());
        Assert.assertEquals(arg1, response.body().asString());


    }

}
