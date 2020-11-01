package com.example.trivia_app.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TriviaApp")
public class AnswerModel {

    @ColumnInfo(name = "Id")
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "DateTime")
    public String dateTime;

    @ColumnInfo(name = "Name")
    public String name;

    @ColumnInfo(name = "Answer1")
    public String answer1;

    @ColumnInfo(name = "Answer2")
    public String Answer2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return Answer2;
    }

    public void setAnswer2(String answer2) {
        Answer2 = answer2;
    }
}
