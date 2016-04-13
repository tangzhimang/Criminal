package com.example.administrator.criminal.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.criminal.R;
import com.example.administrator.criminal.activity.CrimeActivity;
import com.example.administrator.criminal.utility.CrimeLab;
import com.example.administrator.criminal.vo.Crime;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeListFragment extends Fragment {

    private ArrayList<Crime> mCrimes;
    private ListView CrimeListView;

    public CrimeListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimeListFrame_title);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.crime_list_fragment, container, false);
        CrimeListView = (ListView)v.findViewById(R.id.CrimeListView);
        mCrimes = CrimeLab.get(getActivity()).getmCrimes();
        CrimeAdapter adapter = new CrimeAdapter(getActivity(),R.layout.list_item_crime_adapter,mCrimes);
        CrimeListView.setAdapter(adapter);
        CrimeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Crime crime = mCrimes.get(position);
                Intent intent = new Intent(getActivity(), CrimeActivity.class);
                intent.putExtra(CrimeFragment.EXTRA_CRIME_ID,crime.getmId());
                startActivity(intent);
                //Toast.makeText(getActivity(),crime.getmTitle(),Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    private class CrimeAdapter extends ArrayAdapter<Crime> {

        public CrimeAdapter(Context context, int resource, List<Crime> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime_adapter,null);
            }
            Crime crime = getItem(position);
            TextView titleTextView = (TextView)convertView.findViewById(R.id.crime_list_item_title_TextView);
            titleTextView.setText(crime.getmTitle());
            TextView dateTextView = (TextView)convertView.findViewById(R.id.crime_list_item_date_adapter);
            dateTextView.setText(crime.getmDate().toString());
            CheckBox SolvedCheckBox =(CheckBox)convertView.findViewById(R.id.crime_list_item_solve_checkBox);
            SolvedCheckBox.setChecked(crime.ismSolved());
            return convertView;
        }
    }

}
