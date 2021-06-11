package com.example.i_padi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class AktivitiActivity extends AppCompatActivity {
    ImageView pendapatan, perbelanjaan, percuma, kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktiviti);

        pendapatan = findViewById(R.id.pendapatan);
        perbelanjaan = findViewById(R.id.perbelanjaan);
        percuma = findViewById(R.id.percuma);
        kembali = findViewById(R.id.kembali);

        pendapatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AktivitiActivity.this, PendapatanActivity.class);
                startActivity(intent);
                finish();
            }
        });

        perbelanjaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AktivitiActivity.this, PerbelanjaanActivity.class);
                startActivity(intent);
                finish();
            }
        });
        percuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AktivitiActivity.this, PercumaActivity.class);
                startActivity(intent);
                finish();
            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AktivitiActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}