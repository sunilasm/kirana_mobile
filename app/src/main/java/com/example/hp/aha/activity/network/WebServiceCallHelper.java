package com.example.hp.aha.activity.network;


import android.content.Context;

import com.example.hp.aha.activity.model.HomeFragmentRequest;
import com.example.hp.aha.activity.model.LoginRequestDto;
import com.example.hp.aha.activity.model.LoginResponseDto;
import com.example.hp.aha.activity.model.Submit_Reg_Details_Req;
import com.example.hp.aha.activity.model.Submit_Registration_Data_Request;
import com.example.hp.aha.activity.network.retrofit.ApiClient;
import com.example.hp.aha.activity.network.retrofit.ObserverCallBack;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class WebServiceCallHelper {

    private final ServiceHelperListener helperListener;
    private ApiClient service;
    WebApiInterface apiService;

    public interface ServiceHelperListener {
        public void onServiceSuccess();

        public void obServiceFailure(String msg);
    }

    public WebServiceCallHelper(ServiceHelperListener helperListener) {
        this.helperListener = helperListener;
        // apiService = new ApiClient(this).createRetrofitClient();
    }

    public static void loginUser(Context context, ObserverCallBack myObserver, LoginRequestDto params) {
        WebApiInterface apiService = ApiClient.getClient(context).create(WebApiInterface.class);
        Observable<ResponseBody> responseObservable = apiService.loginUser(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

         myObserver.execute(responseObservable, myObserver);

    }

    public static void submitRegistrationInfoFirst(Context context, ObserverCallBack myObserver,Submit_Registration_Data_Request params) {
        WebApiInterface apiService = ApiClient.getClient(context).create(WebApiInterface.class);
        Observable<ResponseBody> responseObservable = apiService.User_Submit_registration_data_first(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        myObserver.execute(responseObservable, myObserver);
        //myObserver.getListener().onSuccess(new GenericResponseModel<ScanInfoResponseDto>(), myObserver.getRequestTag());
    }

    public static void submitHomeFragment(Context context, ObserverCallBack myObserver, HomeFragmentRequest params) {
        WebApiInterface apiService = ApiClient.getClient(context).create(WebApiInterface.class);
        Observable<ResponseBody> responseObservable = apiService.User_Submit_Home_Fragment(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        myObserver.execute(responseObservable, myObserver);
        //myObserver.getListener().onSuccess(new GenericResponseModel<ScanInfoResponseDto>(), myObserver.getRequestTag());
    }

//    public static void submitRegistrationInfoSecond(Context context, ObserverCallBack myObserver,Submit_Reg_Details_Req params) {
//        WebApiInterface apiService = ApiClient.getClient(context).create(WebApiInterface.class);
//        Observable<ResponseBody> responseObservable = apiService.User_Submit_registration_data_second(params)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread());
//
//        myObserver.execute(responseObservable, myObserver);
//        //myObserver.getListener().onSuccess(new GenericResponseModel<ScanInfoResponseDto>(), myObserver.getRequestTag());
//    }
/*


    public static void village_list(ObserverCallBack myObserver) {
        WebApiInterface apiService = ApiClient.getClient().create(WebApiInterface.class);
        Observable<SearchVillageResponseDto> responseObservable = apiService.VillageList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        myObserver.execute(responseObservable, myObserver);
    }



    public static void search_data(ObserverCallBack myObserver, SearchTinRequeest params) {
        WebApiInterface apiService = ApiClient.getClient().create(WebApiInterface.class);
        Observable<SearchTinResponse> responseObservable = apiService.GetSkyBeneficiariesByVillOrTin(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        myObserver.execute(responseObservable, myObserver);
        //myObserver.getListener().onSuccess(new GenericResponseModel<ScanInfoResponseDto>(), myObserver.getRequestTag());
    }

    public static void search_tin_detail_data(ObserverCallBack myObserver, SearchDetailRequest params) {
        WebApiInterface apiService = ApiClient.getClient().create(WebApiInterface.class);
        Observable<SearchDetailResponseModel> responseObservable = apiService.UserDetailsById_METHOD(params.getId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        myObserver.execute(responseObservable, myObserver);
        //myObserver.getListener().onSuccess(new GenericResponseModel<ScanInfoResponseDto>(), myObserver.getRequestTag());
    }
  */
/**
     * Method to call Web service to submit the scan information.
     *
     * @param myObserver Observer to get the result call backs
     * @param params     {@link ScanInfoRequestDto}
     *//*

    public static void submitScanInfoImage(ObserverCallBack myObserver,Submit_All_Data_Request params) {
        WebApiInterface apiService = ApiClient.getClient().create(WebApiInterface.class);
        Observable<ResponseBody> responseObservable = apiService.User_Submit_all_data(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

         myObserver.execute(responseObservable, myObserver);
        //myObserver.getListener().onSuccess(new GenericResponseModel<ScanInfoResponseDto>(), myObserver.getRequestTag());
    }


    public static void submitScanInfo(ObserverCallBack myObserver, ScanInfoRequestDto params) {
        WebApiInterface apiService = ApiClient.getClient().create(WebApiInterface.class);
        Observable<ResponseBody> responseObservable = apiService.submitScanInfo(params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        myObserver.execute(responseObservable, myObserver);
        //myObserver.getListener().onSuccess(new GenericResponseModel<ScanInfoResponseDto>(), myObserver.getRequestTag());
    }
*/


}