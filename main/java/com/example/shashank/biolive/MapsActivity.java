package com.example.shashank.biolive;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.fingerprint.FingerprintManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public LatLng bmsit = new LatLng(13.133857, 77.567560);

    LocationManager locationManager;
    private TextView mHeadingLabel;
    private ImageView mFingerprintLabel;
    private TextView mParaLabel;
    private FingerprintManager fingerprintManager;
    private KeyguardManager keyguardManager;
    public float[] dist = new float[1];
    Boolean mLocationMask;
    public Context context;

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        mMap.addMarker(new MarkerOptions().position(bmsit).title("BMSIT"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bmsit, 16.0f));


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
                @Override
                public void onLocationChanged(Location location) {

                    if (!location.isFromMockProvider())
                    {
                        double latitude = location.getLatitude();
                        double longitude = location.getLongitude();
                        final LatLng latLng = new LatLng(latitude, longitude);
                        Geocoder geocoder = new Geocoder(getApplicationContext());
                        try {
                            List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                            String str = addressList.get(0).getLocality() + ",";
                            str += addressList.get(0).getCountryName();
                            mMap.addMarker(new MarkerOptions().position(latLng).title(str));
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));
                                }
                            }, 3000);


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Location.distanceBetween(13.133857, 77.567560, latitude, longitude, dist);
                        mHeadingLabel = (TextView) findViewById(R.id.headingLabel);
                        mFingerprintLabel = (ImageView) findViewById(R.id.fingerprintImage);
                        mParaLabel = (TextView) findViewById(R.id.paraLabel);
                        if (dist[0] < 110) {

                            mMap.addCircle(new CircleOptions()
                                    .center(bmsit)
                                    .radius(110.0)
                                    .strokeWidth(3f)
                                    .strokeColor(Color.BLACK)
                                    .fillColor(Color.argb(50, 0, 250, 0))

                            );

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                                fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
                                keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);

                                if (!fingerprintManager.isHardwareDetected()) {
                                    mParaLabel.setText("Fingerprint Scanner Not Detected");
                                } else if (ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
                                    mParaLabel.setText("Permission Not Granted To use Fingerprint Scanner");

                                } else if (!keyguardManager.isKeyguardSecure()) {
                                    mParaLabel.setText("Add Lock To Your Phone In Settings");

                                } else if (!fingerprintManager.hasEnrolledFingerprints()) {
                                    mParaLabel.setText("You Should Have At Least One Fingerprint In Your Device");

                                } else {
                                    mParaLabel.setText("Place Your Finger On The Scanner To Continue");

                                    FingerprintHandler fingerprintHandler = new FingerprintHandler(MapsActivity.this);
                                    fingerprintHandler.startAuth(fingerprintManager, null);


                                }

                            }
                        } else {
                            mMap.addCircle(new CircleOptions()
                                    .center(bmsit)
                                    .radius(110.0)
                                    .strokeWidth(3f)
                                    .strokeColor(Color.BLACK)
                                    .fillColor(Color.argb(50, 250, 0, 0))

                            );
                            mParaLabel.setText("Be Within Range Of Your College");
                        }
                    }else {
                        mParaLabel.setText("GPS Unable To Locate Location");
                    }
                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
            });
        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
                @Override
                public void onLocationChanged(Location location) {

                    if (!location.isFromMockProvider())
                    {


                        double latitude = location.getLatitude();
                        double longitude = location.getLongitude();
                        final LatLng latLng = new LatLng(latitude, longitude);
                        Geocoder geocoder = new Geocoder(getApplicationContext());
                        try {
                            List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
                            String str = addressList.get(0).getLocality() + ",";
                            str += addressList.get(0).getCountryName();
                            mMap.addMarker(new MarkerOptions().position(latLng).title(str));
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));
                                }
                            }, 3000);


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Location.distanceBetween(13.133857, 77.567560, latitude, longitude, dist);
                        mHeadingLabel = (TextView) findViewById(R.id.headingLabel);
                        mFingerprintLabel = (ImageView) findViewById(R.id.fingerprintImage);
                        mParaLabel = (TextView) findViewById(R.id.paraLabel);
                        if (dist[0] < 110) {

                            mMap.addCircle(new CircleOptions()
                                    .center(bmsit)
                                    .radius(110.0)
                                    .strokeWidth(3f)
                                    .strokeColor(Color.BLACK)
                                    .fillColor(Color.argb(50, 0, 250, 0))

                            );


                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                                fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
                                keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);

                                if (!fingerprintManager.isHardwareDetected()) {
                                    mParaLabel.setText("Fingerprint Scanner Not Detected");
                                } else if (ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED) {
                                    mParaLabel.setText("Permission Not Granted To use Fingerprint Scanner");

                                } else if (!keyguardManager.isKeyguardSecure()) {
                                    mParaLabel.setText("Add Lock To Your Phone In Settings");

                                } else if (!fingerprintManager.hasEnrolledFingerprints()) {
                                    mParaLabel.setText("You Should Have At Least One Fingerprint In Your Device");

                                } else {
                                    mParaLabel.setText("Place Your Finger On The Scanner To Continue");


                                }

                            }
                        } else {
                            mMap.addCircle(new CircleOptions()
                                    .center(bmsit)
                                    .radius(110.0)
                                    .strokeWidth(3f)
                                    .strokeColor(Color.BLACK)
                                    .fillColor(Color.argb(50, 250, 0, 0))

                            );
                            mParaLabel.setText("Be Within Range Of Your College");
                        }
                    }else {
                        mParaLabel.setText("GPS Unable To Locate Location");
                    }
                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
            });
        }

    }

}


