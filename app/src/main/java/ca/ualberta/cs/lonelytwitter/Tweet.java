

/*
 * Tweet
 *
 * Version 1.0
 *
 * January 30, 2018
 *
 * Copyright © 2018 Team X. CMPUT301. University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise please contact fc1@ualberta.ca
 *
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


/**
 * Represents a tweet
 *
 * @author fc1
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 */
public abstract class Tweet implements Tweetable {
    /*instance variables*/
    private String message;
    private Date date;

    /**
     * Construct a tweet object
     *
     * @param message tweet message
     */
    /*constructors*/
    Tweet(String message) {
        this.message = message;
        date = new Date();

    }

    /**
     * Constructs a tweet object
     *
     * @param message tweet message
     * @param date tweet date
     */
    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    /*methods */

    /**
     * Get the message
     *
     * @return message of the tweet
     */
    public String getMessage(){
        return message;
    }

    /**
     * Sets tweet message.
     *
     * @param message tweet message
     * @throws TweetToolLongException the tweet message is over 140 characters
     */
    public void setMessage(String message) throws TweetToolLongException{
        if (message.length() < 140) {
            this.message = message;
        }
        else{
            throw new TweetToolLongException();

        }

    }

    /**
     * Get the date of the tweet
     *
     * @return date of the tweet
     */
    public Date getDate(){
        return date;

    }

    /**
     * Sets the date of the tweet
     *
     * @param date tweet date
     */
    public void setDate(Date date){
        this.date = date;
    }

    /**
     * Checks if the tweet is important
     *
     * @return boolean indicting if the tweet is important or not
     */
    public abstract Boolean isImportant();

    /**
     * Converts parameters of the tweet to string
     *
     * @return date and message of the tweet
     */
    public String toString(){
        return date.toString() + " | " + message;
    }
}

