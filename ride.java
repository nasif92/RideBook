package com.example.assignment_1;

public class ride {
    String date;
    String time;
    double distance,speed;
    int cadence;
    String comments;
    String name;

    ride(String time) {
        this("", time,0.0,0.0,0,"");

    }
    ride(String name, Double distance){
        this.name = name;
        this.distance = distance;
    }
    ride(String date, String time, double distance){
        this.date = date;
        this.time = time;
        this.distance = distance;

    }

    ride(String name, String time, double distance, double speed, int cadence, String comments){
        this.name = name;
        this.time = time;
        this.distance = distance;
        this.speed = speed;
        this.cadence = cadence;
        this.comments = comments;
    }
    ride(){
        this.name = getName();
        this.comments = getComments();
        this.cadence = getCadence();
        this.speed = getSpeed();
        this.distance = getDistance();
        this.date = getDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getCadence() {
        return cadence;
    }

    public void setCadence(int cadence) {
        this.cadence = cadence;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
