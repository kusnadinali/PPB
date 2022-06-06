package com.example.memorist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TaskDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        TextView titles = findViewById(R.id.editTextTitle);
        TextView courses = findViewById(R.id.editTextCourse);
        TextView dates = findViewById(R.id.editTextDate);
        TextView descs = findViewById(R.id.editTextDesc);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        titles.setText(title);

        String course = intent.getStringExtra("course");
        courses.setText(course);

        String date = intent.getStringExtra("date");
        dates.setText(date);

        String desc = intent.getStringExtra("desc");
        descs.setText(desc);
    }
}