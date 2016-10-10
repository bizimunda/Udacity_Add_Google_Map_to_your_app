package com.example.android.locationlesson1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;


public class Polyline extends ActionBarActivity implements OnMapReadyCallback{

    GoogleMap m_map;
    boolean mapReady=false;

    LatLng renton=new LatLng(50.882076, 4.387266);
    LatLng kirkland=new LatLng(50.852229, 4.411556);
    LatLng everett=new LatLng(50.863119, 4.426147);
    LatLng lynnwood=new LatLng(50.885813, 4.401771);
    LatLng montlake=new LatLng(47.7973733,-122.3281771);
    LatLng kent=new LatLng(47.385938,-122.258212);
    LatLng showare=new LatLng(47.38702,-122.23986);

    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(50.863309, 4.376350))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polyline);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {

        map.moveCamera(CameraUpdateFactory.newCameraPosition(SEATTLE));
        map.addPolyline(new PolylineOptions().geodesic(true).add(renton).add(kirkland).add(everett).add(lynnwood).add(renton));
        map.addPolygon(new PolygonOptions().add(renton, kirkland, everett, lynnwood).fillColor(Color.GREEN));
        map.addCircle(new CircleOptions()
                .center(renton)
                .radius(50)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(64,0,255,0)));

    }
}
