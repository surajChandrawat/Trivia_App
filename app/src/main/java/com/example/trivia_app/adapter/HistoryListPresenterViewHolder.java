package com.example.trivia_app.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.trivia_app.R;

import androidx.recyclerview.widget.RecyclerView;

public class HistoryListPresenterViewHolder extends RecyclerView.ViewHolder implements HistoryRowView {

    private Context context;
    private TextView txtDateTime,txtName,txtAnswer2,txtAnswer3;

    public HistoryListPresenterViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        txtDateTime = itemView.findViewById(R.id.txtDateTime);
        txtName = itemView.findViewById(R.id.txtName);
        txtAnswer2 = itemView.findViewById(R.id.txtAnswer2);
        txtAnswer3 = itemView.findViewById(R.id.txtAnswer3);
    }

    @Override
    public void setDateTime(String dateTime,int position) {
        position = position + 1;
        dateTime = "Game " + position + " : " + dateTime;
        txtDateTime.setText(dateTime);
    }

    @Override
    public void setName(String name) {
        name = "Name : " + name;
        txtName.setText(name);
    }

    @Override
    public void setAnswer1(String answer1) {
        answer1 = "Answer : " + answer1;
        txtAnswer2.setText(answer1);
    }

    @Override
    public void setAnswer2(String answer2) {
        answer2 = "Answer : " + answer2;
        txtAnswer3.setText(answer2);
    }
}

