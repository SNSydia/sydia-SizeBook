package ca.ualberta.cs.sizebook;

import java.util.Date;

/**
 * Created by sydia on 1/19/17.
 */

public class NormalTweet extends Tweet {
    public NormalTweet(String message) {
        super(message);
    }

    public NormalTweet(String message, Person mood) {
        super(message, mood);
    }

    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    @Override
    public Boolean isImportant() {
        return false;
    }
}
