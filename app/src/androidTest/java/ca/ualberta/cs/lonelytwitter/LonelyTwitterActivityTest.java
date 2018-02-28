package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;


    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());

    }

    public void testAddingTweetToTheList(){
        solo.assertCurrentActivity("Wrong activity",LonelyTwitterActivity.class);
        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");

        solo.enterText((EditText) solo.getView(R.id.body), "");

        assertTrue(solo.searchText("Test Tweet!"));

        solo.clickOnButton("Clear");
        assertFalse(solo.searchText("Test Tweet!"));
    }

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }

}