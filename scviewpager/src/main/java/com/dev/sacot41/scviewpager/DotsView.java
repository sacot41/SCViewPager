package com.dev.sacot41.scviewpager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuel on 2015-06-27.
 */

public class DotsView extends LinearLayout {

    private List<ImageView> dots;
    private int numberOfPage = 0;
    private int mSelectedRessource;
    private int mUnSelectedRessource;

    public DotsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setDotRessource(int selectedRessource, int unSelectedRessource) {
        mSelectedRessource = selectedRessource;
        mUnSelectedRessource = unSelectedRessource;
    }

    public void setNumberOfPage(int pageNumber) {

        numberOfPage = pageNumber;
        dots = new ArrayList<>();

        for(int i = 0; i < numberOfPage; i++) {
            ImageView dot = new ImageView(getContext());
            dot.setImageDrawable(getResources().getDrawable(mUnSelectedRessource));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            addView(dot, params);

            dots.add(dot);
        }

        selectDot(0);
    }

    public void selectDot(int idx) {
        Resources res = getResources();
        for(int i = 0; i < numberOfPage; i++) {
            int drawableId = (i==idx)?(mSelectedRessource):(mUnSelectedRessource);
            Drawable drawable = res.getDrawable(drawableId);
            dots.get(i).setImageDrawable(drawable);
        }
    }

}
