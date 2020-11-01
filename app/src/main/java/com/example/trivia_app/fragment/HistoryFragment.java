package com.example.trivia_app.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.trivia_app.HomeActivity;
import com.example.trivia_app.R;
import com.example.trivia_app.adapter.HistoryAdapter;
import com.example.trivia_app.adapter.HistoryListPresenter;
import com.example.trivia_app.database.BackgroundTask;
import com.example.trivia_app.database.DatabaseCallBack;
import com.example.trivia_app.model.AnswerModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryFragment extends Fragment implements DatabaseCallBack {

    private View view;
    private Context context;
    RecyclerView recyclerView;

    public static HistoryFragment newInstance(Bundle args) {
        HistoryFragment historyFragment = new HistoryFragment();
        historyFragment.setArguments(args);
        return historyFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_history, container, false);
        context = getActivity();
        init();
        return view;
    }

    private void init() {
        ((HomeActivity)context).toolbarTitle(getString(R.string.history));
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.hasFixedSize();
        BackgroundTask backgroundTask = new BackgroundTask(context, null, this);
        backgroundTask.execute(2);
    }

    @Override
    public void insertData() {}

    @Override
    public void getHistory(ArrayList<AnswerModel> answerModels) {
        System.out.println("size is ==  " + answerModels.size());
        HistoryAdapter historyAdapter = new HistoryAdapter(new HistoryListPresenter(answerModels), context);
        recyclerView.setAdapter(historyAdapter);

    }
}
