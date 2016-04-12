package com.example.administrator.criminal.utility;

import android.content.Context;

import com.example.administrator.criminal.vo.Crime;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Administrator on 2016/4/12.
 */
public class CrimeLab {

    private ArrayList<Crime> mCrimes;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context appContext) {
        this.mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        for(int i=0;i<100;i++) {
            Crime crime = new Crime();
            crime.setmTitle("Crime #" + i);
            crime.setmSolved(i%2==0);
            mCrimes.add(crime);
        }
    }

    public static CrimeLab get(Context context){
        if(sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getmCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID uuid) {
        for(Crime crime:mCrimes) {
            if (crime.getmId().equals(uuid))
                return crime;
        }
        return null;
    }

}
