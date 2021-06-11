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

public class PendapatanActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner pendapatandapat, jenisaktivitidapat, aktivitidapat, itemdapat, ukurandapat;
    EditText edtHargadapat, kuantitidapat;
    Button btn1, btn2;
    ImageButton kembali;
    FirebaseDatabase database;
    DatabaseReference reference;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendapatan);

        btn1 = findViewById(R.id.simpan);
        btn2 = findViewById(R.id.retrieve);
        pendapatandapat = findViewById(R.id.pendapatandapat);
        jenisaktivitidapat = findViewById(R.id.jenisaktivitidapat);
        aktivitidapat = findViewById(R.id.aktivitidapat);
        itemdapat = findViewById(R.id.itemdapat);
        ukurandapat = findViewById(R.id.ukurandapat);
        btn1 = findViewById(R.id.simpan);
        btn2 = findViewById(R.id.retrieve);
        edtHargadapat = findViewById(R.id.hargadapat);
        floatingActionButton = findViewById(R.id.btnbaru);
        kuantitidapat = findViewById(R.id.kuantitidapat);
        kembali = findViewById(R.id.kembali);
        kuantitidapat = findViewById(R.id.kuantitidapat);
        reference = database.getInstance().getReference().child("Pendapatan");

        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this,R.array.Pendapatan,R.layout.pendapatan_spinner_layout1);
        adapter1.setDropDownViewResource(R.layout.spinner_dropdown_layout1);
        pendapatandapat.setAdapter(adapter1);
        pendapatandapat.setOnItemSelectedListener(this);

        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.AktivitiJualann,R.layout.pendapatan_spinner_layout2);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_layout2);
        jenisaktivitidapat.setAdapter(adapter2);
        jenisaktivitidapat.setOnItemSelectedListener(this);

        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this,R.array.AktivitiJualan,R.layout.pendapatan_spinner_layout3);
        adapter3.setDropDownViewResource(R.layout.spinner_dropdown_layout3);
        aktivitidapat.setAdapter(adapter3);
        aktivitidapat.setOnItemSelectedListener(this);

        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(this,R.array.ItemJualan,R.layout.pendapatan_spinner_layout4);
        adapter4.setDropDownViewResource(R.layout.spinner_dropdown_layout4);
        itemdapat.setAdapter(adapter4);
        itemdapat.setOnItemSelectedListener(this);

        ArrayAdapter adapter5 = ArrayAdapter.createFromResource(this,R.array.PengukuranJualan,R.layout.pendapatan_spinner_layout5);
        adapter5.setDropDownViewResource(R.layout.spinner_dropdown_layout5);
        ukurandapat.setAdapter(adapter5);
        ukurandapat.setOnItemSelectedListener(this);



        floatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PendapatanActivity.this, AktivitiActivity.class);
                startActivity(intent);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String Pendapatandapat = pendapatandapat.getSelectedItem().toString();
                String jenisaktiviti = jenisaktivitidapat.getSelectedItem().toString();
                String aktiviti = aktivitidapat.getSelectedItem().toString();
                String item = itemdapat.getSelectedItem().toString();
                String ukuran = ukurandapat.getSelectedItem().toString();
                String harga = edtHargadapat.getText().toString();
                String kuantiti= kuantitidapat.getText().toString();
                String userId = reference.push().getKey();


                Pendapatan pendapatan = new Pendapatan(Pendapatandapat,jenisaktiviti,aktiviti,item, ukuran, harga,kuantiti,userId);

                reference.child(userId).setValue(pendapatan);
                Toast.makeText(PendapatanActivity.this, "Data disimpan", Toast.LENGTH_SHORT).show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PendapatanActivity.this, AktivitiActivity.class);
                startActivity(intent);
                finish();
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PendapatanActivity.this, RetrievePendapatanActivity.class);
                startActivity(intent);
                finish();

            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PendapatanActivity.this, AktivitiActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PendapatanActivity.this, PaparPendapatanActivity.class);
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