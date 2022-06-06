package com.example.crud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.ViewHolder> {
    private DataItemUser dataUser;
    private Context mContext;


    public SingleAdapter(DataItemUser dataUser, Context mContext) {
        this.dataUser = dataUser;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvName.setText(dataUser.getFirstName());
        viewHolder.tvLastName.setText(dataUser.getLastName());
        Glide.with(mContext).load(dataUser.getAvatar()).into(viewHolder.imgAvatar);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_avatar)
        ImageView imgAvatar;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_last_name)
        TextView tvLastName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
