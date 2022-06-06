package com.example.ligasepakbola;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KlubAdapter extends RecyclerView.Adapter<KlubAdapter.KlubViewHolder>{
    private ArrayList<Klub> klub;
    private LayoutInflater mInflater;
    Context context;

    public KlubAdapter(Context ctx, ArrayList<Klub> klub){
        this.context = ctx;
        this.klub = klub;
        this.mInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public KlubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.klub_item, parent, false);
        return new KlubViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull KlubViewHolder holder, int position) {
        holder.tViewKlub.setText(klub.get(position).getNama());
        holder.tViewPoin.setText(klub.get(position).getPoin());

        final String getNama = klub.get(position).getNama();
        final int getPoin = klub.get(position).getPoin();

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent item = new Intent(context, DetailKlub.class);
                item.putExtra("title",getNama);
                item.putExtra("course",getPoin);
                context.startActivity(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return klub.size();
    }

    public class KlubViewHolder extends RecyclerView.ViewHolder{
        TextView tViewKlub, tViewPoin;
//        tViewMenang, tViewKalah, tViewSeri, tViewMasuk, tViewKemasukan, tViewSelisih, tViewTotal;
        public KlubViewHolder(@NonNull View itemView) {
            super(itemView);
            tViewKlub = itemView.findViewById(R.id.klubView);
            tViewPoin = itemView.findViewById(R.id.poinView);
        }
    }
}
