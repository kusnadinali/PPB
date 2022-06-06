package com.example.memorist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDAO {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(MyTask Task);

    @Delete
    void delete(MyTask Task);

    @Query("SELECT * FROM task_table ORDER BY date ASC")
    LiveData<List<MyTask>> getAll(); //Room generates all necessary code to update the LiveData when the database is updated.

    @Query("DELETE FROM task_table")
    void deleteAll();
}
