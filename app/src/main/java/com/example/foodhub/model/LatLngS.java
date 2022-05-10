package com.example.foodhub.model;

import com.google.android.gms.maps.model.LatLng;

public class LatLngS {
    private   double  lat;
    private  double lng;
    private  LatLng latLng;

    public LatLng getLatLng() {
         latLng = new LatLng(lat, lng);
        return latLng;

    }

    public LatLngS(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }


    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
