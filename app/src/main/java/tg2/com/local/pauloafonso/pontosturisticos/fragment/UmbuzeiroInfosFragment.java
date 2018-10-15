package tg2.com.local.pauloafonso.pontosturisticos.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tg2.com.local.pauloafonso.pontosturisticos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UmbuzeiroInfosFragment extends Fragment {


    public UmbuzeiroInfosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_umbuzeiro_infos, container, false);
    }

}
