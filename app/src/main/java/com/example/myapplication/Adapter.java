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

//        ImageView imageView = convertView.findViewById(R.id.img);
        TextView textView = convertView.findViewById(R.id.tv);
        LinearLayout linearLayout = convertView.findViewById(R.id.lin);

        final Currency model = Database.getList().get(position);

        textView.setText(model.getCharCode());

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, model.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
