package com.example.memorist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {
    private TaskRepository mRepository;
    private final LiveData<List<MyTask>> mAllTasks;

    public TaskViewModel (@NonNull Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        mAllTasks = mRepository.getAllTasks();
    }

    LiveData<List<MyTask>> getAllTasks() {
        return mAllTasks;
    }

    public void insert(MyTask task) {
        mRepository.insert(task);
    }
}
