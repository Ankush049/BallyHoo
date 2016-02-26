package com.prathimad.ankushc.ballyhoo.model;

import com.prathimad.ankushc.ballyhoo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankushc on 2/26/16.
 */
public class Promotion {

    private List<Promotion> promotions;

    private Integer mImageUrl;
    private String mWebsiteUrl;
    private String mPromotionHeadline;
    private String mPromotionDescription;

    public Promotion() {
        initializeDate();
    }

    public Promotion(Integer imageUrl, String websiteUrl, String promotionHeadline, String promotionDescription) {
        this.mImageUrl = imageUrl;
        this.mWebsiteUrl = websiteUrl;
        this.mPromotionHeadline = promotionHeadline;
        this.mPromotionDescription = promotionDescription;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public Integer getImageUrl() {
        return mImageUrl;
    }

    public String getWebsiteUrl() {
        return mWebsiteUrl;
    }

    public String getPromotionHeadline() {
        return mPromotionHeadline;
    }

    public String getPromotionDescription() {
        return mPromotionDescription;
    }

    public void setPromotions(List<Promotion> persons) {
        this.promotions = persons;
    }

    private void initializeDate() {
        promotions = new ArrayList<Promotion>();

        Promotion promo1 = new Promotion(R.mipmap.amazon_icon, "http://www.amazon.com" , "Big discount on Amazon", "Get upto 50% off on electronics");
        Promotion promo2 = new Promotion(R.mipmap.myntra_icon, "http://www.myntra.com" , "Myntra Mega Sale", "Only for today mega sale on clothing");
        Promotion promo3 = new Promotion(R.mipmap.walmart_icon, "http://www.walmart.com" , "Walmart weekend bargain", "Get free coupons and passes on Rs 300/- shopping.");
        Promotion promo4 = new Promotion(R.mipmap.amazon_icon, "http://www.amazon.com" , "Amazon electronics offers", "Get huge discounts for replacing your old items");
        Promotion promo5 = new Promotion(R.mipmap.amazon_icon, "http://www.amazon.com" , "Abra Ka Dabra Sale", "Huge discounts on clothings and electronics");
        Promotion promo6 = new Promotion(R.mipmap.myntra_icon, "http://www.myntra.com" , "Myntra fashion sale", "Whole new set of fashion collection at cheapest price");

        promotions.add(promo1);
        promotions.add(promo2);
        promotions.add(promo3);
        promotions.add(promo4);
        promotions.add(promo5);
        promotions.add(promo6);
    }

}
