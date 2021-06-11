package com.example.i_padi;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class PendapatanAdapter extends RecyclerView.Adapter<PendapatanAdapter.AktivitiViewHolder> {

    private Context context;
    private ArrayList<Pendapatan> pendapatan;

    public PendapatanAdapter(Context context, ArrayList<Pendapatan> pendapatan) {
        this.context = context;
        this.pendapatan = pendapatan;
    }

    @NonNull
    @Override
    public AktivitiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new AktivitiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AktivitiViewHolder holder, int position) {
        final Pendapatan pendapatan = this.pendapatan.get(position);

        holder.pendapatan.setText(pendapatan.getPendapatan());
        holder.jenisaktiviti.setText(pendapatan.getJenisaktiviti());
        holder.aktiviti.setText(pendapatan.getAktiviti());
        holder.item.setText(pendapatan.getItem());
        holder.ukuran.setText(pendapatan.getUkuran());
        holder.harga.setText(pendapatan.getHarga());
        holder.kuantiti.setText(pendapatan.getKuantiti());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Pendapatan").child(pendapatan.getId());
                databaseReference.removeValue();
                Toast.makeText(context,"Data telah dibuang", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {

        return pendapatan.size();
    }
    public static class AktivitiViewHolder extends RecyclerView.ViewHolder {
        TextView pendapatan, jenisaktiviti, aktiviti, item, ukuran, harga, kuantiti;
        ImageView imageView;
        ImageView delete;


        public AktivitiViewHolder(@NonNull View itemView) {
            super(itemView);

            pendapatan = itemView.findViewById(R.id.pendapatandapat);
            jenisaktiviti = itemView.findViewById(R.id.jenisaktivitidapat);
            aktiviti = itemView.findViewById(R.id.aktivitidapat);
            item = itemView.findViewById(R.id.itemdapat);
            ukuran = itemView.findViewById(R.id.ukurandapat);
            harga = itemView.findViewById(R.id.hargadapat);
            kuantiti = itemView.findViewById(R.id.kuantitidapat);
            imageView = itemView.findViewById(R.id.imageView);
            kuantiti = itemView.findViewById(R.id.kuantitidapat);
            delete = itemView.findViewById(R.id.delete);

        }
    }
}