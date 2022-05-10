package com.example.foodhub.fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodhub.R;
import com.example.foodhub.model.LatLngS;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MapsFragment extends Fragment implements OnMapReadyCallback {

    LatLng place;
    GoogleMap googleMap;
    MapView mapView;
    CardView restaurantCard;
    ImageView imageView_location;
    final List<LatLngS> latLong = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 300);
        latLong.add(new LatLngS(29.992204123157748, 31.14198453598512));
        latLong.add(new LatLngS(29.991519049082264, 31.141350726691613));
        latLong.add(new LatLngS(29.991967582737498, 31.141347275620458));
        latLong.add(new LatLngS(29.99072894262765, 31.142129014008997));
        imageView_location = view.findViewById(R.id.location);
        restaurantCard = view.findViewById(R.id.restaurant_card);
        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
        imageView_location.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                googleMap.clear();
                getMyLocation();
                addMarker(latLong);

            }
        });
    }

    private void getMyLocation() {
        place = new LatLng(Double.parseDouble(String.valueOf(googleMap.getMyLocation().getLatitude())), Double.parseDouble(String.valueOf(googleMap.getMyLocation().getLongitude())));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(place, 16);
        googleMap.animateCamera(cameraUpdate);
        

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
//                googleMap.clear();
                restaurantCard.setVisibility(View.GONE);
                place = latLng;
                getLocation(latLng);


            }
        });


        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(@NonNull Marker marker) {
                String title = marker.getTitle();
                restaurantCard.setVisibility(View.VISIBLE);
                return true;
            }
        });


    }
    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }


    void addMarker(List<LatLngS> latLong) {

        for (LatLngS s : latLong) {

            googleMap.addMarker(new MarkerOptions().
                    position(s.getLatLng()).
                    title("Hospital")
            .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.ic_marker)));
        }
        googleMap.addCircle(new CircleOptions()
                .center(place)
                .radius(200)
                .strokeWidth(2)
                .strokeColor(Color.parseColor("#FE724C"))
                .fillColor(Color.parseColor("#12FE724C")));

    }

    void getLocation(LatLng latLng) {
        StringRequest request = new StringRequest(0, "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + latLng.latitude + ","
                + latLng.longitude + "&key=AIzaSyAZTJpSbPKLHSxIE6V96XxZqhcpSn-zzFM&language=en",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject js = new JSONObject(response);
                            JSONArray results = js.getJSONArray("results");
                            JSONObject place = results.getJSONObject(0);
                            String address = place.getString("formatted_address");


                        } catch (JSONException e) {

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);
    }
}
