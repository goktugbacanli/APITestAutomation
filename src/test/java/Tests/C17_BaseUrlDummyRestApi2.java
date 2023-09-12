package Tests;

import BaseURL.BaseUrlDummyApi;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlDummyRestApi2 extends BaseUrlDummyApi {

    @Test
    public void test01(){
        //1)Endpoint and Request body
        specJsonPlaceholder.pathParams("pp1","posts","pp2","50");
        //2)Expected data
        //3)Actual data
        Response response=given()
                .when()
                .spec(specJsonPlaceholder)
                .delete("/{pp1}/{pp2}");

        response.prettyPrint();
        //4)Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .body(  "userId",Matchers.nullValue());


    }
}
