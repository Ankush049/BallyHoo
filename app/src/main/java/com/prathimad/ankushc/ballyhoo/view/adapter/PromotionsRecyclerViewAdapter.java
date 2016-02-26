package com.prathimad.ankushc.ballyhoo.view.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.prathimad.ankushc.ballyhoo.R;
import com.prathimad.ankushc.ballyhoo.model.Promotion;

import java.util.List;

/**
 * Created by ankushc on 2/26/16.
 */
public class PromotionsRecyclerViewAdapter
        extends RecyclerView.Adapter<PromotionsRecyclerViewAdapter.PromotionViewHolder>{

    List<Promotion> mPromotions;

    public PromotionsRecyclerViewAdapter(List<Promotion> promotions){
        this.mPromotions = promotions;
    }

    public static class PromotionViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView mPromotionDetails;
        TextView mPromotionSubDetails;
        ImageView mpPromotionPhoto;

        PromotionViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView)itemView.findViewById(R.id.promotion_card_view);
            mPromotionDetails = (TextView)itemView.findViewById(R.id.promotion_details);
            mPromotionSubDetails = (TextView)itemView.findViewById(R.id.promotion_sub_details);
            mpPromotionPhoto = (ImageView) itemView.findViewById(R.id.promotion_photo);
        }
    }

    @Override
    public PromotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.promotion_card_view, parent, false);
        PromotionViewHolder mPromotionViewHolder = new PromotionViewHolder(v);
        return mPromotionViewHolder;
    }

    @Override
    public void onBindViewHolder(PromotionViewHolder holder, int position) {
        holder.mPromotionDetails.setText(mPromotions.get(position).getPromotionHeadline());
        Log.i("ADAPTER", mPromotions.get(position).getPromotionHeadline() + "   " + holder.mPromotionDetails.getText().toString());
        holder.mPromotionSubDetails.setText(mPromotions.get(position).getPromotionDescription());
        Log.i("ADAPTER", mPromotions.get(position).getPromotionDescription() + "   " + holder.mPromotionSubDetails.getText().toString());
        holder.mpPromotionPhoto.setImageResource(mPromotions.get(position).getImageUrl());
        Log.i("ADAPTER", mPromotions.get(position).getImageUrl() + "   " + holder.mPromotionDetails.getText().toString());
    }

    @Override
    public int getItemCount() {
        return mPromotions.size();
    }
}