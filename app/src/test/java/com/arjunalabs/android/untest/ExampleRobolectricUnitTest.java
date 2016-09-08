package com.arjunalabs.android.untest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by bobbyadiprabowo on 9/8/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk=23, packageName = "com.arjunalabs.android.untest", constants = BuildConfig.class)
public class ExampleRobolectricUnitTest {

    @Test
    public void textApp() {
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        assertNotNull(mainActivity);
    }
}
