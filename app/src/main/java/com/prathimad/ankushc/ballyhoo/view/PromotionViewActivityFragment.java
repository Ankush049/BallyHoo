package com.prathimad.ankushc.ballyhoo.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prathimad.ankushc.ballyhoo.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PromotionViewActivityFragment extends Fragment {

    public PromotionViewActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_promotion_view, container, false);
    }
}
