package com.dev.sacot41.scviewpager;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Samuel on 2015-07-06.
 */

public class SCSizeAnimation extends SCPageAnimation {

    public float dHeigh;
    public float dWidth;

    private int startHeigh;
    private int startWidth;

    /**
     *
     * @param forPage page to apply animation
     * @param dh height variation, in percentage
     * @param dw width variation, in percentage
     */
    public SCSizeAnimation(int forPage, float dh, float dw) {
        this.page = forPage;
        this.dHeigh = dh;
        this.dWidth = dw;
    }

    @Override
    public void applyTransformation(View onView, float positionOffset) {
        ViewGroup.LayoutParams param = onView.getLayoutParams();

        if(positionOffset <= 0) {
            startHeigh = onView.getMeasuredHeight();
            startWidth = onView.getMeasuredWidth();
            return;
        }

        param.height = (int)(dHeigh * startHeigh * positionOffset) + startHeigh;
        param.width = (int)(dWidth * startHeigh * positionOffset) + startWidth;
        onView.setLayoutParams(param);
    }
}
