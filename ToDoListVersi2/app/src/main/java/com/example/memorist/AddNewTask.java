package com.example.memorist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddNewTask extends AppCompatActivity {
    EditText addtitle, addcourse, adddate,adddesc, addtime;
    Button btnAdd;
    /**
     * Calendar untuk mendapatkan waktu saat ini
     */
    final Calendar calendar= Calendar.getInstance();
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);

        addtitle = findViewById(R.id.theTitle);
        addcourse = findViewById(R.id.theCourse);
        adddate = findViewById(R.id.theduedate);
        adddesc = findViewById(R.id.desc);
        addtime = findViewById(R.id.editTextAddTime);
        btnAdd= findViewById(R.id.buttonAdd);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                displayDate();
            }
        };
        addtime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showTimeDialog();
            }
        });
        adddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(AddNewTask.this, date, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnAdd.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(addtitle.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String taskTitle = addtitle.getText().toString();
                String taskCourse = addcourse.getText().toString();
                String taskDate = adddate.getText().toString();
                String taskTime = addtime.getText().toString();
                String taskDesc = adddesc.getText().toString();
                MyTask task = new MyTask(taskTitle,taskDate,taskDesc,taskCourse,taskTime);
                replyIntent.putExtra("task",task);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }

    private void displayDate(){
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        adddate.setText(dateFormat.format(calendar.getTime()));
    }

    private void showTimeDialog(){
        /**
         * Initialize TimePicker Dialog
         */
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                /**
                 * Method ini dipanggil saat kita selesai memilih waktu di DatePicker
                 */
                addtime.setText(hour+":"+minute);
            }
            },
                /**
                 * Tampilkan jam saat ini ketika TimePicker pertama kali dibuka
                 */
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),
                DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }
}