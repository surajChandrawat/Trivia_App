package com.example.trivia_app;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.trivia_app.fragment.FirstPageFragment;
import com.example.trivia_app.fragment.SummaryFragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView toolbarTitle;
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {
        toolbarTitle = findViewById(R.id.title);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById(R.id.imgBack).setOnClickListener(this);
        Bundle bundle = new Bundle();
        addFragment(FirstPageFragment.newInstance(bundle));
    }

    public void toolbarTitle(String title) {
        toolbarTitle.setText(title);
    }

    public void addFragment(Fragment fragment) {
        this.fragment = fragment;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment, "fragmentTag")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imgBack) {
            onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        Fragment fragment1 = getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        if(fragment1 instanceof FirstPageFragment) {
            finish();
        } else {
            if (fm.getBackStackEntryCount() > 0) {
                fm.popBackStack();
            } else {
                super.onBackPressed();
            }
        }
    }

    public void onFinishClick() {
        Fragment fragment1 = getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        if (fragment1 instanceof SummaryFragment) {
            getSupportFragmentManager().popBackStackImmediate();
            getSupportFragmentManager().popBackStackImmediate();
            getSupportFragmentManager().popBackStackImmediate();
            getSupportFragmentManager().popBackStackImmediate();
            Bundle bundle = new Bundle();
            addFragment(FirstPageFragment.newInstance(bundle));
        }
    }
}
