package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements ride_adding_activity.OnRideAddingInteractionListener, View.OnClickListener{
    ListView ride_view;
    boolean ride_empty = true;
    public static ArrayList<ride> rides;
    public static ArrayAdapter<ride> ride_adapter;
    Button add_button, delete_button;
    static double total_distance;

    public static int index = -1;
    int edited_index;
    activity_tracker activity_tracker = new activity_tracker();
    boolean activity = activity_tracker.isFalse();
    String []date = {"2000", "2001", "2002", "Hamilton", "Denver", "Los Angeles","!212"};
    String []time = {"110", "123", "144", "55", "CO", "CA","ab"};
    String[] distance = {"1","2","3","4","5","6","7"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // the different views and array lists
        ride_view = findViewById(R.id.ride_content);
        rides =new ArrayList<>();
        add_button = (Button) findViewById(R.id.add_button);
        delete_button = (Button) findViewById(R.id.delete_button);

        add_button.setOnClickListener(this);
        delete_button.setOnClickListener(this);
        ride_adapter = new ride_array_adapter(rides,this);
        ride_view.setAdapter(ride_adapter);

        rides.add((new ride("Total Distance: ",total_distance)));

        ride_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                index = i;

            }
        });
        ride_view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ride_adding_activity.class);
                startActivity(intent);
                index = i;
                edited_index = -1;
                return false;
            }
        });


    }
    @Override
    public void onResume(){
        super.onResume();
        ride_adapter = new ride_array_adapter(rides,this);
        ride_view.setAdapter(ride_adapter);

        System.out.println("Date: " + rides.get(rides.size()-1).getDate());
    }
    @Override
    public void addingRide(ride newRide){
        System.out.println("Adding city bro");
        ride_adapter.add(newRide);

    }
    @Override
    public void editingRide(ride newRide){

    }

    public void onClick(View view) {
        if (view.getId() == R.id.add_button){

            Toast.makeText(this, "Cool!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ride_adding_activity.class);
            activity = activity_tracker.isTrue();
            startActivity(intent);
            ride_empty = false;

        }
        else if (view.getId() == R.id.delete_button){
            System.out.println("Testing deleteaaaa");

            Toast.makeText(this, "DELETING", Toast.LENGTH_SHORT).show();
            if ((!ride_empty) && (index !=-1)){
                rides.remove(index);
                ride_adapter.notifyDataSetChanged();
                System.out.println("Testing delete");
            }
            index = -1;
        }

/*
        ride a_ride = new ride("Sam");
        //a_ride.setDate(message);
        ride b_ride = new ride("Sam");
        a_ride.setDate(message);
        rides.add(a_ride);
        rides.add(b_ride);
*/
        // it's not showing as they are all objects


    }



}
