package Tests;

import BaseURL.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C20_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {
    @Test
    public void test01(){
        //1)Endpoint and Request Body
        specHerokuapp.pathParam("pp1","booking")
                .queryParam("firstname","Susan");
        //2)Expected Data
        //3)Actual Data
        Response response=given()
                .when()
                .spec(specHerokuapp)
                .get("{pp1}");
        response.prettyPrint();
        //4)Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(4 ));
    }
}
