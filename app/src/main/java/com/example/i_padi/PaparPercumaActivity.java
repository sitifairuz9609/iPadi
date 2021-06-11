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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PaparPercumaActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    PercumaAdapter adapter;
    DatabaseReference reference;
    FirebaseDatabase database;
    ImageView back;
    Button button2;
    private ArrayList<Percuma> Percuma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papar_percuma);

        recyclerView = findViewById(R.id.recyclerview);
        back = findViewById(R.id.back);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Percuma = new ArrayList<>();
        adapter = new PercumaAdapter(this, Percuma);
        recyclerView.setAdapter(adapter);


        reference = database.getInstance().getReference().child("Percuma");


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Percuma percuma = dataSnapshot.getValue(Percuma.class);
                    Percuma.add(percuma);

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
                Intent intent = new Intent(PaparPercumaActivity.this, PercumaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}