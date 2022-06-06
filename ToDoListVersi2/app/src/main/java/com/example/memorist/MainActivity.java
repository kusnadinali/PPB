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
    List<MyTask> list;
    FloatingActionButton btnAddNew;
    private TaskViewModel tViewModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddNew = findViewById(R.id.floatingActionButtonAdd);
        btnAddNew.setOnClickListener( view -> {
            Intent intent = new Intent(MainActivity.this, AddNewTask.class);
            startActivityForResult(intent, NEW_TASK_ACTIVITY_REQUEST_CODE);
        });

        recyclerView = findViewById(R.id.mytask); // Get a handle to the RecyclerView.
        final TaskAdapter taskAdapter = new TaskAdapter(new TaskAdapter.TaskDiff(), this);  // Create an adapter and supply the data to be displayed.
        recyclerView.setAdapter(taskAdapter);// Connect the adapter with the RecyclerView.
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Give the RecyclerView a default layout manager.

        tViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        tViewModel.getAllTasks().observe(this, tasks -> {
            taskAdapter.submitList(tasks);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == NEW_TASK_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            MyTask task = data.getParcelableExtra("task");

            tViewModel.insert(task);

            Toast.makeText(this,"Task Saved",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Task Not Saved",Toast.LENGTH_SHORT).show();
        }
    }
}