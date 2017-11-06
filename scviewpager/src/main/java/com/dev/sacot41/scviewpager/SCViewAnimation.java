package com.dev.sacot41.scviewpager;

import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Samuel on 2015-07-06.
 */

public class SCViewAnimation {

    private View view;
    private HashMap<Integer, ArrayList<SCPageAnimation>> pageAnimationMap;
    private int startX;
    private int startY;

    public SCViewAnimation(View inView) {
        this.view = inView;
        this.pageAnimationMap = new HashMap<Integer, ArrayList<SCPageAnimation>>();
    }

    public void startToPosition(Integer xPosition, Integer yPosition) {
        if (xPosition != null) {
            this.view.setX(xPosition);
            startX = xPosition;
        }
        if (yPosition != null) {
            this.view.setY(yPosition);
            startY = yPosition;
        }
        this.view.requestLayout();
    }

    public void addPageAnimation(SCPageAnimation inPageAnimation) {
        ArrayList<SCPageAnimation> animationList = pageAnimationMap.get(inPageAnimation.page);
        if (animationList == null) animationList = new ArrayList<SCPageAnimation>();
        animationList.add(inPageAnimation);
        pageAnimationMap.put(inPageAnimation.page, animationList);
        if(inPageAnimation instanceof SCPositionAnimation){
            SCPositionAnimation animation = (SCPositionAnimation) inPageAnimation;
            animation.setStart(startX, startY);
            startX += animation.xPosition;
            startY += animation.yPosition;
        }
    }

    public void applyAnimation(int page, float positionOffset) {
        ArrayList<SCPageAnimation> animationList = pageAnimationMap.get(page);

        if (animationList == null) return;

//        System.out.println("page:" + page + "; offset:" + positionOffset);

        for(SCPageAnimation animation : animationList) {
            animation.applyTransformation(this.view, positionOffset);
        }
    }

}
