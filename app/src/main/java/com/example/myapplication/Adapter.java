package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.myapplication.models.Currency;
//import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private Context context;

    public Adapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Database.getList().size();
    }

    @Override
    public Object getItem(int position) {
        return Database.getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_list, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.tv);

        final Currency model = Database.getList().get(position);

        textView.setText(model.getCharCode());

        return convertView;
    }
}
