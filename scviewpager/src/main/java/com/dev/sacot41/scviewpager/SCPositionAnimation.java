package com.dev.sacot41.scviewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Samuel on 2015-07-06.
 */

public class SCPositionAnimation extends SCPageAnimation {

    public int xPosition;
    public int yPosition;

    private float xStartPosition;
    private float yStartPosition;

    /**
     * @param forPage page to apply animation
     * @param dx x moving, in dp
     * @param dy y moving, in dp
     */

    public SCPositionAnimation(Context context, int forPage, int dx, int dy) {
        this.page = forPage;
        this.xPosition = dx;
        this.yPosition = dy;
        this.xStartPosition = -1;
        this.yStartPosition = -1;
    }

    public void applyTransformation(View onView, float positionOffset) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) onView.getLayoutParams();

        if (positionOffset <= 0.0001) {

            xStartPosition = onView.getTranslationX();
            yStartPosition = onView.getTranslationY();

            return;
        }

        onView.setTranslationX((int)(xPosition * positionOffset) + xStartPosition);
        onView.setTranslationY((int)(yPosition * positionOffset) + yStartPosition);
        onView.requestLayout();
    }
}
