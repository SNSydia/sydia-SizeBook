package ca.ualberta.cs.sizebook;

/**
 * Created by sydia on 1/19/17.
 */

public interface Tweetable {
    public String getMessage();
    public void setMessage(String string) throws TweetTooLongException;

}
