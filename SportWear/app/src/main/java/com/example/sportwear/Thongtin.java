package com.example.sportwear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Thongtin extends AppCompatActivity {
    Toolbar toolbarThongTin;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin);
        toolbarThongTin = findViewById(R.id.toolbarThongtin);
        ActionBar();
       /* SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); */
    }

    private void ActionBar() {
        setSupportActionBar(toolbarThongTin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarThongTin.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
   /* @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng truongVietMy = new LatLng(10.759474, 106.666858);
        mMap.addMarker(new MarkerOptions().position(truongVietMy).title("Trung Tâm Tin Học ĐHKHTN TPHCM").snippet("137E Nguyễn Chí Thanh,Phường 9, Quận 5, TP Hồ Chí Minh").icon(BitmapDescriptorFactory.defaultMarker()));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(truongVietMy).zoom(20).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    } */
}
