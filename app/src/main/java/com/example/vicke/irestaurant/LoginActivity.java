package com.example.vicke.irestaurant;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextView tvRegister, tvForgot;
    private EditText etEmail, etPassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        tvForgot = (TextView) findViewById(R.id.tvForgot);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            //start profile activity...
//            Intent menuIntent = new Intent(LoginActivity.this, MenuActivity.class);
//            startActivity(menuIntent);

        }

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class );
                startActivity(registerIntent);
            }
        });

        tvForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent forgotIntent = new Intent(LoginActivity.this, ForgotActivity.class);
                startActivity(forgotIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userLogin();

            }
        });
    }

    private void userLogin(){
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        //check if variable are empty or not
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Attempt to login...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login sucessful", Toast.LENGTH_SHORT).show();
                            //start profile
                            finish();
                            Intent menuIntent = new Intent(LoginActivity.this, MenuActivity.class);
                            startActivity(menuIntent);
                        }
                        else
                            Toast.makeText(LoginActivity.this, "Login failed, please try again", Toast.LENGTH_SHORT).show();
                    }
                });

    }

}