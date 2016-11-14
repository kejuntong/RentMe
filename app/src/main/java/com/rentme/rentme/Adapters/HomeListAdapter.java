package com.rentme.rentme.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public HomeListAdapter(Context context, ArrayList<RentalItem> itemList){
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.itemList = itemList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View arg0) {
            super(arg0);
        }
//
//        TextView itemText;
//        CheckBox itemCheckbox;
//        ImageButton itemAdd;
//        TextView heightText;
//        ToggleButton toggleButton;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        ViewHolder viewHolder = null;
        View view = mInflater.inflate(R.layout.item_home_rental, null);
        viewHolder = new ViewHolder(view);
//        viewHolder.itemText = (TextView) view.findViewById(R.id.filter_item_text);
//        viewHolder.itemCheckbox = (CheckBox) view.findViewById(R.id.filter_check_box);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

//        holder.itemText.setText(itemList.get(position).getItemName());
//
//        if (itemList.get(position).getItemType() == Constants.FILTER_CHECK_BOX_SINGLE){
//
//            if (itemList.get(position).getIsSelected()){
//                singleSelectedPosition = position;
//            }
//
//            if (position == singleSelectedPosition){
//                holder.itemCheckbox.setAlpha(1.0f);
//                holder.itemCheckbox.setChecked(true);
//            } else {
//                holder.itemCheckbox.setAlpha(0f);
//                holder.itemCheckbox.setChecked(false);
//            }
//
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    for (FilterItem item : itemList){
//                        item.setIsSelected(false);
//                    }
//                    itemList.get(position).setIsSelected(true);
//                    singleSelectedPosition = position;
//                    notifyDataSetChanged();
//
//                    if (onItemClickListener != null){
//                        onItemClickListener.onItemClick(holder.itemView, position, null);
//                    }
//
//                }
//            });
//        }


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

}

