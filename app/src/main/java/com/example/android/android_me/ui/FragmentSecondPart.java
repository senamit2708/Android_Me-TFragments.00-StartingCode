package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senamit on 28/1/18.
 */

public class FragmentSecondPart extends Fragment{

    private static final String LOG_TAG = FragmentSecondPart.class.getSimpleName();
    private List<Integer> mImageIds;
    private int mListIndex;
    private String imageIdsKey;
    private String listIndexKey;
    public FragmentSecondPart() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (savedInstanceState!=null){
            mImageIds= savedInstanceState.getIntegerArrayList(imageIdsKey);
            mListIndex=savedInstanceState.getInt(listIndexKey);
        }

        View rootView = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_second_part, container, false);

        final ImageView imageView = (ImageView)rootView.findViewById(R.id.imageView_second_part);
//        imageView.setImageResource(AndroidImageAssets.getBodies().get(0));
//        mListIndex = savedInstanceState.getInt("keyPosition");
        Log.i(LOG_TAG, "the index position is "+mListIndex);
        if (mImageIds!= null){
            imageView.setImageResource(mImageIds.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mImageIds.size()-1>mListIndex){
                        mListIndex++;
                    }else {
                        mListIndex=0;
                    }

                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });

        }else {
            Log.i(LOG_TAG, "the Image array of body is null");
        }


        return rootView;


    }


    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(imageIdsKey, (ArrayList<Integer>) mImageIds);
        outState.putInt(listIndexKey, mListIndex);
        super.onSaveInstanceState(outState);
    }
}
