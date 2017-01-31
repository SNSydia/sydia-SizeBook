package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by sydia on 1/19/17.
 */

public abstract class Mood {
    private Date date;

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    private String mood;
    // Constructor
    public Mood(Date date, String mood) {
        this.date = date;
        this.mood = mood;
    }

    // Default Constructor
    public Mood(){
        super();
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String CurrentMood(){
        return mood;
    }

    public abstract String getMoodFormatString();

}
