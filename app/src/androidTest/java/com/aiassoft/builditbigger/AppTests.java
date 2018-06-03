/**
 * Copyright (C) 2018 by George Vrynios
 * This project was made under the supervision of Udacity
 * in the Android Developer Nanodegree Program
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aiassoft.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by gvryn on 03/06/18.
 */

/**
 * In this test we will check the app starting plus the async task
 * that provides the fresh joke
 */
@RunWith(AndroidJUnit4.class)
public class AppTests {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void connectedTest() {
        onView(withId(R.id.btn_fresh_joke)).check(matches(withText(R.string.button_text)));

        String freshJoke = null;
        AFreshJokeAsyncTask aFreshJokeAsyncTask = new AFreshJokeAsyncTask(null);
        try {
            freshJoke = aFreshJokeAsyncTask.execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(freshJoke);
    }
}
