package com.example.administrator.criminal.activity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.example.administrator.criminal.R;
import com.example.administrator.criminal.fragment.CrimeFragment;
import com.example.administrator.criminal.utility.SingleFrameActivity;

import java.util.UUID;

public class CrimeActivity extends SingleFrameActivity implements CrimeFragment.OnFragmentInteractionListener{



    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }


}
