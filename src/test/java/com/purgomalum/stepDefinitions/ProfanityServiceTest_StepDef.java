package com.purgomalum.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static com.purgomalum.Constants.*;


public class ProfanityServiceTest_StepDef {

    public ProfanityServiceTest_StepDef(){

        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = CONTAINS_PROFANITY;

    }

    @Given("^a call is made to profanity service with text \"([^\"]*)\"$")
    public void a_call_is_made_to_profanity_service_with_text(String arg1) throws Throwable {

        RequestSpecification request = RestAssured.given();
        request.param(TEXT, arg1);
        BaseStepDef.response = request.get();
    }

    @Then("^response code is \"([^\"]*)\"$")
    public void response_code_is(String arg1) throws Throwable {
        Assert.assertEquals(Integer.parseInt(arg1), BaseStepDef.response.statusCode());

    }

    @Given("^a call is made to profanity service with text \"([^\"]*)\" and a new profanity word \"([^\"]*)\"$")
    public void a_call_is_made_to_profanity_service_with_text_and_a_new_profanity_word(String arg1, String arg2) throws Throwable {

        RequestSpecification request = RestAssured.given();
        request.param(TEXT, arg1);
        request.param(ADD, arg2);
        BaseStepDef.response = request.get();
    }

    @Then("^the response body is \"([^\"]*)\"$")
    public void the_response_body_is(String arg1) throws Throwable {
        System.out.println(BaseStepDef.response.body().asString());
        Assert.assertEquals(arg1, BaseStepDef.response.body().asString());


    }

}
