package com.example.crud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SingleResourceAdapter extends RecyclerView.Adapter<SingleResourceAdapter.ViewHolder>{
    private DataItemResource dataResource;
    private Context mContext;

    public SingleResourceAdapter(DataItemResource dataResource, Context mContext) {
        this.dataResource = dataResource;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public SingleResourceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_resource, parent, false);
        return new SingleResourceAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleResourceAdapter.ViewHolder holder, int position) {
        holder.tvColorName.setText(dataResource.getName());
        holder.tvYear.setText(String.valueOf(dataResource.getYear()));
        holder.tvCode.setText(dataResource.getColor());
        holder.tvValue.setText(dataResource.getPantoneValue());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_color_name)
        TextView tvColorName;
        @BindView(R.id.tv_year)
        TextView tvYear;
        @BindView(R.id.tv_code)
        TextView tvCode;
        @BindView(R.id.tv_pantone_value)
        TextView tvValue;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
