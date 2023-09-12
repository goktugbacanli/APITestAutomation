package Tests;

import BaseURL.BaseUrlHerokuapp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_BaseUrlHerokuapp extends BaseUrlHerokuapp {
    @Test
    public void test01(){
        //1)Endpoint and Request body
        specHerokuapp.pathParam("pp1","booking");
        //2)Expected Data
        //3)Actual Data
        Response response=given()
                .when()
                .spec(specHerokuapp)
                .get("/{pp1}");


        //4)Assertion
        JsonPath responseJsonPath=response.jsonPath();
        System.out.println(responseJsonPath.getList("bookingid").size());
        response.then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(1165));

    }
}
