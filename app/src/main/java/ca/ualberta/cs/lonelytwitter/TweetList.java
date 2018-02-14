package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

import ca.ualberta.cs.lonelytwitter.Tweet;

/**
 * Created by fc1 on 2/13/18.
 */

public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){
        tweets.add(tweet);

    }

    public boolean hasTweet(Tweet tweet){

        return tweets.contains(tweet);

    }

    public Tweet getTweet(int index){

        return tweets.get(index);

    }

    public void delete(Tweet tweet){

        tweets.remove(tweet);

    }

    public int getCount(){

        return tweets.size();

    }

}
