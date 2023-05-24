package com.example.encomm;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

 interface Api {

    @Multipart
    @POST("login.php")
    Call<UserModel> login(@Part("Phone") RequestBody phone,
                          @Part("Password") RequestBody password,
                          @Part("ConCode") RequestBody conCode);
     @Multipart
     @POST("SignUp.php")
     Call<UserModel> Signup(@Part("Name") RequestBody name,
                           @Part("Phone") RequestBody phone,
                            @Part("Email") RequestBody email,
                             @Part("Password") RequestBody password,
                             @Part("ConCode") RequestBody conCode);
}
