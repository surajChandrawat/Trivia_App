package com.example.trivia_app.database;


import com.example.trivia_app.model.AnswerModel;
import java.util.ArrayList;

public interface DatabaseCallBack {

    void insertData();

    void getHistory(ArrayList<AnswerModel> answerModels);
}
