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

package com.aiassoft.androidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by gvryn on 02/06/18.
 */

/**
 * This library contains an activity that will display the text
 * passed as an intent extra
 */
public class JokeActivity extends AppCompatActivity {

    public static final String EXTRA_FRESH_JOKE = "EXTRA_FRESH_JOKE";

    private static TextView mJokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        mJokeTextView = findViewById(R.id.tv_joke);

        /**
         * should be called from another activity. if not, show error toast and return
         */
        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        } else {

            /** read the Intent parameter */
            String aFreshJoke = null;
            if(intent.hasExtra(EXTRA_FRESH_JOKE)){
                aFreshJoke = intent.getStringExtra(EXTRA_FRESH_JOKE);
            }
            if(aFreshJoke == null || aFreshJoke.isEmpty()) {
                mJokeTextView.setText(getString(R.string.default_joke));
            }
            else{
                mJokeTextView.setText(aFreshJoke);
            }
        }
    }

    private void closeOnError() {
        String err = this.getString(R.string.activity_error_message_missing_extras, JokeActivity.class.getSimpleName());

        Toast.makeText(this, err, Toast.LENGTH_LONG).show();

        finish();
    }
}
