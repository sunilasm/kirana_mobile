package com.example.hp.aha.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.hp.aha.R;
import com.example.hp.aha.activity.model.CustomerModel;
import com.example.hp.aha.activity.model.Submit_Registration_Data_Request;
import com.example.hp.aha.activity.network.WebServiceCallHelper;
import com.example.hp.aha.activity.network.retrofit.ObserverCallBack;
import com.example.hp.aha.activity.utils.ConnectionUtils;
import com.example.hp.aha.activity.utils.LogManager;
import com.example.hp.aha.activity.utils.ToastUtils;

import org.json.JSONObject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import okhttp3.ResponseBody;

public class RegistrationActivity extends AppCompatActivity implements ObserverCallBack.ServiceCallback {

    private Submit_Registration_Data_Request submit_request_obj;
    private EditText firstName,middleName,lastName,email,dob,password,confirmPassword;
    private Button btnRegister;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnRegister = (Button)findViewById(R.id.register_button);
        firstName = (EditText)findViewById(R.id.edtfirstname);
        middleName = (EditText)findViewById(R.id.edtmiddlename);
        lastName = (EditText)findViewById(R.id.edtlastname);
        email = (EditText)findViewById(R.id.edtEmail);
        dob = (EditText)findViewById(R.id.edtdob);
        password = (EditText)findViewById(R.id.edtPass);
        confirmPassword = (EditText)findViewById(R.id.edtConfirmPass);
        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                new DatePickerDialog(RegistrationActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFormValid()) {

                    int selectedId = radioSexGroup.getCheckedRadioButtonId();
                    radioSexButton = (RadioButton) findViewById(selectedId);

                    submit_info(radioSexButton.getText().toString());
                }
            }
        });
    }

    boolean isFormValid(){
        if(firstName.getText().toString().trim().length()==0){
            firstName.setError("First name not entered");
            firstName.requestFocus();
            return false;
        }
        if(lastName.getText().toString().trim().length()==0){
            lastName.setError("Last name not entered");
            lastName.requestFocus();
            return false;
        }
        if(email.getText().toString().trim().length()==0){
            email.setError("email id not entered");
            email.requestFocus();
            return false;
        }
        if(dob.getText().toString().trim().length()==0){
            dob.setError("Password not entered");
            dob.requestFocus();
            return false;
        }
        if(password.getText().toString().trim().length()==0){
            password.setError("Please confirm password");
            password.requestFocus();
            return false;

        }
        if(password.getText().toString().trim().length()<6) {
            password.setError("Password should be atleast of 6 charactors");
            password.requestFocus();
            return false;
        }

        if(confirmPassword.getText().toString().trim().length()<6) {
            confirmPassword.setError("Password should be atleast of 6 charactors");
            confirmPassword.requestFocus();
            return false;
        }

        if(!password.getText().toString().trim().equals(confirmPassword.getText().toString())){
            confirmPassword.setError("Password Not matched");
            confirmPassword.requestFocus();
            return false;

        }

        return true;
    }


    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dob.setText(sdf.format(myCalendar.getTime()));
    }


    private void submit_info(String gender) {

        submit_request_obj = new Submit_Registration_Data_Request();

        CustomerModel customer = new CustomerModel();
        customer.setEmail(email.getText().toString().trim());
        customer.setFirstname(firstName.getText().toString().trim());
        customer.setLastname(lastName.getText().toString().trim());

        submit_request_obj.setCustomer(customer);

        Intent i = new Intent(RegistrationActivity.this, RegistrationActivity2.class);
        i.putExtra("MyClass", (Serializable) submit_request_obj);
        startActivity(i);

      //  serverTransaction();
    }

    private void serverTransaction() {
        try {
            if (ConnectionUtils.isNetworkAvailable(this)) {
                ObserverCallBack myObserver = new ObserverCallBack(this);
                myObserver.setLoading(true);
                myObserver.setListener(this);
                myObserver.setRequestTag(1);
                WebServiceCallHelper.submitRegistrationInfoFirst(getApplicationContext(), myObserver, submit_request_obj);
            } else {
                ToastUtils.shortToast(this, getString(R.string.server_error));
            }
        } catch (Exception ex) {
            LogManager.printStackTrace(ex);
        }
    }
    public void onSuccess(Object response, int tag) {
        try {
            if (tag == 1) {
                System.out.println("response Send Data Response - " + response);
                String text = ((ResponseBody) response).string();
                System.out.println(text);
                System.out.println("response Send Data Response - " + text);
                ToastUtils.shortToast(this, "Registration Successful");

                String customerId="";
                try {
                    JSONObject obj = new JSONObject(text);
                    customerId = obj.getString("id");
                } catch (Throwable t) {
                    Log.e("My App", "Could not parse malformed JSON:");
                }

                Intent i = new Intent(RegistrationActivity.this, RegistrationActivity2.class);
                i.putExtra("customerId",customerId);
                startActivity(i);
                finish();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onError(String msg, Throwable error) {

    }
}
