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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RetrievePerbelanjaanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner perbelanjaanbelanja, jenisaktivitibelanja, ukuranbelanja;
    EditText edtHargabelanja, kuantitibelanja, aktivitibelanja, itembelanja;
    Button btn1, btn2;
    ImageButton kembali;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_perbelanjaan);

        btn1 = findViewById(R.id.simpan);
        btn2 = findViewById(R.id.retrieve);
        perbelanjaanbelanja = findViewById(R.id.perbelanjaanbelanja);
        jenisaktivitibelanja = findViewById(R.id.jenisaktivitibelanja);
        aktivitibelanja = findViewById(R.id.aktivitibelanja);
        itembelanja = findViewById(R.id.itembelanja);
        ukuranbelanja = findViewById(R.id.ukuranbelanja);
        btn1 = findViewById(R.id.simpan);
        btn2 = findViewById(R.id.retrieve);
        kembali = findViewById(R.id.kembali);
        edtHargabelanja = findViewById(R.id.hargabelanja);
        kuantitibelanja = findViewById(R.id.kuantitibelanja);
        reference = database.getInstance().getReference().child("Perbelanjaan");

        ArrayAdapter adapter6 = ArrayAdapter.createFromResource(this,R.array.Perbelanjaan,R.layout.pendapatan_spinner_layout6);
        adapter6.setDropDownViewResource(R.layout.spinner_dropdown_layout6);
        perbelanjaanbelanja.setAdapter(adapter6);
        perbelanjaanbelanja.setOnItemSelectedListener(this);

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.Aktiviti,R.layout.pendapatan_spinner_layout2);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_layout2);
        jenisaktivitibelanja.setAdapter(adapter2);
        jenisaktivitibelanja.setOnItemSelectedListener(this);

        ArrayAdapter adapter10 = ArrayAdapter.createFromResource(this,R.array.PengukuranTambahan,R.layout.pendapatan_spinner_layout10);
        adapter10.setDropDownViewResource(R.layout.spinner_dropdown_layout10);
        ukuranbelanja.setAdapter(adapter10);
        ukuranbelanja.setOnItemSelectedListener(this);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String Perbelanjaanbelanja = perbelanjaanbelanja.getSelectedItem().toString();
                String jenisaktiviti = jenisaktivitibelanja.getSelectedItem().toString();
                String aktiviti = aktivitibelanja.getText().toString();
                String item = itembelanja.getText().toString();
                String ukuran = ukuranbelanja.getSelectedItem().toString();
                String harga = edtHargabelanja.getText().toString();
                String kuantiti= kuantitibelanja.getText().toString();
                String userId = reference.push().getKey();


                Perbelanjaan perbelanjaan = new Perbelanjaan(Perbelanjaanbelanja,jenisaktiviti,aktiviti,item, ukuran, harga,kuantiti,userId);

                reference.child(userId).setValue(perbelanjaan);
                Toast.makeText(RetrievePerbelanjaanActivity.this, "Data disimpan", Toast.LENGTH_SHORT).show();

            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RetrievePerbelanjaanActivity.this, PerbelanjaanActivity.class);
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