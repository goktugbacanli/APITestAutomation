package TestDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestDataJsonPlaceholder {
    public static int başariliSorguStatusKodu=200;
    public static String contentType="application/json; charset=utf-8";
    public static String headerConnection="keep-alive";
    public static JSONObject responseBodyOlustur10(){
        JSONObject expectedData =new JSONObject();
        expectedData.put("userId",1);
        expectedData.put("id",10);
        expectedData.put("title","optio molestias id quia eum");
        expectedData.put("body","quo et expedita modi cum officia vel magni\nndoloribus qui repudiandae\nnvero nisi sit\nnquos veniam quod sed accusamus veritatis error");
        return expectedData;
    }
    public static JSONObject createResponseBody(double userId,double id,String title,String body){
        JSONObject expectedData =new JSONObject();
        expectedData.put("userId",userId);
        expectedData.put("id",id);
        expectedData.put("title",title);
        expectedData.put("body", body);
        return expectedData;
    }
    public static Map<String,Object> createHashMapBody(double userId, double id, String title, String body){
        Map<String,Object> bodyMap=new HashMap<>();
        bodyMap.put("title",title);
        bodyMap.put("body",body);
        bodyMap.put("userId",userId);
        bodyMap.put("id",id);
        return bodyMap;


    }



}
