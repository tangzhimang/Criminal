package com.example.administrator.criminal.activity;

import android.support.v4.app.Fragment;

import com.example.administrator.criminal.fragment.CrimeListFragment;
import com.example.administrator.criminal.utility.SingleFrameActivity;

/**
 * Created by Administrator on 2016/4/12.
 */
public class CrimeListActivity extends SingleFrameActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
