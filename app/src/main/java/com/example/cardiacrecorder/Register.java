package com.example.cardiacrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    TextView t11,t22,t44;
    EditText e11,e33;
    Button b11;
    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(Register.this,MainActivity.class);
            startActivity(intent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        t11=(TextView) findViewById(R.id.textView2);
        t22=(TextView) findViewById(R.id.textView4);
        t44=(TextView) findViewById(R.id.textView42);
        e11=(EditText) findViewById(R.id.editTextTextPersonName2);
        e33=(EditText) findViewById(R.id.editTextTextPersonName22);
        b11=(Button) findViewById(R.id.button);
        mAuth=FirebaseAuth.getInstance();

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email,password;
                email=String.valueOf(e11.getText());
                password=String.valueOf(e33.getText());
                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(Register.this, "Enter Email.", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(Register.this, "Enter PAssword.", Toast.LENGTH_SHORT).show();
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(Register.this, "Registration Successful.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Register.this,LoginPage.class);
                                    startActivity(intent);
                                }
                                else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}