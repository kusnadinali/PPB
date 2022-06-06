package com.example.roomwordssample;

import androidx.room.Entity;
import androidx.room.ColumnInfo;
import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

//describe the Entity (which represents the SQLite table) for your words.
@Entity(tableName = "word_table")
public class Word {
    @PrimaryKey
    @NonNull //value can never be null.
    @ColumnInfo(name = "word")//Specify the name of the column in the table
    private String mWord;

    public Word(@NonNull String word) {this.mWord = word;}

    public String getWord(){return this.mWord;}
}
