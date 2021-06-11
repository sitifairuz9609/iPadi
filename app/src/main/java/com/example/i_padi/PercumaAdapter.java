package com.example.i_padi;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class PercumaAdapter extends RecyclerView.Adapter<PercumaAdapter.AktivitiViewHolder> {

    private Context context;
    private ArrayList<Percuma> percuma;

    public PercumaAdapter(Context context, ArrayList<Percuma> percuma) {
        this.context = context;
        this.percuma = percuma;
    }

    @NonNull
    @Override
    public AktivitiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item3,parent,false);
        return new AktivitiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AktivitiViewHolder holder, int position) {
        final Percuma percuma = this.percuma.get(position);

        holder.percuma.setText(percuma.getPercuma());
        holder.jenisaktiviti.setText(percuma.getJenisaktiviti());
        holder.aktiviti.setText(percuma.getAktiviti());
        holder.item.setText(percuma.getItem());
        holder.ukuran.setText(percuma.getUkuran());
        holder.harga.setText(percuma.getHarga());
        holder.kuantiti.setText(percuma.getKuantiti());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Percuma").child(percuma.getId());
                databaseReference.removeValue();
                Toast.makeText(context,"Data telah dibuang", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {

        return percuma.size();
    }

    public static class AktivitiViewHolder extends RecyclerView.ViewHolder {
        TextView percuma, jenisaktiviti, aktiviti, item, ukuran, harga, kuantiti;
        ImageView imageView;
        ImageView delete;


        public AktivitiViewHolder(@NonNull View itemView) {
            super(itemView);

            percuma = itemView.findViewById(R.id.percumacuma);
            jenisaktiviti = itemView.findViewById(R.id.jenisaktiviticuma);
            aktiviti = itemView.findViewById(R.id.aktiviticuma);
            item = itemView.findViewById(R.id.itemcuma);
            ukuran = itemView.findViewById(R.id.ukurancuma);
            harga = itemView.findViewById(R.id.hargacuma);
            kuantiti = itemView.findViewById(R.id.kuantiticuma);
            imageView = itemView.findViewById(R.id.imageView);
            kuantiti = itemView.findViewById(R.id.kuantiticuma);
            delete = itemView.findViewById(R.id.delete);

        }
    }
}