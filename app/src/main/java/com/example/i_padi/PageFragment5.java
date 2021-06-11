package com.example.i_padi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PageFragment5 extends Fragment {
    TextView Subsidii, Pendapatann, Kliksini;
    DatabaseReference reference, reference1;
    Button btnsubsidi;
    ImageView back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater
                .inflate(R.layout.page_5,container,
                        false);
        Subsidii = rootView.findViewById(R.id.subsidi);
        Pendapatann = rootView.findViewById(R.id.pendapatan);
        btnsubsidi = rootView.findViewById(R.id.btnsubsidi);
        back = rootView.findViewById(R.id.back);
        reference = FirebaseDatabase.getInstance().getReference().child("Duit");
        reference1 = FirebaseDatabase.getInstance().getReference().child("Subsidi");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    String pendapatan = ds.child("pendapatan").getValue(String.class);
                    String subsidi = ds.child("subsidi").getValue(String.class);

                    float Pendapatan = Float.parseFloat(String.valueOf(pendapatan));
                    float Subsidi = Float.parseFloat(String.valueOf(subsidi));
                    float value = Subsidi/Pendapatan;

                    Subsidii.setText(String.valueOf(value));
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    String pendapatan = ds.child("pendapatan").getValue(String.class);

                    float Pendapatan = Float.parseFloat(String.valueOf(pendapatan));
                    float value = Pendapatan/Pendapatan;

                    Pendapatann.setText(String.valueOf(value));
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        btnsubsidi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String Pendapatan = Pendapatann.getText().toString();
                String Subsidi = Subsidii.getText().toString();

                Subsidi subsidi = new Subsidi(Pendapatan,Subsidi);

                reference1.push().setValue(subsidi);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageFragment5.this.getActivity(), InovasiActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}