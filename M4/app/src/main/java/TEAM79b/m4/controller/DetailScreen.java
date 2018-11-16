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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);


        Intent intent = getIntent();
        String key = intent.getStringExtra("key");

        Location location = (Location) getIntent().getSerializableExtra("locationObj");

        TextView detailName = (TextView) findViewById(R.id.detailName);
        detailName.setText(key);
        TextView detailLat = (TextView) findViewById(R.id.detailLat);
        String dLat = "Latitude: " + location.getLatitude();
        detailLat.setText(dLat);
        TextView detailLon = (TextView) findViewById(R.id.detailLon);
        String dLon = "Longitude: " + location.getLongitude();
        detailLon.setText(dLon);
        TextView detailAdd1 = (TextView) findViewById(R.id.detailAdd1);
        detailAdd1.setText(location.getAddress1());
        TextView detailAdd2 = findViewById(R.id.detailAdd2);
        String add2 = location.getCity() + ", " + location.getState() + " "
                + location.getZip();
        detailAdd2.setText(add2);
        TextView detailType = findViewById(R.id.detailType);
        String address2 = location.getCity() + ", " + location.getState() + " " + location.getZip();
        detailAdd2.setText(address2);
        detailType.setText(location.getType());
        TextView detailPhone = (TextView) findViewById(R.id.detailPhone);
        detailPhone.setText(location.getPhoneNum());
        TextView detailWeb = (TextView) findViewById(R.id.detailWeb);
        detailWeb.setText(location.getUrl());

        goToList();
        goToItemList();
    }

    /**
     * goes back to the list of locations
     */
    private void goToList() {
        Button backToList = (Button) findViewById(R.id.backToList);
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
        Button goItemList = (Button) findViewById(R.id.goItemList);
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
