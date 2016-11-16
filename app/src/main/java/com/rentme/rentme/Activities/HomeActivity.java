package com.rentme.rentme.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.rentme.rentme.Adapters.HomeListAdapter;
import com.rentme.rentme.Models.RentalItem;
import com.rentme.rentme.R;

import java.util.ArrayList;

/**
 * Created by kejuntong on 16-11-13.
 */
public class HomeActivity extends Activity {

    RecyclerView mRecyclerView;
    HomeListAdapter mAdapter;
    SlidingMenu slidingMenu;

    ArrayList<RentalItem> rentalItemList;

    DatabaseReference databaseRef;
    StorageReference storageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        databaseRef = FirebaseDatabase.getInstance().getReference("rental");

        initRecyclerView();

        addDataLoadingListener();


//        RentalItem item = new RentalItem("1000", "North York");
//        ArrayList<String> testPhotoList = new ArrayList<>();
//        testPhotoList.add("www.123");
//        testPhotoList.add("sssssat");
//        item.setPhotoList(testPhotoList);
//        databaseRef.child("0010").setValue(item);


//        storageRef = FirebaseStorage.getInstance().getReferenceFromUrl("gs://rentme-93fc4.appspot.com/rental/REALTOR.jpg");
//        System.out.println("test path: " + storageRef.getPath() );
//
//        testImageView = (ImageView) findViewById(R.id.image_view);
//        Glide.with(this).using(new FirebaseImageLoader()).load(storageRef).into(testImageView);

    }

    private void initRecyclerView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        rentalItemList = new ArrayList<>();
        mAdapter = new HomeListAdapter(this, rentalItemList);

        mRecyclerView.setAdapter(mAdapter);
    }

    private void addDataLoadingListener(){
        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                rentalItemList.clear();

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    RentalItem rentalItem = child.getValue(RentalItem.class);
                    rentalItem.setKey(child.getKey());
                    rentalItemList.add(rentalItem);
                }

                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void setSlidingMenu(){
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        slidingMenu.setShadowDrawable(R.drawable.menu_shadow);
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        slidingMenu.setFadeDegree(0.35f);
        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setMenu(R.layout.view_sliding_menu);

        menuButton = (ImageButton) findViewById(R.id.menu_button);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingMenu.toggle();
            }
        });
    }

}
