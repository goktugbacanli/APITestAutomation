package TestDatas;

import org.json.JSONObject;

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
    public static JSONObject createResponseBody(int userId,int id,String title,String body){
        JSONObject expectedData =new JSONObject();
        expectedData.put("userId",userId);
        expectedData.put("id",id);
        expectedData.put("title",title);
        expectedData.put("body", body);
        return expectedData;
    }


}
