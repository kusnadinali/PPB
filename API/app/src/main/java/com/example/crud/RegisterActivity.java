package com.example.crud;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.edtPass)
    EditText edtPassword;
    @BindView(R.id.btnRegister)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnRegister)
    public void onViewClicked() {

        BodyRegister bodyRegister =  new BodyRegister();
        RegisterResponse errorResponse = new RegisterResponse();
        bodyRegister.setEmail(edtEmail.getText().toString());
        bodyRegister.setPassword(edtPassword.getText().toString());



        RestClient.getService().postRegister(bodyRegister).enqueue(new Callback<RegisterResponse>() {
            // TODO method dibawah otomatis pada saat new Callback
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {
                    String registerResponse = "Id: " + response.body().getId() + "\nToken: " + response.body().getToken();
                    Toast.makeText(RegisterActivity.this, registerResponse, Toast.LENGTH_SHORT).show();
                    Log.i("Response", response.message());
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }else{
                    if (TextUtils.isEmpty(edtEmail.getText())){
                        errorResponse.setError("Missing Email");
                    }else if (TextUtils.isEmpty(edtPassword.getText())){
                        errorResponse.setError("Missing Password");
                    }
                    String registerResponse = response.code() + "\n" +  errorResponse.getError();
                    Toast.makeText(RegisterActivity.this, registerResponse, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }

}
