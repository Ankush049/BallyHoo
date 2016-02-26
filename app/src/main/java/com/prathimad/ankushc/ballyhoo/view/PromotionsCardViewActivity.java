package com.prathimad.ankushc.ballyhoo.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.prathimad.ankushc.ballyhoo.R;
import com.prathimad.ankushc.ballyhoo.model.Promotion;
import com.prathimad.ankushc.ballyhoo.view.adapter.PromotionClickListener;
import com.prathimad.ankushc.ballyhoo.view.adapter.PromotionsRecyclerViewAdapter;

import java.util.List;

public class PromotionsCardViewActivity extends AppCompatActivity {

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
                        openInWebBrowser(mPromotions.get(position).getWebsiteUrl());
                    }
                })
        );
        // Maybe we can use it for creating new promotions, can be in the view of the
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "In future we will allow vendor to add prommotions, via this", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    public void openInWebBrowser(final String url) {
        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        this.startActivity(intent);
    }

}
