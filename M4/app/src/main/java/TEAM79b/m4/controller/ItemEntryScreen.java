package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.List;

import TEAM79b.m4.R;
import TEAM79b.m4.model.Item;
import TEAM79b.m4.model.Location;
import TEAM79b.m4.model.LocationContainer;

/**
 * screen that allows the user to add a new item to a location
 */
public class ItemEntryScreen extends AppCompatActivity implements Serializable {

    private EditText itemSDesc;
    private EditText itemLDesc;
    private EditText itemVal;
    private EditText itemCat;
    private EditText itemTime;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_entry_screen);

        itemSDesc = (EditText) findViewById(R.id.itemSDesc);
        itemLDesc = (EditText) findViewById(R.id.itemLDesc);
        itemVal = (EditText) findViewById(R.id.itemVal);
        itemCat = (EditText) findViewById(R.id.itemCat);
        itemTime = (EditText) findViewById(R.id.itemTime);

        goToItemList();
    }

    /**
     * adds new item to a location
     * @param view screen passed in
     */
    public void addNewItem(View view) {
        LocationContainer locContainer = LocationContainer.getInstance();
        Location location = (Location) getIntent().getSerializableExtra("locationObj");
        Item item = new Item(itemTime.getText().toString(), location, itemSDesc.getText().toString()
                , itemLDesc.getText().toString(), Float.parseFloat(itemVal.getText().toString()), itemCat.getText().toString());
        locContainer.getLocationMap().get(location).add(item);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Log.d("blah", user.getEmail());
        String userID = user.getEmail();
        String[] userIDArr = userID.split("\\.");
        userID = userIDArr[0];
        mDatabase.child("users").child(userID).child("locations").child(location.toString()).setValue(location);
        List<Item> tempItemList = locContainer.getLocationMap().get(location);
        mDatabase.child("users").child(userID).child("locations").child(location.toString()).child("item_list").setValue(tempItemList);
        Intent intent = new Intent(ItemEntryScreen.this, ItemListScreen.class);
        intent.putExtra("locationObj", location);
        startActivity(intent);
    }

    /**
     * goes to item list screen
     */
    private void goToItemList() {
        Button goItemList = (Button) findViewById(R.id.goItemList);
        goItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Location location = (Location)  getIntent().getSerializableExtra("locationObj");
                Intent intent = new Intent(ItemEntryScreen.this, ItemListScreen.class);
                intent.putExtra("locationObj", location);
                startActivity(intent);
            }
        });
    }
}
