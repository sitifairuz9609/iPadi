package com.example.i_padi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PadiActivity extends AppCompatActivity {

    Button simpan, back;
    Padi padi;
    RadioButton manual, tekniktaburterus, mr219, mr220l, ya, tidak;
    FirebaseDatabase database;
    DatabaseReference reference;
    int i = 0;
    EditText Hasiljualankg,HasiljualanRM,Keluasanrelong,Keluasanekar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_padi);

        simpan = findViewById(R.id.simpanpadi);
        back = findViewById(R.id.back);
        padi = new Padi();
        manual = findViewById(R.id.manual);
        tekniktaburterus = findViewById(R.id.taburterus);
        mr219 = findViewById(R.id.MR219);
        mr220l = findViewById(R.id.MR220L);
        ya = findViewById(R.id.ya);
        tidak = findViewById(R.id.tidak);
        Hasiljualankg = findViewById(R.id.hasilkg);
        HasiljualanRM = findViewById(R.id.hasilrm);
        Keluasanrelong = findViewById(R.id.luasrelong);
        Keluasanekar = findViewById(R.id.luasekar);

        reference = database.getInstance().getReference().child("Padi");

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

        simpan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String m1 = manual.getText().toString();
                String m2 = tekniktaburterus.getText().toString();
                String m3 = mr219.getText().toString();
                String m4 = mr220l.getText().toString();
                String m5 = ya.getText().toString();
                String m6 = tidak.getText().toString();

                padi.setHasiljualankg(Hasiljualankg.getText().toString());
                padi.setHasiljualanRM(HasiljualanRM.getText().toString());
                padi.setKeluasanrelong(Keluasanrelong.getText().toString());
                padi.setKeluasanekar(Keluasanekar.getText().toString());
                reference.child(String.valueOf(i+1)).setValue(padi);
                if (manual.isChecked()){
                    padi.setCaratanamanpadi(m1);
                    reference.child(String.valueOf(i+1)).setValue(padi);
                } else {
                    padi.setCaratanamanpadi(m2);
                    reference.child(String.valueOf(i+1)).setValue(padi);
                }
                reference.child(String.valueOf(i+1)).setValue(padi);
                if (mr219.isChecked()){
                    padi.setJenispadi(m3);
                    reference.child(String.valueOf(i+1)).setValue(padi);
                } else {
                    padi.setJenispadi(m4);
                    reference.child(String.valueOf(i + 1)).setValue(padi);
                }
                reference.child(String.valueOf(i+1)).setValue(padi);
                if (ya.isChecked()){
                    padi.setPekerjaanutama(m5);
                    reference.child(String.valueOf(i+1)).setValue(padi);
                } else {
                    padi.setPekerjaanutama(m6);
                    reference.child(String.valueOf(i + 1)).setValue(padi);
                }

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(PadiActivity.this, WelcomeActivity.class);
                startActivity(Intent);
                finish();
            }
        });
    }
}




