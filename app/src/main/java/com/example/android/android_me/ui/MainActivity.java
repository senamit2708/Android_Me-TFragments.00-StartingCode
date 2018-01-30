package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.android.android_me.R;

/**
 * Created by senamit on 29/1/18.
 */

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageSelectedListener{

   public static final String LOG_TAG= MainActivity.class.getSimpleName();
   String KEY_POSITION = "keyPosition";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MasterListFragment masterListFragment = new MasterListFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.master_list_fragment,masterListFragment).commit();




    }

    @Override
    public void onImageItemSelected(int position) {
        Log.i(LOG_TAG, "the image selected position is "+position);
        Toast.makeText(MainActivity.this, "the image selected postion is  "+position, Toast.LENGTH_LONG).show();

//        FragmentBodyPart fragmentBodyPart = new FragmentBodyPart();
//        Bundle args = new Bundle();
//        args.putInt(KEY_POSITION, position);
//        fragmentBodyPart.setArguments(args);
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.master_list_fragment, fragmentBodyPart);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
        Intent intent = new Intent(MainActivity.this, AndroidMeActivity.class);
        intent.putExtra(KEY_POSITION, position);
        startActivity(intent);
    }
}
