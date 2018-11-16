package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Item;
import TEAM79b.m4.model.Location;

/**
 * screen generated after an item search
 */
public class SearchDetailScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_detail_screen);

        Item item = (Item) getIntent().getSerializableExtra("itemObj");
        Location location = (Location) getIntent().getSerializableExtra("locationObj");

        TextView itemTimeStamp = findViewById(R.id.itemTimeStamp);
        itemTimeStamp.setText(item.getTimeStamp());
        TextView itemSDesc = findViewById(R.id.itemSDesc);
        itemSDesc.setText(item.getShortDesc());
        TextView itemLDesc = findViewById(R.id.itemLDesc);
        itemLDesc.setText(item.getLongDesc());
        TextView itemVal = findViewById(R.id.itemVal);
        itemVal.setText("$ " + item.getValue());
        TextView itemCat = findViewById(R.id.itemCat);
        itemCat.setText(item.getCategory());
        TextView itemLoc = findViewById(R.id.itemLoc);
        itemLoc.setText("Location: " + location.getName());
    }

    /**
     * goes back to the screen to search for items
     * @param view screen
     */
    public void backToList(View view) {
        String locationName = getIntent().getStringExtra("locationName");
        String itemName = getIntent().getStringExtra("itemName");
        String catName = getIntent().getStringExtra("catName");
        int mode = getIntent().getIntExtra("mode", 0);
        Intent intent = new Intent(SearchDetailScreen.this, SearchListScreen.class);
        intent.putExtra("locationName", locationName);
        intent.putExtra("itemName", itemName);
        intent.putExtra("catName", catName);
        intent.putExtra("mode", mode);
        startActivity(intent);
    }
}
