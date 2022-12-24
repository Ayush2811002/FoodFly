package com.example.foodfly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;
    Button button;
    ProgressBar mku;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText=findViewById(R.id.edit1);
        button=findViewById(R.id.btn1);
        mku=findViewById(R.id.pg1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.getText().toString().trim().isEmpty()){
                    if((editText.getText().toString().trim()).length()==10){
                        mku.setVisibility(View.VISIBLE);
                        button.setVisibility(View.INVISIBLE);

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + editText.getText().toString(),
                                60,
                                TimeUnit.SECONDS,
                                MainActivity2.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                        mku.setVisibility(View.GONE);
                                        button.setVisibility(View.VISIBLE);

                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        mku.setVisibility(View.GONE);
                                        button.setVisibility(View.VISIBLE);
                                        Toast.makeText(MainActivity2.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                                        mku.setVisibility(View.GONE);
                                        button.setVisibility(View.VISIBLE);

                                        Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                        intent.putExtra("mobile",editText.getText().toString());
                                        intent.putExtra("mobile",editText.getText().toString());
                                        intent.putExtra("backendotp",backendotp);
                     startActivity(intent);
                                    }
                                }

                        );
//                        Intent intent =new Intent(getApplicationContext(),MainActivity.class);
//                        intent.putExtra("mobile",editText.getText().toString());
//                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity2.this,"please enter correct number",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity2.this,"Enter mobile number",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}