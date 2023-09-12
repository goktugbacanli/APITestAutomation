package Tests;

import BaseURL.BaseUrlDummyApi;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C16_BaseUrlDummyRestApi extends BaseUrlDummyApi {

    @Test
    public void test01(){
        //1) end point and requestbody
        specJsonPlaceholder.pathParam("pp1","posts");
        //2)Expected data
        //3)Actual data
        Response response=given()
                        .when()
                        .spec(specJsonPlaceholder)
                        .get("/{pp1}");
        response.prettyPrint();
        //4)Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.hasSize(100));
    }
    @Test
    public void test02(){
        //1) end point and requestbody
        specJsonPlaceholder.pathParams("pp1","posts","pp2",44);
        //2)Expected data
        //3)Actual data
        Response response=given()
                .when()
                .spec(specJsonPlaceholder)
                .get("/{pp1}/{pp2}");
        response.prettyPrint();
        //4)Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));

    }
}
