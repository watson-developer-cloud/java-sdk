package com.ibm.watson.developer_cloud.android.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.WindowManager;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by blakeball on 9/29/16.
 */

@RunWith(AndroidJUnit4.class)
public class CameraHelperTest {

  @Rule
  public IntentsTestRule<MainActivity> intentsTestRule =
      new IntentsTestRule<MainActivity>(MainActivity.class);

  @Before
  public void unlockScreen() {
    final MainActivity activity = intentsTestRule.getActivity();
    Runnable wakeUpDevice = new Runnable() {
      public void run() {
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON |
            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
      }
    };
    activity.runOnUiThread(wakeUpDevice);
  }

  @Test public void testCameraFlow() {


    Bitmap icon = BitmapFactory.decodeResource(
        InstrumentationRegistry.getTargetContext().getResources(),
        R.mipmap.ic_launcher);

    Intent resultData = new Intent();
    resultData.putExtra("data", icon);
    Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, resultData);

    intending(toPackage("com.android.camera")).respondWith(result);

    Espresso.onView(withId(R.id.camera_button)).perform(click());

    intended(toPackage("com.android.camera"));

  }

}
