package com.example.memorist;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;

public class TaskRepository {
    private TaskDAO mTaskDao;
    private LiveData<List<MyTask>> mAllTasks;

    TaskRepository(Application application) {
        TaskRoomDatabase db = TaskRoomDatabase.getDatabase(application);
        mTaskDao = db.taskDao();
        mAllTasks = mTaskDao.getAll();
    }
    LiveData<List<MyTask>> getAllTasks() {
        return mAllTasks;
    }

    public void insert(MyTask task) {
        TaskRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTaskDao.insert(task);
        });
    }

    public void delete(MyTask task){

    }
}
