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

import java.text.DecimalFormat;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private float mMaxZoomLevel;
    private static final String MOON_MAP_URL_FORMAT =
            "https://tile.sievamaps.com/hot/{z}/{x}/{y}.png";
    private static Double[] lat, lng;
    private int tile_width = 256, tile_height = 256, latLongCount = 1;
    private DecimalFormat df = new DecimalFormat("0.00");

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
                24.9999986,
                39.5028878,
                25.71261522,
                65.72127674,
                -59.84726846,
                11.15425388,
                -1.13920953,
                -29.26042715,
                -46.15989805,
                -57.68975363,
                -27.79186042,
                -40.28881731,
                4.09707382,
                -44.25322598,
                -63.10707272,
                -43.72257976,
                -5.70769423,
                39.98978605,
                -14.01983372,
                -29.75524039,
                -68.7903107,
                -35.92576616,
                -51.15359526,
                -18.46488267,
                -0.44384056,
                -55.538715,
                -44.94358942,
                -40.98744469,
                3.86876985,
                9.98057743,
                -39.63138243,
                23.94152963,
                -57.39860901,
                -42.32332611,
                -36.32948453,
                -20.5854918,
                19.03622277,
                -71.12212711,
                -48.89760379,
                43.37099014,
                26.73929708,
                16.25227115,
                12.5863576,
                -30.02924202,
                9.80001085,
                49.78684521,
                -14.71984211,
                -18.10862577,
                68.6308292,
                -43.68713135,
                7.6059637,
                12.89059928,
                18.80905188,
                -42.07444319,
                -13.8356424,
                3.43299508,
                27.91149606,
                -28.93626674,
                -46.39431985,
                57.2363901,
                27.45032787,
                -54.28120004,
                23.15788528,
                44.78708148,
                9.32988399,
                -73.04103164,
                12.06787266,
                -14.86293486,
                33.07767741,
                -47.3884403,
                19.13077304,
                17.11604818,
                38.74604558,
                2.26316095,
                -58.01220322,
                18.40792459,
                2.23842699,
                32.96073543,
                15.03358257,
                48.87125184,
                -20.24793772,
                -44.03306761,
                35.42035902,
                -40.48818452,
                -12.06767565,
                -42.8601713,
                -35.86638385,
                58.51053393,
                69.52110773,
                -12.97161338,
                -43.67690779,
                9.5907299
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
                -71.0175096,
                106.5237978,
                -98.97379499,
                -166.4522706,
                -165.0070541,
                15.29164506,
                23.5282394,
                146.7563712,
                32.84614602,
                -132.7967528,
                37.75417316,
                -59.97359654,
                172.3622378,
                28.10627851,
                146.0920119,
                -179.5447686,
                114.2999216,
                -28.69827031,
                16.58268984,
                145.4396897,
                -159.1612041,
                177.951893,
                50.62092096,
                -165.9622969,
                -77.22514379,
                -66.5469906,
                68.43610333,
                74.20362178,
                139.1060864,
                -58.77504542,
                177.4647478,
                -83.70595951,
                63.52798081,
                -40.90215771,
                54.5328094,
                -153.6233452,
                -179.4531914,
                -94.08243753,
                25.93281877,
                17.33294685,
                -79.62436601,
                130.4959328,
                115.5155721,
                -10.12623282,
                163.5986087,
                73.15522611,
                179.2445229,
                -130.7852997,
                -155.9223988,
                -46.79763809,
                5.45236076,
                68.43438009,
                42.45864565,
                -67.88331822,
                142.5456196,
                -176.889036,
                117.6407886,
                58.46937127,
                -160.8453595,
                -9.36647757,
                20.43978216,
                176.3419377,
                -104.6855556,
                88.21002152,
                175.0458431,
                -162.2179733,
                -152.0950944,
                26.49581642,
                140.6927402,
                20.75246288,
                95.70676983,
                -79.34616741,
                -41.3866562,
                83.77119598,
                -95.6840817,
                -54.87966517,
                -130.3252831,
                -160.1075705,
                116.5387154,
                -149.0939797,
                -158.2996112,
                148.6944615,
                45.12536158,
                110.9241187,
                40.3144458,
                54.42129689,
                2.97485859,
                20.98433565,
                67.16321802,
                174.3721029,
                32.33240737,
                76.5291946
        };
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMaxZoomLevel = 10;
//        mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
        new CountDownTimer(100 * 13000, 13000) {

            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onTick(long millisUntilFinished) {
                long startTime = System.nanoTime();
//                CustomUrlTileProvider mTileProvider = new CustomUrlTileProvider(
//                        tile_width,
//                        tile_height,
//                        MOON_MAP_URL_FORMAT);
//                mMap.addTileOverlay(new TileOverlayOptions()
//                        .tileProvider(mTileProvider)
//                        .zIndex(-1));

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                        9.5907299,
                        76.5291946),
//                                lat[latLongCount],
//                                lng[latLongCount]),
                        14));
                mMap.addMarker(new MarkerOptions().position(new LatLng(
                        9.5907299,
                        76.5291946)));
                latLongCount++;

                long endTime = System.nanoTime();
                long totalTime = (endTime - startTime) / 1000000;
                System.out.println("API call time: " + (df.format(totalTime)));
                mMap.clear();
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    private void getLocations() {
//        for (int latLongCount = 1; latLongCount < lat.length; latLongCount++) {
        // final int finalI = latLongCount;
        new CountDownTimer(10 * 10000, 10000) {

            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onTick(long millisUntilFinished) {

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                                lat[latLongCount],
                                lng[latLongCount]),
                        14));
                mMap.addMarker(new MarkerOptions().position(new LatLng(
                        lat[latLongCount],
                        lng[latLongCount])));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(
                        lat[latLongCount],
                        lng[latLongCount])));
                latLongCount++;
            }

            @Override
            public void onFinish() {

            }
        }.start();

//        }
    }
}