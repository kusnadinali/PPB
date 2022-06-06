package com.example.memorist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskViewHolder extends RecyclerView.ViewHolder{
    LinearLayout layoutView;
    private final TextView textViewTitle;
    private final TextView textViewDate;
    private final TextView textViewTime;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewTitle = itemView.findViewById(R.id.titleItemView);
        textViewDate = itemView.findViewById(R.id.dateItemView);
        textViewTime = itemView.findViewById(R.id.timeItemView);
        layoutView = itemView.findViewById(R.id.layoutView);
    }

    public void bind (String title, String date, String time) {
        textViewTitle.setText(title);
        textViewDate.setText(date);
        textViewTime.setText(time);
    }

    static TaskViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasklist_item, parent, false);
        return new TaskViewHolder(view);
    }
}
