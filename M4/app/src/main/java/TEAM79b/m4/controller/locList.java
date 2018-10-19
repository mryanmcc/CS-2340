package TEAM79b.m4.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import TEAM79b.m4.R;

import static TEAM79b.m4.controller.WelcomeScreen.tokens;

public class locList extends AppCompatActivity {

    public ListView listView;
    public ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc_list);

        listView = (ListView) findViewById(R.id.locListView);
        adapter = new ArrayAdapter(locList.this, android.R.layout.simple_list_item_1, tokens);
        listView.setAdapter(adapter);

        goToApp();
    }

    private void goToApp() {
        Button backToApp = (Button) findViewById(R.id.backToApp);
        backToApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(locList.this, AppScreen.class));
            }
        });
    }
}
