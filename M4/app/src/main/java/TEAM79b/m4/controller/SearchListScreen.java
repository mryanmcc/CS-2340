package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Item;
import TEAM79b.m4.model.Location;
import TEAM79b.m4.model.LocationContainer;

public class SearchListScreen extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private LocationContainer locContainer = LocationContainer.getInstance();
    private HashMap<Location, List<Item>> locationKeys = locContainer.getLocationMap();
    private List<Item> values = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list_screen);

        Set<Location> keys = locationKeys.keySet();
        final Location[] keyListTemp = keys.toArray(new Location[keys.size()]);

        final String locationName = getIntent().getStringExtra("locationName");
        final String itemName = getIntent().getStringExtra("itemName");
        final String catName = getIntent().getStringExtra("catName");
        final int mode = getIntent().getIntExtra("mode", 0);

        if (locationName.equals("All Locations")) {
            for (Location loc: keyListTemp) {
                values.addAll(locContainer.getLocationMap().get(loc));
            }
        } else {
            for (Location loc: keyListTemp) {
                if (loc.getName().equals(locationName)) {
                    values.addAll(locContainer.getLocationMap().get(loc));
                }
            }
        }
        final String[] itemValues = new String[values.size()];
        for (int i = 0; i < values.size(); i++) {
            if (mode == 0) {
                if (values.get(i).getShortDesc().equals(itemName)) {
                    itemValues[i] = values.get(i).getShortDesc();
                }
            } else {
                if (values.get(i).getCategory().equals(catName)) {
                    itemValues[i] = values.get(i).getShortDesc();
                }
            }
        }
        listView = findViewById(R.id.searchListView);
        adapter = new ArrayAdapter(SearchListScreen.this, android.R.layout.simple_list_item_1, itemValues);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Location location = (Location) getIntent().getSerializableExtra("locationObj");
                Item tempValues = values.get(position);
                Intent intent = new Intent(SearchListScreen.this, SearchDetailScreen.class);
                intent.putExtra("itemObj", tempValues);
                intent.putExtra("locationObj", location);
                intent.putExtra("locationName", locationName);
                intent.putExtra("itemName", itemName);
                intent.putExtra("catName", catName);
                intent.putExtra("mode", mode);
                startActivity(intent);
            }
        });
    }

    public void backToSearch(View view) {
        startActivity(new Intent(SearchListScreen.this, SearchScreen.class));
    }
}
