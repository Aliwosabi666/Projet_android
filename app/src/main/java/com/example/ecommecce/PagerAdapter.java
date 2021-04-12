package com.example.ecommecce;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ecommecce.ui.statut.GagneFragment;
import com.example.ecommecce.ui.statut.NewFragment;
import com.example.ecommecce.ui.statut.PerduFragment;
import com.example.ecommecce.ui.statut.PropositionFragment;
import com.example.ecommecce.ui.statut.QualifiedFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    private int tabsNumber;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior, int tabs) {
        super(fm, behavior);
        this.tabsNumber = tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new NewFragment();
            case 1:
                return new QualifiedFragment();
            case 2 :
                return new PropositionFragment();
            case 3 :
                return new GagneFragment();
            case 4 :
                return new PerduFragment();
                default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
