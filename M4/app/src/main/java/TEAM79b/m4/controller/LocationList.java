package TEAM79b.m4.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Location;
import TEAM79b.m4.model.LocationContainer;


public class LocationList extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter adapter;
    private HashMap locationKeys = LocationContainer.getLocationMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc_list);

        Set<Location> keys = locationKeys.keySet();
        final Location[] keyListTemp = keys.toArray(new Location[keys.size()]);
        final String[] keyList = new String[keys.size()];
        for (int i = 0; i < keyListTemp.length; i++) {
            keyList[i] = keyListTemp[i].getName();
        }
        listView = (ListView) findViewById(R.id.locListView);
        adapter = new ArrayAdapter(LocationList.this, android.R.layout.simple_list_item_1, keyList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String temp = keyList[position];
                Location temp2 = keyListTemp[position];
                Intent intent = new Intent(LocationList.this, detailScreen.class);
                intent.putExtra("key", temp);
                intent.putExtra("locationObj", temp2);
                startActivity(intent);
            }
        });

        goToApp();
    }

    private void goToApp() {
        Button backToApp = (Button) findViewById(R.id.backToApp);
        backToApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LocationList.this, AppScreen.class));
            }
        });
    }
}
