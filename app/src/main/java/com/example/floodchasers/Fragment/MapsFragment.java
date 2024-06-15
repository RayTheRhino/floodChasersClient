package com.example.floodchasers.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.floodchasers.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //init view
        View view = inflater.inflate(R.layout.fragment_maps,container,false);

        //init map fragmant
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_maps);

        //async maps
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                //when the map is loaded
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(@NonNull LatLng latLng) {
                        //when clicked on map
                        //init marker options
                        MarkerOptions markerOptions = new MarkerOptions();
                        //set position of the marker
                        markerOptions.position(latLng);
                        //set title for the marker
                        markerOptions.title(latLng.latitude+ " : "+latLng.longitude);
                        //remove all marker
                        googleMap.clear();
                        //animating the zoom marker
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                                latLng,10
                        ));
                        //Add marker on the map
                        googleMap.addMarker((markerOptions));
                    }
                });
            }
        });
        return view;
    }
}