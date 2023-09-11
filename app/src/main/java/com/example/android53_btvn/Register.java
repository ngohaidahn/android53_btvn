package com.example.android53_btvn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText txtUsernameRegister;
    private EditText txtPasswordRegister;
    private EditText txtPasswordConfirm;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtUsernameRegister = findViewById(R.id.txtUserNameRegister);
        txtPasswordRegister = findViewById(R.id.txtPasswordRegister);
        txtPasswordConfirm = findViewById(R.id.txtPasswordConfirm);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsernameRegister.getText().toString();
                String password = txtPasswordRegister.getText().toString();
                String passwordConfirm = txtPasswordConfirm.getText().toString();

                if (!username.isEmpty() && !passwordConfirm.isEmpty() && password.isEmpty()) {
                    Intent intent = new Intent();
                    intent.putExtra("key_username", username);
                    intent.putExtra("key_password", password);
                    intent.putExtra("key_passwordConfirm", passwordConfirm);

                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        // đã thất bại khi người dùng click vào nút Back.
        // Khi này sẽ không trả về data.
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }


}