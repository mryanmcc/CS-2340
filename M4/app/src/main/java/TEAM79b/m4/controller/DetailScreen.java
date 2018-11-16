package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Location;
import TEAM79b.m4.model.LocationContainer;

/**
 * location detail screen
 */
public class DetailScreen extends AppCompatActivity implements Serializable {
    private List<String> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);


        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        LocationContainer locContainer = LocationContainer.getInstance();

        Location location = (Location) getIntent().getSerializableExtra("locationObj");

        TextView detailName = findViewById(R.id.detailName);
        detailName.setText(key);
        TextView detailLat = findViewById(R.id.detailLat);
        detailLat.setText("Latitude: " + location.getLatitude());
        TextView detailLon = findViewById(R.id.detailLon);
        detailLon.setText("Longitude: " + location.getLongitude());
        TextView detailAdd1 = findViewById(R.id.detailAdd1);
        detailAdd1.setText(location.getAddress1());
        TextView detailAdd2 = findViewById(R.id.detailAdd2);
        detailAdd2.setText(location.getCity() + ", " + location.getState() + " " + location.getZip());
        TextView detailType = findViewById(R.id.detailType);
        detailType.setText(location.getType());
        TextView detailPhone = findViewById(R.id.detailPhone);
        detailPhone.setText(location.getPhoneNum());
        TextView detailWeb = findViewById(R.id.detailWeb);
        detailWeb.setText(location.getUrl());

        goToList();
        goToItemList();
    }

    /**
     * goes back to the list of locations
     */
    private void goToList() {
        Button backToList = findViewById(R.id.backToList);
        backToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailScreen.this, LocationListScreen.class));
            }
        });
    }

    /**
     * goes to the list of items
     */
    private void goToItemList() {
        final Location location = (Location) getIntent().getSerializableExtra("locationObj");
        Button goItemList = findViewById(R.id.goItemList);
        goItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailScreen.this, ItemListScreen.class);
                intent.putExtra("locationObj", location);
                startActivity(intent);
            }
        });
    }
}
