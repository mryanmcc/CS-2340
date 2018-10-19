package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Location;

public class detailScreen extends AppCompatActivity {

    private HashMap model = Location.getLocationMap();
    private List<String> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        values = (List<String>) model.get(key);

        TextView detailName = (TextView) findViewById(R.id.detailName);
        detailName.setText(key);
        TextView detailLat = (TextView) findViewById(R.id.detailLat);
        detailLat.setText("Latitude: " + values.get(0));
        TextView detailLon = (TextView) findViewById(R.id.detailLon);
        detailLon.setText("Longitude: " + values.get(1));
        TextView detailAdd1 = (TextView) findViewById(R.id.detailAdd1);
        detailAdd1.setText(values.get(2));
        TextView detailAdd2 = (TextView) findViewById(R.id.detailAdd2);
        detailAdd2.setText(values.get(3) + ", " + values.get(4) + " " + values.get(5));
        TextView detailType = (TextView) findViewById(R.id.detailType);
        detailType.setText(values.get(6));
        TextView detailPhone = (TextView) findViewById(R.id.detailPhone);
        detailPhone.setText(values.get(7));
        TextView detailWeb = (TextView) findViewById(R.id.detailWeb);
        detailWeb.setText(values.get(8));

        goToList();
    }

    private void goToList() {
        Button backToList = (Button) findViewById(R.id.backToList);
        backToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(detailScreen.this, locList.class));
            }
        });
    }
}
