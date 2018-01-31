package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by fc1 on 1/16/18.
 */

/**
 * Represents an important tweet
 *
 * @author fc1
 * @version 1.0
 * @see Tweet
 *
 *
 */

public class ImportantTweet extends Tweet {

    /**
     * Constructs an important tweet
     *
     * @param message important tweet message
     */
    ImportantTweet(String message){

        super(message);
    }

    /**
     * Constructs an important tweet
     *
     * @param message important tweet message
     * @param date important tweet date
     */
    ImportantTweet(String message, Date date){

        super(message, date);
    }

    @Override
    /**
     * Represents a tweet is important
     *
     * @return TRUE
     */
    public Boolean isImportant() {

        return Boolean.TRUE;
    }

}
