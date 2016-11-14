package com.rentme.rentme.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
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

    ArrayList<RentalItem> rentalItemList;

    DatabaseReference databaseRef;
    StorageReference storageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        rentalItemList = new ArrayList<>();
        mAdapter = new HomeListAdapter(this, rentalItemList);

        // for testing
        for (int i=0; i<10; i++){
            rentalItemList.add(new RentalItem());
        }

        mRecyclerView.setAdapter(mAdapter);

//        databaseRef = FirebaseDatabase.getInstance().getReference();
//        RentalItem item = new RentalItem("1000", "North York");
//        databaseRef.child("rental").child("0001").setValue(item);


        storageRef = FirebaseStorage.getInstance().getReferenceFromUrl("gs://rentme-93fc4.appspot.com");
        System.out.println("test path: " + storageRef.child("rental").child("REALTOR.jpg") );


    }
}
