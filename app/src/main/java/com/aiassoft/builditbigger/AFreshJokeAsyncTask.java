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

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by gvryn on 03/06/18.
 * This class uses the AsyncTask mechanism to read a fresh joke
 * from the Google Cloud Engine
 */

public class AFreshJokeAsyncTask extends AsyncTask<String, Void, String> {

    private static MyApi mMyApi;

    private static AFreshJokeAsyncTaskCallback mAFreshJokeAsyncTaskCallback;

    public interface AFreshJokeAsyncTaskCallback {
        void onResult(String result);
    }

    public AFreshJokeAsyncTask(AFreshJokeAsyncTaskCallback aFreshJokeAsyncTaskCallback) {
        this.mAFreshJokeAsyncTaskCallback = aFreshJokeAsyncTaskCallback;
    }

    @Override
    protected String doInBackground(String... strings) {
        if (mMyApi == null) {
            // for browser test on my pc http://192.168.1.11:8080/_ah/api/myApi/v1/mybean
            // developer app server
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
//                    .setRootUrl("http://192.168.1.11:8080/_ah/api/");

                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                       @Override
                       public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                           abstractGoogleClientRequest.setDisableGZipContent(true);
                       }
                   });

            mMyApi = builder.build();
        }

        try {
            return mMyApi.apiAFreshJoke().execute().getData();//  .getAfreshJoke();
        } catch (IOException e) {
            Log.e("AFreshJokeAsyncTask", e.getMessage());
            //return e.getMessage();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (mAFreshJokeAsyncTaskCallback != null) {
            mAFreshJokeAsyncTaskCallback.onResult(result);
        }
    }
}
