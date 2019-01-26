package com.example.kevinbui.listapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView myListView;//Reference to listview
    String[] items;
    String[] prices;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources(); // Reference to resources
        myListView = (ListView)findViewById(R.id.myListView);
        items = res.getStringArray(R.array.items); // List of strings for items
        prices = res.getStringArray(R.array.prices); // List of strings for prices
        descriptions = res.getStringArray(R.array.descriptions); // List of strings for descriptions

        // Itemadapater merge 3 files into layout file
        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descriptions); // Only referencing
        myListView.setAdapter(itemAdapter); // Use the reference
    }
}
