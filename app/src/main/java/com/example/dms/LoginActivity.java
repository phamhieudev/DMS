package com.example.dms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dms.ui.DashboardFragment;

public class LoginActivity extends AppCompatActivity {

    private TextView txtUsername;
    private TextView txtPassword;
    private Button btnlogin;

    boolean isValid = false;

    private int counter = 5;
    private  String username = "Hieu";
    private  String pass = "1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsername = (TextView)findViewById(R.id.txtUsername);
        txtPassword = (TextView) findViewById(R.id.txtPassword);
        btnlogin = (Button)findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = txtUsername.getText().toString();
                String inputPassword = txtPassword.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Vui lòng nhập đủ thông tin",Toast.LENGTH_SHORT).show();
                }
                else {

                    isValid = validate(inputName,inputPassword);
                    if(!isValid){
                        counter--;
                        Toast.makeText(LoginActivity.this,"Sai thông tin",Toast.LENGTH_SHORT).show();
                        if (counter == 0){
                            btnlogin.setEnabled(false);
                        }
                    }
                    else {
                        Toast.makeText(LoginActivity.this,"Login success",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                        intent.putExtra("sessionname",inputName);
                        startActivity(intent);
                    }

                }
            }
        });
    }

    private boolean validate(String name,String password){
        if (name.equals(username)&&password.equals(pass)){
            return true;
        }
        return false;
    }
}