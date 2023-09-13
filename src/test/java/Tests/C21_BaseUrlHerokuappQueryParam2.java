package Tests;

import BaseURL.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C21_BaseUrlHerokuappQueryParam2 extends BaseUrlHerokuapp {
    @Test
    public void test01(){
        //Endpoint and Request body
        specHerokuapp.pathParam("pp1","booking")
                .queryParams("firstname","Josh","lastname","Allen");
        //Expected data
        //Actual data
        Response response=given()
                .when()
                .spec(specHerokuapp)
                .get("/{pp1}");

        //Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.notNullValue());
    }
}
