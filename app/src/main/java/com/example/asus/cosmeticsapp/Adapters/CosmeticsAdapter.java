package com.example.asus.cosmeticsapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.cosmeticsapp.Views.CosmeticsDetails;
import com.example.asus.cosmeticsapp.Model.Cosmetic;
import com.example.asus.cosmeticsapp.R;

import java.util.List;

public class CosmeticsAdapter extends RecyclerView.Adapter<CosmeticsAdapter.MyViewHolder> {
    private List<Cosmetic> cosmetics;
    private Context context;
    public static final String COSMETIC = "cosmetic";

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private View mTextView;

        private MyViewHolder(View v) {
            super(v);
            mTextView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CosmeticsAdapter(List<Cosmetic> catFactArrayList, Context context) {
        cosmetics = catFactArrayList;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new MyViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@Nullable MyViewHolder holder, final int position) {

        TextView name = holder.mTextView.findViewById(R.id.textViewItem);
        name.setText(cosmetics.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CosmeticsDetails.class);
                intent.putExtra(COSMETIC, cosmetics.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cosmetics.size();
    }
}