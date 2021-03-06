package tg2.com.local.pauloafonso.pontosturisticos.fragment;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import tg2.com.local.pauloafonso.pontosturisticos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CachoeiraMapaFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng original;
    MapView mapView;
    View mView;

    public CachoeiraMapaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_cachoeira_mapa, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = (MapView) mView.findViewById(R.id.map_cachoeira);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());

        mMap = googleMap;
        LatLng cachoeira = new LatLng(-9.392602, -38.196983);
        mMap.addMarker(new MarkerOptions().position(cachoeira).title("Cachoeira de Paulo Afonso"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cachoeira));
        CameraPosition camPos = CameraPosition.builder().target(new LatLng(-9.392602, -38.196983)).zoom(18).bearing(0).tilt(45).build();

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(camPos));
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        mMap.setMyLocationEnabled(true);

    }

}
