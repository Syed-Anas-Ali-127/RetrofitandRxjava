package com.example.android.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Syed Anas Ali on 24-Dec-18.
 */

public interface Api1 {

    String Base_url = "http://www.mocky.io/v2/";

    @GET("5c20a3e52e00000f001e0b5f")
    Call<List<GetnSet>> getDetails();
}
