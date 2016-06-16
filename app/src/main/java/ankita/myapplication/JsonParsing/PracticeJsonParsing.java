package ankita.myapplication.JsonParsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ankita.myapplication.R;

public class PracticeJsonParsing extends AppCompatActivity {

    TextView tv;
    String jsonString = "["+"{ \"name\": \"Karan\"," +
                        "\"mark\":{\"math\":20,\"chemistry\":30,\"physics\":40}," +
                        "\"email\":[\"abc@gmai.com\",\"pqr@gmail.com\"]}," +
                        "{ \"name\": \"Shyam\"," +
                        "\"mark\":{\"math\":50,\"chemistry\":10,\"physics\":30}," +
                        "\"email\":[\"bcd@gmai.com\",\"sdfr@gmail.com\"]},"+
                        "{ \"name\": \"Ram\"," +
                        "\"mark\":{\"math\":20,\"chemistry\":80,\"physics\":50}," +
                        "\"email\":[\"sfg@gmai.com\",\"gfs@gmail.com\"]}"
                        +"]";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_json_parsing);
        tv = (TextView)findViewById (R.id.tvParsedArray);
        JSONArray root = null;
        try {
            root  = new JSONArray (jsonString);
        }
        catch (JSONException e) {
            e.printStackTrace ();
        }

        String data="";
        data+="Actual json String:\n"+jsonString+"\n\n";


        for (int i=0;i<root.length ();i++){
            try {
                JSONObject object = root.getJSONObject (i);
                Log.d("Object"+i+" ",object.toString ());
                data+= "Name : "+object.getString ("name")+"\n";
                data+="Marks :\n";
                JSONObject marks = object.getJSONObject ("mark");
                data+="   Math:"+marks.getInt ("math")+"\n";
                data+="   Physics:"+marks.getInt ("physics")+"\n";
                data+="   Chemistry:"+marks.getInt ("chemistry")+"\n";
                JSONArray emails = object.getJSONArray ("email");
                data+="Emails: ";
                for(int j=0;j<emails.length ();j++){
                    data+=emails.getString (j)+" ";
                }
                data+="\n---------------------------------------\n\n";
            }
            catch (JSONException e) {
                e.printStackTrace ();
            }
        }
        tv.setText (data);
    }
}
