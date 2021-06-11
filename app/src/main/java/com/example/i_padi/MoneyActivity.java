package com.example.i_padi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MoneyActivity extends AppCompatActivity {
    TextView totalbalance, totalpendapatan, totalperbelanjaan;
    DatabaseReference reference2, reference1, reference3;
    BarChart mChart;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);

        totalbalance = findViewById(R.id.Baki);
        totalpendapatan = findViewById(R.id.pendapatan);
        totalperbelanjaan = findViewById(R.id.perbelanjaan);
        mChart = findViewById(R.id.barchart);
        back = findViewById(R.id.back);
        reference1 = FirebaseDatabase.getInstance().getReference().child("Perbelanjaan");
        reference2 = FirebaseDatabase.getInstance().getReference().child("Pendapatan");
        reference3 = FirebaseDatabase.getInstance().getReference().child("Duit");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoneyActivity.this, DuitActivity.class);
                startActivity(intent);
                finish();
            }
        });


        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                double sum1 = 0;

                for (DataSnapshot ds : snapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object harga = map.get("harga");
                    double pValue = Double.parseDouble(String.valueOf(harga));
                    sum1 += pValue;

                    totalperbelanjaan.setText(String.valueOf("RM" + sum1));

                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        reference2 = FirebaseDatabase.getInstance().getReference().child("Pendapatan");
        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                double sum2 = 0;

                for (DataSnapshot ds : snapshot.getChildren()) {
                    Map<String, Object> map = (Map<String, Object>) ds.getValue();
                    Object harga = map.get("harga");
                    double pValue = Double.parseDouble(String.valueOf(harga));
                    sum2 += pValue;

                    totalpendapatan.setText(String.valueOf("RM" + sum2));
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        reference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    String pendapatan = ds.child("pendapatan").getValue(String.class);
                    String perbelanjaan = ds.child("perbelanjaan").getValue(String.class);

                    double Pendapatan = Double.parseDouble(pendapatan);
                    double Perbelanjaan = Double.parseDouble(perbelanjaan);
                    double baki = Pendapatan - Perbelanjaan;

                    totalbalance.setText(String.valueOf("RM " + baki));
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        mChart = (BarChart) findViewById(R.id.barchart);
        mChart.setDrawGridBackground(false);
        mChart.setPinchZoom(false);
        mChart.getAxisRight().setEnabled(false);
        mChart.getAxisLeft().setEnabled(false);
        mChart.getXAxis().setEnabled(false);
        mChart.setDrawBarShadow(false);
        mChart.getDescription().setEnabled(false);

        reference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<BarEntry> dataVals = new ArrayList<BarEntry>();

                if(snapshot.hasChildren()){
                    for(DataSnapshot myDataSnapshot : snapshot.getChildren()){
                        dataVals.add(new BarEntry(0,-(Float.parseFloat(myDataSnapshot.child("perbelanjaanlain").getValue(String.class)))));
                        dataVals.add(new BarEntry(1,Float.parseFloat(myDataSnapshot.child("penjualanpadi").getValue(String.class))));
                        dataVals.add(new BarEntry(2,-(Float.parseFloat(myDataSnapshot.child("operasi").getValue(String.class)))));
                        dataVals.add(new BarEntry(3,Float.parseFloat(myDataSnapshot.child("pendapatanlain").getValue(String.class))));
                        dataVals.add(new BarEntry(4,-(Float.parseFloat(myDataSnapshot.child("upah").getValue(String.class)))));
                        dataVals.add(new BarEntry(5,-(Float.parseFloat(myDataSnapshot.child("sewa").getValue(String.class)))));
                    }
                    showChart(dataVals);
                }else{
                    mChart.clear();
                    mChart.invalidate();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void showChart(ArrayList<BarEntry> dataVals) {
        ArrayList<Double>valuelist = new ArrayList<Double>();

        String[] myText = {"Perbelanjaan Lain", "Penjualan Padi", "Operasi", "Pendapatan Lain", "Upah", "Sewa"};

        BarDataSet barDataSet = new BarDataSet(dataVals, "");
        BarData data = new BarData (barDataSet);
        barDataSet.setColors(new int[] {Color.RED, Color.GREEN, Color.RED, Color.GREEN, Color.RED, Color.RED,});
        barDataSet.setValueFormatter(new MyFormatter(myText));
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(11f);
        mChart.setData(data);
        mChart.invalidate();

        XAxis xaxis = mChart.getXAxis();
        xaxis.setDrawGridLines(false);
        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        xaxis.setDrawLabels(true);
        xaxis.setDrawAxisLine(false);

        YAxis yAxisLeft = mChart.getAxisLeft();
        yAxisLeft.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        yAxisLeft.setDrawGridLines(false);
        yAxisLeft.setDrawAxisLine(false);
        yAxisLeft.setEnabled(false);

        mChart.getAxisRight().setEnabled(false);
        // set your custom renderer
        mChart.setDrawValueAboveBar(true);


    }

    static class MyFormatter implements IValueFormatter {
        private DecimalFormat mFormat;
        String[] text;

        public MyFormatter(String[] text) {
            this.text = text;
            mFormat = new DecimalFormat("#####.00");
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return text[(int) entry.getX()];
        }
    }


}



