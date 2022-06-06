package com.example.memorist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {
    private List<MyTask> tasks = new ArrayList<>();

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasklist_item,parent,false);
        return new TaskHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        MyTask currentTask = tasks.get(position);
        holder.textViewTitle.setText(currentTask.getTitle());
//        holder.textViewCourse.setText(currentTask.getCourse());
        holder.textViewDate.setText(currentTask.getDate());
//        holder.textViewDesc.setText(currentTask.getDesc());

//        holder.itemView.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Intent item = new Intent(context, TaskDetail.class);
//                item.putExtra("title",getTitle);
//                item.putExtra("course",getCourse);
//                item.putExtra("date",getDate);
//                item.putExtra("desc",getDesc);
//                context.startActivity(item);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setTasks(List<MyTask>tasks){
        this.tasks = tasks;
        for(int i = 0; i < tasks.size(); i++){
            System.out.println("task:" + tasks.get(i).getTitle());
        }
        notifyDataSetChanged();
    }

    class TaskHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        private TextView textViewCourse;
        private TextView textViewDate;
        private TextView textViewDesc;

        public TaskHolder(View itemView){
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.title);
            textViewDate = (TextView) itemView.findViewById(R.id.date);
        }
    }
//    Context context;
//    private ArrayList<MyTask> myTask;
//    private LayoutInflater mInflater;
//
//    public TaskAdapter(Context ctx, ArrayList<MyTask> task){
//        context = ctx;
//        myTask = task;
//        mInflater = LayoutInflater.from(context);
//    }
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View mItemView = mInflater.inflate(R.layout.tasklist_item, parent, false);
//        return new MyViewHolder(mItemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.title.setText(myTask.get(position).getTitle());
////        holder.course.setText(myTask.get(position).getCourse());
//        holder.date.setText(myTask.get(position).getDate());
////        holder.desc.setText(myTask.get(position).getDesc());
//
//        final String getTitle = myTask.get(position).getTitle();
//        final String getCourse = myTask.get(position).getCourse();
//        final String getDate = myTask.get(position).getDate();
//        final String getDesc = myTask.get(position).getDesc();
//
//        holder.itemView.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Intent item = new Intent(context, TaskDetail.class);
//                item.putExtra("title",getTitle);
//                item.putExtra("course",getCourse);
//                item.putExtra("date",getDate);
//                item.putExtra("desc",getDesc);
//                context.startActivity(item);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return myTask.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView title, date, course, desc;
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            title = (TextView) itemView.findViewById(R.id.title);
//            date = (TextView) itemView.findViewById(R.id.date);
//            course = (TextView) itemView.findViewById(R.id.course);
//            desc = (TextView) itemView.findViewById(R.id.desc);
//        }
//    }
}
