package com.example.assignment_1;

public class ride_class_checker {
    String name, time;
    double distance, speed;
    int cadence;

    public ride_class_checker(String time, double distance, double speed) {
        this.time = time;
        this.distance = distance;
        this.speed = speed;
    }

    public ride_class_checker(String name, String time, double distance, double speed, int cadence) {
        this.cadence = cadence;
        this.distance = distance;
        this.speed = speed;
        this.time = time;

    }



}
