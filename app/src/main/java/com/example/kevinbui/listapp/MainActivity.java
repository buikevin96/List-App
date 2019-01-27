package com.example.kevinbui.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView myListView; // Reference to listview in layout file
    String[] items;
    String[] prices;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference to resources
        Resources res = getResources();
        myListView = (ListView)findViewById(R.id.myListView);// Initialize

        // Reference to  arrays
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        descriptions = res.getStringArray(R.array.descriptions);

        // To use new adapter, create reference to it
        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descriptions);
        myListView.setAdapter(itemAdapter);

        // Go from one screen to another screen or activity
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showDetailActivity = new Intent(getApplicationContext(), DetailActivity.class);
                // Send that activity the index of the item that got clicked
                showDetailActivity.putExtra("com.example.kevinbui.ITEM_INDEX", i);
                startActivity(showDetailActivity); // Switch the screen when we click the item

            }
        });
    }
}
