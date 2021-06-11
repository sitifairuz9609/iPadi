package com.example.i_padi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PageFragment7 extends Fragment {
    TextView zakat, pendapatann;
    DatabaseReference reference, reference1;
    Button Zakat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.page_7, container,
                        false);

        pendapatann = rootView.findViewById(R.id.pendapatan);
        zakat = rootView.findViewById(R.id.zakat);
        Zakat = rootView.findViewById(R.id.btnzakat);
        reference = FirebaseDatabase.getInstance().getReference().child("Duit");
        reference1 = FirebaseDatabase.getInstance().getReference().child("Zakat");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    String pendapatan = ds.child("pendapatan").getValue(String.class);
                    String perbelanjaan = ds.child("perbelanjaan").getValue(String.class);

                    double Pendapatan = Float.parseFloat(String.valueOf(pendapatan));
                    double Perbelanjaan = Float.parseFloat(String.valueOf(perbelanjaan));
                    double value = (Pendapatan-Perbelanjaan)*0.05;

                   zakat.setText(String.valueOf(value));
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

                    double Pendapatan = Float.valueOf(pendapatan);

                    pendapatann.setText(String.valueOf(Pendapatan));
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        Zakat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Zakat = zakat.getText().toString();
                String Pendapatan = pendapatann.getText().toString();

                Zakat zakat = new Zakat(Pendapatan,Zakat);

                reference1.push().setValue(zakat);
            }
        });
        return rootView;
    }
}







