package com.example.memorist;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//declare the entities that belong in the database
@Database(entities={MyTask.class},version = 1, exportSchema = false)
public abstract class TaskRoomDatabase extends RoomDatabase {

    public abstract TaskDAO taskDao();
    private static volatile TaskRoomDatabase instance;
    public static synchronized TaskRoomDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TaskRoomDatabase.class, "task_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(sRoomDatabaseCallback)
                    .build();
        }
        return instance;
    }
//    private static final int NUMBER_OF_THREADS = 4;
//    static final ExecutorService databaseWriteExecutor =
//            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

//    static TaskRoomDatabase getDatabase(final Context context) {
//        if (INSTANCE == null) {
//            synchronized (TaskRoomDatabase.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                            TaskRoomDatabase.class, "task_database")
////                            .addCallback(sRoomDatabaseCallback)
//                            .build();
//                }
//            }
//        }
//        return INSTANCE;
//    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();

            // If you want to keep data through app restarts,
            // comment out the following block
//            databaseWriteExecutor.execute(() -> {
//                // Populate the database in the background.
//                // If you want to start with more words, just add them.
//                TaskDAO dao = instance.taskDao();
//                dao.deleteAll();
//
//                MyTask task = new MyTask("Tugas 1", "28 Februari 2022", "Membuat aplikasi to do list", "Mobile");
//                dao.insert(task);
////                task = new Word("World");
////                dao.insert(word);
//            });
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void,Void>{
        private TaskDAO taskDao;
        private PopulateDbAsyncTask(TaskRoomDatabase db){
            taskDao = db.taskDao();
        }
        @Override
        protected Void doInBackground(Void... voids){
            taskDao.insert(new MyTask("Tugas","14 Maret 2022","Susah","PPB"));
            taskDao.insert(new MyTask("Tugas 2","14 Maret 2022","Susah banget","PPB"));
            return null;
        }
    }
}
