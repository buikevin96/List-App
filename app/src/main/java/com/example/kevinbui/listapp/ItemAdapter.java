package com.example.kevinbui.listapp;

import android.content.Context;
import android.icu.text.AlphabeticIndex;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] items;
    String[] prices;
    String[] descriptions;

    // Constructor
    public ItemAdapter(Context c, String[] i, String[] p, String[] d){
        items = i;
        prices = p;
        descriptions = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    // How we're going to inflate view and put stuff in it
    @Override
    public View getView(int i, View View, ViewGroup viewGroup) {

        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        TextView nameTextView = (TextView)v.findViewById(R.id.nameTextView);
        TextView descriptionTextView = (TextView)v.findViewById(R.id.descriptionTextView);
        TextView priceTextView = (TextView)v.findViewById(R.id.priceTextView);

        // Retrieve info
        String name = items[i];
        String desc = descriptions[i];
        String cost = prices[i];

        // Put retrieved info into textview
        nameTextView.setText(name);
        descriptionTextView.setText(desc);
        priceTextView.setText(cost);

        return v;
    }
}

