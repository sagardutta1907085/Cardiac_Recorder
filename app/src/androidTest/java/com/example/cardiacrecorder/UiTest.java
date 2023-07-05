package com.example.cardiacrecorder;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.isDialog;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

import android.os.SystemClock;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
/**
 * UI_Test
 * This activity is for UI test
 */
public class UiTest {
    /**
     * Rule added
     */
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Check the Application Name
     */
//    @Test
//    public void checkAppName()
//    {
//        onView(withText("Cardiac Recorder")).check(matches(isDisplayed()));
//    }

    /**
     *Checking View Measurement List
     */
    @Test
    public void checkPrevList()
    {
        SystemClock.sleep(4000);
        Espresso.onView(withId(R.id.viewMmButton)).perform(click());
        SystemClock.sleep(4000);
    }

    /**
     * Add Measurement Functionality check
     */
    @Test
    public void AddMeasurementTest() {
        SystemClock.sleep(4000);
        Espresso.onView(withId(R.id.viewMmButton)).perform(click());
        SystemClock.sleep(4000);
        Espresso.pressBack();
        Espresso.onView(withId(R.id.AddMmButton)).perform(click());
        Espresso.onView(withId(R.id.editTextDateId)).perform(ViewActions.typeText("01-02-2019"));
        Espresso.onView(withId(R.id.editTextTimeId)).perform(ViewActions.typeText("22:00"));
        Espresso.onView(withId(R.id.editTextSysId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextSysId)).perform(ViewActions.typeText("126"));
        Espresso.onView(withId(R.id.editTextDiasId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextDiasId)).perform(ViewActions.typeText("62"));
        Espresso.onView(withId(R.id.editTextHrtId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextHrtId)).perform(ViewActions.typeText("52"));
        Espresso.onView(withId(R.id.addButtonId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.addButtonId)).perform(click());
        Espresso.pressBack();
        Espresso.pressBack();
        Espresso.onView(withId(R.id.viewMmButton)).perform(click());
        SystemClock.sleep(4000);
    }

    /**
     * Checking Update Measurement Functionality
     */
    @Test
    public void UpdateMeasurementTest()
    {
        SystemClock.sleep(4000);
        Espresso.onView(withId(R.id.viewMmButton)).perform(click());
        SystemClock.sleep(4000);
        onData(anything()).inAdapterView(withId(R.id.measureListViewId)).atPosition(0).
                perform(click());
        SystemClock.sleep(2000);
        Espresso.onView(withId(R.id.updateActivityButtonId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.updateActivityButtonId)).perform(click());
        Espresso.onView(withId(R.id.editTextSysUpdateId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextSysUpdateId)).perform(ViewActions.clearText());
        Espresso.onView(withId(R.id.editTextSysUpdateId)).perform(ViewActions.typeText("106"));
        Espresso.onView(withId(R.id.editTextCommentUpdateId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextCommentUpdateId)).perform(ViewActions.clearText());
        Espresso.onView(withId(R.id.editTextCommentUpdateId)).perform(ViewActions.typeText("Resting"));
        Espresso.onView(withId(R.id.updateButtonId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.updateButtonId)).perform(click());
        SystemClock.sleep(1000);
        onData(anything()).inAdapterView(withId(R.id.measureListViewId)).atPosition(0).
                perform(click());
        Espresso.onView(withId(R.id.cmntDetailsTextId)).perform(ViewActions.scrollTo());
        SystemClock.sleep(1000);
        Espresso.pressBack();
    }

    /**
     * Testing the deletion of a measurement
     */
    @Test
    public void DeleteMeasurementTest()
    {
        SystemClock.sleep(4000);
        Espresso.onView(withId(R.id.viewMmButton)).perform(click());
        SystemClock.sleep(4000);
        onData(anything()).inAdapterView(withId(R.id.measureListViewId)).atPosition(0).
                perform(longClick());
        Espresso.onView(withText("YES"))
                .inRoot(isDialog())
                .check(matches(isDisplayed()))
                .perform(click());
        SystemClock.sleep(2000);
    }

