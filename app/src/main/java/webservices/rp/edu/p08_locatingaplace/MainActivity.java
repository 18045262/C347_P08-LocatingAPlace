package webservices.rp.edu.p08_locatingaplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback(){
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                }

            }
        });


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null){
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);


                    LatLng poi_CausewayPoint = new LatLng(1.436065, 103.786263);
                    Marker cp = map.addMarker(new
                            MarkerOptions()
                            .position(poi_CausewayPoint)
                            .title("Causeway Point")
                            .snippet("Shopping after class")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng poi_RP = new LatLng(1.44224, 103.785733);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_CausewayPoint,
                            15));

                    Marker North = map.addMarker(new
                            MarkerOptions()
                            .position(poi_RP)
                            .title("North - HQ")
                            .snippet(
                                    "Block 333, Admiralty Ave 3, 765654\n" +
                                    "Operating hours: 10am-5pm\n" +
                                    "Tel:65433456\n")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null){
                    map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);


                    LatLng poi_CausewayPoint = new LatLng(1.436065, 103.786263);
                    Marker cp = map.addMarker(new
                            MarkerOptions()
                            .position(poi_CausewayPoint)
                            .title("Causeway Point")
                            .snippet("Shopping after class")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng poi_RP = new LatLng(1.44224, 103.785733);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_CausewayPoint,
                            15));

                    Marker North = map.addMarker(new
                            MarkerOptions()
                            .position(poi_RP)
                            .title("Central")
                            .snippet(
                                    "Block 3A, Orchard Ave 3, 134542 \n" +
                                    "Operating hours: 11am-8pm\n" +
                                    "Tel:67788652\n")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null){
                    map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

                    LatLng poi_CausewayPoint = new LatLng(1.436065, 103.786263);
                    Marker cp = map.addMarker(new
                            MarkerOptions()
                            .position(poi_CausewayPoint)
                            .title("Causeway Point")
                            .snippet("Shopping after class")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                    LatLng poi_RP = new LatLng(1.44224, 103.785733);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_CausewayPoint,
                            15));

                    Marker North = map.addMarker(new
                            MarkerOptions()
                            .position(poi_RP)
                            .title("East")
                            .snippet(
                                    "Block 555, Tampines Ave 3, 287788 \n" +
                                    "Operating hours: 9am-5pm\n" +
                                    "Tel:66776677\n")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));


                }
            }
        });

    }
}



