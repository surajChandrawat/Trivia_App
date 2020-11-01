package com.example.trivia_app.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trivia_app.HomeActivity;
import com.example.trivia_app.R;
import com.example.trivia_app.database.BackgroundTask;
import com.example.trivia_app.database.DatabaseCallBack;
import com.example.trivia_app.model.AnswerModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstPageFragment extends Fragment implements View.OnClickListener, DatabaseCallBack {

    private View view;
    private Context context;
    private EditText edt_name;
    private Bundle bundle;

    public static FirstPageFragment newInstance(Bundle args) {
        FirstPageFragment firstPageFragment = new FirstPageFragment();
        firstPageFragment.setArguments(args);
        return firstPageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first_page, container, false);
        context = getActivity();
        init();
        return view;
    }

    private void init() {
        ((HomeActivity)context).toolbarTitle(getString(R.string.first_page));
        edt_name = view.findViewById(R.id.edt_name);
        view.findViewById(R.id.btn_next).setOnClickListener(this);
        view.findViewById(R.id.btn_history).setOnClickListener(this);
        BackgroundTask backgroundTask = new BackgroundTask(context, null, this);
        backgroundTask.execute(2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                if(edt_name.getText().toString().trim().isEmpty()) {
                    Toast.makeText(context, R.string.enter_name,Toast.LENGTH_LONG).show();
                } else {
                    bundle.putString("UserName", edt_name.getText().toString().trim());
                    ((HomeActivity)context).addFragment(SecondPageFragment.newInstance(bundle));
                }
                break;

            case R.id.btn_history:
                ((HomeActivity)context).addFragment(HistoryFragment.newInstance(null));
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        bundle = getArguments();
    }

    @Override
    public void insertData() {}

    @Override
    public void getHistory(ArrayList<AnswerModel> answerModels) {
        System.out.println("size is ==  " + answerModels.size());
        if(answerModels.size() > 0) {
            view.findViewById(R.id.btn_history).setVisibility(View.VISIBLE);
        } else {
            view.findViewById(R.id.btn_history).setVisibility(View.GONE);
        }
    }
}
