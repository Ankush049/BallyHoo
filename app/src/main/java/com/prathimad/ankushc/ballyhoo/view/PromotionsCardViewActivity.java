package com.prathimad.ankushc.ballyhoo.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.prathimad.ankushc.ballyhoo.R;
import com.prathimad.ankushc.ballyhoo.model.Promotion;
import com.prathimad.ankushc.ballyhoo.navigation.MenuNavigationActivity;
import com.prathimad.ankushc.ballyhoo.view.adapter.PromotionClickListener;
import com.prathimad.ankushc.ballyhoo.view.adapter.PromotionsRecyclerViewAdapter;
import com.prathimad.ankushc.ballyhoo.view.adapter.SwipeableRecyclerViewTouchListener;

import java.util.List;

public class PromotionsCardViewActivity extends MenuNavigationActivity implements NavigationView.OnNavigationItemSelectedListener{

    //TODO : Bug on this page, that the first card is getting hidden by tool bar partially.
    // Resolved  by keeping a padding of size action bar.
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private PromotionsRecyclerViewAdapter mViewAdapter;
    private List<Promotion> mPromotions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promotion_filter_naviagtion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.promotion_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setVerticalScrollBarEnabled(true);

        mLinearLayoutManager = new LinearLayoutManager(this.getApplicationContext());
        mLinearLayoutManager.setSmoothScrollbarEnabled(true);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mPromotions = new Promotion().getPromotions();
        mViewAdapter = new PromotionsRecyclerViewAdapter(mPromotions);
        mRecyclerView.setAdapter(mViewAdapter);

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


        SwipeableRecyclerViewTouchListener swipeTouchListener =
                new SwipeableRecyclerViewTouchListener(mRecyclerView, new SwipeableRecyclerViewTouchListener.SwipeListener() {
                    @Override
                    public boolean canSwipeLeft(int position) {
                        return false;
                    }

                    @Override
                    public boolean canSwipeRight(int position) {
                        return true;
                    }

                    @Override
                    public void onDismissedBySwipeLeft(RecyclerView recyclerView, int[] reverseSortedPositions) {
                        // Left blank intentionally, so that nothing happens when you swipe left.
                    }

                    @Override
                    public void onDismissedBySwipeRight(RecyclerView recyclerView, int[] reverseSortedPositions) {
                        for (int position : reverseSortedPositions) {
                            mPromotions.remove(position);
                            mViewAdapter.notifyItemRemoved(position);
                        }
                        mViewAdapter.notifyDataSetChanged();
                    }

                });

        mRecyclerView.addOnItemTouchListener(swipeTouchListener);


        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.promotion_filter_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.promotion_filter_nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/

    }

    public void openInWebBrowser(final String url) {
        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        this.startActivity(intent);
    }

    /*
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile_naviagtion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
}
