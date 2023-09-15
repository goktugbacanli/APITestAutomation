package Tests;

import BaseURL.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoExpectedData;
import pojos.PojoHerokuappBookingdates;
import pojos.PojoHerokuappRequestBody;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_Post_Pojo extends BaseUrlHerokuapp {
    @Test
    public void test01(){
        //1)Endpoint and Request Body
        specHerokuapp.pathParams("pp1","booking");
        PojoHerokuappBookingdates bookingdates=new PojoHerokuappBookingdates("2021-06-01","2021-06-10");
        PojoHerokuappRequestBody requestBodyPojo =new PojoHerokuappRequestBody("Ahmet","Bulut",500,false,bookingdates,"wi-fi");
        //2)Expected Data
        PojoExpectedData expectedDataPojo=new PojoExpectedData(24,requestBodyPojo);

        //3)Actual Data
        Response response=given().spec(specHerokuapp)
                .when().contentType(ContentType.JSON).body(requestBodyPojo)
                .post("{pp1}");
        response.prettyPrint();

        PojoExpectedData responsePojo=response.as(PojoExpectedData.class);

        //4)Assertion
        assertEquals(expectedDataPojo.getBooking().getFirstname(),responsePojo.getBooking().getFirstname());
        assertEquals(expectedDataPojo.getBooking().getLastname(),responsePojo.getBooking().getLastname());
        assertEquals(expectedDataPojo.getBooking().getTotalprice(),responsePojo.getBooking().getTotalprice());
        assertEquals(expectedDataPojo.getBooking().getBookingdates().getCheckin(),responsePojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedDataPojo.getBooking().getBookingdates().getCheckout(),responsePojo.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedDataPojo.getBooking().getAdditionalneeds(),responsePojo.getBooking().getAdditionalneeds());
        assertEquals(expectedDataPojo.getBooking().isDepositpaid(),responsePojo.getBooking().isDepositpaid());

    }
}
