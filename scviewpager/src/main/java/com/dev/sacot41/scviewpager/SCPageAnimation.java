package com.dev.sacot41.scviewpager;

import android.view.View;

/**
 * Created by Samuel on 2015-07-06.
 */

public abstract class SCPageAnimation {
    public int page;
    public abstract void applyTransformation(View onView, float positionOffset);
}