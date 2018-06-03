package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.aiassoft.androidlibrary.JokeActivity;
import com.aiassoft.builditbigger.AFreshJokeAsyncTask;

/**
 * Paid Version
 * Modified to meets project specifications.
 * by getting a fresh joke via async task and the engine
 * the display it in the activity that resides in the library
 * This version doesn't display any adds
 */
public class MainActivityFragment extends Fragment {


    private static boolean mAppIsAlive = true;

    private ProgressBar mProgressBar;
    private Button mFreshJokeButton;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mProgressBar = root.findViewById(R.id.progress_bar);

        mFreshJokeButton = root.findViewById(R.id.btn_fresh_joke);

        mFreshJokeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                mProgressBar.setVisibility(View.VISIBLE);
                new AFreshJokeAsyncTask(new AFreshJokeAsyncTask.AFreshJokeAsyncTaskCallback() {
                    @Override
                    public void onResult(String aFreshJoke) {
                        if (mAppIsAlive)
                            startJokeActivity(aFreshJoke);
                    }
                }).execute();
            }
        });

        return root;
    }

    @Override
    public void onPause() {
        super.onPause();
        mAppIsAlive = false;
    }

    @Override
    public void onResume() {
        super.onResume();
        mAppIsAlive = true;
    }

    public void startJokeActivity(String freshJoke) {
        mProgressBar.setVisibility(View.GONE);
        Intent intent = new Intent(getActivity(), JokeActivity.class);
        intent.putExtra(JokeActivity.EXTRA_FRESH_JOKE, freshJoke);
        getActivity().startActivity(intent);
    }
}
