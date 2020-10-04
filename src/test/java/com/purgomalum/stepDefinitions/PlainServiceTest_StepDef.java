package com.purgomalum.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import static com.purgomalum.Constants.*;

public class PlainServiceTest_StepDef {


    @Given("^a call is made to profanity PlainText service with text \"([^\"]*)\"$")
    public void a_call_is_made_to_profanity_PlainText_service_with_text(String arg1) throws Throwable {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = PLAIN;
        RequestSpecification request = RestAssured.given();
        request.param(TEXT, arg1);
        BaseStepDef.response = request.get();
    }

    @Then("^the response body equals \"([^\"]*)\"$")
    public void the_response_body_equals(String arg1) throws Throwable {
        System.out.println(BaseStepDef.response.body().asString());
        Assert.assertEquals(arg1, BaseStepDef.response.body().asString());

    }
    @Given("^a call is made to profanity service with text \"([^\"]*)\", add \"([^\"]*)\" and fillChar\"([^\"]*)\"$")
    public void a_call_is_made_to_profanity_service_with_text_add_and_fillChar(String arg1, String arg2, String arg3) throws Throwable {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = PLAIN;
        RequestSpecification request = RestAssured.given();
        request.param(TEXT, arg1);
        request.param(ADD, arg2);
        request.param(FILL_CHAR, arg3);
        BaseStepDef.response = request.get();

    }

    @Given("^a call is made to profanity service with text \"([^\"]*)\" and fillText \"([^\"]*)\"$")
    public void a_call_is_made_to_profanity_service_with_text_and_fillText(String arg1, String arg2) throws Throwable {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = PLAIN;
        RequestSpecification request = RestAssured.given();
        request.param(TEXT, arg1);
        request.param(FILL_TEXT, arg2);
        BaseStepDef.response = request.get();

    }


}