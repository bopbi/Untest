package com.arjunalabs.android.untest;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.util.ActivityController;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by bobbyadiprabowo on 9/8/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk=23, packageName = "com.arjunalabs.android.untest", constants = BuildConfig.class)
public class ExampleRobolectricUnitTest {

    @Test
    public void textApp() {

        // setup activity
        ActivityController<MainActivity> mainActivityController = Robolectric.buildActivity(MainActivity.class);

        MainActivity mainActivity = mainActivityController.create().start().resume().visible().get();
        assertNotNull(mainActivity);

        // get the recyclerview
        RecyclerView recyclerView = (RecyclerView) mainActivity.findViewById(R.id.recycler);
        recyclerView.measure(0, 0);
        recyclerView.layout(0, 0, 100, 10000);

        assertNotNull(recyclerView);

        // get the recyclerview item
        View view = recyclerView.findViewHolderForAdapterPosition(0).itemView;

        assertNotNull(view);

        // perform click on recyclerview item
        view.performClick();

        // check the activity called from the click
        ShadowActivity shadowActivity = Shadows.shadowOf(mainActivity);
        Intent intent = shadowActivity.peekNextStartedActivityForResult().intent;

        // check if activity is correct
        assertEquals(DetailActivity.class.getName(), intent.getComponent().getClassName());

    }
}
