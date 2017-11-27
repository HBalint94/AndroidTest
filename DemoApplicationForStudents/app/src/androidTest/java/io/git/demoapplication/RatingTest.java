package io.git.demoapplication;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.student.application.demoapplication.R;
import io.student.application.demoapplication.RatingActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by Balint on 2017. 11. 26..
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RatingTest {

    @Rule
    public ActivityTestRule<RatingActivity> mActivityRule = new ActivityTestRule(RatingActivity.class);


    @Test
    public void CheckWelcomeTextTest() {
        onView(withText("Please tell us how much did you like to use the application:")).check(matches(isDisplayed()));
    }

    @Test
    public void PriceCalculationViaTextViewWithYENTest() {
        onView(withId(R.id.ratingBarStars)).perform(click());
        onView(withId(R.id.editTextComments)).perform(clearText(),typeText("Not bad ,but I've already seen some better app"));
        onView(withId(R.id.buttonRate)).perform(click());
        onView(withId(R.id.textViewActRating)).check(matches(withText("3.0")));
    }


}
