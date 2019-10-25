package com.example.logindemo;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

import java.text.DecimalFormat;

public class SecondActivity2 extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private float mMaxZoomLevel;
    private static final String MOON_MAP_URL_FORMAT =
            "https://tile.sievamaps.com/hot/{z}/{x}/{y}.png";
    int i = 0;
    public static Double[] lat, lng;

    int tile_width = 256;
    int tile_height = 256;
    DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tile_overlay_demo);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        lat = new Double[]{
                9.5907299,
                41.9029468,
                -37.8199669,
                51.529831,
                22.5584134,
                9.7923541,
                45.4262289,
                31.2088705,
                22.6958007,
                24.9999986
        };
        lng = new Double[]{
                76.5291946,
                12.4522948,
                144.9812606,
                -0.1743451,
                75.7538562,
                -74.8039497,
                10.9224912,
                29.9070125,
                75.8641383,
                -71.0175096
        };
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMaxZoomLevel = 10;
        mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
        new CountDownTimer(50 * 500, 500) {

            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onTick(long millisUntilFinished) {
                long startTime = System.nanoTime();
                CustomUrlTileProvider mTileProvider = new CustomUrlTileProvider(
                        tile_width,
                        tile_height, MOON_MAP_URL_FORMAT);
                mMap.addTileOverlay(
                        new TileOverlayOptions().tileProvider(mTileProvider)
                                .zIndex(-1));
                long endTime = System.nanoTime();
                long totalTime = (endTime - startTime) / 1000000;
                System.out.println("API call time: " + (df.format(totalTime)));
                //Log.d(getString(R.string.api), String.valueOf(totalTime + "--" + startTime + "--" + endTime));

            }

            @Override
            public void onFinish() {

            }
        }.start();

//        }
    }

//        if (mMap.getCameraPosition().zoom > mMaxZoomLevel) {
//            mMap.moveCamera(CameraUpdateFactory.zoomTo(mMaxZoomLevel));
//        }
    //getLocations();

    //  }

    private void getLocations() {
//        for (int i = 1; i < lat.length; i++) {
        // final int finalI = i;
        new CountDownTimer(10 * 3000, 3000) {

            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onTick(long millisUntilFinished) {

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat[i], lng[i]), 14));
                mMap.addMarker(new MarkerOptions().position(new LatLng(lat[i], lng[i])));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat[i], lng[i])));
                i++;
            }

            @Override
            public void onFinish() {

            }
        }.start();

//        }
    }
}