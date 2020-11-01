package com.example.trivia_app.database;

import android.content.Context;
import android.os.AsyncTask;


import com.example.trivia_app.model.AnswerModel;

import java.util.ArrayList;
import java.util.List;

public class BackgroundTask extends AsyncTask<Integer, Integer, Integer> {

    private Context context;
    private AnswerModel answerModel;
    private DatabaseCallBack databaseCallBack;
    private List<AnswerModel> getAllItemList = new ArrayList<>();

    public BackgroundTask(Context context, AnswerModel answerModel, DatabaseCallBack databaseCallBack) {
        this.context = context;
        this.databaseCallBack = databaseCallBack;
        this.answerModel = answerModel;
    }

    @Override
    protected Integer doInBackground(Integer... integers) {
        switch (integers[0]) {
            case 1:
                DatabaseClient.getInstance(context).getAppDatabase().itemDao().
                        insertItem(answerModel);
                return 1;

            case 2:
                getAllItemList = DatabaseClient.getInstance(context).getAppDatabase().itemDao()
                        .getAllItem();
                System.out.println("list size is 11==  " + getAllItemList.size());
                if (getAllItemList == null) {
                    return 402;
                } else return 2;
        }
        return 0;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        switch (integer) {
            case 1:
                databaseCallBack.insertData();

            case 2:
                databaseCallBack.getHistory(new ArrayList<>(getAllItemList));
                break;
            default:
                break;
        }
    }
}

