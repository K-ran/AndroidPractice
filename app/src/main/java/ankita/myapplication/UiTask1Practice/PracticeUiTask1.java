package ankita.myapplication.UiTask1Practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import ankita.myapplication.R;

public class PracticeUiTask1 extends AppCompatActivity {
    RelativeLayout rrLogin,rrSignUp;
    Button btnLogin,btnSignUp;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_practive_ui_task1);
        rrLogin = (RelativeLayout)findViewById (R.id.rrSignInForm);
        rrSignUp = (RelativeLayout)findViewById (R.id.rrSignUpForm);
        btnSignUp=(Button)findViewById (R.id.btnSignup);
        btnLogin=(Button)findViewById (R.id.btnLogin);
    }

    public void onLoginClicked(View view){
        Button button = (Button)view;
        button.setBackgroundResource (R.drawable.iphone_button_selected);
        button.setTextColor (getResources ().getColor (R.color.customWhite));
        btnSignUp.setBackgroundResource (R.drawable.iphone_button);
        btnSignUp.setTextColor (getResources ().getColor (R.color.green));
        rrSignUp.setVisibility (View.GONE);
        rrLogin.setVisibility (View.VISIBLE);
    }
    public void onSignUpClicked(View view){
        Button button = (Button)view;
        button.setBackgroundResource (R.drawable.iphone_button_selected);
        button.setTextColor(getResources ().getColor (R.color.customWhite));
        btnLogin.setBackgroundResource (R.drawable.iphone_button);
        btnLogin.setTextColor (getResources ().getColor (R.color.green));
        rrSignUp.setVisibility (View.VISIBLE);
        rrLogin.setVisibility (View.GONE);
    }
}
