package com.example.trivia_app.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trivia_app.HomeActivity;
import com.example.trivia_app.R;
import com.example.trivia_app.database.BackgroundTask;
import com.example.trivia_app.database.DatabaseCallBack;
import com.example.trivia_app.model.AnswerModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SummaryFragment extends Fragment implements View.OnClickListener, DatabaseCallBack {

    private View view;
    private Context context;
    private Bundle bundle;

    public static SummaryFragment newInstance(Bundle args) {
        SummaryFragment summaryFragment = new SummaryFragment();
        summaryFragment.setArguments(args);
        return summaryFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_summary, container, false);
        context = getActivity();
        init();
        return view;
    }

    private void init () {
        bundle = getArguments();
        ((HomeActivity)context).toolbarTitle(getString(R.string.summary));
        view.findViewById(R.id.btn_finish).setOnClickListener(this);
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtAnswer2 = view.findViewById(R.id.txtAnswer2);
        TextView txtAnswer3 = view.findViewById(R.id.txtAnswer3);
        txtName.setText("Hello \" " + bundle.getString("UserName") + "\" ,");
        txtAnswer2.setText("Answer: \"" + bundle.getString("answer2") + "\"");
        txtAnswer3.setText("Answer: \"" + bundle.getString("answer3") + "\"");
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_finish) {
            AnswerModel answerModel = new AnswerModel();
            answerModel.setName(bundle.getString("UserName"));
            answerModel.setAnswer1(bundle.getString("answer2"));
            answerModel.setAnswer2(bundle.getString("answer3"));
            answerModel.setDateTime(getCurrentDateTime());
            BackgroundTask backgroundTask = new BackgroundTask(context, answerModel, this);
            backgroundTask.execute(1);
        }
    }

    @SuppressLint("SimpleDateFormat")
    private String getCurrentDateTime() {
        SimpleDateFormat format = new SimpleDateFormat("d");
        String date = format.format(new Date());

        if(date.endsWith("1") && !date.endsWith("11"))
            format = new SimpleDateFormat("d'st' MMM hh:mm a");
        else if(date.endsWith("2") && !date.endsWith("12"))
            format = new SimpleDateFormat("d'nd' MMM hh:mm a");
        else if(date.endsWith("3") && !date.endsWith("13"))
            format = new SimpleDateFormat("d'rd' MMM hh:mm a");
        else
            format = new SimpleDateFormat("d'th' MMM hh:mm a");

        return format.format(new Date());
    }

    @Override
    public void insertData() {
        Toast.makeText(context, R.string.insert,Toast.LENGTH_LONG).show();
        ((HomeActivity)context).onFinishClick();
    }

    @Override
    public void getHistory(ArrayList<AnswerModel> answerModels) {}
}
