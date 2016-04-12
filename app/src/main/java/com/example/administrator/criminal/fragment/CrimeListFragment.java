package com.example.administrator.criminal.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.criminal.R;
import com.example.administrator.criminal.utility.CrimeLab;
import com.example.administrator.criminal.vo.Crime;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeListFragment extends ListFragment {

    private ArrayList<Crime> mCrimes;

    public CrimeListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimeListFrame_title);
        mCrimes = CrimeLab.get(getActivity()).getmCrimes();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        return textView;
    }

}
