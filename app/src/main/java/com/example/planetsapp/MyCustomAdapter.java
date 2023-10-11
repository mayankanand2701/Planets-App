package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    // Using custom layouts
    // Using custom adapter
    private ArrayList<Planet> planetArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Planet> planetArrayList, Context context) {
        super(context,R.layout.item_list_layout,planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    // view holder class
    private static class MyViewHolder{
        TextView planetname;
        TextView mooncount;
        ImageView imageView;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the planet object form the current positon
        Planet planets=getItem(position);
        // Inflate layout
        MyViewHolder myViewHolder;
        final View result;

        if(convertView==null)
        {
            myViewHolder=new MyViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );
            // Finding views
            myViewHolder.planetname=(TextView) convertView.findViewById(R.id.planetname);
            myViewHolder.mooncount=(TextView) convertView.findViewById(R.id.mooncount);
            myViewHolder.imageView=(ImageView) convertView.findViewById(R.id.iamgeview);

            result=convertView;
            convertView.setTag(myViewHolder);
        }
        else {
            // the view is recycled
            myViewHolder=(MyViewHolder) convertView.getTag();
            result=convertView;
        }
        // Getting the data form teh model class
        myViewHolder.planetname.setText(planets.getPlanetName());
        myViewHolder.mooncount.setText(planets.getMoonCount());
        myViewHolder.imageView.setImageResource(planets.getPlanetImage());
        return result;
    }
}
