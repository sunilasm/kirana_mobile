package com.example.hp.aha.activity.network;

import com.example.hp.aha.activity.model.HomeFragmentRequest;
import com.example.hp.aha.activity.model.LoginRequestDto;
import com.example.hp.aha.activity.model.LoginResponseDto;
import com.example.hp.aha.activity.model.Submit_Reg_Details_Req;
import com.example.hp.aha.activity.model.Submit_Registration_Data_Request;

import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Interface for the web services
 */

public interface WebApiInterface {


   // @FormUrlEncoded
    @POST("integration/customer/token")
    Observable<ResponseBody> loginUser(@Body LoginRequestDto params);

 // http://13.233.41.0/rest/V1/integration/customer/token?username=altenasmmailtest@yopmail.com&password=Admin@123
   // BASE_URL = "http://13.233.41.0/rest/V1/";

  //  Content-Type: application/x-www-form-urlencoded

    @POST("customers")
    Observable<ResponseBody> User_Submit_registration_data_first(@Body Submit_Registration_Data_Request requestDto);

    // BASE_URL =
    //      "http://13.233.41.0/rest/V1/";
    // URL: http://13.233.41.0/rest/all/V1/categories

    @POST("categories")
    Observable<ResponseBody> User_Submit_Home_Fragment(@Body HomeFragmentRequest requestDto);

//    @POST("customers/billingAddress")
//    Observable<ResponseBody> User_Submit_registration_data_second(@Body Submit_Reg_Details_Req requestDto);


  //  public static final String BASE_URL = "http://13.233.41.0/rest/V1/";

//"http://13.233.41.0/rest/V1/integration/customer/"

  /*
    @POST(ApiMethods.SUBMIT_SCAN_INFO)
    Observable<ResponseBody> submitScanInfo(@Body ScanInfoRequestDto requestDto);


    @GET(ApiMethods.VillageList_METHOD)
    Observable<SearchVillageResponseDto> VillageList();


    @POST(ApiMethods.SearchList_METHOD)
    Observable<SearchTinResponse> GetSkyBeneficiariesByVillOrTin(@Body SearchTinRequeest requestDto);


    @GET(ApiMethods.UserDetailsById_)
    Observable<SearchDetailResponseModel> UserDetailsById_METHOD(@Query("Id") long Id);


    @POST(ApiMethods.PostBenificiary)
    Observable<ResponseBody> User_Submit_all_data(@Body Submit_All_Data_Request requestDto);*/

}
