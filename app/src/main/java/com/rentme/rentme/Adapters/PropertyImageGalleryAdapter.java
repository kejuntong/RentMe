package com.rentme.rentme.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rentme.rentme.Fragments.PropertyImageFragment;

import java.util.ArrayList;

/**
 * Created by kevintong on 16-11-18.
 */
public class PropertyImageGalleryAdapter extends FragmentStatePagerAdapter {

    ArrayList<String> photoList;

    public PropertyImageGalleryAdapter(FragmentManager fm, ArrayList<String> photoList) {
        super(fm);
        this.photoList = photoList;
    }

    @Override
    public Fragment getItem(int position) {
        PropertyImageFragment fragment = new PropertyImageFragment();
        fragment.setSelectedNumber(position);
        fragment.setImageUrl(photoList.get(position));
        return fragment;
    }

    @Override
    public int getCount() {
        return photoList.size();
    }
}
