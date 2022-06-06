package com.example.memorist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int NEW_TASK_ACTIVITY_REQUEST_CODE = 1;
    ArrayList<MyTask> list;
    FloatingActionButton btnAddNew;
    private TaskViewModel tViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddNew = findViewById(R.id.floatingActionButtonAdd);
        btnAddNew.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this, AddNewTask.class);
            startActivityForResult(intent, NEW_TASK_ACTIVITY_REQUEST_CODE);
        });
//        list = new ArrayList<MyTask>();
//        // get data
//        for (int i=1; i <= 8; i++){
//            MyTask t = new MyTask("Tugas "+i, "28 Februari 2022","Membuat aplikasi to do list","Mobile");
//            list.add(t);
//        }


        RecyclerView mytask = findViewById(R.id.mytask); // Get a handle to the RecyclerView.
        mytask.setLayoutManager(new LinearLayoutManager(this)); // Give the RecyclerView a default layout manager.
        mytask.setHasFixedSize(true);
        final TaskAdapter taskAdapter = new TaskAdapter();  // Create an adapter and supply the data to be displayed.
        mytask.setAdapter(taskAdapter);// Connect the adapter with the RecyclerView.
        // ViewModelProviders.of
        tViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        tViewModel.getAllTasks().observe(this, new Observer<List<MyTask>>() {
            @Override
            public void onChanged(@Nullable List<MyTask> tasks) {
               taskAdapter.setTasks(tasks);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == NEW_TASK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            String title = data.getStringExtra(AddNewTask.EXTRA_TITLE);
            String course = data.getStringExtra(AddNewTask.EXTRA_COURSE);
            String date = data.getStringExtra(AddNewTask.EXTRA_DATE);
            String desc = data.getStringExtra(AddNewTask.EXTRA_DESC);

            MyTask task = new MyTask(title, course, date, desc);
            tViewModel.insert(task);

            Toast.makeText(this,"Task Saved",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Task Not Saved",Toast.LENGTH_SHORT).show();
        }
    }
}