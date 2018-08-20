package tg2.com.local.pauloafonso.pontosturisticos.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import tg2.com.local.pauloafonso.pontosturisticos.fragment.infosFragment;
import tg2.com.local.pauloafonso.pontosturisticos.fragment.mapaFragment;

public class TabAdapter extends FragmentStatePagerAdapter {

    private String[] tituloTabs = {"INFORMAÇÕES", "MAPAS"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new infosFragment();
                break;
            case 1:
                fragment = new mapaFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return tituloTabs.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tituloTabs[position];
    }
}
