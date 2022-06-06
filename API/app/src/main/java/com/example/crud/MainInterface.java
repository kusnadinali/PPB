package com.example.crud;

import org.w3c.dom.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface MainInterface {

    @POST("api/login")
    Call<LoginResponse> postLogin(@Body BodyLogin bodyLogin);

    @POST("api/register")
    Call<RegisterResponse> postRegister(@Body BodyRegister bodyRegister);

    @GET("api/users?page=2")
    Call<ListUserResponse> getList();

    @GET("api/users/{id}")
    Call<SingleUserResponse> getSingleList(@Path("id") int id);

    @GET("api/unknown")
    Call<ListResourceResponse> getListResource();

    @GET("api/unknown/{id}")
    Call<SingleResourceResponse> getSingleResource(@Path("id") int id);

    @FormUrlEncoded
    @POST("api/users")
    Call<CreateUserResponse> createUser(
        @Field("name") String name,
        @Field("job") String job
    );

    @FormUrlEncoded
    @PUT("/api/users/{id}")
    Call<UpdateUserResponse> updateUser(
            @Field("id") int id,
            @Field("name") String name,
            @Field("job") String job
    );

    @FormUrlEncoded
    @PATCH("/api/users/{id}")
    Call<UpdateUserResponse> updatePatchUser(
            @Path("id") int id,
            @Field("name") String name,
            @Field("job") String job
    );

    @DELETE("api/users/{id}")
    Call<Void> deleteUser(
            @Path("id") int id
    );

    @GET("/api/users?delay=3")
    Call<ListUserResponse> getUserDelay();
}
