package ankita.myapplication.facebooklogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.Arrays;

import ankita.myapplication.R;

public class PracticeFacebookLogin extends AppCompatActivity {

    LoginButton loginButton;
    CallbackManager callbackManager;
    AccessToken accessToken;
    @Override
    protected void onCreate (Bundle savedInstanceState) {

        FacebookSdk.sdkInitialize (getApplicationContext ());
        AppEventsLogger.activateApp (this);
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practice_facebook_login);
        callbackManager = CallbackManager.Factory.create ();
        loginButton = (LoginButton) findViewById (R.id.connectWithFbButton);
        loginButton.setReadPermissions(Arrays.asList ("public_profile","user_friends"));
        loginButton.registerCallback (callbackManager, new FacebookCallback<LoginResult> () {
            @Override
            public void onSuccess (LoginResult loginResult) {
                accessToken=  loginResult.getAccessToken ();
                Log.d ("facebook", "Login success");
                Toast.makeText (PracticeFacebookLogin.this, "Successful login", Toast.LENGTH_SHORT).show ();
                GraphRequest request = GraphRequest.newMeRequest(
                        accessToken,
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                Log.d ("hi",object.toString ());
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "friendlists");
                request.setParameters (parameters);
                request.executeAsync ();
            }

            @Override
            public void onCancel () {
                // App code
            }

            @Override
            public void onError (FacebookException exception) {
                // App code
            }
        });
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        Log.d ("cool", "On activity result called");
        callbackManager.onActivityResult (requestCode, resultCode, data);
        super.onActivityResult (requestCode, resultCode, data);
    }
}
