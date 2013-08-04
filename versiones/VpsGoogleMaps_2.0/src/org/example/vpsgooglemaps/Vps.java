package org.example.vpsgooglemaps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Vps extends FragmentActivity 
	implements OnMapClickListener {
		   private final LatLng Upla = new LatLng(-33.021944, -71.641944);
		   private GoogleMap mapa;
		  
		   @Override protected void onCreate(Bundle savedInstanceState) {
		      super.onCreate(savedInstanceState);
		      setContentView(R.layout.activity_vps);
		      mapa = ((SupportMapFragment) getSupportFragmentManager()
		            .findFragmentById(R.id.map)).getMap();
		      mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		      mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(Upla, 15));
		      mapa.setMyLocationEnabled(true);
		      mapa.getUiSettings().setZoomControlsEnabled(false);
		      mapa.getUiSettings().setCompassEnabled(true);
		      mapa.addMarker(new MarkerOptions()
		            .position(Upla)
		            .title("Upla")
		            .snippet("Universidad de Playa Ancha")
		            .icon(BitmapDescriptorFactory
		                   .fromResource(R.drawable.ic_launcher))
		            .anchor(0.5f, 0.5f));
		      mapa.setOnMapClickListener(this);
		   }
		 
		   public void moveCamera(View view) {
		         mapa.moveCamera(CameraUpdateFactory.newLatLng(Upla));
		   }
		 
		   public void animateCamera(View view) {
		      if (mapa.getMyLocation() != null)
		         mapa.animateCamera(CameraUpdateFactory.newLatLngZoom(
		            new LatLng( mapa.getMyLocation().getLatitude(),                                                 mapa.getMyLocation().getLongitude()), 15));
		   }
		 
		   public void addMarker(View view) {
		      mapa.addMarker(new MarkerOptions().position(
		           new LatLng(mapa.getCameraPosition().target.latitude,
		      mapa.getCameraPosition().target.longitude)));

		   }
		 
		   @Override
		   public void onMapClick(LatLng puntoPulsado) {
		      mapa.addMarker(new MarkerOptions().position(puntoPulsado).
		         icon(BitmapDescriptorFactory
		            .defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
		   }
		}
