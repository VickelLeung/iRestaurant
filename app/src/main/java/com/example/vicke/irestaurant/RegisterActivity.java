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
import android.widget.Toast;

import com.example.vicke.irestaurant.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etUsername;
    private EditText etPhone;
    private Button btnRegister;
    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = (EditText) findViewById(R.id.etRegEmail);
        etPassword = (EditText) findViewById(R.id.etRegPassword);
        etUsername = (EditText) findViewById(R.id.etRegUsername);
        etPhone = (EditText) findViewById(R.id.etRegPhone);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();


        btnRegister.setOnClickListener(this);

    }

    private void registerUser(){
        final String email = etEmail.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();
        final String username = etUsername.getText().toString().trim();
        final String phone = etPhone.getText().toString().trim();

       int passLength = etPassword.getText().length();

        //check if variable are empty or not
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if(passLength < 6){
            Toast.makeText(this, "Password length must be greater than 6", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(username)){
            Toast.makeText(this, "Username is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(phone)){
            Toast.makeText(this, "Phone is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering user please wait...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        //user sucessfully logging
                        if(task.isSuccessful()) {
                            //display to user sucessfully registered
                            Toast.makeText(RegisterActivity.this, "Register sucessful", Toast.LENGTH_SHORT).show();
                            //save information to database
                            saveUserInfo(username, password, phone, email);
                            //go back to login activity
                            Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(loginIntent);
                        }
                        else
                            Toast.makeText(RegisterActivity.this, "Couldn't register, try again.", Toast.LENGTH_SHORT).show();

                        progressDialog.hide();
                    }
                });

    }

    private void saveUserInfo(String username, String password, String phone, String email){

        //name,pass,email,phone
        User user = new User(username,password,email,phone);

        FirebaseUser fbUser = firebaseAuth.getCurrentUser();
        databaseReference.child(fbUser.getUid()).setValue(user);

    }

    @Override
    public void onClick(View v) {

        if(v == btnRegister){
            registerUser();
        }
    }


}