package com.example.memorist;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.RoomDatabase;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.List;

public class TaskRepository {
    private TaskDAO mTaskDao;
    private LiveData<List<MyTask>> mAllTasks;

    TaskRepository(Application application) {
        TaskRoomDatabase db = TaskRoomDatabase.getInstance(application);
        mTaskDao = db.taskDao();
        mAllTasks = mTaskDao.getAll();
    }
    public LiveData<List<MyTask>> getAllTasks() {
        return mAllTasks;
    }

    public void insert(MyTask task) {
        new InsertMemoAsyncTask(mTaskDao).execute(task);
//        TaskRoomDatabase.databaseWriteExecutor.execute(() -> {
//            mTaskDao.insert(task);
//        });
    }

    private static class InsertMemoAsyncTask extends AsyncTask<MyTask,Void,Void>{
        private TaskDAO taskDao;

        private InsertMemoAsyncTask(TaskDAO taskDao){
            this.taskDao = taskDao;
        }
        @Override
        protected Void doInBackground(MyTask... tasks){
            taskDao.insert(tasks[0]);
            return null;
        }
    }
}
