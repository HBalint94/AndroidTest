package io.git.demoapplication;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import io.student.application.demoapplication.MainActivity;
import io.student.application.demoapplication.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CurrencyChangeTest {

	@Rule
	public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

	@Test
	public void CheckWelcomeTextTest() {
		onView(withText("Hello User!")).check(matches(isDisplayed()));
	}

	@Test
	public void PriceCalculationViaTextViewWithYENTest() {
		onView(withId(R.id.editTextValue)).perform(clearText(), typeText("500"));
		onView(withId(R.id.editTextValue)).perform(closeSoftKeyboard());
		onView(withId(R.id.currencySpinner)).perform(click());
		onData(allOf(is(instanceOf(String.class)),is("YEN"))).perform(click());
		onView(withId(R.id.currencySpinner)).check(matches(withSpinnerText(containsString("YEN"))));
		onView(withId(R.id.calculateButton)).perform(click());
		onView(withId(R.id.textViewResult)).check(matches(withText("1500 HUF")));
	}
	@Test
	public void PriceCalculationViaSeekBarWithUSDTest() {
		onView(withId(R.id.seekBarAmount)).perform(click(1,3));
		onView(withId(R.id.currencySpinner)).perform(click());
		onData(allOf(is(instanceOf(String.class)),is("USD"))).perform(click());

		onView(withId(R.id.currencySpinner)).check(matches(withSpinnerText(containsString("USD"))));
		onView(withId(R.id.calculateButton)).perform(click());
		onView(withId(R.id.textViewResult)).check(matches(withText("7400000 HUF")));


	}
	@Test
	public void PriceCalculationViaTextViewWithEuroTest() {
		onView(withId(R.id.editTextValue)).perform(clearText(), typeText("10"));
		onView(withId(R.id.editTextValue)).perform(closeSoftKeyboard());
		onView(withId(R.id.currencySpinner)).perform(click());
		onData(allOf(is(instanceOf(String.class)),is("EURO"))).perform(click());
		onView(withId(R.id.currencySpinner)).check(matches(withSpinnerText(containsString("EURO"))));
		onView(withId(R.id.calculateButton)).perform(click());
		onView(withId(R.id.textViewResult)).check(matches(withText("3100 HUF")));
	}
}
