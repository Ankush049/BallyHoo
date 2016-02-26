package com.prathimad.ankushc.ballyhoo.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.prathimad.ankushc.ballyhoo.R;
import com.prathimad.ankushc.ballyhoo.model.Preference;
import com.prathimad.ankushc.ballyhoo.model.Promotion;
import com.prathimad.ankushc.ballyhoo.view.adapter.PromotionClickListener;
import com.prathimad.ankushc.ballyhoo.view.adapter.PromotionsRecyclerViewAdapter;

import java.util.List;

public class PreferenceSelectionActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private PromotionsRecyclerViewAdapter viewAdapter;
    private List<Promotion> mPromotions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promotions_card_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.promotion_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setVerticalScrollBarEnabled(true);

        mLinearLayoutManager = new LinearLayoutManager(this.getApplicationContext());
        mLinearLayoutManager.setSmoothScrollbarEnabled(true);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mPromotions = new Promotion().getPromotions();
        viewAdapter = new PromotionsRecyclerViewAdapter(mPromotions);
        mRecyclerView.setAdapter(viewAdapter);

        mRecyclerView.addOnItemTouchListener(
                new PromotionClickListener(this, new PromotionClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Log.i("CARD VIEW ::: " , "clicked the position : " + position + "   " + mPromotions.get(position).getWebsiteUrl());
                        //TODO Store the preference.
                    }
                })
        );
    }

}
