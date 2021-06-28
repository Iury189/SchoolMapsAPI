package com.example.testmaps;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap; // Componente GoogleMap para gerar a visualização do mapa
    Intent intent; // Componente Intent para descrição abstrata de uma operação a ser executadas

     // Método que serve para iniciar as operações de incialização
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtenha o SupportMapFragment e seja notificado quando o mapa estiver pronto para ser usado.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    // Método que inicia o mapa quando estiver pronto para ser utilizado
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Retorna o intent que inicia a atividade
        intent = getIntent(); 
        // Obtem os dados da intent
        String nome = intent.getExtras().getString("Nome");
        double latitude = intent.getExtras().getDouble("Latitude");
        double longitude = intent.getExtras().getDouble("Longitude");
        // Adicione um marcador nos lugares
        LatLng local = new LatLng(latitude,longitude);
        mMap.addMarker(new MarkerOptions().position(local).title(nome));
        // Podendo se movimentar no mapa
        mMap.moveCamera(CameraUpdateFactory.newLatLng(local));
    }
}
