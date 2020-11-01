package com.example.trivia_app.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;


import com.example.trivia_app.HomeActivity;
import com.example.trivia_app.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FinalPageFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Context context;
    private String value = "";
    private Bundle bundle;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4;

    public static FinalPageFragment newInstance(Bundle args) {
        FinalPageFragment finalPageFragment = new FinalPageFragment();
        finalPageFragment.setArguments(args);
        return finalPageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_final_page, container, false);
        context = getActivity();
        init();
        return view;
    }

    private void init() {
        ((HomeActivity)context).toolbarTitle(getString(R.string.final_page));
        view.findViewById(R.id.btn_next).setOnClickListener(this);
        checkBox1 = view.findViewById(R.id.checkbox1);
        checkBox2 = view.findViewById(R.id.checkbox2);
        checkBox3 = view.findViewById(R.id.checkbox3);
        checkBox4 = view.findViewById(R.id.checkbox4);
        value = "";

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    value = value + getString(R.string.white) + "," ;
                } else {
                    value = value.replaceAll(getString(R.string.white) + ",", "");
                }
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    value = value + getString(R.string.yellow) + "," ;
                } else {
                    value = value.replaceAll(getString(R.string.yellow) + ",", "");
                }
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    value = value + getString(R.string.orange) + "," ;
                } else {
                    value = value.replaceAll(getString(R.string.orange) + ",", "");
                }
            }
        });

        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    value = value + getString(R.string.green) + "," ;
                } else {
                    value = value.replaceAll(getString(R.string.green) + ",", "");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_next) {
            if(value.isEmpty()) {
                Toast.makeText(context, R.string.select_answer3,Toast.LENGTH_LONG).show();
            } else {
                value = value.substring(0,value.length() - 1);
                System.out.println("value is ==  " + value);
                bundle.putString("answer3",value);
                ((HomeActivity)context).addFragment(SummaryFragment.newInstance(bundle));
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        bundle = getArguments();
        assert bundle != null;
        if(bundle.getString("answer3") != null) {
            String value1 = bundle.getString("answer3") + ",";
            if(value1.contains(getResources().getString(R.string.white))) {
                checkBox1.setChecked(true);
            }
            if(value1.contains(getResources().getString(R.string.yellow))) {
                checkBox2.setChecked(true);
            }
            if(value1.contains(getResources().getString(R.string.orange))) {
                checkBox3.setChecked(true);
            }
            if(value1.contains(getResources().getString(R.string.green))) {
                checkBox4.setChecked(true);
            }
        }
    }
}
