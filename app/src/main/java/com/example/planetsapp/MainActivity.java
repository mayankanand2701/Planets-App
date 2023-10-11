package com.example.planetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetArrayList;
    private static MyCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adapter view
        listView=findViewById(R.id.listview);
        planetArrayList=new ArrayList<>();

        Planet planet1 = new Planet("Mercury","0 Moons",R.drawable.mercury);
        Planet planet2 = new Planet("Venus", "0 Moons", R.drawable.venus);
        Planet planet3 = new Planet("Earth","1 Moon",R.drawable.earth);
        Planet planet4 = new Planet("Mars", "2 Moons", R.drawable.mars);
        Planet planet5 = new Planet("Jupiter", "79 Moons", R.drawable.jupiter);
        Planet planet6 = new Planet("Saturn", "83 Moons", R.drawable.saturn);
        Planet planet7 = new Planet("Uranus", "27 Moons", R.drawable.uranus);
        Planet planet8 = new Planet("Neptune", "14 Moons", R.drawable.neptune);

        planetArrayList.add(planet1);
        planetArrayList.add(planet2);
        planetArrayList.add(planet3);
        planetArrayList.add(planet4);
        planetArrayList.add(planet5);
        planetArrayList.add(planet6);
        planetArrayList.add(planet7);
        planetArrayList.add(planet8);

        adapter=new MyCustomAdapter(planetArrayList,getApplicationContext());
        listView.setAdapter(adapter);

        // Handling Click Events
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=adapter.getItem(position).getPlanetName();
                if(name.equals("Mercury"))
                {
                    Intent i=new Intent(getApplicationContext(),MercuryActivity.class);
                    startActivity(i);
                }
                else if(name.equals("Venus"))
                {
                    Intent i=new Intent(getApplicationContext(),VenusActivity.class);
                    startActivity(i);
                }
                else if(name.equals("Earth"))
                {
                    Intent i=new Intent(getApplicationContext(),EarthActivity.class);
                    startActivity(i);
                }
                else if(name.equals("Mars"))
                {
                    Intent i=new Intent(getApplicationContext(),MarsActivity.class);
                    startActivity(i);
                }
                else if(name.equals("Jupiter"))
                {
                    Intent i=new Intent(getApplicationContext(),JupyterActivity.class);
                    startActivity(i);
                }
                else if(name.equals("Saturn"))
                {
                    Intent i=new Intent(getApplicationContext(),SaturnActivity.class);
                    startActivity(i);
                }
                else if(name.equals("Uranus"))
                {
                    Intent i=new Intent(getApplicationContext(),UranusActivity.class);
                    startActivity(i);
                }
                else if(name.equals("Neptune"))
                {
                    Intent i=new Intent(getApplicationContext(),NeptuneActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}