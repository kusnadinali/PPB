package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.rvListUser)
    RecyclerView rvListUser;
    @BindView(R.id.tvResponseCode)
    TextView tvResponseCode;

    private List<DataItemUser> listItem;
    private DataItemUser item;
    private List<DataItemResource> listItemColor;
    private DataItemResource itemResource;
    private RecyclerAdapter adapter;
    private SingleAdapter sAdapter;
    private ResourceAdapter rAdapter;
    private SingleResourceAdapter srAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //getListUser();
        //getSingleUser();
        //getListColor();
        //getSingleColor();
        //createUser();
        //updateUser();
        //updatePatchUser();
        //deleteUser();
        getListUserDelay();
    }

    private void getListUser(){
        RestClient.getService().getList().enqueue(new Callback<ListUserResponse>() {
            @Override
            public void onResponse(Call<ListUserResponse> call, Response<ListUserResponse> response) {
                if (response.isSuccessful()){
                    tvResponseCode.setText("Response Code: " +response.code());

                    listItem = response.body().getData();

                    adapter = new RecyclerAdapter(listItem, MainActivity.this);
                    rvListUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvListUser.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListUserResponse> call, Throwable t) {
                tvResponseCode.setText(t.getMessage());
            }
        });
    }

    private void getSingleUser(){
        RestClient.getService().getSingleList(2).enqueue(new Callback<SingleUserResponse>() {
            @Override
            public void onResponse(Call<SingleUserResponse> call, Response<SingleUserResponse> response) {
                if (!response.isSuccessful()){
                    tvResponseCode.setText("Response Code " + response.code());
                    return;
                }
                if (response.isSuccessful()){
                    tvResponseCode.setText("Response Code: " +response.code());
                    item = response.body().getData();
                    sAdapter = new SingleAdapter(item, MainActivity.this);
                    rvListUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvListUser.setAdapter(sAdapter);
                }
            }

            @Override
            public void onFailure(Call<SingleUserResponse> call, Throwable t) {
                tvResponseCode.setText(t.getMessage());
            }
        });
    }

    private void getListColor(){
        RestClient.getService().getListResource().enqueue(new Callback<ListResourceResponse>() {
            @Override
            public void onResponse(Call<ListResourceResponse> call, Response<ListResourceResponse> response) {
                if (!response.isSuccessful()){
                    tvResponseCode.setText("Response Code " + response.code());
                    return;
                }
                if (response.isSuccessful()){
                    tvResponseCode.setText("Response Code: " +response.code());
                    listItemColor = response.body().getData();
                    Log.d(TAG, "onResponse: " + response.body().toString());
                    rAdapter = new ResourceAdapter(listItemColor, MainActivity.this);
                    rvListUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvListUser.setAdapter(rAdapter);
                }
            }

            @Override
            public void onFailure(Call<ListResourceResponse> call, Throwable t) {
                tvResponseCode.setText(t.getMessage());
            }
        });
    }

    private void getSingleColor(){
        RestClient.getService().getSingleResource(23).enqueue(new Callback<SingleResourceResponse>() {
            @Override
            public void onResponse(Call<SingleResourceResponse> call, Response<SingleResourceResponse> response) {
                if (!response.isSuccessful()){
                    tvResponseCode.setText("Response Code " + response.code());
                    return;
                }
                if (response.isSuccessful()){
                    tvResponseCode.setText("Response Code: " +response.code());
                    itemResource = response.body().getData();
                    Log.d(TAG, "onResponse: " + response.body().toString());
                    srAdapter = new SingleResourceAdapter(itemResource, MainActivity.this);
                    rvListUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvListUser.setAdapter(srAdapter);
                }
            }

            @Override
            public void onFailure(Call<SingleResourceResponse> call, Throwable t) {
                tvResponseCode.setText(t.getMessage());
            }
        });
    }

    private void createUser() {
        RestClient.getService().createUser("morpheus","leader").enqueue(new Callback<CreateUserResponse>() {
            // TODO method dibawah otomatis pada saat new Callback
            @Override
            public void onResponse(Call<CreateUserResponse> call, Response<CreateUserResponse> response) {
                if (!response.isSuccessful()){
                    tvResponseCode.setText("Resonse Code " + response.code());
                    return;
                }
                if (response.isSuccessful()){
                    tvResponseCode.setText("Response Code: " +response.code()+"\n" + response.body().toString());
                    Toast.makeText(MainActivity.this, "create success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CreateUserResponse> call, Throwable t) {
                tvResponseCode.setText(t.getMessage());
            }
        });
    }

    private void updateUser(){
        RestClient.getService().updateUser(2,"morpheus","zion resident").enqueue(new Callback<UpdateUserResponse>() {
            // TODO method dibawah otomatis pada saat new Callback
            @Override
            public void onResponse(Call<UpdateUserResponse> call, Response<UpdateUserResponse> response) {
                if (!response.isSuccessful()){
                    tvResponseCode.setText("Resonse Code " + response.code());
                    return;
                }
                if (response.isSuccessful()){
                    tvResponseCode.setText("Response Code: " +response.code()+"\n" + response.body().toString());
                    Toast.makeText(MainActivity.this, "update success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UpdateUserResponse> call, Throwable t) {
                tvResponseCode.setText(t.getMessage());
            }
        });
    }

    private void updatePatchUser(){
        RestClient.getService().updatePatchUser(2,"morpheus","zion resident").enqueue(new Callback<UpdateUserResponse>() {
            // TODO method dibawah otomatis pada saat new Callback
            @Override
            public void onResponse(Call<UpdateUserResponse> call, Response<UpdateUserResponse> response) {
                if (!response.isSuccessful()){
                    tvResponseCode.setText("Resonse Code " + response.code());
                    return;
                }
                if (response.isSuccessful()){
                    tvResponseCode.setText("Response Code: " +response.code()+"\n" + response.body().toString());
                    Toast.makeText(MainActivity.this, "update success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UpdateUserResponse> call, Throwable t) {
                tvResponseCode.setText(t.getMessage());
            }
        });
    }

    private void deleteUser(){
        RestClient.getService().deleteUser(2).enqueue(new Callback<Void>() {
            // TODO method dibawah otomatis pada saat new Callback
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()){
                    tvResponseCode.setText("Resonse Code " + response.code());
                    return;
                }
                if (response.isSuccessful()){
                    tvResponseCode.setText("Response Code: " +response.code());
                    Toast.makeText(MainActivity.this, "delete success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                tvResponseCode.setText(t.getMessage());
            }
        });
    }

    private void getListUserDelay(){
        RestClient.getService().getUserDelay().enqueue(new Callback<ListUserResponse>() {
            @Override
            public void onResponse(Call<ListUserResponse> call, Response<ListUserResponse> response) {
                if (response.isSuccessful()){
                    tvResponseCode.setText("Response Code: " +response.code());

                    listItem = response.body().getData();

                    adapter = new RecyclerAdapter(listItem, MainActivity.this);
                    rvListUser.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    rvListUser.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ListUserResponse> call, Throwable t) {
                tvResponseCode.setText(t.getMessage());
            }
        });
    }
}