package com.rentme.rentme.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.davemorrissey.labs.subscaleview.ImageViewState;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.rentme.rentme.R;

/**
 * Created by Kevin on 2015-12-03.
 */
public class PropertyImageFragment extends Fragment {

    View rootView;

    int selectedNumber;
    String imageUrl;
    ImageView imageView;

    StorageReference storageRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_property_image, container, false);

        storageRef = FirebaseStorage.getInstance().getReferenceFromUrl(imageUrl);

        imageView = (ImageView) rootView.findViewById(R.id.image_view);
//        imageView.setMinimumScaleType(SubsamplingScaleImageView.SCALE_TYPE_CUSTOM);
//        imageView.setMinimumDpi(1);
        Glide.with(getActivity()).using(new FirebaseImageLoader()).load(storageRef).into(imageView);


        return rootView;
    }

    public void setSelectedNumber(int number){
        this.selectedNumber = number;
    }
    public void setImageUrl(String url){
        this.imageUrl = url;
    }

}
