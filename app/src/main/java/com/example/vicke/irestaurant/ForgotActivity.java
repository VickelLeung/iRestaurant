package com.example.vicke.irestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotActivity extends AppCompatActivity {

    private EditText etEmail;
    private Button btnRetrieve;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        etEmail = (EditText) findViewById(R.id.etForgotEmail);
        btnRetrieve = (Button) findViewById(R.id.btnRetrieve);
        firebaseAuth = FirebaseAuth.getInstance();

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                retrievePass();
            }
        });

    }

    private void retrievePass(){

        String email = etEmail.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            //display success
                            Toast.makeText(ForgotActivity.this, "password reset sent to your email.", Toast.LENGTH_SHORT).show();

                            //go back to login page
                            Intent loginIntent = new Intent(ForgotActivity.this, LoginActivity.class);
                            startActivity(loginIntent);
                        }
                        else
                            Toast.makeText(ForgotActivity.this, "Error, please try again", Toast.LENGTH_SHORT).show();
                    }
                });
        }
}