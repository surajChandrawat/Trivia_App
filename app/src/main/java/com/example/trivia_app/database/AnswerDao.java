package com.example.trivia_app.database;


import com.example.trivia_app.model.AnswerModel;
import java.util.List;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface AnswerDao {

    @Insert
    void insertItem(AnswerModel answerModel);

    @Query("SELECT * FROM TriviaApp")
    List<AnswerModel> getAllItem();
}
