package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "tweets.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("Lifecycle", "onCreate is called");
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);


		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();

				saveInFile();


			}
		});

        Button clearButton = (Button) findViewById(R.id.clear);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);


        clearButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);

                tweetList.clear();

                adapter.clear();

                saveInFile();


            }
        });
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i("Lifecycle", "onStart is called");

		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
                R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);

        //Tweet tweet = new Tweet("");
        NormalTweet normalTweet = new NormalTweet("");
        try {
            normalTweet.setMessage("Hello World!");
        }
        catch (TweetToolLongException e){
            Log.e("Error ---->", "Tweet message too long");

        }



	}

	private void loadFromFile() {

		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			// Taken from link
            // 2018-01-23
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	@Override
    protected void onDestroy(){
	    super.onDestroy();
	    Log.i("Lifecycle", "onDestroy is called");
    }
}