package com.prathimad.ankushc.ballyhoo.model;

import com.prathimad.ankushc.ballyhoo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankushc on 2/26/16.
 */
public class Preference {

    private Integer mPreferenceImageId;
    private String mPreferenceName;
    private List<Preference> mPreferences;

    public Preference() {
        initializePreferences();
    }

    public Preference(String preferenceName, Integer preferenceImageId) {
        this.mPreferenceName = preferenceName;
        this.mPreferenceImageId = preferenceImageId;
    }

    public String getPreferenceName() {
        return mPreferenceName;
    }

    public List<Preference> getPreferences() {
        return mPreferences;
    }

    public Integer getPreferenceImageId() {
        return mPreferenceImageId;
    }

    private void initializePreferences() {

        mPreferences = new ArrayList<Preference>();

        Preference pref1 = new Preference("Clothing", R.mipmap.ic_launcher_icon);
        Preference pref2 = new Preference("Electronics", R.mipmap.ic_launcher_icon);
        Preference pref3 = new Preference("Home Decor", R.mipmap.ic_launcher_icon);
        Preference pref4 = new Preference("Gaming", R.mipmap.ic_launcher_icon);

        mPreferences.add(pref1);
        mPreferences.add(pref2);
        mPreferences.add(pref3);
        mPreferences.add(pref4);
    }

}
