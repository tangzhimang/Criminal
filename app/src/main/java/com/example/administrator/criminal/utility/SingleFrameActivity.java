package com.example.administrator.criminal.utility;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.administrator.criminal.R;
import com.example.administrator.criminal.fragment.CrimeFragment;

/**
 * Created by Administrator on 2016/4/12.
 */
public abstract class SingleFrameActivity extends FragmentActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.Fragment fragment = fragmentManager.findFragmentById(R.id.FragmentContainer);

        if(fragment == null) {
            fragment = createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.FragmentContainer, fragment)
                    .commit();
        }
    }
}
