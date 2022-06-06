package com.example.memorist;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class MyTask {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name="title")
    @NonNull
    String title;

    @ColumnInfo(name="date")
    @NonNull
    String date;

    @ColumnInfo(name="desc")
    String desc;

    @ColumnInfo(name="course")
    @NonNull
    String course;

    public MyTask(String title, String date, String desc, String course) {
        this.title = title;
        this.date = date;
        this.desc = desc;
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
