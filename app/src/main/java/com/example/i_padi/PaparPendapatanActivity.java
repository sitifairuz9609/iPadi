package com.example.i_padi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PaparPendapatanActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView back;
    PendapatanAdapter adapter;
    DatabaseReference reference;
    FirebaseDatabase database;
    private ArrayList<Pendapatan> Pendapatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papar_pendapatan);

        recyclerView = findViewById(R.id.recyclerview);
        back = findViewById(R.id.back);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Pendapatan = new ArrayList<>();
        adapter = new PendapatanAdapter(this, Pendapatan);
        recyclerView.setAdapter(adapter);


        reference = database.getInstance().getReference().child("Pendapatan");


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Pendapatan pendapatan = dataSnapshot.getValue(Pendapatan.class);
                    Pendapatan.add(pendapatan);

                }
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaparPendapatanActivity.this, AktivitiActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}