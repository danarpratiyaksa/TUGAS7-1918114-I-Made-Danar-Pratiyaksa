package com.example.tugas7_1918114;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<CasingHP> CasingHP;
    public CustomListAdapter(Activity activity, List<CasingHP>
            CasingHP) {
        this.activity = activity;
        this.CasingHP = CasingHP;
    }
    @Override
    public int getCount() {
        return CasingHP.size();
    }
    @Override
    public Object getItem(int location) {
        return CasingHP.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView nama_casing = (TextView)
                convertView.findViewById(R.id.text_nama_casing);
        TextView harga = (TextView)
                convertView.findViewById(R.id.text_harga);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        CasingHP m = CasingHP.get(position);
        nama_casing.setText("Nama Casing : "+ m.get_nama_casing());
        harga.setText("Harga : "+ m.get_harga());
        return convertView;
    }
}