package com.example.android.android_me.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;

import com.example.android.android_me.data.*;

/**
 * Created by senamit on 29/1/18.
 */

public class MasterListFragment extends Fragment {

    private static final String LOG_TAG = MasterListFragment.class.getSimpleName();
    OnImageSelectedListener mCallback;

    public MasterListFragment() {
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //here we r checking that the activity has implemented the interface or not
        try {
            mCallback = (OnImageSelectedListener) activity;
        }catch (ClassCastException e){
            Log.e(LOG_TAG, "no interface implemented into the activity");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //its good to add fragment at run time, else getContext() doesnt work
//        View rootView = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_master_list, container, false);

        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView = (GridView) rootView.findViewById(R.id.image_grid_view);

        //getContext() is not working here, if i added fragment in layout, so i added fragment at run time
        // i dont the reason behind it
        MasterListAdapter mListAdapter = new MasterListAdapter(container.getContext(),AndroidImageAssets.getAll());
        gridView.setAdapter(mListAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallback.onImageItemSelected(position);
            }
        });

        return rootView;


    }


    public interface OnImageSelectedListener{
        public void onImageItemSelected(int position);
    }


}
