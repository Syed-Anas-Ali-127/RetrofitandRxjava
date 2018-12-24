package com.example.android.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Syed Anas Ali on 22-Dec-18.
 */

public interface Api {

    String Base_url = "http://www.mocky.io/v2/";

    @GET("5c1e25c53100000e00fdd24b")
    Call<List<GetnSet>> getDetails();
}
