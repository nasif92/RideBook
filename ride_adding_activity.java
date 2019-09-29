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
import android.widget.Toast;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.example.assignment_1.MainActivity.index;
import static com.example.assignment_1.MainActivity.rides;

public class ride_adding_activity extends AppCompatActivity implements View.OnClickListener{

    public boolean button_clicked = false;
    boolean edited = false;
    EditText date_input, time_input,speed_input, distance_input,cadence_input,comments_input;
    public static int ride_counter;
    Button button;

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
        TextView time_inst = findViewById(R.id.time_inst);

        //sending activity to main after button is pushed every view by ID is here
        button = (Button) findViewById(R.id.button);
        date_input = (EditText) findViewById(R.id.date);
        time_input = findViewById(R.id.time);
        distance_input = findViewById(R.id.distance_text);
        speed_input = findViewById(R.id.average_speed);
        cadence_input = findViewById(R.id.cadence);
        comments_input = findViewById(R.id.comments);
        button.setOnClickListener(this);

        if (index != -1 ){
            date_input.setText(rides.get(index).getDate());
            distance_input.setText(String.valueOf(rides.get(index).getDistance()));
            time_input.setText(rides.get(index).getTime());
            speed_input.setText(String.valueOf(rides.get(index).getSpeed()));
            cadence_input.setText(rides.get(index).getTime());
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
            String distance = distance_input.getText().toString();
            if (distance.matches("")){
                System.out.println("test in ride");
                Toast.makeText(getApplicationContext(),"NO INPUT", Toast.LENGTH_SHORT).show();

            }
            else{
                if (edited){
                    System.out.println("Subtracting : "+rides.get(index).getDistance());
                    rides.remove(index);
                    MainActivity.rides_counter--;
                }

                MainActivity.rides_counter++;
                index = -1;
                MainActivity.rides.add(new ride(date, time,Double.valueOf(distance)));
                finish();
            }
        }
    }
}
