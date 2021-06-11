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

import com.github.mikephil.charting.charts.PieChart;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PageFragment3 extends Fragment {
    TextView Pendapatann, BuatSendiri;
    DatabaseReference reference, reference2;
    Button Penjimatan;
    PieChart pieChart;
    ImageView back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater
                .inflate(R.layout.page_3,container,
                        false);
        pieChart = rootView.findViewById (R.id.piechart);
        Pendapatann = rootView.findViewById(R.id.pendapatanbuatsendiri);
        BuatSendiri = rootView.findViewById(R.id.pendapatan);
        Penjimatan = rootView.findViewById(R.id.penjimatan);
        back = rootView.findViewById(R.id.back);
        reference = FirebaseDatabase.getInstance().getReference().child("Duit");
        reference2 = FirebaseDatabase.getInstance().getReference().child("Penjimatan");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageFragment3.this.getActivity(), WelcomeActivity.class);
                startActivity(intent);
            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    String pendapatan = ds.child("pendapatan").getValue(String.class);
                    String buatsendiri = ds.child("buatsendiri").getValue(String.class);

                    float Pendapatan = Float.parseFloat(String.valueOf(pendapatan));
                    float Buatsendiri = Float.parseFloat(String.valueOf(buatsendiri));
                    float sum = Pendapatan + Buatsendiri;

                    BuatSendiri.setText(String.valueOf(sum));
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

                    float Pendapatan = Float.valueOf(pendapatan);

                    Pendapatann.setText(String.valueOf(Pendapatan));
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        Penjimatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Pendapatan = Pendapatann.getText().toString();
                String buatSendiri = BuatSendiri.getText().toString();

                Penjimatan penjimatan = new Penjimatan(Pendapatan,buatSendiri);

                reference2.push().setValue(penjimatan);
            }
        });
        return rootView;

    }
}
