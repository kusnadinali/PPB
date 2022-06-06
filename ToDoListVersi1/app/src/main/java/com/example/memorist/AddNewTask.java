package com.example.memorist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddNewTask extends AppCompatActivity {
    public static final String EXTRA_TITLE = "com.example.memorist.EXTRA_TITLE";
    public static final String EXTRA_COURSE = "com.example.memorist.EXTRA_COURSE";
    public static final String EXTRA_DATE = "com.example.memorist.EXTRA_DATE";
    public static final String EXTRA_DESC = "com.example.memorist.EXTRA_DESC";
    EditText addtitle, addcourse, adddate, adddesc;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);

        addtitle = findViewById(R.id.theTitle);
        addcourse = findViewById(R.id.theCourse);
        adddate = findViewById(R.id.theduedate);
        adddesc = findViewById(R.id.desc);
        btnAdd= findViewById(R.id.buttonAdd);

        btnAdd.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
//            String t = addtitle.getText().toString();
//            String c = addcourse.getText().toString();
//            String d = adddate.getText().toString();
//            String dc = adddesc.getText().toString();
//
//            replyIntent.putExtra(EXTRA_TITLE, t);
//            replyIntent.putExtra(EXTRA_COURSE, c);
//            replyIntent.putExtra(EXTRA_DATE, d);
//            replyIntent.putExtra(EXTRA_DESC, dc);


            if (TextUtils.isEmpty(addtitle.getText())) {
                return;
            } else {
                String t = addtitle.getText().toString();
                replyIntent.putExtra(EXTRA_TITLE, t);
            }
            if (TextUtils.isEmpty(addcourse.getText())) {
                return;
            } else {
                String c = addcourse.getText().toString();
                replyIntent.putExtra(EXTRA_COURSE, c);
            }
            if (TextUtils.isEmpty(adddate.getText())) {
                return;
            } else {
                String d = adddate.getText().toString();
                replyIntent.putExtra(EXTRA_DATE, d);
            }
            if (TextUtils.isEmpty(adddesc.getText())) {
                return;
            } else {
                String dc = adddesc.getText().toString();
                replyIntent.putExtra(EXTRA_DESC, dc);
            }
//            System.out.println(t + " " + d + c + dc);
            setResult(RESULT_OK, replyIntent);
            finish();
        });
    }
}