package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by fc1 on 2/13/18.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2{

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){

        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        if (tweets.hasTweet(tweet)){
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));

    }

    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
        assertTrue(Boolean.TRUE);
    }

    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");

        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
        assertEquals(returnedTweet.getDate(), tweet.getDate());

    }


    public void testDeleteTweet(){

        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");

        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testGetCount(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");
        assertEquals(0, tweets.getCount());
        tweets.add(tweet);
        assertEquals(1, tweets.getCount());

    }

    public void testGetTweets(){
        TweetList tweets = new TweetList();
        Tweet tweet1 = new NormalTweet("hello");
        tweets.add(tweet1);
        Tweet tweet2 = new NormalTweet("tweet2");
        tweets.add(tweet2);


    }

}
