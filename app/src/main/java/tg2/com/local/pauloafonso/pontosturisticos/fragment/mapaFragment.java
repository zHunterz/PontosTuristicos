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
public class mapaFragment extends Fragment {


    public mapaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mapa, container, false);
    }

}
