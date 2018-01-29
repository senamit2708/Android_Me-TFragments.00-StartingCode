package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

//here we have to extend R in fragment
import com.example.android.android_me.R;
import com.example.android.android_me.data.*;

/**
 * Created by senamit on 28/1/18.
 */

public class FragmentBodyPart extends Fragment {

    private static final String LOG_TAG = FragmentBodyPart.class.getSimpleName();

    public FragmentBodyPart() {
        Log.i(LOG_TAG, "inside the constructor of the FragmentBodyPart");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.i(LOG_TAG, "inisde the oncreate view method of fragment");
//        View rootView = inflater.inflate(R.layout.fragment_body_part, container,false );
        View rootView = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_body_part, container, false);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView_body_part);

        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));


        return rootView;
    }
}
