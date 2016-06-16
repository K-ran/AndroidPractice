package ankita.myapplication.HttpCallsWithVolley;

/**
 * Created by ankita on 16/6/16.
 */
public class MyHttpService {
    public static final int GET=0;
    public static final int POST=1;

    String url;
    int method;
    public MyHttpService(String url,int method){
        this.method=method;
        this.url =url;
    }

    public String getResponse(){
        String response=null;
        return  response;
    }
    
}
