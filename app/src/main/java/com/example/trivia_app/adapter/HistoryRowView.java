package com.example.trivia_app.adapter;

public interface HistoryRowView {

    void setDateTime(String dateTime, int position);
    void setName(String name);
    void setAnswer1(String answer1);
    void setAnswer2(String answer2);
}
