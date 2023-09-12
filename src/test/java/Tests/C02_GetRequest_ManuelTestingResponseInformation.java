package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_ManuelTestingResponseInformation {
    @Test
    public void test01(){
        //1)Request Body ve endpoint hazirla
        String url ="https://restful-booker.herokuapp.com/booking/10";
        //2)Expected Body Hazırla
        //3)Request Gönder ve Actual Response kaydet
        Response response=given().when().get(url);
        System.out.println("Status Code:"+response.getStatusCode()+
                "\nContent type:"+response.getContentType()+
                "\nServer Header value:"+response.getHeader("Server")+
                "\nStatus Line:"+response.getStatusLine()+
                "\nResponse Time:"+response.getTime()+"ms");

    }
}
