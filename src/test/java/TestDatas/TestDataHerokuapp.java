package TestDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
    public static Map<String,Object> createRequestBodyMap(String firstName,String lastName,double totalPrice,boolean depositpaid,String checkin,String checkout, String additionalneeds){
        Map<String,Object> requestBodyMap=new HashMap<>();
        Map<String,String> bookingDatesMap=new HashMap<>();
        bookingDatesMap.put("checkin",checkin);
        bookingDatesMap.put("checkout",checkout);
        requestBodyMap.put("firstname",firstName);
        requestBodyMap.put("lastname",lastName);
        requestBodyMap.put("totalprice",totalPrice);
        requestBodyMap.put("depositpaid",depositpaid);
        requestBodyMap.put("bookingdates",bookingDatesMap);
        requestBodyMap.put("additionalneeds",additionalneeds);
        return requestBodyMap;

    }
    public static Map<String,Object> createExpectedDataMap(){
    Map<String,Object> expectedData =new HashMap<>();
    expectedData.put("bookingid",24);
    expectedData.put("booking",createRequestBodyMap("Ahmet","Bulut",500,false,"2021-06-01","2021-06-01","wi-fi"));
    return expectedData;

    }

}
