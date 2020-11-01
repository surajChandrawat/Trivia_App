package com.example.trivia_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.trivia_app.R;

import androidx.recyclerview.widget.RecyclerView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryListPresenterViewHolder> {

    private final HistoryListPresenter presenter;
    private Context context;

    public HistoryAdapter(HistoryListPresenter presenter, Context context) {
        this.presenter = presenter;
        this.context = context;
    }

    @Override
    public HistoryListPresenterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HistoryListPresenterViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cell_history_list_view, parent, false),context);
    }

    @Override
    public void onBindViewHolder(HistoryListPresenterViewHolder holder, int position) {
        presenter.onBindRepliesLevelOneRowViewAtPosition(position, holder);

    }

    @Override
    public int getItemCount() {
        return presenter.getHistoryRowsCount();
    }

    @Override
    public int getItemViewType(int position) {
        return presenter.getHistoryRowsViewType(position);
    }
}
