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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


/**
 * Free Version
 * Modified to meets project specifications.
 * by getting a fresh joke via async task and the engine
 * the display it in the activity that resides in the library
 * This version displays adds
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

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
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
        Intent intent = new Intent(getContext(), JokeActivity.class);
        intent.putExtra(JokeActivity.EXTRA_FRESH_JOKE, freshJoke);
        getActivity().startActivity(intent);
    }
}
