package com.example.hp.aha.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.hp.aha.R;
import com.example.hp.aha.activity.model.LoginRequestDto;
import com.example.hp.aha.activity.model.LoginResponseDto;
import com.example.hp.aha.activity.network.WebServiceCallHelper;
import com.example.hp.aha.activity.network.retrofit.ObserverCallBack;
import com.example.hp.aha.activity.prefrence.AppPrefs;
import com.example.hp.aha.activity.utils.AppConstants;
import com.example.hp.aha.activity.utils.ConnectionUtils;
import com.example.hp.aha.activity.utils.LogManager;
import com.example.hp.aha.activity.utils.ToastUtils;

import okhttp3.ResponseBody;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements ObserverCallBack.ServiceCallback {

    private static final String EXTRA_DATA_LOGIN = "login_data";
    private EditText mUserNameView, mPasswordView;
    private Button btnRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnRegistration = (Button)findViewById(R.id.btn_registration);
        btnRegistration.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
            }
        });
        // Set up the login form.
        mUserNameView = findViewById(R.id.user_name);
        mPasswordView = findViewById(R.id.password);

        mUserNameView.setText("altenasmmailtest@yopmail.com");
        mPasswordView.setText("Admin@123");

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.btn_login);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

    }

    private void attemptLogin() {

        // Reset errors.
        mUserNameView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mUserNameView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;


        // Check for a valid username address.
        if (TextUtils.isEmpty(email)) {
            mUserNameView.setError(getString(R.string.error_field_required));
            focusView = mUserNameView;
            cancel = true;
        }
        // Check for a valid password, if the use r entered one.
        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }
        /*&& !isPasswordValid(password)
        else if (!isEmailValid(email)) {
            mUserNameView.setError(getString(R.string.error_invalid_email));
            focusView = mUserNameView;
            cancel = true;
        }*/

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
           // AppPrefs.getInstance(this).saveAccessToken(this, "");
            //ToastUtils.shortToast(getApplicationContext(),"Attempt to Login");
            loginUser();
            //successLoginCall();
        }
    }


    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }


    public static void switchToLoginScreen(Context context, String data) {
        Intent intent = new Intent(context, LoginActivity.class);
        if (!data.equals("")) {
            intent.putExtra(EXTRA_DATA_LOGIN, data);
        }
        context.startActivity(intent);
    }


    private void loginUser() {
        try {
            if (ConnectionUtils.isNetworkAvailable(this)) {
                ObserverCallBack myObserver = new ObserverCallBack(this);
                myObserver.setLoading(true);
                myObserver.setListener(this);
                myObserver.setRequestTag(1);

                WebServiceCallHelper.loginUser(getApplicationContext(),myObserver, createRequestModel());
            } else {
                ToastUtils.shortToast(this, getString(R.string.server_error));
            }
        } catch (Exception ex) {
            LogManager.printStackTrace(ex);
        }
    }

    private LoginRequestDto createRequestModel() {
        LoginRequestDto requestDto = new LoginRequestDto();
        requestDto.setUsername(mUserNameView.getText().toString());
        requestDto.setPassword(mPasswordView.getText().toString());

       //requestDto.setGrant_type(AppConstants.GRANT_TYPE);
        return requestDto;
    }


    @Override
    public void onSuccess(Object response, int tag) {
        try {
            System.out.println("response coming - "+response);
            if (tag == 1) {

                String text = ((ResponseBody) response).string();
                System.out.println("Send Data Response coming text- "+text);

                if (text != null) {
                    ToastUtils.shortToast(this, "Login Successful");
                    successLoginCall(text);
                } else {
                    ToastUtils.shortToast(this, getString(R.string.something_went_wrong));
                }
            }
        } catch (Exception ex) {
            LogManager.printStackTrace(ex);
        }
    }

    private void successLoginCall(String responseModel) {
        AppPrefs.getInstance(this).saveUserName(this, mUserNameView.getText().toString());
        AppPrefs.getInstance(this).saveAccessToken(this, responseModel);

        startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
        finish();
    }

    @Override
    public void onError(String msg, Throwable error) {
        System.out.println("response coming msg - "+msg);
        System.out.println("response coming error - "+error);
        ToastUtils.shortToast(this, "The user name or password is incorrect.");
    }
}

