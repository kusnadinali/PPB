package com.example.memorist;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Dao;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository mRepository;
    private final LiveData<List<MyTask>> mAllTasks;
    private WorkManager workManager;
    private static final String TAG = TaskViewModel.class.getSimpleName();

    public TaskViewModel (@NonNull Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        mAllTasks = mRepository.getAllTasks();
        workManager = WorkManager.getInstance(application);
    }



    LiveData<List<MyTask>> getAllTasks() {
        return mAllTasks;
    }

    @SuppressLint("RestrictedApi")
    public void insert(MyTask task) {
        mRepository.insert(task);
        String myFormat="dd/MM/yyyy - HH:mm";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        String combineDateTime = task.date + " - " + task.time;
        Date date;
        try {
            date = dateFormat.parse(combineDateTime);
            Long diffTime = date.getTime() - System.currentTimeMillis();
            System.out.println("diffTime:" + diffTime);
            Data myData = new Data.Builder()
                    .putString("title", task.getTitle())
                    .build();
             WorkRequest workRequest = new OneTimeWorkRequest.Builder(NotificationWorker.class)
                    .setInitialDelay(diffTime, TimeUnit.MILLISECONDS)
                     .setInputData(myData)
                    .build();
            workManager.enqueue(workRequest);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
