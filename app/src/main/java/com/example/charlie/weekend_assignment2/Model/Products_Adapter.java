package com.example.charlie.weekend_assignment2.Model;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charlie.weekend_assignment2.FragmentHolder_MainActivity;
import com.example.charlie.weekend_assignment2.R;
import com.example.charlie.weekend_assignment2.Utility.ItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 12/06/2016.
 */
public class Products_Adapter extends RecyclerView.Adapter<Products_Adapter.ItemHolder>{

    Activity activity;
    int layoutResourceId;

    private List<Listing> categories;
    private int rowLayout;
    private Context context;

    ArrayList<Listing> data = new ArrayList<Listing>();

    public Products_Adapter(Context context, List<Listing> categories, int rowLayout){

        this.categories = categories;
        this.context = context;
        this.rowLayout = rowLayout;

        notifyDataSetChanged();
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(Products_Adapter.ItemHolder holder, int position) {
        final Listing listing = categories.get(position);
        holder.Price.setText(listing.getCurrentPrice());
        Picasso.with(context)
                .load(listing.getProductImageUrl().get(0))
                .into( holder.Image);
        holder.setClickListener(new ItemClickListener() {

            @Override
            public void onClick(View view, int position) {
                Log.i("Clicked",""+position);
                FragmentHolder_MainActivity mainActivity = (FragmentHolder_MainActivity) context;
              //  mainActivity.SelectItem(2,""+listing.getProductId());
            }
        });




    }

    @Override
    public int getItemCount() {
        return categories == null ? 0: categories.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        TextView Price;
        ImageView Image;
        private ItemClickListener clickListener;

        public void setClickListener(ItemClickListener itemClickListener){
            this.clickListener = itemClickListener;
        }


        public ItemHolder(View row) {
            super(row);

            Price= (TextView)row.findViewById(R.id.titleText);
            Image = (ImageView)row.findViewById(R.id.Image);
            row.setTag(row);
            row.setOnClickListener(this);
            row.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onClick(v, getPosition());
            return false;
        }
    }
}




