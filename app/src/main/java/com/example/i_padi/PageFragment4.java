package com.example.i_padi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PageFragment4 extends Fragment {
    PieChart pieChart;
    DatabaseReference reference;
    ImageView back;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater
                .inflate(R.layout.page_4,container,
                        false);
        pieChart = rootView.findViewById (R.id.piechart);
        back = rootView.findViewById(R.id.back);
        reference = FirebaseDatabase.getInstance().getReference().child("Penjimatan");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageFragment4.this.getActivity(), WelcomeActivity.class);
                startActivity(intent);
            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<PieEntry> value = new ArrayList<>();
                if (snapshot.hasChildren()) {
                    for (DataSnapshot myDataSnapshot : snapshot.getChildren()) {
                        value.add(new PieEntry(Float.parseFloat(myDataSnapshot.child("pendapatan").getValue(String.class)),""));
                        value.add(new PieEntry(Float.parseFloat(myDataSnapshot.child("pendapatanbuatsendiri").getValue(String.class)),"Penjimatan"));
                    }
                    showChart(value);
                } else {
                    pieChart.clear();
                    pieChart.invalidate();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return rootView;


    }

    private void showChart(List<PieEntry> value) {
        List<Float>valueList = new ArrayList<>();
        String title = "Title";

        PieDataSet pieDataSet = new PieDataSet(value, "");
        PieData pieData = new PieData(pieDataSet);
        pieDataSet.setColors(new int[] { Color.rgb(0, 121, 107), Color.rgb(234,170,0)});
        pieDataSet.setValueTextColor(Color.rgb(0, 121, 107));
        pieDataSet.setValueTextSize(20f);
        pieChart.setHoleRadius(0f);
        pieChart.setDrawHoleEnabled(false);
        pieChart.getDescription ().setEnabled (false);
        pieChart.animate ();
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}