package com.example.i_padi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PerbelanjaanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner perbelanjaanbelanja, jenisaktivitibelanja, aktivitibelanja, itembelanja, ukuranbelanja;
    EditText edtHargabelanja, kuantitibelanja;
    Button btn1, btn2;
    ImageButton kembali;
    FirebaseDatabase database;
    DatabaseReference reference;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perbelanjaan);

        btn1 = findViewById(R.id.simpan);
        btn2 = findViewById(R.id.retrieve);
        perbelanjaanbelanja = findViewById(R.id.perbelanjaanbelanja);
        jenisaktivitibelanja = findViewById(R.id.jenisaktivitibelanja);
        aktivitibelanja = findViewById(R.id.aktivitibelanja);
        itembelanja = findViewById(R.id.itembelanja);
        ukuranbelanja = findViewById(R.id.ukuranbelanja);
        btn1 = findViewById(R.id.simpan);
        btn2 = findViewById(R.id.retrieve);
        edtHargabelanja = findViewById(R.id.hargabelanja);
        floatingActionButton = findViewById(R.id.btnbaru);
        kuantitibelanja = findViewById(R.id.kuantitibelanja);
        kembali = findViewById(R.id.kembali);
        kuantitibelanja = findViewById(R.id.kuantitibelanja);
        reference = database.getInstance().getReference().child("Perbelanjaan");

        ArrayAdapter adapter6 = ArrayAdapter.createFromResource(this,R.array.Perbelanjaan,R.layout.pendapatan_spinner_layout6);
        adapter6.setDropDownViewResource(R.layout.spinner_dropdown_layout1);
        perbelanjaanbelanja.setAdapter(adapter6);
        perbelanjaanbelanja.setOnItemSelectedListener(this);

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.Aktiviti,R.layout.pendapatan_spinner_layout2);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_layout2);
        jenisaktivitibelanja.setAdapter(adapter2);
        jenisaktivitibelanja.setOnItemSelectedListener(this);

        ArrayAdapter adapter8 = ArrayAdapter.createFromResource(this,R.array.AktivitiSemua,R.layout.pendapatan_spinner_layout8);
        adapter8.setDropDownViewResource(R.layout.spinner_dropdown_layout3);
        aktivitibelanja.setAdapter(adapter8);
        aktivitibelanja.setOnItemSelectedListener(this);

        ArrayAdapter adapter9 = ArrayAdapter.createFromResource(this,R.array.ItemSemua,R.layout.pendapatan_spinner_layout9);
        adapter9.setDropDownViewResource(R.layout.spinner_dropdown_layout9);
        itembelanja.setAdapter(adapter9);
        itembelanja.setOnItemSelectedListener(this);

        ArrayAdapter adapter10 = ArrayAdapter.createFromResource(this,R.array.PengukuranTambahan,R.layout.pendapatan_spinner_layout10);
        adapter10.setDropDownViewResource(R.layout.spinner_dropdown_layout10);
        ukuranbelanja.setAdapter(adapter10);
        ukuranbelanja.setOnItemSelectedListener(this);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerbelanjaanActivity.this, AktivitiActivity.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String Perbelanjaanbelanja = perbelanjaanbelanja.getSelectedItem().toString();
                String jenisaktiviti = jenisaktivitibelanja.getSelectedItem().toString();
                String aktiviti = aktivitibelanja.getSelectedItem().toString();
                String item = itembelanja.getSelectedItem().toString();
                String ukuran = ukuranbelanja.getSelectedItem().toString();
                String harga = edtHargabelanja.getText().toString();
                String kuantiti= kuantitibelanja.getText().toString();
                String userId = reference.push().getKey();


                Perbelanjaan perbelanjaan = new Perbelanjaan(Perbelanjaanbelanja,jenisaktiviti,aktiviti,item, ukuran, harga,kuantiti,userId);

                reference.child(userId).setValue(perbelanjaan);
                Toast.makeText(PerbelanjaanActivity.this, "Data disimpan", Toast.LENGTH_SHORT).show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerbelanjaanActivity.this, AktivitiActivity.class);
                startActivity(intent);
                finish();
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerbelanjaanActivity.this, RetrievePerbelanjaanActivity.class);
                startActivity(intent);
                finish();

            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerbelanjaanActivity.this, AktivitiActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerbelanjaanActivity.this, PaparPerbelanjaanActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}