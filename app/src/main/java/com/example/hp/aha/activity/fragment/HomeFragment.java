package com.example.hp.aha.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.hp.aha.R;
import com.example.hp.aha.activity.model.HomeFragmentRequest;
import com.example.hp.aha.activity.network.WebServiceCallHelper;
import com.example.hp.aha.activity.network.retrofit.ObserverCallBack;
import com.example.hp.aha.activity.prefrence.AppPrefs;
import com.example.hp.aha.activity.utils.ConnectionUtils;
import com.example.hp.aha.activity.utils.LogManager;
import com.example.hp.aha.activity.utils.ToastUtils;

import okhttp3.ResponseBody;


public class HomeFragment extends Fragment implements ObserverCallBack.ServiceCallback {

    private GridView gridView;
    private HomeFragmentRequest request;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        gridView = (GridView) view.findViewById(R.id.gridview);
        request  = new HomeFragmentRequest();


        String API_KEY = AppPrefs.getInstance(getActivity()).getAccessToken(getActivity());
        request.setToken(API_KEY);

        serverTransaction();
        return view;
    }

    private void serverTransaction() {


        try {
            if (ConnectionUtils.isNetworkAvailable(getActivity())) {
                ObserverCallBack myObserver = new ObserverCallBack(getActivity());
                myObserver.setLoading(true);
                myObserver.setListener((ObserverCallBack.ServiceCallback) getActivity());
                myObserver.setRequestTag(1);
                WebServiceCallHelper.submitHomeFragment(getActivity(), myObserver, request);
            } else {
                ToastUtils.shortToast(getActivity(), getString(R.string.server_error));
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

//                String customerId="";
//                try {
//                    JSONObject obj = new JSONObject(text);
//                    customerId = obj.getString("id");
//                } catch (Throwable t) {
//                    Log.e("My App", "Could not parse malformed JSON:");
//                }

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
