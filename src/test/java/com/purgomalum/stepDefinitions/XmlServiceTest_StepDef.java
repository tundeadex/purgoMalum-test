package com.purgomalum.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;

import static com.purgomalum.constant.Constants.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import io.restassured.path.xml.XmlPath;


public class XmlServiceTest_StepDef {

    private static Response response;


    @Given("^a call is made to profanity XML service with text \"([^\"]*)\"$")
    public void a_call_is_made_to_profanity_XML_service_with_text(String arg1) throws Throwable {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = XML;
        RequestSpecification request = RestAssured.given();
        request.param(TEXT, arg1);
        response = request.get();
    }

    @Then("^response code xml service equals \"([^\"]*)\"$")
    public void response_code_xml_service_equals(String arg1) throws Throwable {
        Assert.assertEquals(Integer.parseInt(arg1), response.statusCode());

    }

    @Then("^the response body xml \"([^\"]*)\" equal \"([^\"]*)\"$")
    public void the_response_body_xml_equal(String arg1, String arg2) throws Throwable {
        System.out.println(response.body().asString());
        String result = "";
        if(arg1.equals("result")){
            result = new XmlPath(response.body().asString()).get("PurgoMalum.result");
        }

        if (arg1.equals("error")){
            result = new XmlPath(response.body().asString()).get("PurgoMalum.error");
        }
        System.out.println(result);
        Assert.assertEquals(arg2, result);

    }

    @Given("^a call is made to profanity XML service with text \"([^\"]*)\", add \"([^\"]*)\" and fillChar\"([^\"]*)\"$")
    public void a_call_is_made_to_profanity_XML_service_with_text_add_and_fillChar(String arg1, String arg2, String arg3) throws Throwable {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = XML;
        RequestSpecification request = RestAssured.given();
        request.param(TEXT, arg1);
        request.param(ADD, arg2);
        request.param(FILL_CHAR, arg3);
        response = request.get();
    }

    @Given("^a call is made to profanity XML service with text \"([^\"]*)\" and fillText \"([^\"]*)\"$")
    public void a_call_is_made_to_profanity_XML_service_with_text_and_fillText(String arg1, String arg2) throws Throwable {
        RestAssured.baseURI = BASE_URI;
        RestAssured.basePath = XML;
        RequestSpecification request = RestAssured.given();
        request.param(TEXT, arg1);
        request.param(FILL_TEXT, arg2);
        response = request.get();

    }



}
