package com.example.i_padi;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    Button simpan, terus;
    EditText Nama, Umur, Telefon;
    RadioButton Bujang, Berkahwin;
    FirebaseDatabase database;
    DatabaseReference reference;
    Profile profile;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Nama = findViewById(R.id.editText_Nama);
        Umur = findViewById(R.id.editText_Umur);
        Bujang = findViewById(R.id.bujang);
        Berkahwin = findViewById(R.id.kahwin);
        Telefon = findViewById(R.id.editTelefon);
        simpan = findViewById(R.id.btn_simpan);
        terus = findViewById(R.id.btn_teruskan);
        profile = new Profile();


        reference = database.getInstance().getReference().child("Profile");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    i = (int)snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m1 = Bujang.getText().toString();
                String m2 = Berkahwin.getText().toString();

                profile.setNama(Nama.getText().toString());
                profile.setUmur(Umur.getText().toString());
                profile.setTelefon(Telefon.getText().toString());

                reference.child(String.valueOf(i + 1)).setValue(profile);
                if (Bujang.isChecked()) {
                    profile.setStatus(m1);
                    reference.child(String.valueOf(i + 1)).setValue(profile);
                } else {
                    profile.setStatus(m2);
                    reference.child(String.valueOf(i + 1)).setValue(profile);
                }
            }
        });
        terus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this,"Daftar berjaya!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ProfileActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}