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
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PageFragment2 extends Fragment {
    PieChart pieChart;
    DatabaseReference reference1;
    ImageView back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater
                .inflate(R.layout.page_2,container,
                        false);
        pieChart = rootView.findViewById (R.id.piechart);
        back = rootView.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageFragment2.this.getActivity(), WelcomeActivity.class);
                startActivity(intent);
            }
        });

        reference1 = FirebaseDatabase.getInstance().getReference().child("Duit");

        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<PieEntry> value = new ArrayList<>();
                if (snapshot.hasChildren()) {
                    for (DataSnapshot myDataSnapshot : snapshot.getChildren()) {
                        value.add(new PieEntry(Float.parseFloat(myDataSnapshot.child("sewa").getValue(String.class)),"Sewa"));
                        value.add(new PieEntry(Float.parseFloat(myDataSnapshot.child("upah").getValue(String.class)),"Upah"));
                        value.add(new PieEntry(Float.parseFloat(myDataSnapshot.child("operasi").getValue(String.class)),"Operasi"));
                        value.add(new PieEntry(Float.parseFloat(myDataSnapshot.child("perbelanjaanlain").getValue(String.class)),"Lain-lain"));
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
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(20f);
        pieChart.setHoleRadius(0f);
        pieChart.setDrawHoleEnabled(false);
        pieChart.getDescription ().setEnabled (false);
        pieChart.animate ();
        pieChart.setData(pieData);
        pieChart.invalidate();

    }

}




