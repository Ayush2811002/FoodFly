package com.example.foodfly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class MainActivity extends AppCompatActivity {
EditText box1,box2,box3,box4,box5,box6;
TextView textView;
String getotpbackend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        box1=findViewById(R.id.int1);
        box2=findViewById(R.id.int2);
        box3=findViewById(R.id.int3);
        box4=findViewById(R.id.int4);
        box5=findViewById(R.id.int5);
        box6=findViewById(R.id.int6);

        textView=findViewById(R.id.textView);
        textView.setText(String.format("+91-%s",getIntent().getStringExtra("mobile")));
        getotpbackend=getIntent().getStringExtra("backendotp");
        ProgressBar progressBar=findViewById(R.id.depr2);
        final Button button2=findViewById(R.id.btn3);

         button2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(!box1.getText().toString().trim().isEmpty()&& !box2.getText().toString().trim().isEmpty()&& !box3.getText().toString().trim().isEmpty() && !box4.getText().toString().trim().isEmpty() && !box5.getText().toString().trim().isEmpty() && !box6.getText().toString().trim().isEmpty()){
                  String entercodeotp=box1.getText().toString()+
                          box2.getText().toString()+
                          box3.getText().toString()+
                          box4.getText().toString()+
                          box5.getText().toString()+
                          box6.getText().toString();

                  if(getotpbackend!=null){

                      progressBar.setVisibility(View.VISIBLE);
                      button2.setVisibility(View.INVISIBLE);

                      PhoneAuthCredential phoneAuthCredential= PhoneAuthProvider.getCredential(
                              getotpbackend,entercodeotp
                      );
                      FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                              .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                  @Override
                                  public void onComplete(@NonNull Task<AuthResult> task) {
                                      progressBar.setVisibility(View.GONE);
                                      button2.setVisibility(View.VISIBLE);
                                      if(task.isSuccessful()){
                                          Intent intent=new Intent(getApplicationContext(),mainpage.class);
                                          intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                          startActivity(intent);

                                      }else {
                                          Toast.makeText(MainActivity.this,"Enter correct OTP",Toast.LENGTH_SHORT).show();

                                      }
                                  }
                              });

                  }else {
                      Toast.makeText(MainActivity.this,"Otp verify",Toast.LENGTH_SHORT).show();
                  }

//


                 }else {

                     Toast.makeText(MainActivity.this,"please enter all number",Toast.LENGTH_SHORT).show();
                 }
             }
         });


         numberotmove();
         findViewById(R.id.resnd).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });
        TextView resendlabel;
        resendlabel=findViewById(R.id.resnd);
        resendlabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void numberotmove() {

        box1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!s.toString().trim().isEmpty()) {
                    box2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        box2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!s.toString().trim().isEmpty()) {
                    box3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        box3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!s.toString().trim().isEmpty()) {
                    box4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        box4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!s.toString().trim().isEmpty()) {
                    box5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        box5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!s.toString().trim().isEmpty()) {
                    box6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}