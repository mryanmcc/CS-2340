package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Item;
import TEAM79b.m4.model.Location;

/**
 * contains details for items when they are selected
 */
public class ItemDetailScreen extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail_screen);

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

        goToItemList();
    }

    /**
     * goes back to the item list screen
     */
    private void goToItemList() {
        Button backToItemList = findViewById(R.id.backToItemList);
        backToItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Location location = (Location)  getIntent().getSerializableExtra("locationObj");
                Intent intent = new Intent(ItemDetailScreen.this, ItemListScreen.class);
                intent.putExtra("locationObj", location);
                startActivity(intent);
            }
        });
    }
}
