package com.example.recognition.view.activitys;

import android.os.Bundle;
import android.view.Menu;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.example.recognition.R;
import com.example.recognition.view.fragments.MainFragment;

public class SingleFragmentActivity extends AppCompatActivity {
    private FragmentManager mFragmentManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .add(R.id.fragment_container, MainFragment.newInstance())
                .addToBackStack(MainFragment.class.getName())
                .commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public void onBackPressed() {
        if (0 == mFragmentManager.getBackStackEntryCount()) {
            finish();
        }
        mFragmentManager.popBackStack();
    }
}