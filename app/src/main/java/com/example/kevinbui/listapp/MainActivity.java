package com.example.kevinbui.listapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Reference to listview in layout file
    ListView myListView;
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
        items = res.getStringArray(R.array.items);

        // Adapter to merge items together
        myListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_listview_detail, items));

    }
}
