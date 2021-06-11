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

public class PageFragment6 extends Fragment {
    PieChart pieChart;
    DatabaseReference reference, reference1;
    ImageView back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater
                .inflate(R.layout.page_6,container,
                        false);

        pieChart = rootView.findViewById(R.id.piechart);
        back = rootView.findViewById(R.id.back);
        reference = FirebaseDatabase.getInstance().getReference().child("Duit");
        reference1 = FirebaseDatabase.getInstance().getReference().child("Subsidi");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PageFragment6.this.getActivity(), WelcomeActivity.class);
                startActivity(intent);
            }
        });

        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<PieEntry> value = new ArrayList<>();
                if (snapshot.hasChildren()) {
                    for (DataSnapshot myDataSnapshot : snapshot.getChildren()) {
                        value.add(new PieEntry(Float.parseFloat(myDataSnapshot.child("pendapatan").getValue(String.class)),"Pendapatan"));
                        value.add(new PieEntry(Float.parseFloat(myDataSnapshot.child("subsidi").getValue(String.class)),"Subsidi"));
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
        PieDataSet pieDataSet = new PieDataSet (value, "");
        pieDataSet.setColors (ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor (Color.BLACK);
        pieDataSet.setValueTextSize (16f);

        PieData pieData = new PieData (pieDataSet);
        pieChart.setData (pieData);
        pieChart.getDescription ().setEnabled (false);
        pieChart.setHoleRadius(64f);//18f
        pieChart.setCenterTextSize(10);//30
        pieChart.setMaxAngle (180f);
        pieChart.setRotationAngle (180f);
        pieChart.setCenterTextOffset (0, -20);
        pieChart.animate ();
        pieChart.setBackgroundColor(Color.rgb(0, 121, 107));
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.rgb(0, 121, 107));
        pieChart.setTransparentCircleColor(Color.WHITE);
        pieChart.setTransparentCircleAlpha(110);
        pieChart.setHoleRadius(58f);
        pieChart.setTransparentCircleRadius(61f);
        pieChart.setDrawCenterText(true);
        pieChart.setHighlightPerTapEnabled(true);
        pieChart.setMaxAngle(180f); // HALF CHART
        pieChart.setRotationAngle(180f);
        pieChart.setCenterTextOffset(0, -20);

    }
}

