package com.example.i_padi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText email, password, passwordconfirm;
    private Button btn_daftar, btn_logmasuk;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.edtText_emailRegist);
        password = findViewById(R.id.edtText_passwordRegist);
        passwordconfirm = findViewById(R.id.edtText_passwordconfirmRegist);
        btn_daftar = findViewById(R.id.btn_daftarRegist);
        btn_logmasuk = findViewById(R.id.btn_loginRegist);

        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });

        btn_logmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    private void Register() {
        String Email = email.getText().toString();
        String password1 = password.getText().toString();
        String password2 = passwordconfirm.getText().toString();

        if (TextUtils.isEmpty(Email)) {
            email.setError("Sila masukkan nama pengguna");
            return;
        } else if (TextUtils.isEmpty(password1)) {
            password.setError("Sila masukkan kata laluan");
            return;
        } else if (TextUtils.isEmpty(password2)) {
            passwordconfirm.setError("Sila pastikan kata laluan yang telah dimasukkan");
            return;
        } else if (!password1.equals(password2)) {
            passwordconfirm.setError("Kata laluan yang dimasukkan tidak sama");
            return;
        }
        firebaseAuth.createUserWithEmailAndPassword(Email,password1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this,"Daftar berjaya!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this, ProfileActivity.class);
                    startActivity(intent);
                    finish();
                } else{
                    Toast.makeText(RegisterActivity.this,"Daftar tidak berjaya!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}