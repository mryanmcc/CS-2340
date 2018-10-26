package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Item;
import TEAM79b.m4.model.Location;
import TEAM79b.m4.model.LocationContainer;

public class ItemListScreen extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter adapter;
    private HashMap<Location, List<Item>> locMap = LocationContainer.getLocationMap();
    private List<Item> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list_screen);

        Location location = (Location) getIntent().getSerializableExtra("LocationObj");
        values = (List<Item>) locMap.get(location);
        final String[] itemValues = new String[values.size()];
        for (int i = 0; i < values.size(); i++) {
            itemValues[i] = values.get(i).getShortDesc();
        }
        listView = (ListView) findViewById(R.id.itemListView);
        adapter = new ArrayAdapter(ItemListScreen.this, android.R.layout.simple_list_item_1, itemValues);
        listView.setAdapter(adapter);
        if (values.size() > 0) {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Item temp = values.get(position);
                    Intent intent = new Intent(ItemListScreen.this, ItemDetailScreen.class);
                    intent.putExtra("itemObj", (Serializable) temp);
                    startActivity(intent);
                }
            });
        }

        goToNewItem();
        goToLocation();
    }

    private void goToNewItem() {
        final Location location = (Location) getIntent().getSerializableExtra("LocationObj");
        Button goAddItem = (Button) findViewById(R.id.goAddItem);
        goAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ItemListScreen.this, ItemEntryScreen.class);
                intent.putExtra("locationObj", (Serializable) location);
                startActivity(intent);
            }
        });
    }

    private void goToLocation() {
        Button backToLoc = (Button) findViewById(R.id.backToLoc);
        backToLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ItemListScreen.this, detailScreen.class));
            }
        });
    }
}
