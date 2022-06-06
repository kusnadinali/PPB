package com.example.memorist;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class MyTask implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name="title")
    @NonNull
    String title;

    @ColumnInfo(name="date")
    @NonNull
    String date;

    @ColumnInfo(name="time")
    @NonNull
    String time;

    @ColumnInfo(name="desc")
    String desc;

    @ColumnInfo(name="course")
    @NonNull
    String course;

    public MyTask(String title, String date, String desc, String course, String time) {
        this.title = title;
        this.date = date;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String date) {
        this.time = time;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.course);
        parcel.writeString(this.date);
        parcel.writeString(this.time);
        parcel.writeString(this.desc);
    }

    protected MyTask(Parcel in){
        this.id = in.readInt();
        this.title = in.readString();
        this.course = in.readString();
        this.date = in.readString();
        this.time = in.readString();
        this.desc = in.readString();
    }

    public static final Parcelable.Creator<MyTask> CREATOR = new Parcelable.Creator<MyTask>(){

        @Override
        public MyTask createFromParcel(Parcel source) {
            return new MyTask(source);
        }

        @Override
        public MyTask[] newArray(int size) {
            return new MyTask[size];
        }
    };
}
