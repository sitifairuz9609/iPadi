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

public class PercumaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner percumacuma, jenisaktiviticuma, aktiviticuma, itemcuma, ukurancuma;
    EditText edtHargacuma, kuantiticuma;
    Button btn1, btn2;
    ImageButton kembali;
    FirebaseDatabase database;
    DatabaseReference reference;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percuma);

        btn1 = findViewById(R.id.simpan);
        btn2 = findViewById(R.id.retrieve);
        percumacuma = findViewById(R.id.percumacuma);
        jenisaktiviticuma = findViewById(R.id.jenisaktiviticuma);
        aktiviticuma = findViewById(R.id.aktiviticuma);
        itemcuma = findViewById(R.id.itemcuma);
        ukurancuma = findViewById(R.id.ukurancuma);
        btn1 = findViewById(R.id.simpan);
        btn2 = findViewById(R.id.retrieve);
        edtHargacuma = findViewById(R.id.hargacuma);
        floatingActionButton = findViewById(R.id.btnbaru);
        kuantiticuma = findViewById(R.id.kuantiticuma);
        kembali = findViewById(R.id.kembali);
        kuantiticuma = findViewById(R.id.kuantiticuma);
        reference = database.getInstance().getReference().child("Percuma");

        ArrayAdapter adapter11 = ArrayAdapter.createFromResource(this,R.array.Percuma,R.layout.pendapatan_spinner_layout11);
        adapter11.setDropDownViewResource(R.layout.spinner_dropdown_layout11);
        percumacuma.setAdapter(adapter11);
        percumacuma.setOnItemSelectedListener(this);


        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.Aktiviti,R.layout.pendapatan_spinner_layout2);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_layout2);
        jenisaktiviticuma.setAdapter(adapter2);
        jenisaktiviticuma.setOnItemSelectedListener(this);

        ArrayAdapter adapter8 = ArrayAdapter.createFromResource(this,R.array.AktivitiSemua,R.layout.pendapatan_spinner_layout8);
        adapter8.setDropDownViewResource(R.layout.spinner_dropdown_layout3);
        aktiviticuma.setAdapter(adapter8);
        aktiviticuma.setOnItemSelectedListener(this);

        ArrayAdapter adapter9 = ArrayAdapter.createFromResource(this,R.array.ItemSemua,R.layout.pendapatan_spinner_layout9);
        adapter9.setDropDownViewResource(R.layout.spinner_dropdown_layout9);
        itemcuma.setAdapter(adapter9);
        itemcuma.setOnItemSelectedListener(this);

        ArrayAdapter adapter10 = ArrayAdapter.createFromResource(this,R.array.PengukuranTambahan,R.layout.pendapatan_spinner_layout10);
        adapter10.setDropDownViewResource(R.layout.spinner_dropdown_layout10);
        ukurancuma.setAdapter(adapter10);
        ukurancuma.setOnItemSelectedListener(this);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PercumaActivity.this, AktivitiActivity.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String Percumacuma = percumacuma.getSelectedItem().toString();
                String jenisaktiviti = jenisaktiviticuma.getSelectedItem().toString();
                String aktiviti = aktiviticuma.getSelectedItem().toString();
                String item = itemcuma.getSelectedItem().toString();
                String ukuran = ukurancuma.getSelectedItem().toString();
                String harga = edtHargacuma.getText().toString();
                String kuantiti= kuantiticuma.getText().toString();
                String userId = reference.push().getKey();


                Percuma percuma = new Percuma(Percumacuma,jenisaktiviti,aktiviti,item, ukuran, harga,kuantiti,userId);

                reference.child(userId).setValue(percuma);
                Toast.makeText(PercumaActivity.this, "Data disimpan", Toast.LENGTH_SHORT).show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PercumaActivity.this, AktivitiActivity.class);
                startActivity(intent);
                finish();
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PercumaActivity.this, RetrievePercumaActivity.class);
                startActivity(intent);
                finish();

            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PercumaActivity.this, AktivitiActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PercumaActivity.this, PaparPercumaActivity.class);
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