    @Test
    public void CompleteAppTest(){
        SystemClock.sleep(4000);
        Espresso.onView(withId(R.id.viewMmButton)).perform(click());
        SystemClock.sleep(4000);
        Espresso.pressBack();
        Espresso.onView(withId(R.id.AddMmButton)).perform(click());
        Espresso.onView(withId(R.id.editTextDateId)).perform(ViewActions.typeText("01-02-2019"));
        Espresso.onView(withId(R.id.editTextTimeId)).perform(ViewActions.typeText("22:00"));
        Espresso.onView(withId(R.id.editTextSysId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextSysId)).perform(ViewActions.typeText("126"));
        Espresso.onView(withId(R.id.editTextDiasId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextDiasId)).perform(ViewActions.typeText("62"));
        Espresso.onView(withId(R.id.editTextHrtId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextHrtId)).perform(ViewActions.typeText("52"));
        Espresso.onView(withId(R.id.addButtonId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.addButtonId)).perform(click());
        Espresso.pressBack();
        Espresso.pressBack();
        Espresso.onView(withId(R.id.viewMmButton)).perform(click());
        SystemClock.sleep(4000);


        onData(anything()).inAdapterView(withId(R.id.measureListViewId)).atPosition(0).
                perform(click());
        SystemClock.sleep(2000);
        Espresso.onView(withId(R.id.updateActivityButtonId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.updateActivityButtonId)).perform(click());
        Espresso.onView(withId(R.id.editTextSysUpdateId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextSysUpdateId)).perform(ViewActions.clearText());
        Espresso.onView(withId(R.id.editTextSysUpdateId)).perform(ViewActions.typeText("106"));
        Espresso.onView(withId(R.id.editTextCommentUpdateId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextCommentUpdateId)).perform(ViewActions.clearText());
        Espresso.onView(withId(R.id.editTextCommentUpdateId)).perform(ViewActions.typeText("Resting"));
        Espresso.onView(withId(R.id.updateButtonId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.updateButtonId)).perform(click());
        SystemClock.sleep(1000);
        onData(anything()).inAdapterView(withId(R.id.measureListViewId)).atPosition(0).
                perform(click());
        Espresso.onView(withId(R.id.cmntDetailsTextId)).perform(ViewActions.scrollTo());
        SystemClock.sleep(1000);
        Espresso.pressBack();

        Espresso.onView(withId(R.id.floatAddBtnId)).perform(click());
        Espresso.onView(withId(R.id.editTextDateId)).perform(ViewActions.typeText("02-02-2019"));
        Espresso.onView(withId(R.id.editTextTimeId)).perform(ViewActions.typeText("23:00"));
        Espresso.onView(withId(R.id.editTextSysId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextSysId)).perform(ViewActions.typeText("85"));
        Espresso.onView(withId(R.id.editTextDiasId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextDiasId)).perform(ViewActions.typeText("49"));
        Espresso.onView(withId(R.id.editTextHrtId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextHrtId)).perform(ViewActions.typeText("60"));
        Espresso.onView(withId(R.id.editTextCommentId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextCommentId)).perform(ViewActions.typeText("sitting"));
        Espresso.onView(withId(R.id.addButtonId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.addButtonId)).perform(click());
        Espresso.pressBack();
        Espresso.pressBack();
        SystemClock.sleep(2000);

        Espresso.onView(withId(R.id.floatAddBtnId)).perform(click());
        Espresso.onView(withId(R.id.editTextDateId)).perform(ViewActions.typeText("03-02-2019"));
        Espresso.onView(withId(R.id.editTextTimeId)).perform(ViewActions.typeText("19:30"));
        Espresso.onView(withId(R.id.editTextSysId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextSysId)).perform(ViewActions.typeText("97"));
        Espresso.onView(withId(R.id.editTextDiasId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextDiasId)).perform(ViewActions.typeText("63"));
        Espresso.onView(withId(R.id.editTextHrtId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextHrtId)).perform(ViewActions.typeText("52"));
        Espresso.onView(withId(R.id.editTextCommentId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.editTextCommentId)).perform(ViewActions.typeText("laying"));
        Espresso.onView(withId(R.id.addButtonId)).perform(ViewActions.scrollTo());
        Espresso.onView(withId(R.id.addButtonId)).perform(click());
        Espresso.pressBack();
        Espresso.pressBack();
        SystemClock.sleep(2000);

        onData(anything()).inAdapterView(withId(R.id.measureListViewId)).atPosition(1).
                perform(longClick());
        Espresso.onView(withText("YES"))
                .inRoot(isDialog())
                .check(matches(isDisplayed()))
                .perform(click());

        SystemClock.sleep(2000);
        Espresso.pressBack();
        Espresso.pressBack();
        Espresso.pressBack();
        Espresso.pressBack();
        Espresso.pressBack();
        Espresso.onView(withText("YES"))
                .inRoot(isDialog())
                .check(matches(isDisplayed()))
                .perform(click());
    }
}
