package pojos;

public class PojoJsonPlaceHolder {
    //1)Tüm variable'lar private oluşturuldu
    private String title;
    private String body;
    private int userId;
    private int id;
    //2)Tüm variable'lar için getter ve setter oluşturuldu.
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //3)Tüm parametreleri içeren constructor olusturuldu
    public PojoJsonPlaceHolder(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }
    //4)Parametresiz constructor oluşturuldu
    public PojoJsonPlaceHolder() {
    }
    //5)toString() metodu olusturuldu


    @Override
    public String toString() {
        return "PojoJsonPlaceHolder{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
