package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.*;

import java.util.List;

/**
 * Created by senamit on 28/1/18.
 */

public class FragmentSecondPart extends Fragment{

    private List<Integer> mImageIds;
    private int mListIndex;
    public FragmentSecondPart() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_second_part, container, false);

        ImageView imageView = (ImageView)rootView.findViewById(R.id.imageView_second_part);
//        imageView.setImageResource(AndroidImageAssets.getBodies().get(0));
        imageView.setImageResource(mImageIds.get(mListIndex));

        return rootView;


    }


    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }
}
