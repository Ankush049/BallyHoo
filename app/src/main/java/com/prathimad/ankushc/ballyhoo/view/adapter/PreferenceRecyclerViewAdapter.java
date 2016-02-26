package com.prathimad.ankushc.ballyhoo.view.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.prathimad.ankushc.ballyhoo.R;
import com.prathimad.ankushc.ballyhoo.model.Preference;

import java.util.List;

/**
 * Created by ankushc on 2/26/16.
 */
public class PreferenceRecyclerViewAdapter
        extends RecyclerView.Adapter<PreferenceRecyclerViewAdapter.PromotionViewHolder>{

    List<Preference> mPreferences;

    public PreferenceRecyclerViewAdapter(List<Preference> preferences){
        this.mPreferences = preferences;
    }

    public static class PromotionViewHolder extends RecyclerView.ViewHolder {
        Button mButton;


        PromotionViewHolder(View itemView) {
            super(itemView);
            mButton = (Button) itemView.findViewById(R.id.item_selection_preference);
        }
    }

    @Override
    public PromotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.preference_selection_view, parent, false);
        PromotionViewHolder mPromotionViewHolder = new PromotionViewHolder(v);
        return mPromotionViewHolder;
    }

    @Override
    public void onBindViewHolder(PromotionViewHolder holder, int position) {
        holder.mButton.setBackgroundResource(mPreferences.get(position).getPreferenceImageId());
        holder.mButton.setText(mPreferences.get(position).getPreferenceName());
        Log.i("ADAPTER", mPreferences.get(position).getPreferenceName() + "   " + holder.mButton.getText().toString());
    }

    @Override
    public int getItemCount() {
        return mPreferences.size();
    }
}