package com.solution.jens.sacheck.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.solution.jens.sacheck.fragment.VariableFragment;
import com.solution.jens.sacheck.fragment.CheckSalaryFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jens on 7/13/2016.
 */
public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    private final CheckSalaryFragment fCheckSalaryFragment;
    private final VariableFragment fVariableFragment;
    private List<Fragment> fFragmentList = new ArrayList<>();
    private List<String> fFragmentTitle = new ArrayList<>();

//    private int[] tabIcons = {
//            R.drawable.ic_tab_favourite,
//            R.drawable.ic_tab_contacts
//    };

    private String fTitle[] = new String[]{"Check", "Variable"};

    public TabFragmentPagerAdapter(FragmentManager supportFragmentManager, CheckSalaryFragment  aCheckSalaryFragment,
                                   VariableFragment variableFragment) {
        super(supportFragmentManager);

        fCheckSalaryFragment = aCheckSalaryFragment;
        fVariableFragment = variableFragment;
    }

    public void addFragment (Fragment aFragment, String aTitle){
        fFragmentList.add(aFragment);
        fFragmentTitle.add(aTitle);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment = fCheckSalaryFragment;
                break;
            case 1:
                fragment = fVariableFragment;
                break;
            default:
                fragment=null;
                break;
        }
        return fragment;
    }



    @Override
    public CharSequence getPageTitle(int position) {
        return fTitle[position];
    }

    @Override
    public int getCount() {
        return fTitle.length;
    }

}
