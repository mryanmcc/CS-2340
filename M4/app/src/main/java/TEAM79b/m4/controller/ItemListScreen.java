package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.List;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Item;
import TEAM79b.m4.model.Location;
import TEAM79b.m4.model.LocationContainer;

/**
 * screen that shows the list of items for a location
 */
public class ItemListScreen extends AppCompatActivity implements Serializable {

    private ListView listView;
    private ArrayAdapter adapter;
    LocationContainer locContainer = LocationContainer.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list_screen);
        final List<Item> values;

        Location location = (Location) getIntent().getSerializableExtra("locationObj");
        Log.d("HELPOUTm", Integer.toString(locContainer.getLocationMap().size()));
        values = locContainer.getLocationMap().get(location);
        Log.d("chica", locContainer.getLocationMap().toString());
        final String[] itemValues = new String[values.size()];
        for (int i = 0; i < values.size(); i++) {
            itemValues[i] = values.get(i).getShortDesc();
        }
        listView = findViewById(R.id.itemListView);
        adapter = new ArrayAdapter(ItemListScreen.this,
                android.R.layout.simple_list_item_1, itemValues);
        listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Location location = (Location) getIntent().getSerializableExtra("locationObj");
                    Item tempValues = values.get(position);
                    Intent intent = new Intent(ItemListScreen.this, ItemDetailScreen.class);
                    intent.putExtra("itemObj", tempValues);
                    intent.putExtra("locationObj", location);
                    startActivity(intent);
                }
            });
        //}

        goToNewItem();
        goToLocation();
    }

    /**
     * goes to item entry screen to add new item
     */
    private void goToNewItem() {
        final Location location = (Location) getIntent().getSerializableExtra("locationObj");
        Button goAddItem = findViewById(R.id.goAddItem);
        goAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemListScreen.this, ItemEntryScreen.class);
                intent.putExtra("locationObj", location);
                startActivity(intent);
            }
        });
    }

    /**
     * goes back to screen with all locations
     */
    private void goToLocation() {
        final Location location = (Location) getIntent().getSerializableExtra("locationObj");
        Button backToLoc = findViewById(R.id.backToLoc);
        backToLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemListScreen.this, DetailScreen.class);
                intent.putExtra("locationObj", location);
                startActivity(intent);
            }
        });
    }
}
