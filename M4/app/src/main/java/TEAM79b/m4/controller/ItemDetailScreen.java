package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Item;
import TEAM79b.m4.model.Location;

public class ItemDetailScreen extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail_screen);

        Item item = (Item) getIntent().getSerializableExtra("itemObj");

        goToItemList();
    }

    private void goToItemList() {
        Button backToItemList = (Button) findViewById(R.id.backToItemList);
        backToItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Location location = (Location)  getIntent().getSerializableExtra("locationObj");
                Intent intent = new Intent(ItemDetailScreen.this, ItemListScreen.class);
                intent.putExtra("LocationObj", location);
                startActivity(intent);
            }
        });
    }
}
