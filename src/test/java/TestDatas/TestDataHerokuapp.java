package TestDatas;

import org.json.JSONObject;

public class TestDataHerokuapp {
    public static JSONObject createRequestBody(String firstName,String lastName,int totalPrice,boolean depositpaid,String checkin,String checkout, String additionalneeds){
        JSONObject requestBody=new JSONObject();
        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin",checkin);
        bookingDates.put("checkout",checkout);
        requestBody.put("firstname",firstName);
        requestBody.put("lastname",lastName);
        requestBody.put("totalprice",totalPrice);
        requestBody.put("depositpaid",depositpaid);
        requestBody.put("bookingdates",bookingDates);
        requestBody.put("additionalneeds",additionalneeds);
        return requestBody;

    }
    public static JSONObject createExpectedData(int bookingId,String firstName,String lastName,int totalPrice,boolean depositpaid,String checkin,String checkout, String additionalneeds){
        JSONObject bookingData=new JSONObject();
        JSONObject bookingDates=new JSONObject();
        JSONObject expectedData=new JSONObject();
        bookingDates.put("checkin",checkin);
        bookingDates.put("checkout",checkout);
        bookingData.put("firstname",firstName);
        bookingData.put("lastname",lastName);
        bookingData.put("totalprice",totalPrice);
        bookingData.put("depositpaid",depositpaid);
        bookingData.put("bookingdates",bookingDates);
        bookingData.put("additionalneeds",additionalneeds);
        expectedData.put("bookingid",bookingId);
        expectedData.put("booking",bookingData);



        return expectedData;

    }

}
