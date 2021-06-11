package com.example.i_padi;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class PerbelanjaanAdapter extends RecyclerView.Adapter<PerbelanjaanAdapter.AktivitiViewHolder>{

    private Context context;
    private ArrayList<Perbelanjaan> perbelanjaan;

    public PerbelanjaanAdapter(Context context, ArrayList<Perbelanjaan> perbelanjaan) {
        this.context = context;
        this.perbelanjaan = perbelanjaan;
    }

    @NonNull
    @Override
    public AktivitiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2,parent,false);
        return new AktivitiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AktivitiViewHolder holder, int position) {
        final Perbelanjaan perbelanjaan = this.perbelanjaan.get(position);

        holder.perbelanjaan.setText(perbelanjaan.getPerbelanjaan());
        holder.jenisaktiviti.setText(perbelanjaan.getJenisaktiviti());
        holder.aktiviti.setText(perbelanjaan.getAktiviti());
        holder.item.setText(perbelanjaan.getItem());
        holder.ukuran.setText(perbelanjaan.getUkuran());
        holder.harga.setText(perbelanjaan.getHarga());
        holder.kuantiti.setText(perbelanjaan.getKuantiti());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Perbelanjaan").child(perbelanjaan.getId());
                databaseReference.removeValue();
                Toast.makeText(context,"Data telah dibuang", Toast.LENGTH_SHORT).show();

            }
        });
    }
    @Override
    public int getItemCount() {

        return perbelanjaan.size();
    }

    class AktivitiViewHolder extends RecyclerView.ViewHolder {
        TextView perbelanjaan, jenisaktiviti, aktiviti, item, ukuran, harga, kuantiti;
        ImageView imageView;
        ImageView delete;


        public AktivitiViewHolder(@NonNull View itemView) {
            super(itemView);

            perbelanjaan = itemView.findViewById(R.id.perbelanjaanbelanja);
            jenisaktiviti = itemView.findViewById(R.id.jenisaktivitibelanja);
            aktiviti = itemView.findViewById(R.id.aktivitibelanja);
            item = itemView.findViewById(R.id.itembelanja);
            ukuran = itemView.findViewById(R.id.ukuranbelanja);
            harga = itemView.findViewById(R.id.hargabelanja);
            kuantiti = itemView.findViewById(R.id.kuantitibelanja);
            imageView = itemView.findViewById(R.id.imageView);
            kuantiti = itemView.findViewById(R.id.kuantitibelanja);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}