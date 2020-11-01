package com.example.trivia_app.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.example.trivia_app.HomeActivity;
import com.example.trivia_app.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondPageFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Context context;
    private String value = "";
    private Bundle bundle;
    private RadioButton radioButton0,radioButton1,radioButton2,radioButton3;

    public static SecondPageFragment newInstance(Bundle args) {
        SecondPageFragment secondPageFragment = new SecondPageFragment();
        secondPageFragment.setArguments(args);
        return secondPageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second_page, container, false);
        context = getActivity();
        init();
        return view;
    }

    private void init() {
        ((HomeActivity)context).toolbarTitle(getString(R.string.second_page));
        view.findViewById(R.id.btn_next).setOnClickListener(this);
        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        radioButton0 = view.findViewById(R.id.radio0);
        radioButton1 = view.findViewById(R.id.radio1);
        radioButton2 = view.findViewById(R.id.radio2);
        radioButton3 = view.findViewById(R.id.radio3);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                System.out.println("id is==  " + checkedId  + "    " + R.id.radio0);
                if(checkedId == R.id.radio0) {
                    value = getResources().getString(R.string.sachin_tendulkar);
                } else if(checkedId == R.id.radio1) {
                    value = getResources().getString(R.string.virat_kohli);
                } else if(checkedId == R.id.radio2) {
                    value = getResources().getString(R.string.adam_gilchirst);
                } else if(checkedId == R.id.radio3) {
                    value = getResources().getString(R.string.jacques_kallis);
                }
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        bundle = getArguments();
        assert bundle != null;
        if(bundle.getString("answer2") != null) {
            value = bundle.getString("answer2");
            if(value != null && value.equals(getResources().getString(R.string.sachin_tendulkar))) {
                radioButton0.setChecked(true);
            } else if(value != null && value.equals(getResources().getString(R.string.virat_kohli))) {
                radioButton1.setChecked(true);
            } else if(value != null && value.equals(getResources().getString(R.string.adam_gilchirst))) {
                radioButton2.setChecked(true);
            } else if(value != null && value.equals(getResources().getString(R.string.jacques_kallis))) {
                radioButton3.setChecked(true);
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_next) {
            if(value.isEmpty()) {
                Toast.makeText(context, R.string.select_answer2,Toast.LENGTH_LONG).show();
            } else {
                bundle.putString("answer2",value);
                ((HomeActivity)context).addFragment(FinalPageFragment.newInstance(bundle));
            }
        }
    }
}
