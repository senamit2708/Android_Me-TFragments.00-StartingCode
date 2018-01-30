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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senamit on 28/1/18.
 */

public class FragmentBodyPart extends Fragment {

    private static final String LOG_TAG = FragmentBodyPart.class.getSimpleName();

    //lets create variable, so that it takes the correct data, not the hardcoded
    private List<Integer> mImageIds;
    private int mListIndex;
    private String imageIdsKey;
    private String listIndexKey;

    public FragmentBodyPart() {
        Log.i(LOG_TAG, "inside the constructor of the FragmentBodyPart");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //if i dont use savedinstance state, my values of mImageIds and mLIstindex become zero, i dont know, why
        //because setter is working for the first time but not for the second time.
        //i think thats why onattach is used...
        if (savedInstanceState!=null){
            mImageIds= savedInstanceState.getIntegerArrayList(imageIdsKey);
            mListIndex=savedInstanceState.getInt(listIndexKey);
        }
        Log.i(LOG_TAG, "inisde the oncreate view method of fragment");
//        View rootView = inflater.inflate(R.layout.fragment_body_part, container,false );
        View rootView = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_body_part, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView_body_part);

//        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));
        Log.i(LOG_TAG, "the index postition is "+mListIndex);
        Log.i(LOG_TAG, "the index postition is "+mImageIds);

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

    public void setImageIds(List<Integer> imageIds) {
        Log.i(LOG_TAG, "inside setmImagedIds");
        mImageIds = imageIds;
        Log.i(LOG_TAG,"the list of image head is "+mImageIds);
    }

    public void setListIndex(int listIndex) {

        mListIndex = listIndex;
        Log.i(LOG_TAG, "the index postion in setindex is "+mListIndex);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(imageIdsKey, (ArrayList<Integer>) mImageIds);
        outState.putInt(listIndexKey, mListIndex);
        super.onSaveInstanceState(outState);
    }
}
