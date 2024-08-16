package com.example.foodorderapp2.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderapp2.R;
import com.example.foodorderapp2.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class SignupActivity extends BaseActivity {
ActivitySignupBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
    }
    public void setVariable(){
       binding.signupBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email=binding.userEdt.getText().toString();
               String password=binding.passEdt.getText().toString();
               if(password.length()<6){
                   Toast.makeText(SignupActivity.this, "Your password must be 6 characters!", Toast.LENGTH_SHORT).show();
                   return;
               }
               mAuth.createUserWithEmailAndPassword(email,password)
                       .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if(task.isComplete()){
                                   Log.i(TAG,"On Complete: ");
                                   startActivity(new Intent(SignupActivity.this,MainActivity.class));
                               }
                               else{
                                   Log.i(TAG,"failure: "+task.getException());
                                   Toast.makeText(SignupActivity.this, "Authentication Failed!", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
           }
       });
    }
}