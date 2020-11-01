package com.example.trivia_app.adapter;


import com.example.trivia_app.model.AnswerModel;

import java.util.ArrayList;

public class HistoryListPresenter {

    private final ArrayList<AnswerModel> answerModelArrayList;

    public HistoryListPresenter(ArrayList<AnswerModel> answerModelArrayList) {
        this.answerModelArrayList = answerModelArrayList;
    }

    public void onBindRepliesLevelOneRowViewAtPosition(int position, HistoryRowView rowView) {
        AnswerModel answerModel = answerModelArrayList.get(position);
        System.out.println("size is ==  " + position);
        rowView.setName(answerModel.getName());
        rowView.setDateTime(answerModel.getDateTime(),position);
        rowView.setAnswer1(answerModel.getAnswer1());
        rowView.setAnswer2(answerModel.getAnswer2());
    }

    public int getHistoryRowsCount() {
        return answerModelArrayList.size();
    }

    public int getHistoryRowsViewType(int position) {
        return position;
    }
}
