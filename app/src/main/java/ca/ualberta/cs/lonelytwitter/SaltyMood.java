package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by sydia on 1/19/17.
 */

public class SaltyMood extends Mood {

    private String newMood =  "I hate this world!";

    public SaltyMood(Date date, String mood) {
        super(date, mood);
        setMood(newMood);
    }

    @Override
    public String getMoodFormatString(){

        return newMood;
    }


}
