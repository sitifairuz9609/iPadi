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

public class RetrievePercumaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner percumacuma, jenisaktiviticuma, ukurancuma;
    EditText edtHargacuma, kuantiticuma,aktiviticuma, itemcuma;
    Button btn1, btn2;
    ImageButton kembali;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_percuma);
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

        ArrayAdapter adapter10 = ArrayAdapter.createFromResource(this,R.array.PengukuranTambahan,R.layout.pendapatan_spinner_layout10);
        adapter10.setDropDownViewResource(R.layout.spinner_dropdown_layout10);
        ukurancuma.setAdapter(adapter10);
        ukurancuma.setOnItemSelectedListener(this);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String Percumacuma = percumacuma.getSelectedItem().toString();
                String jenisaktiviti = jenisaktiviticuma.getSelectedItem().toString();
                String aktiviti = aktiviticuma.getText().toString();
                String item = itemcuma.getText().toString();
                String ukuran = ukurancuma.getSelectedItem().toString();
                String harga = edtHargacuma.getText().toString();
                String kuantiti= kuantiticuma.getText().toString();
                String userId = reference.push().getKey();


                Percuma percuma = new Percuma(Percumacuma,jenisaktiviti,aktiviti,item, ukuran, harga,kuantiti,userId);

                reference.child(userId).setValue(percuma);
                Toast.makeText(RetrievePercumaActivity.this, "Data disimpan", Toast.LENGTH_SHORT).show();

            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RetrievePercumaActivity.this, PercumaActivity.class);
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