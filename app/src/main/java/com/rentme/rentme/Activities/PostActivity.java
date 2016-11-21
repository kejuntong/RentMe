package com.rentme.rentme.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rentme.rentme.Models.RentalItem;
import com.rentme.rentme.R;

/**
 * Created by kejuntong on 16-11-20.
 */
public class PostActivity extends Activity {

    DatabaseReference databaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        databaseRef = FirebaseDatabase.getInstance().getReference("rental");


//        databaseRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                finish();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


        findViewById(R.id.save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RentalItem item = new RentalItem("1000-test", "North York-test");
//                databaseRef.child("0010").setValue(item);

                String key = databaseRef.push().getKey();
                RentalItem item = new RentalItem("1000-test", "North York-test");
//                item.setKey(key);
                databaseRef.child(key).setValue(item);
            }
        });

    }
}
