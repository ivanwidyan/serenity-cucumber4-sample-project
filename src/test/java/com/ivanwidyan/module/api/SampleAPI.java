package com.ivanwidyan.module.api;
import com.ivanwidyan.module.api.response.adduser.AddSingleUserResponse;
import com.ivanwidyan.module.api.response.getuser.GetSingleUserResponse;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import net.serenitybdd.rest.SerenityRest;
import org.json.simple.JSONObject;

public class SampleAPI {

  public static GetSingleUserResponse getUser (int id) {
    EncoderConfig encoderconfig = new EncoderConfig();
    GetSingleUserResponse response = SerenityRest.given()
            .config(RestAssured.config().encoderConfig(encoderconfig.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
            .get("https://reqres.in/api/users/" + id)
            .getBody().as(GetSingleUserResponse.class);
    return response;
  }

  public static String getUserAsString (int id) {
    EncoderConfig encoderconfig = new EncoderConfig();
    String response = SerenityRest.given()
            .config(RestAssured.config().encoderConfig(encoderconfig.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
            .get("https://reqres.in/api/users/" + id)
            .getBody().prettyPrint();
    return response;
  }

  public static AddSingleUserResponse addUser (String name, String job) {
    EncoderConfig encoderconfig = new EncoderConfig();
    GetSingleUserResponse request = new GetSingleUserResponse();
    AddSingleUserResponse response =  RestAssured.given()
            .config(RestAssured.config().encoderConfig(encoderconfig.appendDefaultContentCharsetToContentTypeIfUndefined(false)))
            .header("Content-Type", "application/json")
            .body(request)
            .post("https://reqres.in/api/users")
            .getBody().as(AddSingleUserResponse.class);

    return response;
  }

  public static GetSingleUserResponse deleteUser (int id) {
    GetSingleUserResponse response = new GetSingleUserResponse();
    return response;
  }
}