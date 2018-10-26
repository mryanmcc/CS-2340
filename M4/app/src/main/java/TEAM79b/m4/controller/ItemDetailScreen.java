package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import TEAM79b.m4.R;

public class ItemDetailScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail_screen);

        goToItemList();
    }

    private void goToItemList() {
        Button backToItemList = (Button) findViewById(R.id.backToItemList);
        backToItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ItemDetailScreen.this, ItemListScreen.class));
            }
        });
    }
}
