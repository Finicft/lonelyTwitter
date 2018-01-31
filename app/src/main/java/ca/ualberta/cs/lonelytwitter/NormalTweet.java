package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


/**
 * Represents a normal tweet
 *
 * @author fc1
 * @version 1.0
 * @see Tweet
 */

public class NormalTweet extends Tweet {
    /**
     * Constructs a normal tweet
     *
     * @param message tweet message
     */
    NormalTweet(String message){
        super(message);
    }

    /**
     * Constructs a normal tweet
     *
     * @param message tweet message
     * @param date date message
     */
    NormalTweet(String message, Date date){
        super(message, date);
    }

    /**
     * Sets to False to indicate the tweet is normal
     *
     * @return False
     */
    @Override
    public Boolean isImportant(){

        return Boolean.FALSE;
    }
}
