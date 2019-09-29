package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.example.assignment_1.MainActivity.index;
import static com.example.assignment_1.MainActivity.rides;

public class ride_adding_activity extends AppCompatActivity implements View.OnClickListener{

    public boolean button_clicked = false;
    boolean edited = false;
    public String date_str,time_str,name_str,distance, speed, cadence, comments;
    EditText date_input, time_input,name_input,speed_input, distance_input;
    private OnRideAddingInteractionListener listener;

    Button button;
    public interface OnRideAddingInteractionListener{
        void addingRide(ride newRide);
        void editingRide(ride newRide);
    }


    public boolean isButton_clicked() {
        return button_clicked;
    }
    public void setButton_clicked(Boolean button_clicked){
        this.button_clicked = button_clicked;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_adding_activity);
        // Get the Intent that started this activity and extract the string
        final Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);


        // Capture the layout's TextView and set the string as its text
        TextView main_view = findViewById(R.id.textView1);
        TextView time_inst = findViewById(R.id.time_inst);
        // testing the message and hard code out
        time_inst.setText("Now here");
        main_view.setText(message);

        //sending activity to main after button is pushed every view by ID is here
        button = (Button) findViewById(R.id.button);
        date_input = (EditText) findViewById(R.id.date);
        time_input = findViewById(R.id.time);
        button.setOnClickListener(this);

        if (index != -1 ){
            date_input.setText(rides.get(index).getDate());
            edited = true;
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button){
            button_clicked = true;
            Intent intent1 = new Intent(ride_adding_activity.this, MainActivity.class);
            String time = time_input.getText().toString();
            String date = date_input.getText().toString();
            if (edited){
                rides.remove(index);
            }
            index = -1;
            MainActivity.rides.add(new ride(date, time,1.1));
            System.out.println("Before  <ain Date: " + rides.get(rides.size()-1).getDate());
            System.out.println("test");
            finish();
//            startActivity(intent1);
        }


    }
}
