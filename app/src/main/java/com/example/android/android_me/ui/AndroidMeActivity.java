/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.android_me.R;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    public static final String LOG_TAG = AndroidMeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);


        Log.i(LOG_TAG, "inside the main activity");
        FragmentBodyPart headPart = new FragmentBodyPart();
        FragmentSecondPart secondPart = new FragmentSecondPart();
        Log.i(LOG_TAG, "the object of fragment is created");

        FragmentManager fragmentManager = getSupportFragmentManager();
//        Log.i(LOG_TAG, "the fragment manager is called ");
//
        fragmentManager.beginTransaction().add(R.id.fragment_head_part, headPart).commit();

//        Log.i(LOG_TAG,"the transaction completed");
        FragmentManager secondFragmentManger = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.fragment_second_part, secondPart).commit();



    }
}
