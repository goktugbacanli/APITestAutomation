package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_Put_ResponseInformationAssertion {
    @Test
    public void test01(){
        //1)Request Body and end point
        String url="https://jsonplaceholder.typicode.com/posts/70";
        JSONObject requestBody=new JSONObject();
        requestBody.put("title","Ahmet");
        requestBody.put("body","Merhaba");
        requestBody.put("userId",10);
        requestBody.put("id",70);
        //2)Expected Body

        //3)Actual Body
        Response response=given()
                                .contentType(ContentType.JSON)
                                .when()
                                .body(requestBody.toString())
                                .put(url);
        response.prettyPrint();
        //4)Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");



    }
}
