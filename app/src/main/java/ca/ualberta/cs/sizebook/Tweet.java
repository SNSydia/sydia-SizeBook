package ca.ualberta.cs.sizebook;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sydia on 1/19/17.
 */

public abstract class Tweet{
    private Date date;
    private String message;
    private ArrayList<Person> MoodList = new ArrayList<Person>();

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }
    // Class Constructor
    public Tweet(Date date, String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Person mood) {
        this.message = message;
        this.date = new Date();
        this.MoodList.add(mood);
    }

    // Another constructor
    public Tweet(Date date, String message, Person mood){
        this.message = message;
        this.date = date;
        this.MoodList.add(mood);
    }
    // DEFAULT CONSTRUCTOR //Takes no arguments
    public Tweet(){
        super();
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message){

        this.message = message;
    }

    public ArrayList<Person> getMoodList() {
        return MoodList;
    }

    public void setMoodList(ArrayList<Person> moodList) {
        MoodList = moodList;
    }

    // Adds mood to list
    public void addMood(Person mood) {
        this.MoodList.add(mood);
    }

    public abstract Boolean isImportant();

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}