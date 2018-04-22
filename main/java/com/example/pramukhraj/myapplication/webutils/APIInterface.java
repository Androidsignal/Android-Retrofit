package com.example.pramukhraj.myapplication.webutils;

import com.example.pramukhraj.myapplication.model.NewRes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    // this method is use for get data and set into newRes Aoutomatic
    @GET("/contacts/")
    Call<NewRes> jsonloeded();

/*
    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
*/
}