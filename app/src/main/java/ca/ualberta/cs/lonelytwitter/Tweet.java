package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sydia on 1/19/17.
 */

public abstract class Tweet implements Tweetable{
    private Date date;
    private String message;
    private ArrayList<Mood> MoodList = new ArrayList<Mood>();

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }
    // Class Constructor
    public Tweet(Date date, String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Mood mood) {
        this.message = message;
        this.date = new Date();
        this.MoodList.add(mood);
    }

    // Another constructor
    public Tweet(Date date, String message, Mood mood){
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

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140){
            throw new TweetTooLongException();
        }

        this.message = message;
    }

    public ArrayList<Mood> getMoodList() {
        return MoodList;
    }

    public void setMoodList(ArrayList<Mood> moodList) {
        MoodList = moodList;
    }

    // Adds mood to list
    public void addMood(Mood mood) {
        this.MoodList.add(mood);
    }

    public abstract Boolean isImportant();

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}
