package com.example.hp.aha.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.hp.aha.R;
import com.example.hp.aha.activity.model.AddressModel;
import com.example.hp.aha.activity.model.CustomerModel;
import com.example.hp.aha.activity.model.Submit_Reg_Details_Req;
import com.example.hp.aha.activity.model.Submit_Registration_Data_Request;
import com.example.hp.aha.activity.network.WebServiceCallHelper;
import com.example.hp.aha.activity.network.retrofit.ObserverCallBack;
import com.example.hp.aha.activity.utils.ConnectionUtils;
import com.example.hp.aha.activity.utils.LogManager;
import com.example.hp.aha.activity.utils.ToastUtils;

import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;

public class RegistrationActivity2 extends AppCompatActivity implements ObserverCallBack.ServiceCallback {

    private EditText fullname,address,landmark,pincode,area,city,state,mobileno;
    private Button btnRegister;
    private Submit_Registration_Data_Request submit_request_obj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        submit_request_obj = (Submit_Registration_Data_Request) getIntent().getSerializableExtra("MyClass");

        System.out.println("responseModelcustomerId - " + submit_request_obj.getCustomer().getFirstname());


        btnRegister = (Button)findViewById(R.id.register_button);
        fullname = (EditText)findViewById(R.id.edtfullname);
        address = (EditText)findViewById(R.id.edtaddress);
        landmark = (EditText)findViewById(R.id.edtlandmark);
        pincode = (EditText)findViewById(R.id.edtpincode);
        area = (EditText)findViewById(R.id.edtarea);
        city = (EditText)findViewById(R.id.edtCity);
        state = (EditText)findViewById(R.id.edtState);
        mobileno = (EditText)findViewById(R.id.edtmobileno);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  if(isFormValid()) {
                submit_info();
                //  }
            }
        });

    }

    private void submit_info() {

        ArrayList<AddressModel> address_arr = new ArrayList<AddressModel>();

        AddressModel address = new AddressModel();

//        address.set(customerId);
        address.setFirstname("Billing Name");
        address.setLastname("Billing Last Name");
        address.setDefaultBilling(true);
        address.setDefaultShipping(true);
        address.setPostcode("250002");
        address.setTelephone("6951111411");
        address.setCity("Meerut");
        address.setCountryId("IN");

        ArrayList<String> str = new ArrayList<>();
        str.add("11");
        address.setStreet(str);
        address_arr.add(address);

        CustomerModel model = new CustomerModel();
        model.setEmail(submit_request_obj.getCustomer().getEmail());
        model.setFirstname(submit_request_obj.getCustomer().getFirstname());
        model.setLastname( submit_request_obj.getCustomer().getLastname());
        model.setAddresses(address_arr);

        submit_request_obj.setCustomer(model);

        serverTransaction();
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
                System.out.println("response Send Data Response - " + text);
                ToastUtils.shortToast(this, "Registration Successful");

//                String customerId="";
//                try {
//                    JSONObject obj = new JSONObject(text);
//                    customerId = obj.getString("id");
//                } catch (Throwable t) {
//                    Log.e("My App", "Could not parse malformed JSON:");
//                }
                Intent i = new Intent(RegistrationActivity2.this, LoginActivity.class);
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

   /* boolean isFormValid(){
        if(first_name.getText().toString().trim().length()==0){
            first_name.setError("First name not entered");
            first_name.requestFocus();
            return false;
        }
        if(last_name.getText().toString().trim().length()==0){
            last_name.setError("Last name not entered");
            last_name.requestFocus();
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

        if(confirm_password.getText().toString().trim().length()<6) {
            confirm_password.setError("Password should be atleast of 6 charactors");
            confirm_password.requestFocus();
            return false;
        }

        if(!password.getText().toString().trim().equals(confirm_password.getText().toString())){
            confirm_password.setError("Password Not matched");
            confirm_password.requestFocus();
            return false;

        }

        return true;
    }*/
}
