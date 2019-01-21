package com.example.hp.aha.activity.network.retrofit;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.hp.aha.activity.utils.ConnectionUtils;
import com.example.hp.aha.activity.utils.LogManager;
import com.example.hp.aha.activity.utils.ToastUtils;

import rx.Observable;
import rx.Observer;
import rx.Subscription;


public class ObserverCallBack<T> implements Observer<T> {
    private Context context;
    private ProgressDialog pDialog = null;
    private Subscription subscription;
    private ServiceCallback<T> listener;
    private boolean isLoading;
    private int requestTag;
    private String loadingMsg;

    public void setLoadingMsg(String loadingMsg) {
        this.loadingMsg = loadingMsg;
    }

    public String getLoadingMsg() {
        return loadingMsg;
    }

    public ObserverCallBack(Context context) {
        this.context = context;
        loadingMsg = "Loading Please Wait...";
    }

    public void setListener(ServiceCallback listener) {
        this.listener = listener;
    }

    public ServiceCallback<T> getListener() {
        return listener;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    public int getRequestTag() {
        return requestTag;
    }

    public void setRequestTag(int requestTag) {
        this.requestTag = requestTag;
    }

    public void execute(Observable observable, ObserverCallBack myObserver) {
        if (ConnectionUtils.isNetworkAvailable(context)) {
            if (isLoading()) {
                showProgressDialog(context);
            }
            subscription = observable.subscribe(myObserver);
        } else {
            ConnectionUtils.alertMessage(context, "Exception");
        }
    }


    public void showProgressDialog(Context context) {
        pDialog = new ProgressDialog(context);
        pDialog.setMessage(getLoadingMsg());
        pDialog.setCancelable(false);
        pDialog.show();
    }

    public void dismissProgressDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
        }
    }


    @Override
    public void onCompleted() {
        LogManager.d("SuccessApi vibansal", "You r aweosome one");
    }

    @Override
    public void onError(Throwable e) {
        try {
//        dismissProgressDialog();
            if (isLoading()) {
                dismissProgressDialog();
            }
            LogManager.d("ErrorIn", e.getMessage());
            listener.onError(e.getMessage(), e);
            subscription.unsubscribe();
            if (e.getMessage() != null && e.getMessage().startsWith("java.lang.IllegalStateException")) {
                ToastUtils.showToast(context, "ServerError", false);
            }

        } catch (Throwable er) {
            // Log the exception
            LogManager.d("ErrorIn", er.getMessage());
        }

    }

    @Override
    public void onNext(T response) {
        if (isLoading()) {
            dismissProgressDialog();
        }
        listener.onSuccess(response, getRequestTag());
        subscription.unsubscribe();
    }

    public interface ServiceCallback<T> {
        void onSuccess(T response, int tag);

        void onError(String msg, Throwable error);
    }
}