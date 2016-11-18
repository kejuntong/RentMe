package com.rentme.rentme.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.rentme.rentme.Adapters.PropertyImageGalleryAdapter;
import com.rentme.rentme.R;

import java.util.ArrayList;

/**
 * Created by kevintong on 16-11-17.
 */
public class PropertyDetailActivity extends FragmentActivity {

    ViewPager mViewPager;
    PropertyImageGalleryAdapter mPagerAdapter;

    ArrayList<String> photoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_detail);

        photoList = new ArrayList<>();
        photoList.add("gs://rentme-93fc4.appspot.com/rental/1.jpg");
        photoList.add("gs://rentme-93fc4.appspot.com/rental/2.jpg");
        photoList.add("gs://rentme-93fc4.appspot.com/rental/3.jpg");
        photoList.add("gs://rentme-93fc4.appspot.com/rental/4.jpg");

        initViewPager();
    }

    public void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mPagerAdapter = new PropertyImageGalleryAdapter(getSupportFragmentManager(), photoList);
        mViewPager.setAdapter(mPagerAdapter);

    }
}
