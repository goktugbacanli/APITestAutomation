package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_GetRequest_AutomationTestingResponseInformation {
    @Test
    public void test01(){
        //1)Request Body and endpoint
        String url="https://restful-booker.herokuapp.com/booking/10";
        //2)Expected Data
        //3)Actual Data
        Response response=given().when().get(url);
        //4)Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");


    }
}
