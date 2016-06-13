package com.example.charlie.weekend_assignment2.Model;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.charlie.weekend_assignment2.FragmentHolder_MainActivity;
import com.example.charlie.weekend_assignment2.R;
import com.example.charlie.weekend_assignment2.Utility.Communicator;
import com.example.charlie.weekend_assignment2.Utility.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 12/06/2016.
 */
public class Gender_Cat_Adapter extends RecyclerView.Adapter<Gender_Cat_Adapter.ItemHolder> {

    Activity activity;
    int layoutResourceId;
    Communicator com;
    private List<Listing> categories;
    private int rowLayout;
    private Context context;

    ArrayList<Listing> data = new ArrayList<Listing>();

    public Gender_Cat_Adapter(Context context, List<Listing> categories, int rowLayout){

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
    public void onBindViewHolder(ItemHolder holder, int position) {
        final Listing listing = categories.get(position);
        holder.Name.setText(listing.getName());
        holder.setClickListener(new ItemClickListener() {

            @Override
            public void onClick(View view, int position) {
                Log.i("Clicked",""+position);
                FragmentHolder_MainActivity mainActivity = (FragmentHolder_MainActivity) context;
                mainActivity.SelectItem(1,listing.getCategoryId());
            }
        });





    }


    @Override
    public int getItemCount() {
        return categories == null ? 0: categories.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
      TextView Name;
      private ItemClickListener clickListener;

       // public void setOnClickListener(ItemClickListener listener){
       //     clickListener = listener;
       // }


        public ItemHolder(View row) {
            super(row);

            Name = (TextView)row.findViewById(R.id.titleText);

            row.setTag(row);
            row.setOnClickListener(this);
            row.setOnLongClickListener(this);

        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
            Log.i("Click","Set");
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getPosition());
            Log.i("CLICK","CLICK");

        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onClick(view, getPosition());
            return true;
        }



    }
}
