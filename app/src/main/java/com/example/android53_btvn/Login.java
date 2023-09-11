package com.example.android53_btvn;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnLogin;
    private TextView tvRegister;

    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvRegister = findViewById(R.id.tvRegister);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lam gi do khi bam nao nut login
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);


            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(Login.this, Register.class);
                getData.launch(intent);

//                startActivity(intent);

            }
        });
    }
    ActivityResultLauncher<Intent> getData = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent intent = result.getData(); // lay ve goi du lieu

                        String username = intent.getStringExtra("username");
                        txtUsername.setText(username);
                        String password = intent.getStringExtra("password");
                        txtPassword.setText(password);

                        Toast.makeText(Login.this, "dang nhap", Toast.LENGTH_SHORT).show();
                    }
                }
            });
}