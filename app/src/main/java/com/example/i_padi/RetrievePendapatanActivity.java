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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RetrievePendapatanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner pendapatandapat, jenisaktivitidapat, ukurandapat;
    EditText edtHargadapat, kuantitidapat, aktivitidapat, itemdapat;
    Button btn1, btn2;
    ImageButton kembali;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_pendapatan);

        btn1 = findViewById(R.id.simpan);
        btn2 = findViewById(R.id.retrieve);
        pendapatandapat = findViewById(R.id.pendapatandapat);
        jenisaktivitidapat = findViewById(R.id.jenisaktivitidapat);
        aktivitidapat = findViewById(R.id.aktivitidapat);
        itemdapat = findViewById(R.id.itemdapat);
        ukurandapat = findViewById(R.id.ukurandapat);
        btn1 = findViewById(R.id.simpan);
        btn2 = findViewById(R.id.retrieve);
        kembali = findViewById(R.id.kembali);
        edtHargadapat = findViewById(R.id.hargadapat);
        kuantitidapat = findViewById(R.id.kuantitidapat);
        kuantitidapat = findViewById(R.id.kuantitidapat);
        reference = database.getInstance().getReference().child("Pendapatan");

        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this,R.array.Pendapatan,R.layout.pendapatan_spinner_layout1);
        adapter1.setDropDownViewResource(R.layout.spinner_dropdown_layout1);
        pendapatandapat.setAdapter(adapter1);
        pendapatandapat.setOnItemSelectedListener(this);

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.AktivitiIkan,R.layout.pendapatan_spinner_layout2);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_layout2);
        jenisaktivitidapat.setAdapter(adapter2);
        jenisaktivitidapat.setOnItemSelectedListener(this);

        ArrayAdapter adapter5 = ArrayAdapter.createFromResource(this,R.array.PengukuranJualan,R.layout.pendapatan_spinner_layout5);
        adapter5.setDropDownViewResource(R.layout.spinner_dropdown_layout5);
        ukurandapat.setAdapter(adapter5);
        ukurandapat.setOnItemSelectedListener(this);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String Pendapatandapat = pendapatandapat.getSelectedItem().toString();
                String jenisaktiviti = jenisaktivitidapat.getSelectedItem().toString();
                String aktiviti = aktivitidapat.getText().toString();
                String item = itemdapat.getText().toString();
                String ukuran = ukurandapat.getSelectedItem().toString();
                String harga = edtHargadapat.getText().toString();
                String kuantiti= kuantitidapat.getText().toString();
                String userId = reference.push().getKey();


                Pendapatan pendapatan = new Pendapatan(Pendapatandapat,jenisaktiviti,aktiviti,item, ukuran, harga,kuantiti,userId);

                reference.child(userId).setValue(pendapatan);
                Toast.makeText(RetrievePendapatanActivity.this, "Data disimpan", Toast.LENGTH_SHORT).show();

            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RetrievePendapatanActivity.this, PendapatanActivity.class);
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