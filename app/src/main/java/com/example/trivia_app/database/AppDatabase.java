package com.example.trivia_app.database;

import com.example.trivia_app.model.AnswerModel;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = AnswerModel.class,version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AnswerDao itemDao();
}
