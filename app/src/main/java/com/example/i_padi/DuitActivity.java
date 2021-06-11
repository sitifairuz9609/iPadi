package com.example.i_padi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class DuitActivity extends AppCompatActivity {
    private TextView jualpadi, dapat, belanja, operasi, sewa, upah, buatsendiri, hakmilik,subsidi, pendapatan, perbelanjaan, percuma, kliksini;
    DatabaseReference reference, reference1,reference2,reference3;
    Button simpan;
    ImageView back, papar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duit);

        jualpadi = findViewById(R.id.penjualanpadi);
        dapat = findViewById(R.id.pendapatanlain);
        belanja = findViewById(R.id.perbelanjaanlain);
        operasi = findViewById(R.id.Operasi);
        sewa = findViewById(R.id.Sewa);
        upah = findViewById(R.id.Upah);
        buatsendiri = findViewById(R.id.Buatsendiri);
        hakmilik = findViewById(R.id.Haksendiri);
        sewa = findViewById(R.id.Sewa);
        upah = findViewById(R.id.Upah);
        back = findViewById(R.id.back);
        subsidi = findViewById(R.id.Subsidi);
        pendapatan = findViewById(R.id.jumlahpendapatan);
        perbelanjaan = findViewById(R.id.jumlahperbelanjaan);
        percuma = findViewById(R.id.jumlahpercuma);
        simpan = findViewById(R.id.simpan);
        papar = findViewById(R.id.terus);
        reference1 = FirebaseDatabase.getInstance().getReference().child("Pendapatan");
        reference2 = FirebaseDatabase.getInstance().getReference().child("Perbelanjaan");
        reference3 = FirebaseDatabase.getInstance().getReference().child("Percuma");
        reference = FirebaseDatabase.getInstance().getReference().child("Duit");


        reference1.orderByChild("pendapatan").equalTo("Penjualan Padi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                double sum = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object harga = map.get("harga");
                    double pValue = Double.parseDouble(String.valueOf(harga));
                    sum += pValue;

                    jualpadi.setText(String.valueOf(sum));
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        reference1.orderByChild("pendapatan").equalTo("Pendapatan Lain").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                double sum = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object harga = map.get("harga");
                    double pValue = Double.parseDouble(String.valueOf(harga));
                    sum += pValue;

                    dapat.setText(String.valueOf(sum));
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        reference2.orderByChild("perbelanjaan").equalTo("Upah").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                double sum = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object harga = map.get("harga");
                    double pValue = Double.parseDouble(String.valueOf(harga));
                    sum += pValue;

                    upah.setText(String.valueOf(sum));
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        reference2.orderByChild("perbelanjaan").equalTo("Operasi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                double sum = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object harga = map.get("harga");
                    double pValue = Double.parseDouble(String.valueOf(harga));
                    sum += pValue;

                    operasi.setText(String.valueOf(sum));
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        reference2.orderByChild("perbelanjaan").equalTo("Sewa").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                double sum = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object harga = map.get("harga");
                    double pValue = Double.parseDouble(String.valueOf(harga));
                    sum += pValue;

                    sewa.setText(String.valueOf(sum));
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        reference2.orderByChild("perbelanjaan").equalTo("Perbelanjaan Lain").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                double sum = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object harga = map.get("harga");
                    double pValue = Double.parseDouble(String.valueOf(harga));
                    sum += pValue;

                    belanja.setText(String.valueOf(sum));
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        reference3.orderByChild("percuma").equalTo("Hak Sendiri").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                double sum = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object harga = map.get("harga");
                    double pValue = Double.parseDouble(String.valueOf(harga));
                    sum += pValue;

                    hakmilik.setText(String.valueOf(sum));
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        reference3.orderByChild("percuma").equalTo("Buat Sendiri").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                double sum = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object harga = map.get("harga");
                    double pValue = Double.parseDouble(String.valueOf(harga));
                    sum += pValue;

                    buatsendiri.setText(String.valueOf(sum));
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        reference3.orderByChild("percuma").equalTo("Subsidi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                double sum = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object harga = map.get("harga");
                    double pValue = Double.parseDouble(String.valueOf(harga));
                    sum += pValue;

                    subsidi.setText(String.valueOf(sum));
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                double sum = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object harga = map.get("harga");
                    double pValue = Double.parseDouble(String.valueOf(harga));
                    sum += pValue;

                    pendapatan.setText(String.valueOf(sum));
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                double sum = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object harga = map.get("harga");
                    double pValue = Double.parseDouble(String.valueOf(harga));
                    sum += pValue;

                    perbelanjaan.setText(String.valueOf(sum));
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        reference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                double sum = 0;

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object harga = map.get("harga");
                    double pValue = Double.parseDouble(String.valueOf(harga));
                    sum += pValue;

                    percuma.setText(String.valueOf(sum));
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Jualpadi = jualpadi.getText().toString();
                String Dapat = dapat.getText().toString();
                String Belanja = belanja.getText().toString();
                String Operasi = operasi.getText().toString();
                String Sewa = sewa.getText().toString();
                String Upah = upah.getText().toString();
                String Subsidi = subsidi.getText().toString();
                String Hakmilik = hakmilik.getText().toString();
                String Buatsendiri = buatsendiri.getText().toString();
                String Pendapatan = pendapatan.getText().toString();
                String Perbelanjaan = perbelanjaan.getText().toString();
                String Percuma = percuma.getText().toString();


                Duit duit = new Duit(Jualpadi,Dapat,Belanja,Operasi,Sewa,Upah,Subsidi,Hakmilik,Buatsendiri,Pendapatan,Perbelanjaan,Percuma);

                reference.push().setValue(duit);
            }
        });
        papar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DuitActivity.this, MoneyActivity.class);
                startActivity(intent);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DuitActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}