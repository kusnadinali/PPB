package com.example.crud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResourceAdapter extends RecyclerView.Adapter<ResourceAdapter.ViewHolder>{
    private List<DataItemResource> dataResource;
    private Context mContext;

    public ResourceAdapter(List<DataItemResource> dataResource, Context mContext) {
        this.dataResource = dataResource;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ResourceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_resource, parent, false);
        return new ResourceAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ResourceAdapter.ViewHolder holder, int position) {
        holder.tvColorName.setText(dataResource.get(position).getName());
        holder.tvYear.setText(String.valueOf(dataResource.get(position).getYear()));
        holder.tvCode.setText(dataResource.get(position).getColor());
        holder.tvValue.setText(dataResource.get(position).getPantoneValue());
    }

    @Override
    public int getItemCount() {
        return dataResource.size();
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
