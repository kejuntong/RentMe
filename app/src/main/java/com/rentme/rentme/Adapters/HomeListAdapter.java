package com.rentme.rentme.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.rentme.rentme.Models.RentalItem;
import com.rentme.rentme.R;

import java.util.ArrayList;

/**
 * Created by kejuntong on 16-11-13.
 */
public class HomeListAdapter extends
        RecyclerView.Adapter<HomeListAdapter.ViewHolder>{

    Context mContext;
    LayoutInflater mInflater;

    ArrayList<RentalItem> itemList;

    StorageReference storageRef;

    public HomeListAdapter(Context context, ArrayList<RentalItem> itemList){
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.itemList = itemList;

        storageRef = FirebaseStorage.getInstance().getReferenceFromUrl("gs://rentme-93fc4.appspot.com/rental");
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View arg0) {
            super(arg0);
        }

        TextView locationText;
        TextView priceText;
        TextView description;
        TextView startTime;

        ImageView roomImage;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_home_rental, null);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.locationText = (TextView) view.findViewById(R.id.location);
        viewHolder.priceText = (TextView) view.findViewById(R.id.price);
        viewHolder.description = (TextView) view.findViewById(R.id.description);
        viewHolder.startTime = (TextView) view.findViewById(R.id.available_time);

        viewHolder.roomImage = (ImageView) view.findViewById(R.id.round_image);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        RentalItem rentalItem = itemList.get(position);

        // suppose region won't be null
        if (rentalItem.getLocation() != null){
            holder.locationText.setText(rentalItem.getLocation() + ", " + rentalItem.getRegion());
        } else {
            holder.locationText.setText(rentalItem.getRegion());
        }

        holder.priceText.setText(rentalItem.getPrice());

        holder.startTime.setText(rentalItem.getAv_time());

        if (rentalItem.getDescription() != null){
            holder.description.setText(rentalItem.getDescription());
        } else {
            holder.description.setVisibility(View.GONE);
        }

        Integer photoNumber = rentalItem.getPhoto_number();
        if (photoNumber != null && photoNumber > 0) {
            StorageReference reference = storageRef.child(itemList.get(position).getKey()).child("1.jpg");
            Glide.with(mContext).using(new FirebaseImageLoader()).load(reference).into(holder.roomImage);
        } else {

        }

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

}

