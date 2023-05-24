package com.example.encomm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class create extends AppCompatActivity {
EditText name;
    EditText phone;
    EditText email;
    EditText password;

    EditText cancode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        name=  findViewById(R.id.ename);
        phone=findViewById(R.id.ephone);
        email=findViewById(R.id.eemail);
        password=findViewById(R.id.epass);
        Button btn2=findViewById(R.id.btn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Signup();
                Intent intent=new Intent(create.this,MainActivity.class);
                startActivity(intent);


            }
        });}
        public void Signup() {

            ProgressDialog pd = new ProgressDialog(this);
            pd.show();
            Api service = RetrofitClint.getApiService();

            RequestBody nameRequestBody = RequestBody.create(MediaType.parse("text/plain"), name.getText().toString());
            RequestBody phoneRequestBody = RequestBody.create(MediaType.parse("text/plain"),phone.getText().toString());
            RequestBody emailRequestBody = RequestBody.create(MediaType.parse("text/plain"), email.getText().toString());
            RequestBody passwordRequestBody = RequestBody.create(MediaType.parse("text/plain"), password.getText().toString());
            RequestBody conCodeRequestBody = RequestBody.create(MediaType.parse("text/plain"), "962");
            Call<UserModel> retCall = service.Signup(nameRequestBody,phoneRequestBody,emailRequestBody,passwordRequestBody,conCodeRequestBody);
            retCall.enqueue(new Callback<UserModel>() {
                @Override

                public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                    pd.dismiss();
                    if (response.body().isResult()) {
                        Toast.makeText(create.this, "done", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(create.this, response.body().getMsg(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable t) {
                    pd.dismiss();
                }
            });
    }
}