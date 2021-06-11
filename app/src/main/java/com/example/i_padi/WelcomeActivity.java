package com.example.i_padi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    ImageView padi,aktiviti,duit,inovasi,akaunpengguna,keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        padi = findViewById(R.id.padi);
        aktiviti = findViewById(R.id.aktiviti);
        duit = findViewById(R.id.duit);
        inovasi = findViewById(R.id.innovasi);

        padi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WelcomeActivity.this,"Daftar berjaya!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(WelcomeActivity.this, PadiActivity.class);
                startActivity(intent);
                finish();
            }
        });

        aktiviti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WelcomeActivity.this,"Daftar berjaya!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(WelcomeActivity.this, AktivitiActivity.class);
                startActivity(intent);
                finish();
            }
        });
        duit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WelcomeActivity.this,"Daftar berjaya!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(WelcomeActivity.this, DuitActivity.class);
                startActivity(intent);
                finish();

            }
        });
        inovasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WelcomeActivity.this,"Daftar berjaya!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(WelcomeActivity.this, InovasiActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}